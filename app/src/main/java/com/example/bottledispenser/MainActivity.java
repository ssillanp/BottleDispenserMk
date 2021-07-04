package com.example.bottledispenser;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

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
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, bD.listBottles());
        mySpinner.setAdapter(adapter);

    }

    BottleDispenser bD = BottleDispenser.getInstance();

    public void addMoney(View v){
         txtOut.setText(bD.addMoney(moneyAmt.getProgress()));
         moneyAmt.setProgress(0);
    }

    public void getBottle(View v){
        try {
            txtOut.setText(bD.buyBottle((int) mySpinner.getSelectedItemId()));
            ArrayAdapter<String> updateAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_dropdown_item, bD.listBottles());
            mySpinner.setAdapter(updateAdapter);
        } catch (IndexOutOfBoundsException e) {
            txtOut.setText("The machine is empty");
        }
    }

    public void returnMoney(View v){
        txtOut.setText(bD.returnMoney());
    }

    public void listBottles(View v){
        StringBuilder outString = new StringBuilder();
        for (String bottleItem:bD.listBottles()){
            outString.append(bottleItem);
            outString.append("\n");
        }
        txtOut.setText(outString);
    }







}