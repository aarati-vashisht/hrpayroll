package com.yoeki.kalpnay.hrporatal.Request.Leave;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.yoeki.kalpnay.hrporatal.HomeMenu.Menuitemmodel;
import com.yoeki.kalpnay.hrporatal.Login.Api;
import com.yoeki.kalpnay.hrporatal.Login.ApiInterface;
import com.yoeki.kalpnay.hrporatal.R;
import com.yoeki.kalpnay.hrporatal.Request.Attachmentview_adapter;
import com.yoeki.kalpnay.hrporatal.Request.NewShiftFragment;
import com.yoeki.kalpnay.hrporatal.Request.PreShiftFragment;
import com.yoeki.kalpnay.hrporatal.Request.RequestMenu;
import com.yoeki.kalpnay.hrporatal.Request.SaveLeave;
import com.yoeki.kalpnay.hrporatal.Request.ShiftChange;
import com.yoeki.kalpnay.hrporatal.TimeAttendance.TimeAttendance_Menu;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaveRequest extends AppCompatActivity implements View.OnClickListener {
    private ImageView img_backrequest;
    String str="temp",whereCome,filepath;
    ViewPager viewpager_leavepager;
    TabLayout tabs_leavetab;
    ArrayList<Menuitemmodel>arrayreqattachlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_request);
        arrayreqattachlist=new ArrayList<>();
        Intent intent= getIntent();
        whereCome = intent.getStringExtra("whereCome");

        initialize();

        setupViewPager(viewpager_leavepager);
        tabs_leavetab.setupWithViewPager(viewpager_leavepager);

        img_backrequest.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(whereCome.equals("fromRequest")) {
            Intent intent = new Intent(getApplicationContext(), RequestMenu.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(getApplicationContext(), TimeAttendance_Menu.class);
            startActivity(intent);
        }
    }
    public  void initialize(){

        img_backrequest=findViewById(R.id.img_backrequest);
        viewpager_leavepager=findViewById(R.id.viewpager_leavepager);
        tabs_leavetab=findViewById(R.id.tabs_leavetab);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NewLeaveFragment(), "Leave Request");
        adapter.addFragment(new LeavepreRecordFragment(), "Leave History");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.img_backrequest:
                finish();
                break;

        }
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


   /* @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK&&requestCode==2) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            final InputStream imageStream;
            try {
                imageStream = LeaveRequest.this.getContentResolver().openInputStream(selectedImage);

                Bitmap Image = BitmapFactory.decodeStream(imageStream);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                Image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] byteArrayImage = baos.toByteArray();
                filepath = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);
                Menuitemmodel dataitem=new Menuitemmodel(Image);
                arrayreqattachlist.add(dataitem);
                  new NewLeaveFragment().arraylistbind(arrayreqattachlist);
                //                Image = getResizedBitmap(Image, 400);
                ByteArrayOutputStream baoss = new ByteArrayOutputStream();
                //  Image.compress(Bitmap.CompressFormat.PNG, 100, baoss); //bm is the bitmap object
                //byte[] bb = baoss.toByteArray();
                // String final_path = Base64.encodeToString(bb, Base64.DEFAULT);
                // Get the cursor
                Cursor cursor = LeaveRequest.this.getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                // stu_image.setImageBitmap(Image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();

           ]
        }
    }*/


}
