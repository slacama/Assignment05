package com.example.assignment05;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String BOOK = "com.example.assignment05.BOOK";
    public static final String CHAPTER = "com.example.assignment05.CHAPTER";
    public static final String VERSE = "com.example.assignment05.VERSE";
    private static final String TAG = "FavoriteVerse";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayVerse (View view) {
        Intent intent = new Intent(this, FavoriteScriptureActivity.class);
        EditText editBook = (EditText) findViewById(R.id.editBook);
        EditText editChapter = (EditText) findViewById(R.id.editChapter);
        EditText editVerse = (EditText) findViewById(R.id.editVerse);
        String book = editBook.getText().toString();
        String chapter = editChapter.getText().toString();
        String verse = editVerse.getText().toString();

        Log.i(TAG, "About to create intent with " + book + " " + chapter + ":" + verse
                + ".");
        intent.putExtra(BOOK, book);
        intent.putExtra(CHAPTER, chapter);
        intent.putExtra(VERSE, verse);
        startActivity(intent);
    }

    public void loadVerse (View view) {
        SharedPreferences sharedPref = this.getSharedPreferences("Scripture", Context.MODE_PRIVATE);
        String book = sharedPref.getString(BOOK, "Book");
        String chapter = sharedPref.getString(CHAPTER, "1");
        String verse = sharedPref.getString(VERSE, "1");
        EditText editBook = (EditText) findViewById(R.id.editBook);
        EditText editChapter = (EditText) findViewById(R.id.editChapter);
        EditText editVerse = (EditText) findViewById(R.id.editVerse);

        editBook.setText(book);
        editChapter.setText(chapter);
        editVerse.setText(verse);
    }
}