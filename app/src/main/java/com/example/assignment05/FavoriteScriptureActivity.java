package com.example.assignment05;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.assignment05.MainActivity.BOOK;
import static com.example.assignment05.MainActivity.CHAPTER;
import static com.example.assignment05.MainActivity.VERSE;

public class FavoriteScriptureActivity extends AppCompatActivity {
    private static final String TAG = "FavoriteVerse";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_scripture);

        Intent intent = getIntent();
        String book = intent.getStringExtra(BOOK);
        String chapter = intent.getStringExtra(CHAPTER);
        String verse = intent.getStringExtra(VERSE);

        Log.i(TAG, "Received intent with " + book + " " + chapter + ":" + verse + ".");

        TextView textView = findViewById(R.id.textView3);
        textView.setText(book + " " + chapter + ":" + verse);
    }

    public void saveScripture(View view) {
        Intent intent = getIntent();

        SharedPreferences sharedPref = this.getSharedPreferences("Scripture", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(BOOK, intent.getStringExtra(BOOK));
        editor.putString(CHAPTER, intent.getStringExtra(CHAPTER));
        editor.putString(VERSE, intent.getStringExtra(VERSE));
        editor.apply();

        Context context = getApplicationContext();
        CharSequence text = "SCRIPTURE SAVED!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        navigateUpTo(new Intent(getBaseContext(), MainActivity.class));
    }


}