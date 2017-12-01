package test.alanfengdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
                new BaseDialogFragment(new EtDialogAdapter(builder))
                        .show(getSupportFragmentManager(), "name");
                break;
            case R.id.show_pdd:
                BaseDialogAdapter.Builder builder1 = new BaseDialogAdapter.Builder()
                        .setStyle(R.style.Base_AlertDialog);
                new BaseDialogFragment(new DataPickerDialog(builder1))
                        .show(getSupportFragmentManager(), "dp");
                break;
            case R.id.show_d:
                BaseDialogAdapter.Builder builder2 = new BaseDialogAdapter.Builder()
                        .setDialog(new AlertDialog.Builder(this, R.style.Base_AlertDialog)
                                .setTitle("123123")
                                .setNegativeButton("cccc", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                .setPositiveButton("ssss", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                }).create())
                        .setGravity(Gravity.BOTTOM);
                new BaseDialogFragment(new DefualtDialogAdapter(builder2))
                    .show(getSupportFragmentManager(), "sssa");
                break;
        }

    }
}
