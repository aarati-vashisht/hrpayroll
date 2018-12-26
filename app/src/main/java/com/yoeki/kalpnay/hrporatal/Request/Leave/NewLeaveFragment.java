package com.yoeki.kalpnay.hrporatal.Request.Leave;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.yoeki.kalpnay.hrporatal.HomeMenu.Menuitemmodel;
import com.yoeki.kalpnay.hrporatal.Login.ApiInterface;
import com.yoeki.kalpnay.hrporatal.R;
import com.yoeki.kalpnay.hrporatal.Request.Attachmentview_adapter;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import cn.pedant.SweetAlert.SweetAlertDialog;

import static android.app.Activity.RESULT_OK;


public class NewLeaveFragment extends Fragment implements View.OnClickListener {


    private TextView tv_leavereqfromdate,tv_leavereqtodate,tv_leavereqtype,tv_leavereqattachment,edt_leavereqdescription,
            tv_totalday,tv_leavebalance;
    private int mYear, mMonth, mDay;
    private AppCompatButton img_backrequest;
    private LinearLayout ly_leavereqattachment,ly_leaveattachment;
    private RecyclerView rec_leavereqattachment;
    ArrayList<Menuitemmodel> arrayreqattachlist;
    LinearLayoutManager linearlayoutmanager;
    String str="temp",whereCome,filepath;
    Button time_entrySubmit;
    ApiInterface apiInterface;
    Date fromDate,toDate;
    NewLeaveFragment fragment;
    View view;
    public static NewLeaveFragment newInstance() {

        //initialize();
        NewLeaveFragment fragment = new NewLeaveFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         view = inflater.inflate(R.layout.fragment_leavenew, container, false);

        Intent intent= getActivity().getIntent();
        whereCome = intent.getStringExtra("whereCome");

        initialize();

        arrayreqattachlist=new ArrayList<>();

        tv_leavereqfromdate.setOnClickListener(this);
        tv_leavereqtodate.setOnClickListener(this);
        tv_leavereqtype.setOnClickListener(this);
       // img_backrequest.setOnClickListener(this);
        tv_leavereqattachment.setOnClickListener(this);
        time_entrySubmit.setOnClickListener(this);

        return view;
    }

    public  void initialize(){

        tv_leavereqfromdate=view.findViewById(R.id.tv_leavereqfromdate);
        tv_leavereqtodate=view.findViewById(R.id.tv_leavereqtodate);
        tv_leavereqtype=view.findViewById(R.id.tv_leavereqtype);
        //img_backrequest=view.findViewById(R.id.img_backrequest);
        tv_leavereqattachment=view.findViewById(R.id.tv_leavereqattachment);
        ly_leavereqattachment=view.findViewById(R.id.ly_leavereqattachment);
        rec_leavereqattachment=view.findViewById(R.id.rec_leavereqattachment);
        ly_leaveattachment=view.findViewById(R.id.ly_leaveattachment);
        tv_leavebalance=view.findViewById(R.id.tv_leavebalance);
        tv_totalday=view.findViewById(R.id.tv_totalday);
        edt_leavereqdescription=view.findViewById(R.id.edt_leavereqdescription);
        time_entrySubmit=view.findViewById(R.id.time_entrySubmit);

    }

    public  void fromdate(){

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        Calendar cc = Calendar.getInstance();
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        final String getCurrentDateTime = sdf.format(cc.getTime());

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        tv_leavereqfromdate.setText(year + "/" + (monthOfYear + 1) +"/"+dayOfMonth );

                        String strtodate=year + "/" + (monthOfYear + 1) +"/"+dayOfMonth;

                        Date date2 = null;
                        Date date1=null;
                        try {
                            date1 = sdf.parse(getCurrentDateTime);
                            date2 = sdf.parse(strtodate);
                            fromDate=sdf.parse(strtodate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (date1.compareTo(date2) < 0)
                        {
                            tv_leavereqfromdate.setText(strtodate );
                            // Log.d("Return","getMyTime smaller than getCurrentDateTime ");
                        }
                        else {
                            tv_leavereqfromdate.setText(getCurrentDateTime );
                            //  tv_leavereqfromdate.setError("select correct date");
                        }

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    public  void todate(){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        Calendar cc = Calendar.getInstance();
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        final String getCurrentDateTime = sdf.format(cc.getTime());

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        tv_leavereqtodate.setText(year + "/" + (monthOfYear + 1) +"/"+dayOfMonth );

                        String strtodate=year + "/" + (monthOfYear + 1) +"/"+dayOfMonth;

                        Date date2 = null;
                        Date date1=null;
                        try {
                            date1 = sdf.parse(getCurrentDateTime);
                            date2 = sdf.parse(strtodate);
                            toDate= sdf.parse(strtodate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (date1.compareTo(date2) < 0)
                        {
                            tv_leavereqtodate.setText(strtodate );
                            getage();
                            // Log.d("Return","getMyTime smaller than getCurrentDateTime ");
                        }
                        else {
                            tv_leavereqtodate.setText(getCurrentDateTime );
                            // tv_leavereqtodate.setError("select correct date");
                        }

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void leavetypedialog(){
        final RadioGroup radioGroup_leavetype;
        TextView tv_leavereqsubmit;
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.leavetype_dialog);

        radioGroup_leavetype=dialog.findViewById(R.id.radioGroup_leavetype);

        radioGroup_leavetype.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Button btn=radioGroup_leavetype.findViewById(i);

                str=btn.getText().toString();
                tv_leavereqtype.setText(btn.getText().toString());

            }
        });
        tv_leavereqsubmit=dialog.findViewById(R.id.tv_leavereqsubmit);

        tv_leavereqsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (str.equals("temp")){
                    Toast.makeText(getActivity(), "Please select leave type", Toast.LENGTH_SHORT).show();
                }else{
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    public void uploadattachmentdialog(final Activity activity){

        final CharSequence[] options = {"Choose from Gallery","Choose from file", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("upload file");
        builder.setItems(options, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int item)
            {
                if (options[item].equals("Choose from Gallery"))
                {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    activity.startActivityForResult(intent, 2);
                }else if (options[item].equals("Choose from file")){

                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                    intent.setType("file/*");
                    getActivity().startActivityForResult(intent, 3);

                }
                else if (options[item].equals("Cancel"))
                {
                    dialog.dismiss();
                }
            }
        });

        builder.show();
    }

    public void uploadattachmentdialog(){

        final CharSequence[] options = {"Choose from Gallery","Choose from file", "Cancel"};

        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getContext());
        builder.setTitle("upload file");
        builder.setItems(options, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int item)
            {
                if (options[item].equals("Choose from Gallery"))
                {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);
                }else if (options[item].equals("Choose from file")){

                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                    intent.setType("file/*");
                    startActivityForResult(intent, 3);

                }
                else if (options[item].equals("Cancel"))
                {
                    dialog.dismiss();
                }
            }
        });

        builder.show();
    }


    public void getage(){
        int age=0;

        long diff = toDate.getTime() - fromDate.getTime();
        long seconds = diff / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = (hours / 24) + 1;

        tv_totalday.setText(String.valueOf(days));
    }

    public  void leave(){
        new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("This is paid leave")
                .setConfirmText("Yes")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {

                        Toast.makeText(getActivity(), "Submitted Successfully", Toast.LENGTH_SHORT).show();
                        sDialog.dismissWithAnimation();

                    }
                })
                .setCancelButton("Cancel", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                    }
                })
                .show();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.tv_leavereqfromdate:
                fromdate();
                break;
            case R.id.tv_leavereqtodate:
                todate();
                break;
            case R.id.tv_leavereqtype:
                leavetypedialog();
                break;
            case R.id.tv_leavereqattachment:
                uploadattachmentdialog();
                break;
            case R.id.time_entrySubmit:

                String strbalance=tv_leavebalance.getText().toString();
                String strtotaldays=tv_totalday.getText().toString();
             /* String  user_id=null;
              user_id = preferance.getInstance(getApplicationContext()).getUserId();
              String strfromdate= tv_leavereqfromdate.getText().toString();
              String leavereqtoda= tv_leavereqtodate.getText().toString();
              String leavereqtype= tv_leavereqtype.getText().toString();
              String leavereqdescription= edt_leavereqdescription.getText().toString();*/
                //saveleave(user_id,"2",strfromdate,leavereqtoda,leavereqdescription,"image",filepath,"png");
                if (Integer.parseInt(strtotaldays)>Integer.parseInt(strbalance)){
                    leave();
                }else {
                    Toast.makeText(getActivity(), "Submitted Successfully!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    public void arraylistbind(ArrayList<Menuitemmodel>arrayreqattachlist){
     //   initialize();
        if (arrayreqattachlist.size()>0){
            ly_leaveattachment.setVisibility(View.GONE);
            ly_leavereqattachment.setVisibility(View.VISIBLE);

            rec_leavereqattachment.setHasFixedSize(true);

            linearlayoutmanager = new LinearLayoutManager(getActivity());

            rec_leavereqattachment.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
            // rec_leavereqattachment.setLayoutManager(new Hori);
            rec_leavereqattachment.setItemAnimator(new DefaultItemAnimator());

            Attachmentview_adapter adapter=new Attachmentview_adapter(getActivity(),arrayreqattachlist);
            rec_leavereqattachment.setAdapter(adapter);
        }else{
            ly_leavereqattachment.setVisibility(View.GONE);
            ly_leaveattachment.setVisibility(View.VISIBLE);
        }
    }


   //  @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK&&requestCode==2) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            final InputStream imageStream;
            try {
                imageStream = getActivity().getContentResolver().openInputStream(selectedImage);
                Bitmap Image = BitmapFactory.decodeStream(imageStream);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                Image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] byteArrayImage = baos.toByteArray();
                filepath = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);
                Menuitemmodel dataitem=new Menuitemmodel(Image);
                arrayreqattachlist.add(dataitem);
                  arraylistbind(arrayreqattachlist);
                ByteArrayOutputStream baoss = new ByteArrayOutputStream();
                Cursor cursor = getActivity().getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
