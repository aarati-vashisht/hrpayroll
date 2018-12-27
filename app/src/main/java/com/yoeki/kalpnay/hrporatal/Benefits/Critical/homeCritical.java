package com.yoeki.kalpnay.hrporatal.Benefits.Critical;

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

public class homeCritical extends AppCompatActivity {

    ImageView critical_back;
    WebView webviewcritical;
    String str="<p><span style=\"font-size: 16pt;\"><strong>Critical Illness:</strong></span></p>\n" +
            "<p><span style=\"font-size: 12pt;\">Your employer, both in these states and in the rest of the country, may also voluntarily provide additional&nbsp;<span style=\"color: windowtext; text-decoration: none; text-underline: none;\">disability coverage</span>. So, if you are unable to work, your first step should be to inquire as to what insurance your employer provides. If you have your own disability coverage, file a claim with that insurance company as well.</span></p>\n" +
            "<p><span style=\"font-size: 12pt; line-height: 107%; font-family: Calibri, sans-serif;\">If you don't have state or employer-based coverage, consider purchasing disability insurance while you're healthy. First, check with your employer to see what coverage they provide, then ask if you can purchase supplemental coverage. Calculate if the benefits you'll get will be enough to maintain your lifestyle in the event of unanticipated disability.</span></p>";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_critical);

        critical_back=findViewById(R.id.critical_back);

        webviewcritical=findViewById(R.id.webviewcritical);

        webviewcritical.loadDataWithBaseURL(null, str, "text/html", "UTF-8", null);
        critical_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
