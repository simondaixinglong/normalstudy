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
 *   scrollBy/scrollTo,移动的是父布局，所以负数的时候，子view向右移动（实际上是父布局向左移动）
 *   scrollTo 方法和 scrollBy 方法移动的是 view 里面的内容（子控件或者是显示的内容），
 *   并且移动的方向和方法的参数正负是相反的（也可以借助参考物来理解（父容器移动，子控件不移动，相对父容器来说，子控件移动的方向是与其相反））。
 *
 *
 */
class ScrollAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_scroll)


//        btnScrollTo.setOnClickListener {
//            (parentLayout as ViewGroup).scrollTo(-30, -30)
//        }
//
//        btnScrollBy.setOnClickListener {
//            (parentLayout as ViewGroup).scrollBy(-30, -30)
//        }

    }
}