package gmailsample.com.lifecycleaware;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            CountriesFragment fragment = new CountriesFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.robin_frame, fragment,fragment.getTag()).commit();
        }
    }
}

