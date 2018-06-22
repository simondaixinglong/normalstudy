package com.simon.study.scroll

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.simon.study.R
import kotlinx.android.synthetic.main.act_scroll.*

/**
 *   created by simon
 *   date 2018/6/22
 *   description:
 *   version code 1.0
 *
 *
 *   scrollBy/scrollTo,移动的是view里面的内容（子view或者显示的内容）
 *
 *
 */
class ScrollAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_scroll)


        btnScrollTo.setOnClickListener {
            (parentLayout as ViewGroup).scrollTo(-30, -30)
        }

        btnScrollBy.setOnClickListener {
            (parentLayout as ViewGroup).scrollBy(-30, -30)
        }

    }
}