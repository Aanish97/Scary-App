package com.example.a3_smd;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import static android.support.v7.widget.RecyclerView.*;

public class AdapterRCV extends RecyclerView.Adapter<myViewHolder> {

    Context con;
    ArrayList<Site>sites;
    private int itemCount;

    public AdapterRCV(ArrayList<Site>sites,Context con, int itemCount) {
        this.con=con;
        this.sites=sites;
        this.itemCount=itemCount;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemCount, viewGroup, false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder myHolder, int i) {

        if(sites!=null && myHolder!=null) {
            myHolder.courseName.setText(sites.get(i).getBookName());
            myHolder.actualProgress.setText(sites.get(i).getWriterName());
        }
    }

    @Override
    public int getItemCount() {

        if(sites!=null) {
            return sites.size();
        }
        return 0;
    }
}
