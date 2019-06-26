package com.example.a3_smd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class winner10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner10);
    }

    public void sendToScaryPg(View view)
    {
        Intent intent = new Intent(winner10.this, scaryPg.class);
        startActivity(intent);
    }
}
