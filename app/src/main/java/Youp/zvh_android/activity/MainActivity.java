package youp.zvh_android.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.AbstractMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import youp.zvh_android.R;
import youp.zvh_android.fragments.ContactFragment;
import youp.zvh_android.fragments.DiaryFragment;
import youp.zvh_android.fragments.HomeFragment;
import youp.zvh_android.fragments.MeasurementStep1Fragment;
import youp.zvh_android.fragments.ServiceFragment;
import youp.zvh_android.helpers.BottomNavigationViewHelper;
import youp.zvh_android.models.HealthIssue;
import youp.zvh_android.models.Measurement;
import youp.zvh_android.webservice.APIService;
import youp.zvh_android.webservice.RetrofitClient;

public class MainActivity extends AppCompatActivity implements Callback<List<HealthIssue>> {

    private Fragment fg;
    private Measurement measurement;
    private APIService apiService;
    private List<HealthIssue> healthIssues;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.measurement:
                    setTitle("Meting");
                    fg = new HomeFragment();
                    setFragment(fg);
                    return true;
                case R.id.diary:
                    setTitle("Mijn Dagboek");
                    fg = new DiaryFragment();
                    setFragment(fg);
                    return true;

                case R.id.contact:
                    setTitle("Contact");
                    fg = new ContactFragment();
                    setFragment(fg);
                    return true;

                case R.id.settings:
                    setTitle("Service");
                    fg = new ServiceFragment();
                    setFragment(fg);
                    return true;

            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        measurement = new Measurement();

        Retrofit retrofit = RetrofitClient.getClient("https://zvh-api.herokuapp.com/");
        apiService = retrofit.create(APIService.class);

        apiService.getAllHealthIssues().enqueue(this);

        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
        customizeNav();

        setTitle("Meting");
        fg = new HomeFragment();
        setFragment(fg);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void onBackPressed() {

        fg.getFragmentManager().popBackStackImmediate();
    }

    public void setFragment(Fragment fg)
    {
        FragmentTransaction fgTransition = getSupportFragmentManager().beginTransaction();
        fgTransition.replace(R.id.content, fg);
        fgTransition.commit();
    }
    public void customizeNav()
    {
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView = menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();

            //icon height and weight
            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, displayMetrics);
            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, displayMetrics);
            iconView.setLayoutParams(layoutParams);
        }
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }


    @Override
    public void onResponse(Call<List<HealthIssue>> call, Response<List<HealthIssue>> response) {
        healthIssues = response.body();
    }

    @Override
    public void onFailure(Call<List<HealthIssue>> call, Throwable t) {

    }
}
