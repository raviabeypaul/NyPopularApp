package com.ravi.newsNyTimes.data.model;



import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Ravi Paul on 2020-01-27.
 */

public class News extends BaseObservable implements Serializable {

    private static final String TAG = "News";
    @SerializedName("title")
    @Bindable
    private final String title;

    @SerializedName("byline")
    @Bindable
    private final String byline;

    @SerializedName("published_date")
    @Bindable
    private final String published_date;

    @SerializedName("url")
    @Bindable
    private final String url;

    @SerializedName("media")
    @Bindable
    private Object media[];

    @SerializedName("abstract")
    private String abstractText;

    @Bindable
    private String imageUrl;

    public News(String byline, String title, String published_date, String url, Object media[], String abstractText) {
        this.title = title;
        this.byline = byline;
        this.published_date = published_date;
        this.url = url;
        this.media = media;
        this.abstractText = abstractText;


//        notifyPropertyChanged(BR.title);
//        notifyPropertyChanged(BR.byline);
//        notifyPropertyChanged(BR.published_date);
    }

    public String getTitle() {
        return title;
    }

    public String getByline() {
        return byline;
    }

    public String getPublished_date() {
        return published_date;
    }

    public String getUrl() { return url; }

    public Object[] getMedia(){return  media;}

    public String getAbstractText(){ return abstractText; }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl){
        Log.e(TAG, "loadImage: " +imageUrl );
        Glide.with(view.getContext()).load(imageUrl).apply(new RequestOptions().circleCrop()).into(view);
    }
}
