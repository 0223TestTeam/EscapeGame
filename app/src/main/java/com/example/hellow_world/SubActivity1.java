package com.example.hellow_world;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ServoRobo on 2017/02/23.
 */

public class SubActivity1 extends Activity{
    boolean flag=false;
    int[] state = new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity1);
        // 現在のintentを取得する
        Intent intent = getIntent();
        // intentから指定キーの数字列を取得する
        intent.getIntArrayExtra("state");

        if (state[0] == 1) {
            findViewById(R.id.background1).setVisibility(View.INVISIBLE);
            findViewById(R.id.background2).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.background1).setVisibility(View.VISIBLE);
            findViewById(R.id.background2).setVisibility(View.INVISIBLE);
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


        Log.d("Touchivemnt", "X:" + event.getX() + ",Y:" + event.getY());
        if (flag==false){
            if (1640<event.getY() && event.getY()<1950 && 400<event.getX() && event.getX()<830){
                Intent intent = new Intent(getApplication(),SubActivity1.class);
                intent.putExtra("state",state);
                startActivityForResult(intent , 10011);
                flag = true;
            }
        }
        return true;
    }
}
