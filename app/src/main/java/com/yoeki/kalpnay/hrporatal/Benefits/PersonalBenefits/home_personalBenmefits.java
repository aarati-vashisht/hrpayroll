package com.yoeki.kalpnay.hrporatal.Benefits.PersonalBenefits;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import com.yoeki.kalpnay.hrporatal.R;

/**
 * Created by IACE on 15-Sep-18.
 */

public class home_personalBenmefits extends AppCompatActivity {

      ImageView personal_back;
      WebView web_personalbenifits;
      String str="<p><strong><span style=\"font-size: 16pt;\">Personal Benefits</span></strong></p>\n" +
              "<div id=\"mntl-sc-block_1-0-19\" class=\"comp mntl-sc-block mntl-sc-block-html\">\n" +
              "<p><span style=\"font-size: 12pt;\">Almost half the (medium and large) employers surveyed offered either a defined benefit or a defined contribution pension plan. About 75% offered&nbsp;health insurance, but almost all required some employee contribution towards the cost. It's not hard to look at the averages and see how your employer or your job offer measures up.</span></p>\n" +
              "</div>\n" +
              "<div id=\"mntl-sc-block_1-0-21\" class=\"comp mntl-sc-block mntl-sc-block-html\">\n" +
              "<p><span style=\"font-size: 12pt;\">In addition, there is an increasing use of bonuses, perks, and incentives by employers to recruit and retain employees. Look at the companies rated the&nbsp;best places to work&nbsp;and you'll discover many offer health club memberships, flexible schedules, daycare, tuition reimbursement, and even on-site dry cleaning.</span></p>\n" +
              "</div>";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_personal_benefit);

        personal_back=findViewById(R.id.personal_back);

        web_personalbenifits=findViewById(R.id.web_personalbenifits);

        web_personalbenifits.loadDataWithBaseURL(null, str, "text/html", "UTF-8", null);

        personal_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
