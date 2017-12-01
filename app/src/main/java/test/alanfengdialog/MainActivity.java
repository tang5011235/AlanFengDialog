package test.alanfengdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void clickEt(View view) {
        switch (view.getId()) {
            case R.id.show_etd:
                BaseDialogAdapter.Builder builder = new BaseDialogAdapter.Builder()
                        .setStyle(R.style.Base_AlertDialog)
                        .setGravity(Gravity.BOTTOM);
                new BaseDialogFragment(new EtDialogAdapter(builder)).show(getSupportFragmentManager(), "name");
                break;
            case R.id.show_pdd:
                BaseDialogAdapter.Builder builder1 = new BaseDialogAdapter.Builder()
                        .setStyle(R.style.Base_AlertDialog);
                new BaseDialogFragment(new DataPickerDialog(builder1)).show(getSupportFragmentManager(), "dp");
            default:

                break;
        }

    }

    public void clickDp(View view) {

    }

    private static final String DIALOG_POSITIVE = "确定";
    private static final String DIALOG_NEGATIVE = "取消";
}
