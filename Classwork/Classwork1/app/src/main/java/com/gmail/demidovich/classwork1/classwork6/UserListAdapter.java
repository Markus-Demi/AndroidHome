package com.gmail.demidovich.classwork1.classwork6;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gmail.demidovich.classwork1.R;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<User> mUserList = new ArrayList<>();
    private OnUserClickListener mListener;

    public void setUserList(List<User> userList) {
        this.mUserList.clear();
        this.mUserList.addAll(userList);
        notifyDataSetChanged();
    }

    public void setListener(OnUserClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Holder myHolder = (Holder) holder;
        final User user = mUserList.get(position);

        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClick(user, position);
                }
            }
        });

        Glide.with(myHolder.mImageView.getContext())
                .load("http://goo.gl/gEgYUd").into(myHolder.mImageView);
        myHolder.mNameTextView.setText(user.getName());
        myHolder.mSurnameTextView.setText(user.getSurname());
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mNameTextView, mSurnameTextView;

        public Holder(View itemView) {
            super(itemView);
            Log.e("User Adapter", "Holder");

            mImageView = itemView.findViewById(R.id.img_user_view_cw6);
            mNameTextView = itemView.findViewById(R.id.user_name_cw6);
            mSurnameTextView = itemView.findViewById(R.id.user_surname_cw6);
        }
    }

    interface OnUserClickListener {
        void onClick(User user, int position);
    }
}
