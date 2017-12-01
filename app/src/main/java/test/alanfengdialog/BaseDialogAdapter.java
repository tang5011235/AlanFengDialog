package test.alanfengdialog;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.LayoutRes;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by Administrator on 2017/11/30.
 * 创建界面，bind翘秆
 */

public abstract class BaseDialogAdapter {

    private ViewGroup mParent;
    public BaseDialogFragment mBaseDialogFragment;
    private int mGravity;
    private int mAnimate;
    private int mStyle;
    private int mThem;


    public abstract
    @LayoutRes
    int getLayoutId();

    /**
     * 获取dialog的界面View
     *
     * @param activity
     * @return
     */
    public ViewGroup getContentView(Activity activity) {
        mParent = (ViewGroup) View.inflate(activity, getLayoutId(), null);
        initView(mParent);
        return mParent;
    }

    public void setDialogFragment(BaseDialogFragment dialogFragment) {
        mBaseDialogFragment = dialogFragment;
    }

    public abstract void initView(ViewGroup viewGroup);

    public void onFragmentDestroy() {

    }

    public void OnStop() {

    }


    //配置dialog
    public void configWindow(BaseDialogFragment dialogFragment) {
        dialogFragment.getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0x00000000));
        dialogFragment.getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialogFragment.getDialog().getWindow().setGravity(Gravity.BOTTOM);
        dialogFragment.getDialog().getWindow().setWindowAnimations(R.style.bottom_dialog);
    }
}
