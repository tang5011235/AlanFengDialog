package test.alanfengdialog;

import android.view.ViewGroup;
import android.widget.DatePicker;

/**
 * Created by Administrator on 2017/12/1.
 */

public class DataPickerDialog extends BaseDialogAdapter {
    /**
     * 获取dialog的界面View
     *
     * @param builder
     * @return
     */
    public DataPickerDialog(Builder builder) {
        super(builder);
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_data_picker;
    }

    @Override
    public void initView(ViewGroup viewGroup) {
        DatePicker dp = viewGroup.findViewById(R.id.dp);
    }
}
