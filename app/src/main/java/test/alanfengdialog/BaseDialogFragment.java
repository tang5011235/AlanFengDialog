package test.alanfengdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.Window;

/**
 * Created by Administrator on 2017/11/30.
 */

public class BaseDialogFragment extends DialogFragment {

    private int mRootViewId;
    private View mRootView;
    private int mGravity;
    private int mAnimate;
    private BaseDialogAdapter mBaseDialogAdapter;

    public BaseDialogFragment(BaseDialogAdapter adapter) {
        mBaseDialogAdapter = adapter;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mBaseDialogAdapter.setDialogFragment(this);
        return mBaseDialogAdapter.setAlertDialogBuilder();
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onActivityCreated(savedInstanceState);
        mBaseDialogAdapter.configWindow(this);
    }


}
