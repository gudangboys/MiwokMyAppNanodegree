package com.example.miwokmyappnanodegree;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.media.MediaPlayer.create;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        /**
         * We create an ArrayList of Word which is already defined in android and here its named word
         */
        final ArrayList<Word> words = new ArrayList<>();

        /** We add a new word object to Word - here both the default and miwok translation
         *
         * We are passing the Class Word as the ArrayList and called it words.
         * as it is an object we can .add new items as defined in the constructor
         * */

        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "ottiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na'accha", R.drawable.number_ten, R.raw.number_ten));




        /** We will not require this ArrayList entry - check above*/
//        words.add("one");
//        words.add("two");
//        words.add("three");
//        words.add("four");
//        words.add("five");
//        words.add("six");
//        words.add("seven");
//        words.add("eight");
//        words.add("nine");
//        words.add("ten");

//        ArrayList<String> miwokTranslation = new ArrayList<>();
//        miwokTranslation.add("lutti");
//        miwokTranslation.add("ottiko");
//        miwokTranslation.add("tolookosu");
//        miwokTranslation.add("oyyisa");
//        miwokTranslation.add("massokka");
//        miwokTranslation.add("temmokka");
//        miwokTranslation.add("kenekaku");
//        miwokTranslation.add("kawinta");
//        miwokTranslation.add("wo'e");
//        miwokTranslation.add("na'accha");

        // Create an {@link ArrayAdapter}, whose data source item is a list of Strings.
        // adapter know how to create layouts for each item in the list, using the
        //simple_list_item_1.xml layout resourse file defined in the Android Framework.
        //This list item layout contains a single {@link TextView}, which the adapter will set to
        //display a single word.


        /**
         * Update the adapter to Word instead of String and the new layout list_item
         */

        //ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, R.layout.list_item, words);

        //ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<>(this, R.layout.list_item);

        /**
         * After creating a custom arayadapter - wordadapter class
         *
         */

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

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
            mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioResourceId());
            mMediaPlayer.start();
            }
        });









        //LinearLayout rootView = findViewById(R.id.rootView);

//          FOR LOOP REMOVED TO ADD LIST + ARRAY ADAPTER
//        for (int index = 0; index < words.size(); index++) {
//
//            //Create a new TextView
//            TextView wordView = new TextView(this);
//
//            //Set the text in the TextView from the ArrayList (in this case words) at current index
//            //which increments with the for loop and adds to the list at that index.
//            wordView.setText(words.get(index));
//
//            //Add the TextView as a child to the rootView (in this case Linear Layout as declared above).
//            rootView.addView(wordView);






//          FOR LOOP REMOVED TO ADD LIST + ARRAY ADAPTER
//        for (int index2 = 0; index2 < miwokTranslation.size(); index2++) {
//            TextView miwokView = new TextView(this);
//            miwokView.setText(miwokTranslation.get(index2));
//            rootView.addView(miwokView);
//        }

//        For demo - you can populate an Empty ArrayList with an existing ArrayList
// ArrayList<String> emptyArrayList = new ArrayList<>();
//        for (int index3 = 0; index3 < miwokTranslation.size(); index3++) {
//            TextView emptyList = new TextView(this);
//            emptyList.setText(miwokTranslation.get(index3));
//            rootView.addView(emptyList);
//        }

    }

}








