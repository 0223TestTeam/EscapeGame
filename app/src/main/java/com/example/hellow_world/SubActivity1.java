package com.example.hellow_world;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import static com.example.hellow_world.Define.*;

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

        if (state[0] == 0) {
            findViewById(R.id.background1).setVisibility(View.VISIBLE);
            findViewById(R.id.background2).setVisibility(View.INVISIBLE);
            findViewById(R.id.background3).setVisibility(View.INVISIBLE);
        } else if(state[0]==1&&state[1]==0){
            findViewById(R.id.background1).setVisibility(View.INVISIBLE);
            findViewById(R.id.background2).setVisibility(View.VISIBLE);
            findViewById(R.id.background3).setVisibility(View.INVISIBLE);
        }else if(state[1]==1&&state[1]==1) {
            findViewById(R.id.background1).setVisibility(View.INVISIBLE);
            findViewById(R.id.background2).setVisibility(View.INVISIBLE);
            findViewById(R.id.background3).setVisibility(View.VISIBLE);
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
        if(state[0]==1) {
            if (flag == false) {
                if (1640 < event.getY() && event.getY() < 1950 && 400 < event.getX() && event.getX() < 830) {
                    Intent intent = new Intent(getApplication(), SubActivity1.class);
                    intent.putExtra("state", state);
                    startActivityForResult(intent, REQ_SUBSUB1);
                    flag = true;
                }else if(state[1]==1){
                    state[0]=1;
                    findViewById(R.id.background1).setVisibility(View.INVISIBLE);
                    findViewById(R.id.background2).setVisibility(View.INVISIBLE);
                    findViewById(R.id.background3).setVisibility(View.VISIBLE);
                }
            }
        }
        return true;
    }

    protected void onActivityResult(int requestCode , int resultCode , Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
        if (requestCode == RESULT_OK && resultCode == REQ_SUBSUB1  && intent != null){
            intent.getIntArrayExtra("state");
            flag = false;
        }
    }
}
