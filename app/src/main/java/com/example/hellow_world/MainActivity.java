package com.example.hellow_world;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import static com.example.hellow_world.Define.REQ_SUB1;
import static com.example.hellow_world.Define.REQ_SUB2;
import static com.example.hellow_world.Define.REQ_SUB3;
import static com.example.hellow_world.Define.REQ_SUB4;

/**
 * Created by ServoRobo on 2017/02/23.
 */

public class MainActivity extends Activity {

    boolean flag1 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //グローバル変数
        UtilCommon common = (UtilCommon)getApplication();



//        if(state[0]==0){
            //findViewById(R.id.background1).setVisibility(View.VISIBLE);
            //findViewById(R.id.background2).setVisibility(View.INVISIBLE);
//        }else if(state[0]==1){
//            findViewById(R.id.background1).setVisibility(View.INVISIBLE);
//            findViewById(R.id.background2).setVisibility(View.VISIBLE);
//        }

    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        //背景画像のサイズ調節
        //CalcActivity.calcBackground(this,(ImageView) findViewById(R.id.imageView1));


        /*
        float scaleX = disp.getWidth() / 600;
        float scaleY = disp.getHeight() /  1200;


        touchedX = event.getX() / scaleX;
        touchedY = event.getY() / scaleY;*/

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        Log.d("Touchivemnt", "X:" + event.getX() + ",Y:" + event.getY());

        if (flag1==false){
            if (0<event.getY() && event.getY()<200 ){
                Intent intent = new Intent(getApplication(),SubActivity1.class);
                startActivityForResult(intent , REQ_SUB1);
                flag1 = true;
            }

            if (1700<event.getX() && event.getX()<1920){
                Intent intent = new Intent(getApplication(),SubActivity2.class);
                startActivityForResult(intent , REQ_SUB2);
                flag1 = true;
            }

            if (0<event.getX() && event.getX()<200){
                Intent intent = new Intent(getApplication(),SubActivity3.class);
                startActivityForResult(intent , REQ_SUB3);
                flag1 = true;
            }

            if (1000<event.getY() && event.getY()<1104){
                Intent intent = new Intent(getApplication(),SubActivity3.class);
                startActivityForResult(intent , REQ_SUB4);
                flag1 = true;
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
