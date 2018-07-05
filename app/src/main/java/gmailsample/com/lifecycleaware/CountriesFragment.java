package gmailsample.com.lifecycleaware;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import gmailsample.com.lifecycleaware.Adapters.RecyclerViewAdapter;
import gmailsample.com.lifecycleaware.models.CountryViewModel;
import gmailsample.com.lifecycleaware.models.MainResponse;


public class CountriesFragment extends Fragment {

    CountryViewModel mCountryViewModel;
    RecyclerViewAdapter mAdapter;
    View view;

    @BindView(R.id.robin)
    RecyclerView mRecyclerView;

    public CountriesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCountryViewModel = ViewModelProviders.of(this).get(CountryViewModel.class);
        mCountryViewModel.init();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_countries, container, false);
        ButterKnife.bind(this, view);
        setUpRecyclerView();
        return view;
    }

    private void setUpRecyclerView() {
        mAdapter = new RecyclerViewAdapter(getContext(), mCountryViewModel.getCountries());
        mCountryViewModel.getCountries().observe(this, new Observer<MainResponse>() {
            @Override
            public void onChanged(@Nullable MainResponse mainResponse) {
                if (mainResponse!=null){
                    mRecyclerView.setAdapter(mAdapter);
                }
            }
        });
    }


}
