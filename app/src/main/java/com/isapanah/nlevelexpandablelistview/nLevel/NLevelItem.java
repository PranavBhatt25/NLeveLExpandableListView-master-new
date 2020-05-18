package com.isapanah.nlevelexpandablelistview.nLevel;

/**
 * Created by sadra on 7/29/17.
 */


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

public class NLevelItem implements NLevelListItem {

    private Object wrappedObject;
    private NLevelItem parent;
    private NLevelView nLevelView;
    private boolean isExpanded = false;

    ///////////
    @NonNull
    public String id;
    @NonNull
    public String title;
    @NonNull
    public String producttitle;
    @NonNull
    public String description;
    @Nullable
    public String image;
    @NonNull
    public String cursor;
    @NonNull
    public String tag;

    public NLevelItem(Object wrappedObject, NLevelItem parent, NLevelView nLevelView) {
        this.wrappedObject = wrappedObject;
        this.parent = parent;
        this.nLevelView = nLevelView;
    }

    public NLevelItem() {

    }

    public Object getWrappedObject() {
        return wrappedObject;
    }

    @Override
    public boolean isExpanded() {
        return isExpanded;
    }

    @Override
    public NLevelListItem getParent() {
        return parent;
    }

    @Override
    public View getView() {
        return nLevelView.getView(this);
    }

    @Override
    public void toggle() {
        isExpanded = !isExpanded;
    }


    ////////////////
    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public void setProducttitle(@NonNull String producttitle) {
        this.producttitle = producttitle;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @Nullable
    public String getImage() {
        return image;
    }

    public void setImage(@Nullable String image) {
        this.image = image;
    }

    @NonNull
    public String getCursor() {
        return cursor;
    }

    public void setCursor(@NonNull String cursor) {
        this.cursor = cursor;
    }

    @NonNull
    public String getTag() {
        return tag;
    }

    public void setTag(@NonNull String tag) {
        this.tag = tag;
    }

    @NonNull
    public String getProducttitle() {
        return producttitle;
    }
}