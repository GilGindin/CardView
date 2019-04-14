package com.gil.cardview;

public class Item {

    private int mImageResource;
    private String mText1;
    private String mText2;

    public Item(int ImageResource, String Text1, String Text2) {
        this.mImageResource = ImageResource;
        this.mText1 = Text1;
        this.mText2 = Text2;
    }
    public void changeText1(String text){
        mText1 = text;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmText1() {
        return mText1;
    }

    public String getmText2() {
        return mText2;
    }
}
