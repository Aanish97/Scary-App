package com.example.a3_smd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class bookPg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_pg);

        Intent intent = getIntent();
        String bookName = intent.getStringExtra("bookName");
        TextView txtBookName = findViewById(R.id.bookName);
        txtBookName.setText(bookName);

/*        txtBookName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(bookPg.this, scaryPg.class);
                startActivity(intent);
            }
        });*/
    }
}
