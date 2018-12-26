package com.yoeki.kalpnay.hrporatal.EventAndTraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.yoeki.kalpnay.hrporatal.R;

public class EventDetailsActivity extends AppCompatActivity implements View.OnClickListener {
     ImageView img_eventdetailback;
     WebView webviewdescription;
    String str="<h2>Description</h2>\n" +
            "<p><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry.</p>\n" +
            "<p>Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book." +
            " It has survived not only five centuries," +
            " but also the leap into electronic typesetting, remaining essentially unchanged.</p>\n" +
            "<p>It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages," +
            " and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details2);
          initilize();

        webviewdescription.loadDataWithBaseURL(null, str, "text/html", "UTF-8", null);
        img_eventdetailback.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.img_eventdetailback:
               finish();
               break;
        }
    }

    public void initilize(){
        img_eventdetailback=findViewById(R.id.img_eventdetailback);
        webviewdescription=findViewById(R.id.webviewdescription);
    }
}
