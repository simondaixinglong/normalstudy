package com.simon.study.view.word_magnifier;

import android.app.Activity;
import android.os.Bundle;
import com.simon.study.R;
import com.simon.study.view.word_magnifier.utils.DisplayUtils;

public class MainActivity extends Activity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_panel);
        DisplayUtils.init(getBaseContext());
    }
}
