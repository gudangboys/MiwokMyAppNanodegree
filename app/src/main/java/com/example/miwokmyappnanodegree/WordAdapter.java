package com.example.miwokmyappnanodegree;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context, ArrayList<Word> words) {


        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.


        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        // Get the {@link AndroidFlavor} object located at this position in the list

        Word currentWord = getItem(position);


        // Find the TextView in the list_item.xml layout with the ID version_name

        TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);

        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView

        miwokTextView.setText(currentWord.getmMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number

        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);

        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView

        defaultTextView.setText(currentWord.getmDefaultTranslation());

//        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
//        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
//        // Get the image resource ID from the current AndroidFlavor object and
//        // set the image to iconView
//        iconView.setImageResource(currentAndroidFlavor.getImageResourceId());

        //Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageView = listItemView.findViewById(R.id.image_view);

        //Get the Image Resource ID and set the image to image_view


        /**
         * set image to image view only if there is an image resource specified
         */

        if (currentWord.hasImage()) {
        imageView.setImageResource(currentWord.getmImageResourceId());


        imageView.setVisibility(View.VISIBLE);
            /**
             * Make sure the view is Visible as it was set to Invisible after else
             */
        }
        else {

            /**
             * else set visibility to GONE (no space used in layout) as compared to INVISIBLE
             */
            imageView.setVisibility(View.GONE);
        }


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView

        return listItemView;
    }
}
