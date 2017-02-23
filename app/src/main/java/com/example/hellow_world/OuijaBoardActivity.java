package com.example.hellow_world;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by ServoRobo on 2017/02/23.
 * 主に文字入力のアクティビティ
 */
public class OuijaBoardActivity extends Activity {

    int[] state = new int[3];  //各アイテムのフラグ

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ouija_board);
    }

    public void back(View v){
        Intent intent = new Intent();
        intent.putExtra("state",state);
        setResult(RESULT_OK,intent);
        finish();
    }
}
