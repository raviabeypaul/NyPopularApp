package com.ravi.newsNyTimes.Repositories;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.ravi.newsNyTimes.data.model.ApiResponse;
import com.ravi.newsNyTimes.data.networking.NewsApi;
import com.ravi.newsNyTimes.data.networking.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    private static NewsRepository newsRepository;
    private static final String TAG = "NewsRepository";
    public static NewsRepository getInstance(){
        if (newsRepository == null){
            newsRepository = new NewsRepository();
        }
        return newsRepository;
    }

    private NewsApi newsApi;

    public NewsRepository(){
        newsApi = RetrofitService.cteateService(NewsApi.class);
    }

    public MutableLiveData<ApiResponse> getNews(String section, String period,
                                                String apiKey){

        Log.e(TAG, "getNews: " );
        final MutableLiveData<ApiResponse> newsData = new MutableLiveData<>();
        newsApi.getNewsDetails(section, period, apiKey).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call,
                                   Response<ApiResponse> response) {
                Log.e(TAG, "onResponse: " + response );
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t);
                newsData.setValue(null);
            }
        });
        return newsData;

    }
}
