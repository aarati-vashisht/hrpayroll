package com.yoeki.kalpnay.hrporatal.Request.shiftchangemanager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.yoeki.kalpnay.hrporatal.R;
import com.yoeki.kalpnay.hrporatal.Request.NewShiftFragment;
import com.yoeki.kalpnay.hrporatal.Request.PreShiftFragment;
import com.yoeki.kalpnay.hrporatal.Request.ShiftChange;

import java.util.ArrayList;
import java.util.List;

public class ShiftmanagerHomeactivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_shiftmangerback;
    private TabLayout tabs_changeshiftmana;
    private ViewPager viewpager_changeshiftmana;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shiftmanager_homeactivity);

        initialize();

        setupViewPager(viewpager_changeshiftmana);
        tabs_changeshiftmana.setupWithViewPager(viewpager_changeshiftmana);

        img_shiftmangerback.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.img_shiftmangerback:
                finish();
                break;
        }

    }

    public void initialize(){

        img_shiftmangerback=findViewById(R.id.img_shiftmangerback);
        tabs_changeshiftmana=findViewById(R.id.tabs_changeshiftmana);
        viewpager_changeshiftmana=findViewById(R.id.viewpager_changeshiftmana);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NewShiftFragment(), "New");
        adapter.addFragment(new PreShiftFragment(), "Pre- Record");
        adapter.addFragment(new AllRequestFragment(), "All Request");
        adapter.addFragment(new AcceptedRequestFragment(), "Accepted Request");
       // adapter.addFragment(new RejectedRequestFragment(), "Rejected Request");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }
        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
