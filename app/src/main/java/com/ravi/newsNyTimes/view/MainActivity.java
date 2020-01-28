package com.ravi.newsNyTimes.view;


import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ravi.newsNyTimes.R;
import com.ravi.newsNyTimes.data.model.News;
import com.ravi.newsNyTimes.viewModels.NewsViewModel;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView noDataTv;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    NewsViewModel newsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG, "onCreate: " );
        inits();
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        newsViewModel.init();
        newsViewModel.getData();
        newsViewModel.getNewsLiveData().observe(this, newsReponse -> {
            List<News> newsList = newsReponse.getResults();
            setupRecycler(newsList);
        });
    }

    private void inits() {
        progressBar =  findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        noDataTv =  findViewById(R.id.textViewNoData);
        recyclerView =  findViewById(R.id.recycler_news);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), 0));
    }

    private void setupRecycler(List<News> dataList) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NewsAdapter(this, dataList));
        Log.e(TAG, "setupRecycler: " +dataList );
        assert dataList != null;
        if (dataList!=null && dataList.size() > 0) {
            dataVisible();
        } else {
            showError("No News..!");
        }
    }

    private void showError(String message) {
        noDataTv.setText(message);
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        noDataTv.setVisibility(View.VISIBLE);
    }

    private void dataVisible() {
        noDataTv.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }


}
