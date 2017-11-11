package com.example.shafy.dolabelkhedma.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.data.DolabElKhedmaContract;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shafy on 21/10/2017.
 */

public class LogListAdapter extends RecyclerView.Adapter<LogListAdapter.ViewHolder> {

    private OnPersonClicked mOnPersonClicked;
    private HashMap<String, String> mSimpleAngelsMap;
    private ArrayList<String> mSimpleAngelsIds;
    public LogListAdapter(OnPersonClicked onPersonClicked, HashMap<String, String> simpleAngelsMap, ArrayList<String> simpleAngelsIds){
        mOnPersonClicked = onPersonClicked;
        mSimpleAngelsMap=simpleAngelsMap;
        mSimpleAngelsIds=simpleAngelsIds;
        notifyDataSetChanged();
    }

    public interface OnPersonClicked{
        void onPersonClickedHandler(ArrayList<String> simpleAngelsIds, int position);
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
        ImageView mIcon;
        public ViewHolder(View itemView) {
            super(itemView);
            mContext=itemView.getContext();
            mName= itemView.findViewById(R.id.tv_main_option_text);
            mIcon = itemView.findViewById(R.id.iv_main_option_icon);
            mIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_add));
            itemView.setOnClickListener(this);

        }
        void onBindViewHolder(int position){
            String id = mSimpleAngelsIds.get(position);
            mName.setText(mSimpleAngelsMap.get(id));
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            mOnPersonClicked.onPersonClickedHandler(mSimpleAngelsIds,position);
        }
    }
}
