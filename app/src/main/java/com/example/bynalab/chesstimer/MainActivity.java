package com.example.bynalab.chesstimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView timer1;
    TextView timer2;
    Button btnpause1;
    Button btnpause2;
    Button btnStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer1 = findViewById(R.id.textView5);
        timer2 = findViewById(R.id.textView2);
        btnStart = findViewById(R.id.button3);
        btnpause1 = findViewById(R.id.button4);
        btnpause2 = findViewById(R.id.button2);
        final int[] stopper = new int[5];
        stopper[0] = 0;
        stopper[1] = 0;

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stopper[0] == 0) {
                    btnStart.setText("Pause");
                    stopper[0] = 1;
                    int min = 180;
                    int seconds = Integer.valueOf(min);
                    CountDownTimer ftimer = new CountDownTimer(seconds * 1000, 1000) {
                        @Override
                        public void onTick(long millis) {

                            timer1.setText(String.valueOf(millis / 1000));
                        }

                        @Override
                        public void onFinish() {

                            timer1.setText("Time Up!");
                            btnStart.setText("Start");
                            stopper[0] = 0;

                        }
                    };
                    ftimer.start();

                }
            }
        });

        btnpause1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStart.setText("Pause");
                int min = 180;
                int seconds = Integer.valueOf(min);
                CountDownTimer stimer = new CountDownTimer(seconds * 1000, 1000) {
                    @Override
                    public void onTick(long millis) {

                        timer2.setText(String.valueOf(millis / 1000));
                    }

                    @Override
                    public void onFinish() {

                        timer2.setText("Time Up!");
                        btnStart.setText("Start");

                    }
                };stimer.start();
                stopper[1] = 2;
                if(stopper[1] == 1){
                    stimer.cancel();
                }
            }
        });

        btnpause2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stopper[0] == 0){
                    btnStart.setText("Pause");
                    stopper[0] = 1;
                    int min = 180;
                    int seconds = Integer.valueOf(min);
                    CountDownTimer ftimer = new CountDownTimer(seconds * 1000, 1000) {
                        @Override
                        public void onTick(long millis) {

                            timer1.setText(String.valueOf(millis / 1000));
                        }

                        @Override
                        public void onFinish() {

                            timer1.setText("Time Up!");
                            btnStart.setText("Start");
                            stopper[0] = 0;

                        }
                    };
                    ftimer.start();
                    stopper[1] = 1;
                    if(stopper[1] == 2){
                        ftimer.cancel();
                    }
                }
            }
        });
    }
}
