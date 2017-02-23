package com.example.hellow_world;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by ServoRobo on 2017/02/23.
 */

public class ActionActivity extends Activity{
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
    }

    public void back(View v){
        Intent intent = new Intent();
        intent.putExtra("Message","結果です");
        setResult(RESULT_OK,intent);
        finish();
    }
}
