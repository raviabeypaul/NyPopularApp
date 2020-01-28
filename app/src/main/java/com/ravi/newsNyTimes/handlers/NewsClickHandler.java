package com.ravi.newsNyTimes.handlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.ravi.newsNyTimes.data.model.News;
import com.ravi.newsNyTimes.view.DetailsActivity;

/**
 * Created by Ravi Paul on 2020-01-27.
 */

public class NewsClickHandler {

    private final Context context;

    public NewsClickHandler(Context context) {
        this.context = context;
    }

    public void onSaveClick(View view, News news) {
        Intent nextInt = new Intent(view.getContext(), DetailsActivity.class);
        nextInt.putExtra("SELECTED_NEWS",news);
        context.startActivity(nextInt);
    }
}
