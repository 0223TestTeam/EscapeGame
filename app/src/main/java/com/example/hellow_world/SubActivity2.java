package com.example.hellow_world;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import static com.example.helloworld.Define.*;

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
                Intent intent = new Intent(getApplication(), BoxKeyActivity2.class);
                int requestCode = REQ_BOXKEY;
                startActivityForResult(intent, requestCode);
                flag = true;
            }
        }

        return true;
    }
}