package com.yoeki.kalpnay.hrporatal.Profile;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.yoeki.kalpnay.hrporatal.HomeMenu.HomeActivity;
import com.yoeki.kalpnay.hrporatal.Login.Api;
import com.yoeki.kalpnay.hrporatal.Profile.BankDetails.BankAccountDetails;
import com.yoeki.kalpnay.hrporatal.Profile.Certification.Certification;
import com.yoeki.kalpnay.hrporatal.Profile.Dependent.Dependent;
import com.yoeki.kalpnay.hrporatal.Profile.Model.APIInterface;
import com.yoeki.kalpnay.hrporatal.Profile.Model.user_info.BasicUserInfo;
import com.yoeki.kalpnay.hrporatal.Profile.Model.user_info.User;
import com.yoeki.kalpnay.hrporatal.Profile.Model.user_info.UserSend_Data;
import com.yoeki.kalpnay.hrporatal.Profile.Qualification.Qualification;
import com.yoeki.kalpnay.hrporatal.R;
import com.yoeki.kalpnay.hrporatal.setting.TextclassTextFrHeader;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends AppCompatActivity {
    ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    TextclassTextFrHeader headerName;
    Button Pro_back;
    private final static String API_KEY = "";
    private static List<String> DataList;
    List<BasicUserInfo> userInfoList;
    ProgressDialog PD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profie);

        PD = new ProgressDialog(Profile.this);
        PD.setMessage("Loading...");
        PD.setCancelable(false);
        PD.show();
        serverCode();

        viewPager = (ViewPager) findViewById(R.id.frame_layout);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        headerName = (TextclassTextFrHeader) findViewById(R.id.profileHeader);
        Pro_back = (Button)findViewById(R.id.Pro_back);
        headerName.setText("Profile");
        disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.profile:
                                headerName.setText("Profile");
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.bank:
                                headerName.setText("Bank Details");
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.qualification:
                                headerName.setText("Education");
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.certification:
                                headerName.setText("Certification");
                                viewPager.setCurrentItem(3);
                                break;
                            case R.id.dependent:
                                headerName.setText("Dependent");
                                viewPager.setCurrentItem(4);
                                break;
                        }

                        return true;
                    }
                });

        Pro_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi

                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }

    public void serverCode(){
        APIInterface apiInterface = Api.getClient().create(APIInterface.class);
        UserSend_Data user = new UserSend_Data("1");
        Call<User> call2 = apiInterface.idUser(user);

        call2.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user1 = response.body();
                try {
                    String status = user1.status;
                    String mess = user1.message;
                    PD.dismiss();
                }catch(Exception e){
                    e.printStackTrace();
                }
                setViewPager(user1);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }

    private void setViewPager(User user) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new Personal_Info(),user);
        viewPagerAdapter.addFragment(new BankAccountDetails(), user);
        viewPagerAdapter.addFragment(new Qualification(), user);
        viewPagerAdapter.addFragment(new Certification(), user);
        viewPagerAdapter.addFragment(new Dependent(), user);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position==0){
                    headerName.setText("Profile");
                }if(position==1){
                    headerName.setText("Bank Details");
                }if(position==2){
                    headerName.setText("Qualification");
                }if(position==3){
                    headerName.setText("Certification");
                }if(position==4){
                    headerName.setText("Dependent");
                }
            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private ArrayList<Fragment> mFragmentList=new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return 5;
        }

        public void addFragment(Fragment fragment, User user) {
            try {

                ArrayList<User> dataofProfile = new ArrayList<User>();
                dataofProfile.add(user);
                Bundle bundle = new Bundle();
                bundle.putSerializable("keyForProfile", dataofProfile);
                fragment.setArguments(bundle);
                mFragmentList.add(fragment);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}