package com.example.a3_smd;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Context c;
    Timer timer;
    int counter = 1;
    ArrayList<Site>data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //service wala kaam
        c = this;
        timer = new Timer();
        timer.schedule(new RemindTask(c),0);

/*        Intent i = new Intent(this, myIntentService.class);
        startService(i);*/

        Site st;
        data = new ArrayList<>();

        st = new Site("Alice In Wonderland","Percy Jackson" );
        data.add(st);
        st = new Site("The Runaway Jury", "Aanish Amir" );
        data.add(st);
        st = new Site("The Client", "Hassan Ali" );
        data.add(st);
        st = new Site("The Mazerunner", "Imran Khan" );
        data.add(st);
        st = new Site("50 Shades of Grey", "Ahmad Ali");
        data.add(st);

        AdapterRCV adapter = new AdapterRCV(data, MainActivity.this, R.layout.myviewholder);
        RecyclerView recyclerView = findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerTouchListener(this, recyclerView, new ClickListener() {
                    @Override
                    public void onClick(View view, final int position)
                    {
                        //on recyclerView btn click
                        Intent intent = new Intent(MainActivity.this, bookPg.class);
                        intent.putExtra("bookName",data.get(position).bookName);
                        intent.putExtra("writerName", data.get(position).getWriterName());
                        startActivity(intent);
                    }

                    @Override
                    public void onLongClick(View view, int position)
                    {}
                }
            )
        );
    }

    class RemindTask extends TimerTask {

        Context cc;

        RemindTask(Context c) {
            cc = c;
        }

        public void run() {
            Intent i = new Intent(cc, myService.class);
            cc.startService(i);
        }

    }

    public interface ClickListener
    {
        void onClick(View view, int position);
        void onLongClick(View view, int position);
    }

    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

        private ClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView, final ClickListener clicklistener){

            this.clicklistener=clicklistener;
            gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child=recycleView.findChildViewUnder(e.getX(),e.getY());
                    if(child!=null && clicklistener!=null){
                        clicklistener.onLongClick(child,recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child=rv.findChildViewUnder(e.getX(),e.getY());
            if(child!=null && clicklistener!=null && gestureDetector.onTouchEvent(e)){
                clicklistener.onClick(child,rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean b) {
        }
    }

}
