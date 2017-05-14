package com.example.hellow_world;

import android.app.Activity;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by primenote on 2017/05/14.
 */

public class CalcActivity {

    public static void getDisplaySize(Activity activity){
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        Log.d("Size", "X:" + point.x + ",Y:" + point.y);
    }

    public static void calcBackground(Activity activity, ImageView imageview){

        WindowManager wm = activity.getWindowManager();
        final Display disp = wm.getDefaultDisplay();
        final ImageView img = imageview;
        ViewGroup.LayoutParams params = img.getLayoutParams();

        //  横幅のみ画面サイズに変更
        params.width = disp.getWidth();
        img.setLayoutParams(params);
    }

}
