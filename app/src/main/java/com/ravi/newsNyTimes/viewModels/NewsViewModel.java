package com.ravi.newsNyTimes.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ravi.newsNyTimes.Repositories.NewsRepository;
import com.ravi.newsNyTimes.data.model.ApiResponse;
import com.ravi.newsNyTimes.utility.Constant;


public class NewsViewModel extends AndroidViewModel {

    private String sections = "all-sections";
    private String period = "1";
    private MutableLiveData<ApiResponse> mutableLiveData;
    private NewsRepository newsRepository;

    public NewsViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        newsRepository = NewsRepository.getInstance();
        mutableLiveData = new MutableLiveData<>();
    }

    public void getData(){
        mutableLiveData = newsRepository.getNews(sections, period, Constant.API_KEY);
    }

    public LiveData<ApiResponse> getNewsLiveData() {
        return mutableLiveData;
    }

}
