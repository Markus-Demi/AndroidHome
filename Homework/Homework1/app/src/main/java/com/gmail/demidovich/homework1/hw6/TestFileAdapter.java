package com.gmail.demidovich.homework1.hw6;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.gmail.demidovich.homework1.R;

import java.util.ArrayList;
import java.util.List;

public class TestFileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<People> mPeopleList = new ArrayList<>();

    public void setPeopleListAdapter(List<People> peopleList) {
        this.mPeopleList.clear();
        this.mPeopleList.addAll(peopleList);
        notifyDataSetChanged();
    }

    public List<People> getPeopleList() {
        return mPeopleList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_testfile, parent, false);

        return new Holder(view);
    }

    static class Holder extends RecyclerView.ViewHolder {
        TextView mNameTextView, mSurnameTextView, mAgeTextView, mIdTextView;
        CheckBox mDegreeBox;

        public Holder(View itemView) {
            super(itemView);
            Log.e("People Adapter", "Holder");

            mNameTextView = itemView.findViewById(R.id.test_file_name);
            mSurnameTextView = itemView.findViewById(R.id.test_file_surname);
            mAgeTextView = itemView.findViewById(R.id.test_file_age);
            mIdTextView = itemView.findViewById(R.id.test_file_id);
            mDegreeBox = itemView.findViewById(R.id.test_file_degree);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder myHolder = (Holder) holder;
        final People people = mPeopleList.get(position);

        myHolder.mNameTextView.setText("name: " + people.getName());
        myHolder.mSurnameTextView.setText("surname: " + people.getSurname());
        myHolder.mAgeTextView.setText("age: " + people.getAge());
        myHolder.mIdTextView.setText("id: " + people.getId());
        myHolder.mDegreeBox.setEnabled(people.isDegree());
    }

    @Override
    public int getItemCount() {
        return mPeopleList.size();
    }
}
