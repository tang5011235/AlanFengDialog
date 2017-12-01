package test.alanfengdialog;

import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/12/1.
 */

public class DefualtDialogAdapter extends BaseDialogAdapter {
    /**
     * 获取dialog的界面View
     *
     * @param builder
     * @return
     */
    public DefualtDialogAdapter(Builder builder) {
        super(builder);
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initView(ViewGroup viewGroup) {

    }
}
