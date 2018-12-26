package com.yoeki.kalpnay.hrporatal.Benefits.RetirementBenefits;

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

public class home_Retirement extends AppCompatActivity {

    ImageView retairement_back;
    WebView webviewretirment;
    String str="<p><strong><span style=\"font-size: 16.0pt; line-height: 107%;\">Retirement Benefits</span></strong></p>\n" +
            "<p><span style=\"font-size: 12pt;\">Retirement benefits are funds set aside to provide people with an income or pension when they end their careers. Retirement plans fit into two general categories:</span></p>\n" +
            "<ul>\n" +
            "<li style=\"text-indent: -.25in;\"><span style=\"font-size: 12pt;\">In&nbsp;<strong>defined benefit plans</strong>(sometimes called pension plans), the benefit amount is pre-determined based on salary and the years of service. In these plans, the employer bears the risk of the investment.</span></li>\n" +
            "<li style=\"text-indent: -.25in;\"><span style=\"font-size: 12pt;\">In&nbsp;<strong>defined contribution plans</strong>(such as a 401k plan), employer or employee contributions are specified, but the benefit amount is usually tied to investment returns, which are not guaranteed.</span></li>\n" +
            "</ul>";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_retirement);

        retairement_back=findViewById(R.id.retairement_back);
        webviewretirment=findViewById(R.id.webviewretirment);

        webviewretirment.loadDataWithBaseURL(null, str, "text/html", "UTF-8", null);

        retairement_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
    }
}
