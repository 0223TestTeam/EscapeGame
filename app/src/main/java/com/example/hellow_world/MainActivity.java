package com.example.hellow_world;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import static com.example.hellow_world.Define.REQ_SUB1;
import static com.example.hellow_world.Define.REQ_SUB2;
import static com.example.hellow_world.Define.REQ_SUB3;
import static com.example.hellow_world.Define.REQ_SUB4;

/**
 * Created by ServoRobo on 2017/02/23.
 */

public class MainActivity extends Activity {

    private UtilCommon common;
    boolean flag1 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //グローバル変数
        common = (UtilCommon)this.getApplication();




//       if(common.getFlag1()==false){
//            findViewById(R.id.background1).setVisibility(View.VISIBLE);
//            findViewById(R.id.background2).setVisibility(View.INVISIBLE);
//        }else if(common.getFlag1()==true){
//            findViewById(R.id.background1).setVisibility(View.INVISIBLE);
//            findViewById(R.id.background2).setVisibility(View.VISIBLE);
//        }

    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        //背景画像のサイズ調節
        int backid;
        if(common.getFlag1()==false){
            backid=R.id. background1;
        }else{
            backid=R.id. background2;
        }



        //CalcActivity.calcBackground(this,(ImageView) findViewById(backid));
        Display display = this.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);

        float scalex=point.x;
        float scaley=point.y;

        scalex=scalex/1920;
        scaley=scaley/1104;

        common.setScaleX(scalex);
        common.setScaleY(scaley);

        Log.d("Scalebefore", "X:" + point.x + ",Y:" + point.y);
        Log.d("Scale", "X:" + common.getScaleX() + ",Y:" + common.getScaleY());

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Boolean flag=false;
        if(flag==false){
            flag=true;
            Log.d("Touchivemnt", "X:" + event.getX() + ",Y:" + event.getY());

            float x=event.getX()/common.getScaleX();
            float y=event.getY()/common.getScaleY();

            Log.d("Touchivemnt2", "X:" + x + ",Y:" + y);

            if (flag1==false){
                if (0<y && y<200 ){
                    Intent intent = new Intent(getApplication(),SubActivity1.class);
                    startActivityForResult(intent , REQ_SUB1);
                    flag1 = true;
                }else if (1700<x && x<1920){
                    Intent intent = new Intent(getApplication(),SubActivity2.class);
                    startActivityForResult(intent , REQ_SUB2);
                    flag1 = true;
                }else if (0<x && x<200){
                    Intent intent = new Intent(getApplication(),SubActivity3.class);
                    startActivityForResult(intent , REQ_SUB3);
                    flag1 = true;
                }else if (1000<y && y<1104){
                    Intent intent = new Intent(getApplication(),SubActivity3.class);
                    startActivityForResult(intent , REQ_SUB4);
                    flag1 = true;
                }

                flag=false;
            }

        }




        return true;
    }

    protected void onActivityResult(int requestCode , int resultCode , Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
        flag1=false;


//        if (resultCode == RESULT_OK && requestCode == REQ_SUB1 && intent != null){
////            if(state[0]==1){
////                findViewById(R.id.background1).setVisibility(View.INVISIBLE);
////                findViewById(R.id.background2).setVisibility(View.VISIBLE);
////            }
//
//            flag1 = false;
//        }
//        if (resultCode == RESULT_OK && requestCode == REQ_SUB2 && intent != null){
//
//            flag1 = false;
//        }
//        if (resultCode == RESULT_OK && requestCode == REQ_SUB3 && intent != null){
//            flag1 = false;
//        }
    }
}
