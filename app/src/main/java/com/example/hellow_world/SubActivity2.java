package com.example.hellow_world;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.util.LogPrinter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;

import static com.example.hellow_world.Define.*;

/**
 * Created by ServoRobo on 2017/02/23.
 */

public class SubActivity2 extends Activity {

    int[] state = new int[3];
    private UtilCommon Flag;

    private DialogFragment dialogFragment;
    private FragmentManager flagmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity2);
        // 現在のintentを取得する
        Intent intent = getIntent();
        // intentから指定キーの数字列を取得する
        // state = intent.getIntArrayExtra("state");

        UtilCommon Flag = (UtilCommon) this.getApplication();

        //if (state[0] == 1) {
        if(Flag.getFlag2() == false){ // 明かりがついていない
            findViewById(R.id.background1).setVisibility(View.VISIBLE);
            findViewById(R.id.background2).setVisibility(View.INVISIBLE);
            findViewById(R.id.background3).setVisibility(View.INVISIBLE);
        } else if (Flag.getFlag6() == false) { //　明かりがついているが、箱が開いていない
            findViewById(R.id.background2).setVisibility(View.VISIBLE);
            findViewById(R.id.background1).setVisibility(View.INVISIBLE);
            findViewById(R.id.background3).setVisibility(View.INVISIBLE);
        } else { //　箱が開いている
            findViewById(R.id.background3).setVisibility(View.VISIBLE);
            findViewById(R.id.background1).setVisibility(View.INVISIBLE);
            findViewById(R.id.background2).setVisibility(View.INVISIBLE);

        }

    }

    public void back(View v) {
        Intent intent = new Intent();
     //   intent.putExtra("state", state);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x, y;
        x = event.getX();
        y = event.getY();
        Log.d("Touchivemnt", "X:" + x + ",Y:" + y);


        if (Flag.getFlag6()==false) {
            if (BOX_LEFT < x && x < BOX_RIGHT && BOX_UP < y && y < BOX_DOWN) {
                Log.d("TouchBOX", "X:" + x + ",Y:" + y);
                flagmentManager = getFragmentManager();
                NumberPickerDialog dialog = new NumberPickerDialog();
                dialog.show(flagmentManager, "dialog");
            }
        } else {
            Intent intent = new Intent(getApplication(), SubSubActivity2.class);
            int requestCode = REQ_SUBSUB2;
            startActivityForResult(intent, requestCode);
        }

        return true;
    }

    public class NumberPickerDialog extends DialogFragment{
        @Override
        public Dialog onCreateDialog (Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater factory = getActivity().getLayoutInflater();
            final View view = factory.inflate(R.layout.dialog, null, false);

            final Button button = (Button)view.findViewById(R.id.button);
            final NumberPicker np0 = (NumberPicker) view.findViewById(R.id.numberPicker0);
            final NumberPicker np1 = (NumberPicker) view.findViewById(R.id.numberPicker1);
            final NumberPicker np2 = (NumberPicker) view.findViewById(R.id.numberPicker2);
            final NumberPicker np3 = (NumberPicker) view.findViewById(R.id.numberPicker3);
            np0.setMaxValue(9); np0.setMinValue(0);
            np1.setMaxValue(9); np1.setMinValue(0);
            np2.setMaxValue(9); np2.setMinValue(0);
            np3.setMaxValue(9); np3.setMinValue(0);

            builder.setView(view)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            if(np0.getValue() == BOX_KEY_0 && np1.getValue() == BOX_KEY_1 && np2.getValue() == BOX_KEY_2 && np3.getValue() == BOX_KEY_3) {
                                // あってる
                                Log.d("Number","true");
                                Flag.setFlag6(true);
                                dialog.dismiss();
                            }else{
                                //　あってない
                                Log.d("Number","false");
                                dialog.dismiss();
                            }
                        }
                    })
                    .setNegativeButton("Cancel", null);
            return builder.create();
        }

        @Override
        public void onPause() {
            super.onPause();
            // onPause でダイアログを閉じる場合
            dismiss();
        }

    }

}






 /*
                private void showDialog(){
                    class MainFragmentDialog extends DialogFragment {
                    @Override
                    public Dialog onCreateDialog(Bundle savedInstanceState) {
                        LayoutInflater inflater = getActivity().getLayoutInflater();
                        View view = inflater.inflate(R.layout.setting_dialog, null, false);

                        final Dialog dialog = new Dialog(SubActivity2.this);
                        dialog.setTitle("NumberPicker");
                        dialog.setContentView(R.layout.dialog);
                        Button button = (Button)dialog.findViewById(R.id.button);

                        final NumberPicker np0 = (NumberPicker) dialog.findViewById(R.id.numberPicker0);
                        final NumberPicker np1 = (NumberPicker) dialog.findViewById(R.id.numberPicker1);
                        final NumberPicker np2 = (NumberPicker) dialog.findViewById(R.id.numberPicker2);
                        final NumberPicker np3 = (NumberPicker) dialog.findViewById(R.id.numberPicker3);
                        np0.setMaxValue(9); np0.setMinValue(0);
                        np1.setMaxValue(9); np1.setMinValue(0);
                        np2.setMaxValue(9); np2.setMinValue(0);
                        np3.setMaxValue(9); np3.setMinValue(0);

                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(np0.getValue() == BOX_KEY_0 && np1.getValue() == BOX_KEY_1 && np2.getValue() == BOX_KEY_2 && np3.getValue() == BOX_KEY_3) {
                                    Intent intent = new Intent(getApplication(), SubSubActivity2.class);
                                    int requestCode = REQ_SUBSUB2;
                                    startActivityForResult(intent, requestCode);
                                } else {
                                    dialog.dismiss();
                                }
                            }
                        });
                    }
                }
            }
        }

        return true;
    }
}
        */