package test.alanfengdialog;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/11/30.
 * 创建界面，bind翘秆
 */

public abstract class BaseDialogAdapter {

    private ViewGroup mParent;
    public BaseDialogFragment mBaseDialogFragment;

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

    public void setDialogFragment(BaseDialogFragment dialogFragment){
        mBaseDialogFragment = dialogFragment;
    }
    public abstract void initView(ViewGroup viewGroup);

    public void onFragmentDestroy(){

    }

    public void OnStop(){

    }
}
