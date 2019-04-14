package com.gil.cardview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adpter extends RecyclerView.Adapter<Adpter.ViewHolder> {

        private ArrayList<Item> mItemList;
        private OnItemClickListener mListener;

        public interface OnItemClickListener{
            void onItemClick(int position);
            void onDeleteClick(int position);
        }

        public void setOnItemClickListener(OnItemClickListener listener){
            mListener = listener;
        }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public ImageView mImageViewDelete;
        public ViewHolder(@NonNull View itemView , final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView1);
            mTextView2 = itemView.findViewById(R.id.textView2);
            mImageViewDelete = itemView.findViewById(R.id.image_delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
            mImageViewDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    public Adpter(ArrayList<Item> itemList){
            mItemList = itemList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout , viewGroup, false);
       ViewHolder nvh = new ViewHolder(v , mListener);
       return nvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
            Item currentItem = mItemList.get(position);
            viewHolder.mImageView.setImageResource(currentItem.getmImageResource());
            viewHolder.mTextView1.setText(currentItem.getmText1());
            viewHolder.mTextView2.setText(currentItem.getmText2());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
