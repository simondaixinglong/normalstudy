package com.simon.study.scroll

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.LinearLayout
import android.widget.Scroller
import android.widget.Switch
import java.util.jar.Attributes

/**
 *   created by simon
 *   date 2018/6/22
 *   description:
 *   version code 1.0
 *
 *   1、初始化 Scroller 类的对象：Scroller scroller = new Scroller(context)
2、重写要滑动的 View 的 computeScroll() 方法：
3、调用 startScroll(int startX, int startY, int dx, int dy)方法开始 View 的滑动，参数分别为开始的位置和横纵方向滑动的位移，这个方法还有一个重载版本，多了一个参数用于控制滑动时间
 */
class ScrollLinearLayout : LinearLayout {

    private var scroller: Scroller? = null
    private var lastX: Int = 0
    private var lastY: Int = 0

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr) {
        scroller = Scroller(context)
    }


    /**
     * 重写父类的 computeScroll方法来判断滑动是否完成，进行对应处理
     */
    override fun computeScroll() {
        super.computeScroll()
        //如果滑动完成，返回false，否则返回true
        if (scroller!!.computeScrollOffset()) {
            scrollTo(scroller!!.currX, scroller!!.currY)
            invalidate()
        }
    }


    /**
     * 重写touchEvent
     *
     * 1、初始化 Scroller 类的对象：Scroller scroller = new Scroller(context)
     * 2、重写要滑动的 View 的 computeScroll() 方法
     * 3、调用 startScroll(int startX, int startY, int dx, int dy)方法开始 View 的滑动，
     * 参数分别为开始的位置和横纵方向滑动的位移，这个方法还有一个重载版本，多了一个参数用于控制滑动时间
     *
     */
    override fun onTouchEvent(event: MotionEvent): Boolean {

        var x: Int = event.x.toInt()
        var y: Int = event.y.toInt()

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                scroller!!.startScroll(lastX, lastY, lastX - x, lastY - y)
                invalidate()
            }

            MotionEvent.ACTION_MOVE -> {
                scrollTo(-x, -y)
                invalidate()
            }

            MotionEvent.ACTION_UP -> {
                scroller!!.startScroll(scrollX, scrollY, -scrollX, -scrollY)
                invalidate()
            }
        }

        return true
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return true
    }


}


















