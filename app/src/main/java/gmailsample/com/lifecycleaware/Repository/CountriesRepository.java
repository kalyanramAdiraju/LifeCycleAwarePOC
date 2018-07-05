package gmailsample.com.lifecycleaware.Repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import javax.inject.Singleton;

import gmailsample.com.lifecycleaware.Network.RestClient;
import gmailsample.com.lifecycleaware.models.MainResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nineleaps on 12/4/18.
 */
@Singleton
public class CountriesRepository {
    public LiveData<MainResponse> getCountriesData(){
    final MutableLiveData<MainResponse> data =new MutableLiveData<>();
        RestClient.getWebServiceData().getUser().enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                if (response.isSuccessful()){
                    data.setValue(response.body());
                }else {
                    Log.d("response","2");
                }
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
            Log.d("response","1");
            }
        });
        return data;
    }

}
