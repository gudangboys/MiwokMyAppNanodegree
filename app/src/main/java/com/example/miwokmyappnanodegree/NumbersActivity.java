package com.example.miwokmyappnanodegree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        /**
         * We create an ArrayList of Word which is already defined in android and here its named word
         */
        ArrayList<Word> words = new ArrayList<>();

        /** We add a new word object to Word - here both the default and miwok translation
         *
         * We are passing the Class Word as the ArrayList and called it words.
         * as it is an object we can .add new items as defined in the constructor
         * */

        words.add(new Word("one", "lutti"));
        words.add(new Word("two", "ottiko"));
        words.add(new Word("three", "tolookosu"));
        words.add(new Word("four", "oyyisa"));
        words.add(new Word("five", "massokka"));
        words.add(new Word("six", "temmokka"));
        words.add(new Word("seven", "kenekaku"));
        words.add(new Word("eight", "kawinta"));
        words.add(new Word("nine", "wo'e"));
        words.add(new Word("ten", "na'accha"));




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

        WordAdapter adapter = new WordAdapter(this, words);

//        GridView gridView = findViewById(R.id.grid); add numbersColumns in xml file for number of columns

          ListView listView = findViewById(R.id.list);

        //Link the listview with the itemsAdapter so it will display list items for each word in the list of the arrayList.

//        gridView.setAdapter(itemsAdapter);

        listView.setAdapter(adapter);









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








