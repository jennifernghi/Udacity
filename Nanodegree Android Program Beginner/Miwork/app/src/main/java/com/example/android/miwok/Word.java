package com.example.android.miwok;

/**
 * Created by jennifernghinguyen on 8/16/16.
 */
public class Word {

    private String miwokWord;
    private String englishWord;
    private int imageResourceId = NO_IMAGE_PROVIDED;
    private int soundResourceId;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String miwokWord, String englishWord, int imageResourceId, int soundResourceId) {
        this.miwokWord = miwokWord;
        this.englishWord = englishWord;
        this.imageResourceId = imageResourceId;
        this.soundResourceId = soundResourceId;
    }

    public Word(String miwokWord, String englishWord, int soundResourceId) {
        this.miwokWord = miwokWord;
        this.englishWord = englishWord;
        this.soundResourceId = soundResourceId;
    }

    public void setMiwokWord(String miwokWord) {
        this.miwokWord = miwokWord;
    }

    public String getMiwokWord() {
        return miwokWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public boolean hasImage() {
        return imageResourceId != NO_IMAGE_PROVIDED;
    }

    public void setSoundResourceId(int soundResourceId) {
        this.soundResourceId = soundResourceId;
    }

    public int getSoundResourceId() {
        return soundResourceId;
    }
}
