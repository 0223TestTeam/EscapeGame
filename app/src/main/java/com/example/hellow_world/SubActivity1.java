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

    private UtilCommon common;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity1);
        // 現在のintentを取得する
        Intent intent = getIntent();

        //グローバル変数
        common = (UtilCommon)this.getApplication();


        if(common.getFlag1()==false){
            findViewById(R.id.backgrounddd1).setVisibility(View.VISIBLE);
            findViewById(R.id.backgrounddd2).setVisibility(View.INVISIBLE);
        }else if(common.getFlag1()==true){
            findViewById(R.id.backgrounddd1).setVisibility(View.INVISIBLE);
            findViewById(R.id.backgrounddd2).setVisibility(View.VISIBLE);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {


        Log.d("Touchivemnt", "X:" + event.getX() + ",Y:" + event.getY());
        Boolean flag=false;

//        if (flag == false&&200 < event.getY() && event.getY() < 350 && 400 < event.getX() && event.getX() < 800) {
//            Intent intent = new Intent(getApplication(), SubSubActivity1.class);
//            startActivityForResult(intent, REQ_SUBSUB1);
//            flag = true;
//        }else if (flag2==false&&250 < event.getY() && event.getY() < 350 && 900 < event.getX() && event.getX() < 1300 && common.getFlag1()==false) {
//            common.setFlag1(true);
//            findViewById(R.id.background1).setVisibility(View.INVISIBLE);
//            findViewById(R.id.background2).setVisibility(View.VISIBLE);
//            flag2=true;
//        }

        if (flag==false&&250 < event.getY() && event.getY() < 350 && 900 < event.getX() && event.getX() < 1300 && common.getFlag1()==false) {
            flag=true;
            common.setFlag1(true);
            findViewById(R.id.backgrounddd1).setVisibility(View.INVISIBLE);
            findViewById(R.id.backgrounddd2).setVisibility(View.VISIBLE);

        }

        return true;
    }

    protected void onActivityResult(int requestCode , int resultCode , Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
//        if (resultCode == RESULT_OK && requestCode == REQ_SUBSUB1 && intent != null){
//            flag = false;
//        }
    }
}
