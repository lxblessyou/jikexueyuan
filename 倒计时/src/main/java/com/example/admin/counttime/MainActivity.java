package com.example.admin.counttime;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity implements View.OnClickListener {
    private EditText et;
    private Button btnStart, btnStop;
    private TextView tv;
    private Timer mTimer = null;
    private TimerTask mTimerTask = null;
    private String startTime = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        et = (EditText) findViewById(R.id.et_input);
        btnStart = (Button) findViewById(R.id.btn_start);
        btnStop = (Button) findViewById(R.id.btn_stop);
        tv = (TextView) findViewById(R.id.tv_show);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                startCountDown();
                break;
            case R.id.btn_stop:
                if (mTimer != null) {
                    btnStart.setClickable(true);
                    mTimer.cancel();
                    tv.setText("0");
                }
                break;
            default:
                break;
        }
    }

    private int time = 0;

    private void startCountDown() {
        btnStart.setClickable(false);
        startTime = et.getText().toString().trim();
        if (TextUtils.isEmpty(startTime)) {
            Toast.makeText(this, "请输入时间", Toast.LENGTH_LONG).show();
            return;
        }
        tv.setText(startTime);
        time = Integer.parseInt(startTime);
        if (mTimer != null) {
            mTimer.cancel();
        }
        mTimer = new Timer();
        mTimerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(time + "");
                        if (time > 0) {
                            time--;
                        } else {
                            btnStart.setClickable(true);
                            mTimer.cancel();
                            tv.setText("0");
                        }
                    }
                });
            }
        };
        mTimer.schedule(mTimerTask, 0, 1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTimer != null) {
            mTimer.cancel();
        }
    }
}
