package com.example.a3_smd;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class myViewHolder extends RecyclerView.ViewHolder {

    public TextView courseName;
    public TextView actualProgress;

    public myViewHolder(View v)
    {
        super(v);
        courseName = itemView.findViewById(R.id.bookName);
        actualProgress = itemView.findViewById(R.id.writerName);

    }
}
