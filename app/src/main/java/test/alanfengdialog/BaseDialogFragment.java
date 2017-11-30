package test.alanfengdialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/11/30.
 */

public class BaseDialogFragment extends DialogFragment implements View.OnClickListener {

    private int mRootViewId;
    private View mRootView;
    private int mGravity;
    private int mAnimate;
    private BaseDialogAdapter mBaseDialogAdapter;

    public BaseDialogFragment(BaseDialogAdapter adapter) {
        mBaseDialogAdapter = adapter;
    }

    public BaseDialogFragment(@LayoutRes int layoutId) {
        mRootViewId = layoutId;
    }

    private BaseDialogFragment(Builder builder) {
        mGravity = builder.mGravity;
        mAnimate = builder.mAnimate;
        mOnClickListener = builder.mOnClickListener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mBaseDialogAdapter != null) {
            mRootView = mBaseDialogAdapter.getContentView(getActivity());
            mBaseDialogAdapter.setDialogFragment(this);
        } else
            mRootView = View.inflate(getActivity(), mRootViewId, null);

        return mRootView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onActivityCreated(savedInstanceState);
        configWindow();
    }

    private void configWindow() {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0x00000000));
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        getDialog().getWindow().setGravity(mGravity != 0 ? mGravity : Gravity.BOTTOM);
        getDialog().getWindow().setWindowAnimations(mAnimate != 0 ? mAnimate : R.style.bottom_dialog);
    }

    /**
     * 为控件添加点击事件
     */
    public void setCanclickWidegt(OnClickListener onClickListener, @IdRes int... ids) {
        for (int i = 0; i < ids.length; i++) {
            mRootView.findViewById(ids[i]).setOnClickListener(this);
        }
        mOnClickListener = onClickListener;
    }

    public String getContent(@IdRes int id) {
        View view = mRootView.findViewById(id);
        if (view instanceof TextView) {
            return ((TextView) view).getText().toString().trim();
        } else {
            return null;
        }
    }

    /**
     * 设置点击事件的处理让用户自定义处理
     */
    public interface OnClickListener {
        void onClick(View view);
    }

    private OnClickListener mOnClickListener;

    public void onClick(View view) {
        mOnClickListener.onClick(view);
    }

    public static final class Builder {
        private int mStyle;
        private int mTheme;
        private int mGravity;
        private int mAnimate;
        private OnClickListener mOnClickListener;

        public Builder() {
        }

        public Builder setMStyle(int val) {
            mStyle = val;
            return this;
        }

        public Builder setMTheme(int val) {
            mTheme = val;
            return this;
        }

        public Builder setMGravity(int val) {
            mGravity = val;
            return this;
        }

        public Builder setMAnimate(int val) {
            mAnimate = val;
            return this;
        }

        public Builder setMOnClickListener(OnClickListener val) {
            mOnClickListener = val;
            return this;
        }

        public BaseDialogFragment build() {
            return new BaseDialogFragment(this);
        }
    }

}
