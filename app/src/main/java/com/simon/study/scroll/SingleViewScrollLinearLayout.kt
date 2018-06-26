package com.simon.study.scroll

import android.content.Context
import android.support.v4.view.ViewCompat
import android.support.v4.widget.ViewDragHelper
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout

/**
 *   created by simon
 *   date 2018/6/25
 *   description:
 *   version code 1.0
 *
 *
 *   不知道小伙伴们发现没有，在这里实现的滑动都是对当前控件的全部的子 View 进行滑动，这样在一定程度上限制了滑动的灵活性。那么我们如何处理单个 View 的滑动呢？轮到我们的 ViewDragHelper 类出场了，通过 ViewDragHelper 我们可以灵活地对不同的 View 施加不同的滑动效果，下面我们来看一下怎么使用这个功能强大的类：
1、初始化 ViewDragHelper 对象：通常使用 ViewDragHelper.create(ViewGroup v, ViewDragHelper.Callback c); 方法来初始化一个新的 ViewDragHelper 对象
2、拦截触摸事件，传递给 ViewDragHelper 对象处理：重写要检测的 ViewGroup 的 onInterceptTouchEvent 方法来拦截触摸事件并且将触摸事件传递给 ViewDragHelper 对象处理
3、处理 computeScroll 方法：ViewDragHelper 内部还是通过 Scroller 来实现滑动的，所以需要实现 computeScroll 方法
4、处理 ViewDragHelper.Callback：这个回调是整个滑动的核心，我们要在这个接口中根据我们自己的逻辑来实现不同的方法并进行处理
 */
class SingleViewScrollLinearLayout : LinearLayout {

    private var viewDragHelper: ViewDragHelper? = null
    private var childViews: Array<View?>? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr) {
        viewDragHelper = ViewDragHelper.create(this, callBack)
    }


    /**
     * 这个方法在布局加载完毕之后回调，
     * 在这里获取子view
     */
    override fun onFinishInflate() {
        super.onFinishInflate()
        childViews = arrayOfNulls(this.childCount)
        for (i in 0 until childViews!!.count()) {
            childViews!![i] = this.getChildAt(i)
        }
    }

    /**
     * ViewDragHelper 同样需要重写 computeScroll 方法，
     * 因为其内部也是通过这个类来实现滑动的
     */
    override fun computeScroll() {
        super.computeScroll()
        if (viewDragHelper!!.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this)
        }

    }

    /**
     * 拦截触摸事件，将事件传递给 viewDragHelper 处理
     */
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        viewDragHelper!!.shouldInterceptTouchEvent(ev!!)
        return true

    }

    /**
     * 将触摸事件传递给 viewDragHelper 处理
     */
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        viewDragHelper!!.processTouchEvent(event!!)
        return true
    }


    /**
     * viewDragHelper 处理触摸事件的回调
     */
    private var callBack = object : ViewDragHelper.Callback() {

        /*
         * 这个方法可以在创建 ViewDragHelper 对象时，指定被监听的 ViewGroup 中哪个子 View 可以被移动，
         * 如果返回 true，那么继续监测当前触摸事件，否则不检测
         */
        override fun tryCaptureView(child: View, pointerId: Int): Boolean {
            //如果触摸的是是第一个子 View 则继续监测触摸事件
            return true
//            return child == childViews!![0]
        }

        /*
         * 水平方向上的滑动处理方法，第一个参数为滑动的子 View，第二个参数是水平方向上移动的距离，
         * 第三个参数为水平方向上较上一次的增量，通常只需要返回 left 就行了，如果不重写这个方法，
         * 那么水平方向上是不会滑动的，因为父类的该方法返回值为 0，下同。
         */
        override fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
            return left
        }

        /*
         * 竖直方向上的滑动
         */
        override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
            return top
        }

    }


}