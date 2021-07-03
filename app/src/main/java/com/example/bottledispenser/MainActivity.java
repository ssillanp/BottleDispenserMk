package com.example.bottledispenser;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView txtOut;
    TextView money;
    SeekBar moneyAmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtOut = (TextView) findViewById(R.id.textOutputView);
        money = (TextView) findViewById(R.id.moneyDisp);
        moneyAmt = (SeekBar) findViewById(R.id.moneyAmountBar);
    }

    BottleDispenser bD = BottleDispenser.getInstance();

    public void addMoney(View v){
         txtOut.setText(bD.addMoney(moneyAmt.getProgress()));
         moneyAmt.setProgress(0);
    }

    public void getBottle(View v){
        txtOut.setText(bD.buyBottle(1));
    }

    public void returnMoney(View v){
        txtOut.setText(bD.returnMoney());
    }

    public void listBottles(View v){
        txtOut.setText(bD.listBottles());
    }







}