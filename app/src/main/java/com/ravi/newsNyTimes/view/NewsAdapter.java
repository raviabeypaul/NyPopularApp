package com.ravi.newsNyTimes.view;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;


import com.google.gson.internal.LinkedTreeMap;
import com.ravi.newsNyTimes.databinding.NewsDataBinding;
import com.ravi.newsNyTimes.data.model.News;
import com.ravi.newsNyTimes.handlers.NewsClickHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravi on 2018-08-08.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private final Context mContext;
    private final List<News> newsList;
    private LayoutInflater layoutInflater;
    private static final String TAG = "NewsAdapter";

    NewsAdapter(Context context, List<News> dataList) {
        this.mContext = context;
        this.newsList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        NewsDataBinding dataBinding = NewsDataBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(dataBinding);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //SET VIEW DATA
        final News news = newsList.get(position);
        holder.bind(news);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final NewsDataBinding newsDataBinding;

        ViewHolder(NewsDataBinding dataBinding) {
            super(dataBinding.getRoot());
            this.newsDataBinding = dataBinding;
            newsDataBinding.setHandler(new NewsClickHandler(mContext));
        }

        void bind(News news) {
            Object objects [] = news.getMedia();
            LinkedTreeMap<Object, Object> map = (LinkedTreeMap<Object, Object>) objects[0];
            ArrayList arrayList = (ArrayList) map.get("media-metadata");
            LinkedTreeMap<Object, Object> mediaObbj = (LinkedTreeMap<Object, Object>) arrayList.get(0);
            String url = (String) mediaObbj.get("url");
            news.setImageUrl(url);
            this.newsDataBinding.setNews(news);
        }
    }
}
