package com.example.citylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class showActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Intent intent=getIntent();//to catch the intent
        String s=intent.getStringExtra("city");//to catch the city name from main activity
        TextView t=findViewById(R.id.textView);//returns the reference of textview layout
        t.setText(s);//text set with city name
        Button b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(showActivity.this,MainActivity.class);
                startActivity(intent2);
                finish();
            }
        });
    }
}