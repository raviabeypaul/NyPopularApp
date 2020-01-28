package com.ravi.newsNyTimes.view;

import android.os.Bundle;

import android.view.MenuItem;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.ravi.newsNyTimes.R;
import com.ravi.newsNyTimes.databinding.ActivityDetailsBinding;
import com.ravi.newsNyTimes.data.model.News;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        News news = (News) getIntent().getSerializableExtra("SELECTED_NEWS");

        ActivityDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        binding.setNews(news);
        ImageView imageView = findViewById(R.id.iv);
        Glide.with(this.getApplicationContext()).load("https://prodvdo.blob.core.windows.net/vdothumb/5860f05dfff8b0fb255dd461/4xow04mrt7bzq2pmx0njw0zfr.15939d7f6-0347-4487-a98f-6b2e84d9d32a").into(imageView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
