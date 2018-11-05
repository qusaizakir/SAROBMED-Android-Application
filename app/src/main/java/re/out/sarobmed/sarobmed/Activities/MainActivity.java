package re.out.sarobmed.sarobmed.Activities;

import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import re.out.sarobmed.sarobmed.Fragments.IncompleteReportsFragment;
import re.out.sarobmed.sarobmed.Fragments.SyncedReportsFragment;
import re.out.sarobmed.sarobmed.Fragments.UnsyncedReportsFragment;
import re.out.sarobmed.sarobmed.R;

public class MainActivity extends AppCompatActivity {

    //Variable for fragment management
    final FragmentManager fm = getSupportFragmentManager();
    final SyncedReportsFragment syncedReportsFragment = new SyncedReportsFragment();
    final UnsyncedReportsFragment unsyncedReportsFragment = new UnsyncedReportsFragment();
    final IncompleteReportsFragment incompleteReportsFragment = new IncompleteReportsFragment();

    //Variables for views
    BottomNavigationView navigation;
    AppBarLayout appBarLayout;
    Toolbar toolbar;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialise all views
        initViews();
        setupBottomNavigation();
        setupToolbar();

        //Set initial fragment as synced reports
        fm.beginTransaction().add(R.id.main_container, syncedReportsFragment, "sync").commit();

    }

    private void initViews() {
        navigation = findViewById(R.id.navigation);
        appBarLayout = findViewById(R.id.main_appbarlayout);
        toolbar = findViewById(R.id.main_toolbar);
        fab = findViewById(R.id.fab);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
            getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
        }
    }

    private void setupBottomNavigation() {
        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_synced:
                        fm.beginTransaction().replace(R.id.main_container, syncedReportsFragment).commit();
                        return true;

                    case R.id.navigation_unsynced:
                        fm.beginTransaction().replace(R.id.main_container, unsyncedReportsFragment).commit();
                        return true;

                    case R.id.navigation_incomplete:
                        fm.beginTransaction().replace(R.id.main_container, incompleteReportsFragment).commit();
                        return true;
                }
                return false;
            }
        };

        navigation.setSelectedItemId(R.id.navigation_synced);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
