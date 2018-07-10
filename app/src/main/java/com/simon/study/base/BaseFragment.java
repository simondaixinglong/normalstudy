package com.simon.study.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * created by simon
 * date 2018/6/29
 * version code 1.0
 * description:Fragment的基类，主要工作有下面
 * 1.
 * 2.
 */
public abstract class BaseFragment extends Fragment {

    protected static final String DATA_KEY = "argument";//用于传值的key
    protected Bundle argumentBundle;//用于组件间传值，未初始化，使用的时候一定要初始化
    protected Map<String, Object> requestMap = new HashMap<>();//用于网络请求设置参数使用，多个网络请求在使用之前，需要条用reset方法

    protected Activity mActivity;
    protected View mRootView;//根view


    /**
     * 直接通过getContext()方法即可得到Context对象
     * 又因为dialog需要依附Activity对象，因此还是需要通过getActivity获取
     *
     * @return
     */
    public Context getContext() {
        if (null == mActivity) {
            return BaseApplication.getInstance();
        }
        return mActivity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(setLayoutResourcesId(), container, false);
        argumentBundle = getArguments();
        initParams(argumentBundle);
        initActions();
        return mRootView;
    }


    /**
     * 设置根布局id
     */
    protected abstract int setLayoutResourcesId();

    /**
     * 初始化view
     * 初始化参数
     *
     * @param bundle
     */
    protected abstract void initParams(Bundle bundle);


    /**
     * 设置事件监听
     */
    protected abstract void initActions();


    /**
     * 为fragment提供findViewById方法
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T findViewById(int id) {
        if (null == mRootView) {
            throw new NullPointerException("root view 为空，请先设置rootView");
        }

        return (T) mRootView.findViewById(id);
    }


    /**
     * 清空请求map
     */
    protected void resetRequestMap() {
        requestMap.clear();
    }


    /**
     * 启动一个Activity
     *
     * @param paramClass
     */
    protected void startActivity(Class<?> paramClass) {
        startActivity(new Intent(getContext(), paramClass));
    }

    /**
     * 启动一个Activity
     *
     * @param paramClass
     */
    protected void startActivityFinish(Class<?> paramClass) {
        startActivity(paramClass);
        this.mActivity.finish();
    }

    /**
     * 启动一个Activity
     *
     * @param paramClass
     * @param paramBundle
     */
    protected void startActivity(Class<?> paramClass, Bundle paramBundle) {
        Intent transIntent = new Intent(getContext(), paramClass);
        transIntent.putExtra(DATA_KEY, paramBundle);
        startActivity(transIntent);
    }

    /**
     * 启动一个Activity
     *
     * @param paramClass
     * @param paramBundle
     */
    protected void startActivityFinish(Class<?> paramClass, Bundle paramBundle) {
        startActivity(paramClass, paramBundle);
        this.mActivity.finish();
    }

    /**
     * 启动Activity并需要返回结果
     */
    protected void startActivityForResult(Class<?> paramClass, int requestCode) {
        Intent transIntent = new Intent(getContext(), paramClass);
        startActivityForResult(transIntent, requestCode);
    }

    /**
     * 启动Activity并需要返回结果
     */
    protected void startActivityForResult(Class<?> paramClass, Bundle paramBundle, int requestCode) {
        Intent transIntent = new Intent(getContext(), paramClass);
        if (null != paramBundle) {
            transIntent.putExtra(DATA_KEY, paramBundle);
        }
        startActivityForResult(transIntent, requestCode);
    }


}
