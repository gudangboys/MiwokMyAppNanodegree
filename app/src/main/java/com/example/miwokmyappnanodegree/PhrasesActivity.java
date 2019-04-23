package com.example.miwokmyappnanodegree;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<>();

        /** We add a new word object to Word - here both the default and miwok translation
         *
         * We are passing the Class Word as the ArrayList and called it words.
         * as it is an object we can .add new items as defined in the constructor
         * */

        words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnƏ oyaase'nƏ", R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is....", "oyaaset", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michƏksƏs?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "ƏƏnƏs'aa", R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I'm coming.", "hƏƏ'ƏƏnƏm", R.raw.phrase_yes_im_coming));
        words.add(new Word("I'm coming.", "ƏƏnƏm", R.raw.phrase_im_coming));
        words.add(new Word("Let's go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new Word("Come here", "Ənni'nem", R.raw.phrase_come_here));


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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(NumbersActivity.this, "List item Clicked", Toast.LENGTH_LONG).show();
                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();
            }
        });






    }
}
