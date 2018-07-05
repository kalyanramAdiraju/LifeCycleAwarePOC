package gmailsample.com.lifecycleaware.Network;

import gmailsample.com.lifecycleaware.models.MainResponse;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by nineleaps on 12/4/18.
 */

public interface WebService {
    @GET("http://services.groupkt.com/country/get/all")
    Call<MainResponse> getUser();

}
