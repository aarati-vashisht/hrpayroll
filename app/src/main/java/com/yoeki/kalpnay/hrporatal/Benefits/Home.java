package com.yoeki.kalpnay.hrporatal.Benefits;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
<<<<<<< HEAD
=======
import android.view.View;
import android.widget.ImageView;
>>>>>>> 97810a8fed45ceb07d3fceb585c36b7874331e05

import com.yoeki.kalpnay.hrporatal.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IACE on 13-Sep-18.
 */

public class Home extends AppCompatActivity {
<<<<<<< HEAD
    RecyclerView Benefits_List;
    List<String> benefit_lists;
=======

    RecyclerView Benefits_List;
    List<String> benefit_lists;
    ImageView img_benifitsback;
>>>>>>> 97810a8fed45ceb07d3fceb585c36b7874331e05

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.benefit_home);

        Benefits_List = (RecyclerView)findViewById(R.id.Benefits_List);
<<<<<<< HEAD
=======
        img_benifitsback=findViewById(R.id.img_benifitsback);

        img_benifitsback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
>>>>>>> 97810a8fed45ceb07d3fceb585c36b7874331e05

       recycler_benefit();
    }

    public void recycler_benefit(){
        benefit_lists = new ArrayList<>();
<<<<<<< HEAD
        benefit_lists.add("Health Care");
        benefit_lists.add("Critical/Illness");
        benefit_lists.add("Personal Benefits");
        benefit_lists.add("Retirement Benefits");
        benefit_lists.add("Flexible Benefits");
        benefit_lists.add("Creative Benefits/Perks");
        benefit_lists.add("Office Ergonomics");

        try {
            Benefits_List.setLayoutManager(new LinearLayoutManager(this));
            benefit_homeRecycler radapter = new benefit_homeRecycler(this,benefit_lists);
                Benefits_List.setAdapter(radapter);
        }catch (Exception e){
=======
        benefit_lists.add("Medical Insurance");
        benefit_lists.add("Critical illness");
        benefit_lists.add("Personal Benefits");
        benefit_lists.add("Retirement Benefits");
        /*benefit_lists.add("Flexible Benefits");
        benefit_lists.add("Creative Benefits/Perks");
        benefit_lists.add("Office Ergonomics");
*/
        try {
            Benefits_List.setLayoutManager(new LinearLayoutManager(this));
              benefit_homeRecycler radapter = new benefit_homeRecycler(this,benefit_lists);
                Benefits_List.setAdapter(radapter);
           }catch (Exception e){
>>>>>>> 97810a8fed45ceb07d3fceb585c36b7874331e05
            e.printStackTrace();
        }
    }
}
