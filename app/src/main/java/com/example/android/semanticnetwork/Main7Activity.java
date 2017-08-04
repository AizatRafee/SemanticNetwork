package com.example.android.semanticnetwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main7Activity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    String message;
    String time_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        time_start = intent.getStringExtra(MainActivity.TIME_START);
    }

    public void soalan1(View v) {
        long start = Long.valueOf(time_start);
        final long end = System.nanoTime();
        final long ms = (end - start) / 1000000;
        myRef.child(message).child("soalan6").setValue(ms);
        Intent intent = new Intent(this, Main9Activity.class);
        start = System.nanoTime();
        String s =String.valueOf(start);
        intent.putExtra(MainActivity.EXTRA_MESSAGE, message);
        intent.putExtra(MainActivity.TIME_START, s);
        startActivity(intent);
    }
}
