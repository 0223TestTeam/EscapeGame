package com.example.hellow_world;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.NumberPicker;

import static com.example.hellow_world.Define.REQ_SUBSUB1;

/**
 * Created by primenote on 2017/05/14.
 */


 public class SubActivity111 extends Activity {
        boolean flag=false;
        boolean flag2=false;
        int[] state = new int[3];

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_subactivity1);
            // 現在のintentを取得する
            Intent intent = getIntent();

        }

        public void back(View v){
            showDialog();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {




            return true;
        }




    private void showDialog() {
        class MainFragmentDialog extends DialogFragment {
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View view = inflater.inflate(R.layout.setting_dialog, null, false);

                NumberPicker np = (NumberPicker) view.findViewById(R.id.numberPicker);
                np.setMaxValue(31);
                np.setMinValue(1);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Number Picker");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // OKクリック時の処理
                    }
                });
                builder.setNegativeButton("Cancel", null);
                builder.setView(view);
                return builder.create();
            }
        }

        // Dialogの表示
        MainFragmentDialog dialog = new MainFragmentDialog();
        dialog.show(getFragmentManager(), "span_setting_dialog");
    }
}
