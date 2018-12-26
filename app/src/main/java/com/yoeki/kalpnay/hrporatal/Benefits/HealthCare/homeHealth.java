package com.yoeki.kalpnay.hrporatal.Benefits.HealthCare;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
=======
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
>>>>>>> 97810a8fed45ceb07d3fceb585c36b7874331e05

import com.yoeki.kalpnay.hrporatal.R;

/**
 * Created by IACE on 15-Sep-18.
 */

<<<<<<< HEAD
public class homeHealth extends AppCompatActivity {

=======
public class homeHealth extends AppCompatActivity implements View.OnClickListener{
      private ImageView benefits_back;
      private WebView webview;

      String str="<p><span style=\"font-size: 16pt;\"><strong><span style=\"line-height: 107%;\">Medical Insurance</span></strong></span></p>\n" +
              "<p><span style=\"font-size: 12pt;\">Medical insurance covers the costs of physician and surgeon fees, hospital rooms, and prescription drugs. Dental and optical care might be offered as part of an overall benefits package. It may be offered as separate pieces or not covered at all. Coverage can sometimes include the employee's family (dependents).</span></p>\n" +
              "<p><span style=\"font-size: 12pt;\">Employers usually pay all or part of the premium for employee medical insurance. Often employees pay a percentage of the monthly cost. The cost of insurance through an employer</span></p>";
>>>>>>> 97810a8fed45ceb07d3fceb585c36b7874331e05
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_benefits);
<<<<<<< HEAD
=======

            initialize();

        webview.loadDataWithBaseURL(null, str, "text/html", "UTF-8", null);

        benefits_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
           switch (v.getId()){
               case R.id.benefits_back:

                  finish();
                  break;
           }
    }

    public void initialize(){
        benefits_back=findViewById(R.id.benefits_back);

        webview=findViewById(R.id.webview);

>>>>>>> 97810a8fed45ceb07d3fceb585c36b7874331e05
    }
}
