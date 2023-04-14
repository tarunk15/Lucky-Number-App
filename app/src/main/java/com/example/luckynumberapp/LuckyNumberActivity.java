package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    Button nn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        tv1= findViewById(R.id.textview2);
        tv2= findViewById(R.id.textview3);
        nn=findViewById(R.id.btn2);

        Intent i = getIntent();
        String User_name = i.getStringExtra("name");

        int number = generate_random_number();
        tv2.setText(""+number);

        nn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data_share(User_name,number);
            }
        });


    }

    public int generate_random_number()
    {
          Random random = new Random();
          int limit = 100;
          int random_numbers_generated = random.nextInt(limit);
          return random_numbers_generated;

    }

    public void data_share(String username , int number)
    {
           Intent i = new Intent(Intent.ACTION_SEND);
           i.setType("text/plain");

           String n = String.valueOf(number);

           i.putExtra(Intent.EXTRA_SUBJECT, "Hello" +username +"!");
           i.putExtra(Intent.EXTRA_TEXT,"Your Lucky Number is" +n);

           startActivity(Intent.createChooser(i,"Choose the Platform"));

    }
}