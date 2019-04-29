package com.example.miwokmyappnanodegree;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

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

        words.add(new Word("red", "wetetti", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("brown", "takaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("gray", "topoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("dusty yellow", "topiisƏ", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiitƏ", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));


        /**
         * After creating a custom arayadapter - wordadapter class
         *
         */

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

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

                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmAudioResourceId());


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

