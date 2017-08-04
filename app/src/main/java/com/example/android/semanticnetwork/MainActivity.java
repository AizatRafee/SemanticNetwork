package com.example.android.semanticnetwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;

    public static final String EXTRA_MESSAGE = "com.example.android.semanticnetwork.MESSAGE2";
    public static final String TIME_START = "com.example.android.semanticnetwork.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

    }

    public void newActivity(View v) {
        EditText editTextName;
        editTextName = (EditText)findViewById(R.id.nameText);
        String name = editTextName.getText().toString();
        Intent intent = new Intent(this, Main2Activity.class);
        final long start = System.nanoTime();
        String s=String.valueOf(start);
        intent.putExtra(EXTRA_MESSAGE, name);
        intent.putExtra(TIME_START, s);
        startActivity(intent);
    }
}
