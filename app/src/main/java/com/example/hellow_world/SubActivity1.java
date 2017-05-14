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
    boolean flag2=false;
    int[] state = new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity1);
        // 現在のintentを取得する
        Intent intent = getIntent();
        // intentから指定キーの数字列を取得する
        state=intent.getIntArrayExtra("state");

        if (state[0] == 0) {
            findViewById(R.id.background1).setVisibility(View.VISIBLE);
            findViewById(R.id.background2).setVisibility(View.INVISIBLE);
        } else if(state[0]==1){
            findViewById(R.id.background1).setVisibility(View.INVISIBLE);
            findViewById(R.id.background2).setVisibility(View.VISIBLE);
        }
    }

    public void back(View v){
        Intent intent = new Intent();
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        Log.d("Touchivemnt", "X:" + event.getX() + ",Y:" + event.getY());
        if (flag == false&&200 < event.getY() && event.getY() < 350 && 400 < event.getX() && event.getX() < 800) {
            Intent intent = new Intent(getApplication(), SubSubActivity1.class);
            intent.putExtra("state", state);
            startActivityForResult(intent, REQ_SUBSUB1);
            flag = true;
        }else if (flag2==false&&250 < event.getY() && event.getY() < 350 && 900 < event.getX() && event.getX() < 1300 &&state[1]==1) {
            state[0]=1;
            findViewById(R.id.background1).setVisibility(View.INVISIBLE);
            findViewById(R.id.background2).setVisibility(View.VISIBLE);
            flag2=true;
        }
        return true;
    }

    protected void onActivityResult(int requestCode , int resultCode , Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
        if (resultCode == RESULT_OK && requestCode == REQ_SUBSUB1 && intent != null){
            state=intent.getIntArrayExtra("state");
            flag = false;
        }
    }
}
