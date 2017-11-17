package com.example.shafy.dolabelkhedma.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shafy.dolabelkhedma.R;

/**
 * Created by shafy on 19/10/2017.
 */

public class AttendanceRemovingListAdapter extends RecyclerView.Adapter<AttendanceRemovingListAdapter.ViewHolder> {

    private OnAttendanceRemoved mOnAttendanceRemoved;
    Cursor mDataNotAdded;

    public AttendanceRemovingListAdapter(OnAttendanceRemoved onAttendanceRemoved,Cursor notAdded){
        mOnAttendanceRemoved=onAttendanceRemoved;
        mDataNotAdded=notAdded;
        notifyDataSetChanged();
    }

    public interface OnAttendanceRemoved{
        void OnRemoveHandler(String postion);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int listItmId= R.layout.home_options_list_item;
        LayoutInflater inflater=LayoutInflater.from(context);
        View view =inflater.inflate(listItmId,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBindViewHolder(position);
    }

    @Override
    public int getItemCount() {
        if(mDataNotAdded==null)
            return 0;
        else
            return mDataNotAdded.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        Context mContext;
        TextView mName;
        ImageView mAdd;
        LinearLayout right;
        LinearLayout left;
        public ViewHolder(View itemView) {
            super(itemView);
            mContext=itemView.getContext();
            mName= itemView.findViewById(R.id.tv_main_option_text);
            mAdd= itemView.findViewById(R.id.iv_main_option_icon);
            right= itemView.findViewById(R.id.ll_list_item_right);
            left= itemView.findViewById(R.id.ll_list_item_left);
            right.setBackground(mContext.getResources().getDrawable(R.drawable.shape_right_red));
            left.setBackground(mContext.getResources().getDrawable(R.drawable.shape_left_red));
            mAdd.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_remove));
            left.setOnClickListener(this);

        }
        void onBindViewHolder(int position){
            mDataNotAdded.moveToPosition(position);
        }

        @Override
        public void onClick(View v) {
            mOnAttendanceRemoved.OnRemoveHandler("data removed");
        }
    }
}
