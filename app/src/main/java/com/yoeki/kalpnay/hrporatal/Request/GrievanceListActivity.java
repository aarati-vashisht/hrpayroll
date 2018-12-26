package com.yoeki.kalpnay.hrporatal.Request;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import com.suke.widget.SwitchButton;
import com.yoeki.kalpnay.hrporatal.Login.Api;
import com.yoeki.kalpnay.hrporatal.Login.ApiInterface;
import com.yoeki.kalpnay.hrporatal.R;
import com.yoeki.kalpnay.hrporatal.setting.preferance;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GrievanceListActivity extends AppCompatActivity implements View.OnClickListener {

    private SwitchButton switch_newgreavance;
    private Button img_backrequestgreveancelist;
    private SwitchCompat newgrievance;
    ApiInterface apiInterface;
    private RecyclerView ryc_grievanceemp;
    private List<Employeegrievancelistmodel.ListGreveance>arrayemplist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grievance_list);

                 initiliaze();

        arrayemplist=new ArrayList<>();
        img_backrequestgreveancelist.setOnClickListener(this);
        newgrievance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                String stat = String.valueOf(isChecked);
                if(stat.equals("true")){
                    Intent intent0=new Intent(getApplicationContext(),GreveanceActivity.class);
//                    Intent intent0=new Intent(getApplicationContext(),Requests.class);
                    startActivity(intent0);
                    finish();
                }else{
                    newgrievance.setChecked(false);
                }
            }
        });
        String  user_id=null;
        user_id = preferance.getInstance(getApplicationContext()).getUserId();
        grievancelist(user_id);
    }
    public  void  initiliaze(){
       // switch_newgreavance=findViewById(R.id.switch_newgreavance);
        img_backrequestgreveancelist=findViewById(R.id.img_backrequestgreveancelist);
        newgrievance=findViewById(R.id.newgrievance);
        ryc_grievanceemp=findViewById(R.id.ryc_grievanceemp);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_backrequestgreveancelist:

                finish();
                break;

        }
    }

    public void grievancelist(String UserId ){

        final ProgressDialog progressDialog = new ProgressDialog(GrievanceListActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show(); // show progress dialogTitle

        apiInterface= Api.getClient().create(ApiInterface.class);

        Employeegrievancelistmodel user = new Employeegrievancelistmodel(UserId);

        Call<Employeegrievancelistmodel> call1 = apiInterface.employeegrivencelist(user);

        call1.enqueue(new Callback<Employeegrievancelistmodel>() {
            @Override
            public void onResponse(Call<Employeegrievancelistmodel> call, Response<Employeegrievancelistmodel> response) {

                Employeegrievancelistmodel user1 = response.body();
                progressDialog.dismiss();
                String str=user1.getMessage();
                String status=user1.getStatus();
                arrayemplist=user1.getListGreveance();

                if (status.equals("Success")){

                    ryc_grievanceemp.setLayoutManager(new LinearLayoutManager(GrievanceListActivity.this, LinearLayoutManager.VERTICAL, false));
                    // rec_leavereqattachment.setLayoutManager(new Hori);
                    ryc_grievanceemp.setItemAnimator(new DefaultItemAnimator());
                    EmpgrievancelistAdapter adapter=new EmpgrievancelistAdapter(GrievanceListActivity.this,arrayemplist);
                    ryc_grievanceemp.setAdapter(adapter);

                }else {
                    Toast.makeText(GrievanceListActivity.this, "Data not found", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Employeegrievancelistmodel> call, Throwable t){
                call.cancel();
                String str= call.toString();
                faillerdiaolog(str);
                //Toast.makeText(LoginActivity.this, "somthing went wrong", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }

    public  void faillerdiaolog(String msg){

        final Dialog dialog = new Dialog(GrievanceListActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.failuremsg);
        TextView tv_failmsg=dialog.findViewById(R.id.tv_failmsg);
        tv_failmsg.setText(msg);
        TextView tv_cancelmsg=dialog.findViewById(R.id.tv_cancelmsg);

        tv_cancelmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

}
