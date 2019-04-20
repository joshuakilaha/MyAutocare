package com.example.myautocare.Admin.AdminViews.BMW.BMW;


import com.google.firebase.database.Exclude;

public class Upload {
    private String mName;
    private String mDescription;
    private String mImageUrl;
    private String mKey;

    public Upload() {
        //empty constructor needed
    }

    public Upload(String name, String Description,String imageUrl) {
        if (name.trim().equals("")) {
            name = "No Name";
        }

        mName = name;
        mDescription = Description;
        mImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    @Exclude
    public String getKey() {
        return mKey;
    }

    @Exclude
    public void setKey(String key) {
        mKey = key;
    }
}
