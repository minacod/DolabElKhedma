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
import com.example.shafy.dolabelkhedma.data.DolabElKhedmaContract;

/**
 * Created by shafy on 19/10/2017.
 */

public class AttendanceAddingListAdapter extends RecyclerView.Adapter<AttendanceAddingListAdapter.ViewHolder> {

    private OnAttendanceAdding mOnAttendanceAdding;
    private  Cursor mDataAdded;

    public AttendanceAddingListAdapter(OnAttendanceAdding onAttendanceAdding,Cursor added){
        mOnAttendanceAdding = onAttendanceAdding;
        mDataAdded=added;
        notifyDataSetChanged();
    }

    public interface OnAttendanceAdding{
        public void OnAddingHandler(Cursor data,int position);
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
        if(mDataAdded==null)
            return 0;
        else
            return mDataAdded.getCount();
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
            mName=(TextView)itemView.findViewById(R.id.tv_main_option_text);
            mAdd=(ImageView)itemView.findViewById(R.id.iv_main_option_icon);
            right=(LinearLayout)itemView.findViewById(R.id.ll_list_item_right);
            left=(LinearLayout)itemView.findViewById(R.id.ll_list_item_left);
            right.setBackground(mContext.getResources().getDrawable(R.drawable.shape_right_green));
            left.setBackground(mContext.getResources().getDrawable(R.drawable.shape_left_green));
            mAdd.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_add));
            left.setOnClickListener(this);

        }
        void onBindViewHolder(int position){
            mDataAdded.moveToPosition(position);
            String tmp=mDataAdded.getString(mDataAdded.getColumnIndex(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME));
            String tmp2=mDataAdded.getString(mDataAdded.getColumnIndex(DolabElKhedmaContract.MainDataEnrty._ID));
            mName.setText(tmp +" "+ tmp2);
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            mOnAttendanceAdding.OnAddingHandler(mDataAdded,position);
        }
    }
}
