package com.example.miwokmyappnanodegree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();

        /** We add a new word object to Word - here both the default and miwok translation
         *
         * We are passing the Class Word as the ArrayList and called it words.
         * as it is an object we can .add new items as defined in the constructor
         * */

        words.add(new Word("Where are you going?", "minto wuksus"));
        words.add(new Word("What is your name?", "tinnƏ oyaase'nƏ"));
        words.add(new Word("My name is....", "oyaaset"));
        words.add(new Word("How are you feeling?", "michƏksƏs?"));
        words.add(new Word("I'm feeling good.", "kuchi achit"));
        words.add(new Word("Are you coming?", "ƏƏnƏs'aa"));
        words.add(new Word("Yes, I'm coming.", "hƏƏ'ƏƏnƏm"));
        words.add(new Word("I'm coming.", "ƏƏnƏm"));
        words.add(new Word("Let's go.", "yoowutis"));
        words.add(new Word("Come here", "Ənni'nem"));


        /**
         * After creating a custom arayadapter - wordadapter class
         *
         */

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

//        GridView gridView = findViewById(R.id.grid); add numbersColumns in xml file for number of columns

        ListView listView = findViewById(R.id.list);

        //Link the listview with the itemsAdapter so it will display list items for each word in the list of the arrayList.

//        gridView.setAdapter(itemsAdapter);

        listView.setAdapter(adapter);






    }
}
