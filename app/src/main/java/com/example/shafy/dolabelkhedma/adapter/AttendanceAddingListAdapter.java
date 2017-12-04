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

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shafy on 19/10/2017.
 */

public class AttendanceAddingListAdapter extends RecyclerView.Adapter<AttendanceAddingListAdapter.ViewHolder> {

    private OnAttendanceAdding mOnAttendanceAdding;
    private HashMap<String, String> mSimpleAngelsMap;
    private ArrayList<String> mSimpleAngelsIds;
    private int offset=0;
    public AttendanceAddingListAdapter(OnAttendanceAdding onAttendanceAdding, HashMap<String, String> simpleAngelsMap, ArrayList<String> simpleAngelsIds){

        mOnAttendanceAdding = onAttendanceAdding;
        mSimpleAngelsMap=simpleAngelsMap;
        mSimpleAngelsIds=simpleAngelsIds;
        offset=0;
        notifyDataSetChanged();
    }

    public interface OnAttendanceAdding{
        void OnAddingHandler(String id,String name);
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
        if(mSimpleAngelsIds ==null)
            return 0;
        else
            return mSimpleAngelsIds.size();
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
            right.setBackground(mContext.getResources().getDrawable(R.drawable.shape_right_green));
            left.setBackground(mContext.getResources().getDrawable(R.drawable.shape_left_green));
            mAdd.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_add));
            left.setOnClickListener(this);

        }
        void onBindViewHolder(int position){

            String id = mSimpleAngelsIds.get(position+offset);
            mName.setText(mSimpleAngelsMap.get(id));
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            String id =mSimpleAngelsIds.get(position);
            String name = mSimpleAngelsMap.get(id);
            mOnAttendanceAdding.OnAddingHandler(id,name);
        }
    }
}
