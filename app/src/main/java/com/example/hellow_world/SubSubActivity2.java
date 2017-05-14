package com.example.hellow_world;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import static com.example.hellow_world.Define.*;

/**
 * Created by ami on 2017/02/23.
 */

public class SubSubActivity2 extends Activity{

    UtilCommon Flag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity1);
        // 現在のintentを取得する
        Intent intent = getIntent();

        findViewById(R.id.background).setVisibility(View.VISIBLE);
    }

    public void back(View v){
        Intent intent = new Intent();
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        UtilCommon Flag3 = (UtilCommon) this.getApplication();

        Log.d("Touchivemnt", "X:" + event.getX() + ",Y:" + event.getY());
        if (0 < event.getY() && event.getY() < 2000 && 0 < event.getX() && event.getX() < 2000) {
            Flag3.setFlag3(true);
        }
        return true;
    }
}
