package com.example.hellow_world;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/**
 * Created by ServoRobo on 2017/02/23.
 * ウィジャ盤に関するアクティビティ
 */

public class SubActivity3 extends Activity{

    boolean flag = false; //ウィジャ盤へのタッチフラグ
    private DialogFragment dialogFragment;
    private FragmentManager flagmentManager;

    GestureDetector gd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity3);

        gd = new GestureDetector(getApplicationContext(),new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });

        /* 現在のintentを取得する */
//        Intent intent = getIntent();

        /* intentから指定キーの数字列を取得する*/
//        intent.getIntArrayExtra("state");

        /* 画像を使用する場合 */
//        if (state[3] == 1) {
//            findViewById(R.id.imageView7).setVisibility(View.INVISIBLE);
//            findViewById(R.id.imageView8).setVisibility(View.VISIBLE);
//        } else {
//            findViewById(R.id.imageView7).setVisibility(View.VISIBLE);
//            findViewById(R.id.imageView8).setVisibility(View.INVISIBLE);
//        }

    }

    public void back(View v){
        Intent intent = new Intent();
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean touchUp = gd.onTouchEvent(event);

        float x = event.getX();
        float y = event.getY();

        Log.d("SA3Touchivemnt", "X:" + x + ",Y:" + y);

        if (flag==false){

            if(touchUp == true){ /*if (1640 < y && y < 1950 && 400 < x && x < 830){*/
                flagmentManager = getFragmentManager();

                // DialogFragment を継承したAlertDialogFragmentのインスタンス
                dialogFragment = new TestDialogFragment();
                // DialogFragmentの表示
                dialogFragment.show(flagmentManager, "dialog");

                flag = true;
            }
        }
        return true;
    }

    public class TestDialogFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            //custom_layoutの要素を扱えるようにするLayoutInflaterを設定(カスタムダイアログ用)
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View view = inflater.inflate(R.layout.custom_layout, null);

            //回答文字列を格納するための変数
            final EditText editText = (EditText)view.findViewById(R.id.pass);

            builder.setView(view)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            Log.d("inputPass","inputText=" + editText.getText().toString());

                            //「play」が入力されてokが押されたらf4を変更
                            if(editText.getText().toString().equals("play")){
//                                flag4 = true;
                            }else{
                                //何もしない
                            }
                        }
                    })
                    .setNegativeButton("Cancel", null);
            return builder.create();
        }

        @Override
        public void onPause() {
            super.onPause();
            // onPause でダイアログを閉じる場合
            dismiss();
        }
    }

    protected void onActivityResult(int requestCode , int resultCode , Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
        if (requestCode == RESULT_OK && resultCode == 1100 && intent != null){
            intent.getIntArrayExtra("state");
            flag = false;
        }
    }
}