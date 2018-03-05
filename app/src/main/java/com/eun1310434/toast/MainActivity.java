/**
 * 05.03.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * 참고) Do it android programming
 */

package com.eun1310434.toast;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
    }

    public void onButton1Clicked(View v) {
        setToast(Toast.makeText(this,"",Toast.LENGTH_SHORT),null, null); //기존 토스트를 사용할려면 makeToast로 갖고옴
    }

    public void onButton2Clicked(View v) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(
                R.layout.toast_view,
                (ViewGroup) findViewById(R.id.toast_layout_root) //toast_view의 LinearLayout을 ViewGroup으로 설정
        );
        TextView text = (TextView) layout.findViewById(R.id.text);

        setToast(new Toast(this), layout, text);
    }

    public void setToast(Toast _toast, View _view , TextView _tv){
        int xOffset;
        int yOffset;

        if(editText.getText().toString().equals("") || editText2.getText().toString().equals("") ){
            editText.setText("50");
            editText2.setText("50");
        }
        xOffset = Integer.parseInt(editText.getText().toString());
        yOffset = Integer.parseInt(editText2.getText().toString());

        try {
            _toast.setDuration(Toast.LENGTH_SHORT);
            _toast.setGravity(
                    Gravity.TOP|Gravity.LEFT, //좌 상단 기준
                    xOffset,
                    yOffset);

            if(_view == null){
                _toast.setText("Toast : " +xOffset+" , " +yOffset);
            }else{
                _toast.setView(_view);
                _tv.setText("Toast : " +xOffset+" , " +yOffset);
            }
            _toast.show();

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void onButton3Clicked(View v) {
        Snackbar.make(v, "This is a Snacbar.", Snackbar.LENGTH_SHORT).show();
    }
}
