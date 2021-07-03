package com.example.bottledispenser;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView txtOut;
    TextView money;
    SeekBar moneyAmt;
    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtOut = (TextView) findViewById(R.id.textOutputView);
        money = (TextView) findViewById(R.id.moneyDisp);
        moneyAmt = (SeekBar) findViewById(R.id.moneyAmountBar);
        mySpinner = (Spinner) findViewById(R.id.selectBottle);

        String[] bottleList = {"Pepsi Max, 0.5l", "Pepsi Max, 1.5l", "Coca-Cola Zero, 0.5l", "Coca-Cola Zero, 1.5l", "Fanta Zero, 0.5l"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, bottleList);
        mySpinner.setAdapter(adapter);

    }

    BottleDispenser bD = BottleDispenser.getInstance();

    public void addMoney(View v){
         txtOut.setText(bD.addMoney(moneyAmt.getProgress()));
         moneyAmt.setProgress(0);
    }

    public void getBottle(View v){
//        System.out.println(mySpinner.getSelectedItemId());
        txtOut.setText(bD.buyBottle((int) mySpinner.getSelectedItemId()));
    }

    public void returnMoney(View v){
        txtOut.setText(bD.returnMoney());
    }

    public void listBottles(View v){
        txtOut.setText(bD.listBottles());
    }







}