package com.example.miwokmyappnanodegree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("father", "ƏpƏ", R.drawable.family_father));
        words.add(new Word("mother", "Əta", R.drawable.family_mother));
        words.add(new Word("son", "angsi", R.drawable.family_son));
        words.add(new Word("daughter", "tune", R.drawable.family_daughter));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother));
        words.add(new Word("older sister", "tete", R.drawable.family_older_sister));
        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister));
        words.add(new Word("grandmother", "ama", R.drawable.family_grandmother));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather));


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

//        GridView gridView = findViewById(R.id.grid); add numbersColumns in xml file for number of columns

        ListView listView = findViewById(R.id.list);

        //Link the listview with the itemsAdapter so it will display list items for each word in the list of the arrayList.

//        gridView.setAdapter(itemsAdapter);

        listView.setAdapter(adapter);



    }
}
