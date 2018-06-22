package com.simon.study.webview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.simon.study.R
import kotlinx.android.synthetic.main.act_web_view.*

/**
 *   created by simon
 *   date 2018/6/22
 *   description:
 *   version code 1.0
 */
class WebViewAct:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_web_view)

        proWebView.addProgressBar()


        proWebView.loadMessageUrl("https://blog.csdn.net/qq_20785431/article/details/51599073")
    }

    override fun onDestroy() {
        super.onDestroy()
        proWebView.destroyWebView()
    }
}