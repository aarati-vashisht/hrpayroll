package com.yoeki.kalpnay.hrporatal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.Toast;

import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

/**
 * Created by IACE on 18-Sep-18.
 */

public class Question_surevey extends AppCompatActivity implements SmileRating.OnSmileySelectionListener, SmileRating.OnRatingSelectedListener {
    SeekBar seekBar;
    SmileRating mSmileRating;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_survey);

        mSmileRating = (SmileRating) findViewById(R.id.question_Answer);
        mSmileRating.setOnSmileySelectionListener(this);
        mSmileRating.setOnRatingSelectedListener(this);
        mSmileRating.setSelectedSmile(BaseRating.GOOD);
    }

    @Override
    public void onRatingSelected(int level, boolean reselected) {
        Toast.makeText(this, "Rated as: " + level + " - " + reselected, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSmileySelected(int smiley, boolean reselected) {
        switch (smiley) {
            case SmileRating.BAD:
                Toast.makeText(this, "Bad", Toast.LENGTH_SHORT).show();
                break;
            case SmileRating.GOOD:
                Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show();
                break;
            case SmileRating.GREAT:
                Toast.makeText(this, "Great", Toast.LENGTH_SHORT).show();
                break;
            case SmileRating.OKAY:
                Toast.makeText(this, "Okay", Toast.LENGTH_SHORT).show();
                break;
            case SmileRating.TERRIBLE:
                Toast.makeText(this, "Terrible", Toast.LENGTH_SHORT).show();
                break;
            case SmileRating.NONE:
                Toast.makeText(this, "None", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
