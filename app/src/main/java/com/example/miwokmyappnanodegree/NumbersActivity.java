package com.example.miwokmyappnanodegree;

import android.content.Context;
import android.media.AudioManager;
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

    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                    mMediaPlayer.pause();
                    mMediaPlayer.seekTo(0);
                } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                    mMediaPlayer.start();
                    //Resume Playback
                } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                   releaseMediaPlayer();
                    //Stop Playback
                }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


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


                //release the media player if it currently exist because user is about to play a different file.
                //if user taps on a different audio file before the current one finishes playing, the
                //onCompletionListener is never called, thats why we need to release resources
                //and create a new MediaPlayer

                releaseMediaPlayer();

                //Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                //use the music stream.
                        AudioManager.STREAM_MUSIC,
                //Request permanent focus
                        AudioManager.AUDIOFOCUS_GAIN);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    //mAudioManager.registerMediaButtonEventreceiver(RemoteControlReceiver);
                    //Start playback


                    //Create and setup MediaPlayer for the resourse accociated with current word
                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioResourceId());

                    //start the audio file
                    mMediaPlayer.start();

                    //Setup a listener on the media player and store it in a global variable so we can stop and release
                    //media player once audio has finished playing
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }

            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        //when activity is stopped, release the media player resources to stop playing sounds
        // and free resources
        releaseMediaPlayer();
    }


    // Clean up the media player by releasing its resources.

    private void releaseMediaPlayer() {
        //If mediaPlayer is not null then it may be currently playing a sound

        if (mMediaPlayer != null) {

            //regardless of the current state of the media player, release  its resources becuase we no longer need it

            mMediaPlayer.release();

            //set the media player back to null. for out code we have decided that setting the media player to null
            //is an easy way to tell that the media player is not configured to play an audio file at the moment.

            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}








