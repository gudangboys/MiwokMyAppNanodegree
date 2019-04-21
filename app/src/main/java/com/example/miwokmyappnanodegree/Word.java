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

    public Word(String defaultTranlastion, String miwokTranslation) {
        mDefaultTranslation = defaultTranlastion;
        mMiwokTranslation = miwokTranslation;
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




}
