package com.example.hellow_world;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;

import static com.example.hellow_world.Define.*;

/**
 * Created by ServoRobo on 2017/02/23.
 */

public class SubActivity2 extends Activity{

    int[] state = new int[3];

    public boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        // 現在のintentを取得する
        Intent intent = getIntent();
        // intentから指定キーの数字列を取得する
        state = intent.getIntArrayExtra("state");

        if (state[0] == 1) {
            findViewById(R.id.imageView5).setVisibility(View.INVISIBLE);
            findViewById(R.id.imageView).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.imageView5).setVisibility(View.VISIBLE);
            findViewById(R.id.imageView).setVisibility(View.INVISIBLE);
        }
    }

    public void back(View v){
        Intent intent = new Intent();
        intent.putExtra("state",state);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x, y;
        x = event.getX();
        y = event.getY();
        Log.d("Touchivemnt", "X:" + x + ",Y:" + y);

        if (flag == false) {
            if (BOX_LEFT < x && x < BOX_RIGHT && BOX_UP < y && y < BOX_DOWN) {
                Log.d("TouchBOX", "X:" + x + ",Y:" + y);
                final Dialog dialog = new Dialog(MainActivity.this);
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

                button.setOnClickListener(new DialogInterface.OnClickListener())
                {
                    @Override
                    public void onClick(View v) {
                        if(np0 == BOX_KEY_0 && np1 == BOX_KEY_1 && np2 == BOX_KEY_2 && np3 == BOX_KEY_3) {
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

        return true;
    }
}