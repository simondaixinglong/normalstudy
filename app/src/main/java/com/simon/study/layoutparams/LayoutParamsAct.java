package com.simon.study.layoutparams;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.simon.study.R;

/**
 * created by simon
 * date 2018/6/28
 * description:
 * version code 1.0
 */
public class LayoutParamsAct extends AppCompatActivity {

    private LinearLayout rootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_params_layout);
        rootView = findViewById(R.id.root_view);

//        addTextView();
    }

    private void addTextView() {

        TextView textView = new TextView(this);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(layoutParams);
        textView.setText("aaaa");
        textView.setBackgroundColor(Color.parseColor("#FF0000"));
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        rootView.addView(textView);
        rootView.removeAllViews();
        rootView.addView(textView);

        RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);


    }


}
