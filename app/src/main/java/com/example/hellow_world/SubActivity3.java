package com.example.hellow_world;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ServoRobo on 2017/02/23.
 * ウィジャ盤に関するアクティビティ
 */

public class SubActivity3 extends Activity{

    int[] state = new int[3];  //各アイテムのフラグ
    boolean flag = false;     //ウィジャ盤へのタッチフラグ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity3);
        // 現在のintentを取得する
        Intent intent = getIntent();
        // intentから指定キーの数字列を取得する
        intent.getIntArrayExtra("state");
/*
        if (state[3] == 1) {
            findViewById(R.id.imageView7).setVisibility(View.INVISIBLE);
            findViewById(R.id.imageView8).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.imageView7).setVisibility(View.VISIBLE);
            findViewById(R.id.imageView8).setVisibility(View.INVISIBLE);
        }*/
    }

    public void back(View v){
        Intent intent = new Intent();
        intent.putExtra("state",state);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        Log.d("Touchivemnt", "X:" + x + ",Y:" + y);

        if (flag==false){
            if (1640 < y && y < 1950 && 400 < x && x < 830){
//                Intent intent = new Intent(getApplication(),OuijaBoardActivity.class);
//                intent.putExtra("state",state);
//                startActivityForResult(intent , 1100);
//                flag = true;
            }
        }
        return true;
    }

    protected void onActivityResult(int requestCode , int resultCode , Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
        if (requestCode == RESULT_OK && resultCode == 1100 && intent != null){
            intent.getIntArrayExtra("state");
            flag = false;
        }
    }
}