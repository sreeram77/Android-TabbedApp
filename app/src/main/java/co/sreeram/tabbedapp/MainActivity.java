package co.sreeram.tabbedapp;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {


    public static int [] userImages={R.drawable.pic,R.drawable.pic,R.drawable.pic,R.drawable.pic,R.drawable.pic,R.drawable.pic,R.drawable.pic,R.drawable.pic,R.drawable.pic,R.drawable.pic};
    public static String [] userNameList={"User 1","User 2","User 3","Content 1","Content 2","Content 3","Choice 1","Choice 2","Choice 3","Choice 1"};
    public static int [] flag={1,1,1,2,2,2,3,3,3,2,3,1,1};
    Context context;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public static class PlaceholderFragment extends Fragment {

        public ListView lv;
        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance() {
            PlaceholderFragment fragment = new PlaceholderFragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            lv=(ListView) rootView.findViewById(R.id.listView);

            CustomAdapter adapter1 = new CustomAdapter((MainActivity)getActivity(), userNameList,userImages,flag);
            lv.setAdapter(adapter1);
            return rootView;

        }
    }

    public static class NewFragment extends Fragment {

        public NewFragment() {
        }

        public static NewFragment newInstance() {
            NewFragment fragment = new NewFragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            String link = "https://cdn.pixabay.com/photo/2015/04/22/12/02/butterfly-734654_960_720.jpg";
            View view = inflater.inflate(R.layout.fragment2, container, false);
            ImageView img = (ImageView) view.findViewById(R.id.iImage);
            TextView textView = (TextView) view.findViewById(R.id.tv1);
            textView.setText(link);
            Picasso.with(getContext()).load(link).into(img);

            return view;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    return PlaceholderFragment.newInstance();
                case 1:
                    return NewFragment.newInstance();
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
                    return "TAB ONE";
                case 1:
                    return "TAB TWO";

            }
            return null;
        }
    }
}
