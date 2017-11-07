package com.book.bookappfirebase.SearchActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.book.bookappfirebase.Adapter.MainGenreListAdapter;
import com.book.bookappfirebase.MainActivity;
import com.book.bookappfirebase.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by kunalmnik95 on 20/10/17.
 */

public class MainGenreActivity extends AppCompatActivity {

    String[] genreStrings = {"Contemporary", "Fantasy", "Fiction", "History", "Horror", "Mystery", "Non-Fiction",
            "Paranormal", "Romance", "Science Fiction", "Suspense", "Thriller", "Young-Adult"};

    ListView mainGenreList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_genre_layout);

        mainGenreList = findViewById(R.id.mainGenreList);

        MainGenreListAdapter adapter = new MainGenreListAdapter(MainGenreActivity.this, genreStrings);

        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, genreStrings);
        mainGenreList.setAdapter(adapter);

        mainGenreList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str = genreStrings[i];
                Toast.makeText(MainGenreActivity.this, str, Toast.LENGTH_SHORT).show();
                Log.i("THIS IS SAMPLE : ", str);
                Intent intent = new Intent(MainGenreActivity.this, SubGenreActivity.class);
                intent.putExtra("GENRE NAME", str);
                startActivity(intent);
            }
        });
    }
}