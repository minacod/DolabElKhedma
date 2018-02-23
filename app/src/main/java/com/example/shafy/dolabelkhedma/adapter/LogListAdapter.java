package com.example.shafy.dolabelkhedma.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.request.RequestOptions;
import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.ui.GlideApp;
import com.example.shafy.dolabelkhedma.utils.FirebaseReferencesUtils;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by shafy on 21/10/2017.
 */

public class LogListAdapter extends RecyclerView.Adapter<LogListAdapter.ViewHolder> {

    private OnPersonClicked mOnPersonClicked;
    private OnPersonLongClicked mOnPersonLongClicked;
    private HashMap<String, String> mSimpleAngelsMap;
    private ArrayList<String> mSimpleAngelsIds;
    public LogListAdapter(OnPersonClicked onPersonClicked, OnPersonLongClicked onPersonLongClicked, HashMap<String, String> simpleAngelsMap, ArrayList<String> simpleAngelsIds){
        mOnPersonClicked = onPersonClicked;
        mOnPersonLongClicked = onPersonLongClicked;
        mSimpleAngelsMap=simpleAngelsMap;
        mSimpleAngelsIds=simpleAngelsIds;
        notifyDataSetChanged();
    }

    public interface OnPersonClicked{
        void onPersonClickedHandler(String id);
    }

    public interface OnPersonLongClicked{
        void onPersonLongClickedHandler(String id);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int listItmId= R.layout.log_list_item;
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        Context mContext;
        TextView mName;
        ConstraintLayout parent;

        ImageView imageView;
        FirebaseStorage fs;
        StorageReference sr;
        public ViewHolder(View itemView) {
            super(itemView);
            mContext=itemView.getContext();
            fs= FirebaseReferencesUtils.getFirebaseStorageInstanse();
            sr = FirebaseReferencesUtils.getAngelStorageReference(mContext,fs);
            mName= itemView.findViewById(R.id.tv_main_option_text);
            imageView= itemView.findViewById(R.id.profile_image);
            parent = itemView.findViewById(R.id.cl_log_activity_list_itm);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }
        void onBindViewHolder(int position){
            /*if(position%2!=0){
                parent.setRotation(180);
                mName.setRotation(180);
                imageView.setRotation(180);
            }*/

            String id = mSimpleAngelsIds.get(position);
            mName.setText(mSimpleAngelsMap.get(id));


            GlideApp.with(mContext)
                    .load(sr.child(id).child("pp"))
                    .apply(RequestOptions.circleCropTransform())
                    .placeholder(R.drawable.ic_contact_avatar_circular)
                    .error(R.drawable.ic_contact_avatar_circular)
                    .thumbnail()
                    .into(imageView);
        }
        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();

            mOnPersonClicked.onPersonClickedHandler(mSimpleAngelsIds.get(position));
        }

        @Override
        public boolean onLongClick(View v) {
            int position=getAdapterPosition();
            mOnPersonLongClicked.onPersonLongClickedHandler(mSimpleAngelsIds.get(position));
            return true;
        }
    }
}
