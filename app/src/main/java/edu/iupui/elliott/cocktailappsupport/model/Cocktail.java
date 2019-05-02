package edu.iupui.elliott.cocktailappsupport.model;

public class Cocktail {
    String mName;
    String mCategory;
    String mGlass;

    // No argument constructor needed for Firestore (to use for mapping)
    public Cocktail() {};

    public Cocktail(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public String getGlass() {
        return mGlass;
    }

    public void setGlass(String glass) {
        mGlass = glass;
    }
}
