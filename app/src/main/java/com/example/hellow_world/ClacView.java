package com.example.hellow_world;

import android.graphics.Canvas;

/**
 * Created by primenote on 2017/04/09.
 */

public class ClacView {
    public int calcview(int x, int y){
        /** 最初にゲーム内の画面サイズを決めておく **/
        final float VIEW_WIDTH = 600;
        final float VIEW_HEIGHT = 900;

        /** SurfaceCreatedに記述 **/
//        float scaleX = getWidth() / VIEW_WIDTH;
//        float scaleY = getHeight() /  VIEW_HEIGHT;
//        scale = scaleX > scaleY ? scaleY : scaleX;
//
//        /** 描画部分で記述 **/
//        Canvas c = holder.lockCanvas();
//        c.translate(getWidth() - VIEW_WIDTH)/2*scale, (getHeight() - VIEW_HEIGHT)/2*scale); // 画面の中央になるように移動させる
//        c.scale(scale, scale); // 端末の画面に合わせて拡大・縮小する
//
//        // 描画処理
//        holder.unlockCanvasAndPost(c);
        return(x);
    }

    public int calcposition(int x,int y){
        return(x);
    };

}
