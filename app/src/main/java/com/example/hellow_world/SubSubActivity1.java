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

public class SubSubActivity1 extends Activity{
    boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subsubactivity1);
        // 現在のintentを取得する
        Intent intent = getIntent();
        // intentから指定キーの数字列を取得する
        //if(state[0]==0){
            findViewById(R.id.background1).setVisibility(View.VISIBLE);
            findViewById(R.id.background2).setVisibility(View.INVISIBLE);
//        }else{
//            findViewById(R.id.background1).setVisibility(View.INVISIBLE);
//            findViewById(R.id.background2).setVisibility(View.VISIBLE);
//        }

    }

    public void back(View v){
        Intent intent = new Intent();
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        Log.d("Touchivemnt", "X:" + event.getX() + ",Y:" + event.getY());
        if(flag==false) {
            if (550 < event.getY() && event.getY() < 800 && 600 < event.getX() && event.getX() < 1300) {
                    //state[1] = 1;
                flag=true;
                Log.d("Getmatch", "match");
            }
        }
        return true;
    }


}
