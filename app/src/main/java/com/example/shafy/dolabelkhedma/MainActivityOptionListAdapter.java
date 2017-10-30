package com.example.shafy.dolabelkhedma;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by shafy on 18/10/2017.
 */

public class MainActivityOptionListAdapter extends RecyclerView.Adapter<MainActivityOptionListAdapter.MainActivityOptionListViewHolder >{


    private OnOptionClicked mOnOptionClicked;
    public MainActivityOptionListAdapter(OnOptionClicked onOptionClicked){
        mOnOptionClicked=onOptionClicked;
    }

    public interface OnOptionClicked{
        void onClickListener(int position);
    }
    @Override
    public MainActivityOptionListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context =parent.getContext();
        int listItemLayoutId=R.layout.home_options_list_item;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(listItemLayoutId,parent,false);
        return  new MainActivityOptionListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainActivityOptionListViewHolder holder, int position) {
        holder.onBindViewHolder(position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MainActivityOptionListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mText;
        ImageView mImage;
        Context mContext;
        public MainActivityOptionListViewHolder(View view){
            super(view);
            mContext =view.getContext();
            mText=(TextView)view.findViewById(R.id.tv_main_option_text);
            mImage=(ImageView)view.findViewById(R.id.iv_main_option_icon);
            view.setOnClickListener(this);
        }

        public void onBindViewHolder(int position){
            switch (position)
            {
                case 0:
                    mText.setText(mContext.getString(R.string.main_add_atten));
                    mImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_attendance));
                    break;
                case 1:
                    mText.setText(mContext.getString(R.string.main_log));
                    mImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_log));
                    break;

                case 2:
                    mText.setText(mContext.getString(R.string.main_friday));
                    mImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_friday));
                    break;

                case 3:
                    mText.setText(mContext.getString(R.string.main_dolab));
                    mImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_dolab));
                    break;

                case 4:
                    mText.setText(mContext.getString(R.string.main_trip));
                    mImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_trip));
                break;

                default:
                    break;
            }
        }
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            mOnOptionClicked.onClickListener(position);
        }
    }
}

