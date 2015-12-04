package ru.malroy.tiomediatesttask.presentation.photos.tabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import ru.malroy.tiomediatesttask.R;
import ru.malroy.tiomediatesttask.presentation.TiomediaApplication;
import ru.malroy.tiomediatesttask.presentation.di.HasComponent;
import ru.malroy.tiomediatesttask.presentation.photos.tabs.popular.PopularPhotosFragment;
import ru.malroy.tiomediatesttask.presentation.photos.tabs.today.TodayPhotosFragment;

public class MainActivity extends AppCompatActivity implements HasComponent<PhotosComponent> {

    private PhotosComponent photosComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PhotosPagerAdapter photosPagerAdapter = new PhotosPagerAdapter(getSupportFragmentManager());

        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(photosPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public PhotosComponent getComponent() {
        if (photosComponent == null) {
            photosComponent = DaggerPhotosComponent.builder()
                    .appComponent(TiomediaApplication.getAppComponent())
                    .build();
        }
        return photosComponent;
    }

    public class PhotosPagerAdapter extends FragmentStatePagerAdapter {

        public PhotosPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return PopularPhotosFragment.newInstance();
                case 1:
                    return TodayPhotosFragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "POPULAR";
                case 1:
                    return "TODAY";
            }
            return null;
        }
    }
}
