package com.example.hellow_world;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import static com.example.hellow_world.Define.*;

/**
 * Created by ServoRobo on 2017/02/23.
 */

public class MainActivity extends Activity {

    boolean flag1 = false;
    boolean flag2 = false;
    boolean flag3 = false;

    int[] state = new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(state[0]==0){
            findViewById(R.id.background1).setVisibility(View.VISIBLE);
            findViewById(R.id.background2).setVisibility(View.INVISIBLE);
        }else if(state[0]==1){
            findViewById(R.id.background1).setVisibility(View.INVISIBLE);
            findViewById(R.id.background2).setVisibility(View.VISIBLE);
        }

    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        RelativeLayout r = (RelativeLayout)findViewById(R.id.layout1);
        Point view = SizeCheck.getViewSize(r);
        Point disp = SizeCheck.getDisplaySize(this);
        Log.d("Size", "X:" + disp.x + ",Y:" + disp.y);

        /*
        LinearLayout r = (LinearLayout)findViewById(R.id.include_views1);
        DisplaySizeCheck.getDisplaySize(this);
        Log.d("viewSize", "X:" + r.getWidth() + ",Y:" + r.getHeight());
        WindowManager wm = getWindowManager();
        final Display disp = wm.getDefaultDisplay();

        final ImageView img = (ImageView) findViewById(R.id.imageView1);
        ViewGroup.LayoutParams params = img.getLayoutParams();

        //  横幅のみ画面サイズに変更
        params.width = disp.getWidth();
        img.setLayoutParams(params);

        float scaleX = disp.getWidth() / 600;
        float scaleY = disp.getHeight() /  1200;
        Float scale = scaleX > scaleY ? scaleY : scaleX;

        touchedX = event.getX() / scale;
        touchedY = event.getY() / scale;*/

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        Log.d("Touchivemnt", "X:" + event.getX() + ",Y:" + event.getY());

        if (flag1==false){
            if (700<event.getY() && event.getY()<1080 && 500<event.getX() && event.getX()<900){
                Intent intent = new Intent(getApplication(),SubActivity1.class);
                intent.putExtra("state",state);
                startActivityForResult(intent , REQ_SUB1);
                flag1 = true;
            }
        }/*else if (flag2==false){
            if (1640<event.getY() && event.getY()<1950 && 400<event.getX() && event.getX()<830){
                Intent intent = new Intent(getApplication(),SubActivity2.class);
                intent.putExtra("state",state);
                startActivityForResult(intent , REQ_SUB2);
                flag2 = true;
            }
        }else if (state[3]==0&&flag3==false){
            if (1640<event.getY() && event.getY()<1950 && 400<event.getX() && event.getX()<830){
                Intent intent = new Intent(getApplication(),SubActivity3.class);
                intent.putExtra("state",state);
                startActivityForResult(intent , REQ_SUB3);
                flag3 = true;
            }
        }else if(state[3]==1&&flag3==false){
            if (1640<event.getY() && event.getY()<1950 && 400<event.getX() && event.getX()<830){
                Intent intent = new Intent(getApplication(),SubActivity3.class);
                intent.putExtra("state",state);
                startActivityForResult(intent , REQ_SUB4);
                flag3 = true;
            }
        }
        */
        //
        return true;
    }

    protected void onActivityResult(int requestCode , int resultCode , Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
        state=intent.getIntArrayExtra("state");
        if (resultCode == RESULT_OK && requestCode == REQ_SUB1 && intent != null){
            if(state[0]==1){
                findViewById(R.id.background1).setVisibility(View.INVISIBLE);
                findViewById(R.id.background2).setVisibility(View.VISIBLE);
            }

            flag1 = false;
        }
        if (resultCode == RESULT_OK && requestCode == REQ_SUB1 && intent != null){
            intent.getIntArrayExtra("state");
            flag2 = false;
        }
        if (resultCode == RESULT_OK && requestCode == REQ_SUB1 && intent != null){
            intent.getIntArrayExtra("state");
            flag3 = false;
        }
    }
}
