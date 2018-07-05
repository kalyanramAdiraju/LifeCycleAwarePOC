package gmailsample.com.lifecycleaware.models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import gmailsample.com.lifecycleaware.Repository.CountriesRepository;

/**
 * Created by nineleaps on 12/4/18.
 */

public class CountryViewModel extends ViewModel {
    private LiveData<MainResponse> countries;
    private CountriesRepository mCountriesRepository;

    @Inject
    public CountryViewModel(CountriesRepository mCountriesRepository) {
        this.mCountriesRepository = mCountriesRepository;
    }

    public void init() {
        if (this.countries != null) {
            return;
        }
        countries = mCountriesRepository.getCountriesData();
    }


    public LiveData<MainResponse> getCountries() {
        return countries;
    }

    public void setCountries(LiveData<MainResponse> countries) {
        this.countries = countries;
    }
}
