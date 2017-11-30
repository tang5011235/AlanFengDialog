package test.alanfengdialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/11/30.
 */

public class EtDialogAdapter extends BaseDialogAdapter {
    @Override
    public int getLayoutId() {
        return R.layout.dialog_et;
    }

    @Override
    public void initView(final ViewGroup viewGroup) {
        final EditText et = viewGroup.findViewById(R.id.et);
        Button btn = viewGroup.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(viewGroup.getContext(), et.getText().toString(), Toast.LENGTH_SHORT).show();
                mBaseDialogFragment.dismiss();
            }
        });
    }
}
