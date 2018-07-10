package com.simon.study.base;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.simon.study.R;

import java.util.HashMap;
import java.util.Map;

/**
 * created by simon
 * date 2018/6/29
 * version code 1.0
 * description:Activity的基类，主要工作有下面：
 * 1.加载自定义的标题栏
 * 2.提供权限申请的方法
 * 3.提供一致的intent参数，便于启动Activity
 * 4.提供网络请求的数据对象map
 * 5.管理back键
 * 6.管理标题栏数据显示设置
 * 7.管理startActivity
 * 8.提供统一初始化参数方法
 * 9.提供统一设置事件监听方法
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected static final String DATA_KEY = "argument";//用于传值的key

    protected RelativeLayout llBaseRoot;//父布局
    protected LinearLayout llBaseTitle;//actionbar
    protected ImageButton ibBaseBackIcon;//actionbar 返回箭头
    protected TextView tvBaseTitleLeft;//actionbar 左边文字 默认隐藏，设值的时候显示
    protected TextView tvBaseTitleTitle;//actionbar title
    protected ImageButton ibBaseShareIcon;//actionbar 右边图标
    protected TextView tvBaseTitleRight;//actionbar 右边文字 默认隐藏，设值的时候显示


    protected Bundle argumentBundle;//用于组件间传值，未初始化，使用的时候一定要初始化
    protected Map<String, Object> requestMap = new HashMap<>();//用于网络请求设置参数使用，多个网络请求在使用之前，需要条用reset方法
    protected int requestPermissionCode = -1;//权限申请码


    protected IBaseListener listener;//返回事件监听

    /**
     * 监听actionbar事件
     */
    public interface IBaseListener {
        void onBackImage();

        void onLeftTextClick();

        void onShareImage();

        void onRightTextClick();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.layout_common_title);
        initBaseParams();
        initAcBaseActions();
        initParams();
        initActions();
    }

    /**
     * 初始化参数
     */
    private void initBaseParams() {
        llBaseRoot = findViewById(R.id.ll_base_title_root);
        llBaseTitle = findViewById(R.id.ll_base_title);
        ibBaseBackIcon = findViewById(R.id.ib_base_back_icon);
        tvBaseTitleLeft = findViewById(R.id.tv_base_title_left);
        tvBaseTitleTitle = findViewById(R.id.tv_base_title_title);
        ibBaseShareIcon = findViewById(R.id.ib_base_share_icon);
        tvBaseTitleRight = findViewById(R.id.tv_base_title_right);
        getArgumentBundle();
    }

    /**
     * 设置事件监听
     */
    private void initAcBaseActions() {
        ibBaseBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    listener.onBackImage();
                }
            }
        });

        tvBaseTitleLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    listener.onLeftTextClick();
                }
            }
        });

        ibBaseShareIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    listener.onShareImage();
                }
            }
        });

        tvBaseTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    listener.onRightTextClick();
                }
            }
        });
    }


    /**
     * 用于
     * 初始化view
     * 初始化参数
     */
    protected abstract void initParams();


    /**
     * 用于设置事件监听
     */
    protected abstract void initActions();


    /**
     * 设置返回键回调监听
     *
     * @param listener
     */
    protected void setBaseListener(IBaseListener listener) {
        this.listener = listener;
    }

    /**
     * 初始化组件间传值的bundle对象
     */
    protected Bundle getArgumentBundle() {
        Intent localIntent = getIntent();
        if (null != localIntent) {
            return localIntent.getBundleExtra(DATA_KEY);
        }
        return null;
    }

    /**
     * 重点是重写setContentView，让继承者可以继续设置setContentView
     * 重写setContentView
     *
     * @param resId
     */
    @Override
    public void setContentView(int resId) {
        View view = getLayoutInflater().inflate(resId, null);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        lp.addRule(RelativeLayout.BELOW, R.id.ll_base_title);
        if (null != llBaseRoot)
            llBaseRoot.addView(view, lp);
    }

    /**
     * 清空请求map
     */
    protected void resetRequestMap() {
        requestMap.clear();
    }


    /**
     * 防止快速点击
     *
     * @return
     */
    private boolean fastClick() {
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return true;
        }
        lastClick = System.currentTimeMillis();
        return false;
    }


    /********************************** 权限申请 ***********************************/

    /**
     * 重写该方法，返回申请权限是否成功
     *
     * @param hasGetPermission
     */
    protected void onGetPermission(boolean hasGetPermission) {
    }

    /**
     * 申请权限
     *
     * @param requestCode
     * @param permissions
     */
    protected void requestPermission(int requestCode, String... permissions) {
        this.requestPermissionCode = requestCode;
        ActivityCompat.requestPermissions(this, permissions, this.requestPermissionCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == this.requestPermissionCode) {
            requestCode = 0;
        }

        while (requestCode < grantResults.length) {
            if (grantResults[requestCode] != 0) {
                onGetPermission(false);
                return;
            }
            requestCode++;
        }
        onGetPermission(true);
    }

    /********************************** 设置Actionbar ***********************************/

    /**
     * 隐藏标题栏
     */
    protected void hideTitleLayout() {
        llBaseTitle.setVisibility(View.GONE);
    }


    /**
     * 设置标题栏背景颜色
     */
    protected void setActionbarColor(int color) {
        llBaseRoot.setBackgroundColor(color);
    }


    /**
     * 设置返回箭头
     *
     * @param drawable
     */
    protected void setBackIcon(Drawable drawable) {
        ibBaseBackIcon.setImageDrawable(drawable);
    }

    /**
     * 设置返回箭头
     *
     * @param resId
     */
    protected void setBackIcon(int resId) {
        setBackIcon(ResourcesCompat.getDrawable(getResources(), resId, null));
    }


    /**
     * 设置分享按钮
     *
     * @param drawable
     */
    protected void setShareIcon(Drawable drawable) {
        ibBaseShareIcon.setImageDrawable(drawable);
        ibBaseShareIcon.setVisibility(View.VISIBLE);
    }

    /**
     * 设置分享按钮
     *
     * @param resId
     */
    protected void setShareIcon(int resId) {
        setShareIcon(ResourcesCompat.getDrawable(getResources(), resId, null));
    }

    /**
     * 设置左边的文字
     *
     * @param leftStr
     */
    protected void setLeftTitle(CharSequence leftStr) {
        tvBaseTitleLeft.setText(leftStr);
        tvBaseTitleLeft.setVisibility(View.VISIBLE);
    }

    /**
     * 设置左边的文字
     *
     * @param resId
     */
    protected void setLeftTitle(int resId) {
        tvBaseTitleLeft.setText(resId);
        tvBaseTitleLeft.setVisibility(View.VISIBLE);
    }


    /**
     * 设置左边文字颜色
     *
     * @param color
     */
    protected void setLeftTitleColor(int color) {
        tvBaseTitleLeft.setTextColor(color);
    }

    /**
     * 设置左边文字字体
     *
     * @param size
     */
    protected void setLeftTitleSize(int size) {
        tvBaseTitleLeft.setTextSize(size);
    }

    /**
     * 设置标题文字
     *
     * @param titleStr
     */
    protected void setBaseTitle(CharSequence titleStr) {
        tvBaseTitleTitle.setText(titleStr);
    }


    /**
     * 设置标题文字
     *
     * @param resId
     */
    protected void setBaseTitle(int resId) {
        tvBaseTitleTitle.setText(resId);
    }

    /**
     * 设置标题颜色
     *
     * @param color
     */
    protected void setBaseTitleColor(int color) {
        tvBaseTitleTitle.setTextColor(color);
    }

    /**
     * 设置标题字体
     *
     * @param size
     */
    protected void setBaseTitleSize(int size) {
        tvBaseTitleTitle.setTextSize(size);
    }

    /**
     * 设置右边文字
     *
     * @param rightStr
     */
    protected void setRightTitle(CharSequence rightStr) {
        tvBaseTitleRight.setText(rightStr);
        tvBaseTitleRight.setVisibility(View.VISIBLE);
    }

    /**
     * 设置右边文字
     *
     * @param redId
     */
    protected void setRightTitle(int redId) {
        tvBaseTitleRight.setText(redId);
        tvBaseTitleRight.setVisibility(View.VISIBLE);
    }

    /**
     * 设置右边文字颜色
     *
     * @param color
     */
    protected void setRightTitleColor(int color) {
        tvBaseTitleRight.setTextColor(color);
    }

    /**
     * 设置右边文字字体
     *
     * @param size
     */
    protected void setRightTitleSize(int size) {
        tvBaseTitleRight.setTextSize(size);
    }

    /**
     * 设置actionbar文字字体
     *
     * @param size
     */
    protected void setAllTextSize(int size) {
        setLeftTitleColor(size);
        setBaseTitleColor(size);
        setRightTitleSize(size);
    }

    /**
     * 设置actionbar文字颜色
     *
     * @param color
     */
    protected void setAllTextColor(int color) {
        setLeftTitleColor(color);
        setBaseTitleColor(color);
        setRightTitleColor(color);
    }

    /**
     * 启动一个Activity
     *
     * @param paramClass
     */
    protected void startActivity(Class<?> paramClass) {
        startActivity(new Intent(this, paramClass));
    }

    /**
     * 启动一个Activity
     *
     * @param paramClass
     */
    protected void startActivityFinish(Class<?> paramClass) {
        startActivity(paramClass);
        finish();
    }

    /**
     * 启动一个Activity
     *
     * @param paramClass
     * @param paramBundle
     */
    protected void startActivity(Class<?> paramClass, Bundle paramBundle) {
        Intent transIntent = new Intent(this, paramClass);
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
        finish();
    }

    /**
     * 启动Activity并需要返回结果
     */
    protected void startActivityForResult(Class<?> paramClass, int requestCode) {
        Intent transIntent = new Intent(this, paramClass);
        startActivityForResult(transIntent, requestCode);
    }

    /**
     * 启动Activity并需要返回结果
     */
    protected void startActivityForResult(Class<?> paramClass, Bundle paramBundle, int requestCode) {
        Intent transIntent = new Intent(this, paramClass);
        if (null != paramBundle) {
            transIntent.putExtra(DATA_KEY, paramBundle);
        }
        startActivityForResult(transIntent, requestCode);
    }

    /********************************** 重写返回键事件 ***********************************/
    @Override
    public void onBackPressed() {
        if (null != listener) {
            listener.onBackImage();
        } else {
            super.onBackPressed();
        }
    }
}