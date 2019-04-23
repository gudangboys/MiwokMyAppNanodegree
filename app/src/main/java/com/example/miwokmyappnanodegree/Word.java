package com.example.miwokmyappnanodegree;

/**
 * class Word represents a vocabulary word that contains both - the default tanslation and the Miwok
 * translation for that word
 */

public class Word {

    /**
     * Private variables in a class are preceded with an "m" to indicate the same
     */

    /** Default trasnaltion for the word */
    private String mDefaultTranslation;

    /** Miwok Translation for the Word*/
    private String mMiwokTranslation;

        /** imageResourceId is the drawable resource id for the image asset*/
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    //Audio resource for each translation
    private int mAudioResourceId;

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;

    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceID, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceID;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get default translation of the word
     * @return
     */

    public  String getmDefaultTranslation(){
        return mDefaultTranslation;
    }


    /**
     * Get miwok tranlation of the word
     * @return
     */

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }


    /**
     * Get image resource id
     */

    public int getmImageResourceId() {
        return mImageResourceId;
    }


    /**
     * Returns whether or not there is an image for this word.
     * @return
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


    // Return audio resource ID of the word


    public int getmAudioResourceId() {return mAudioResourceId;}
}
