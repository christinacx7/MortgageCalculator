package com.example.mortgagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public final DecimalFormat MONEY = new DecimalFormat("$#,##0.00");
    public final DecimalFormat DF = new DecimalFormat("$##.00%");
    public static Mortgage mortgage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mortgage = new Mortgage();
    }

    public void onStart() {
        super.onStart();
        updateView();
    }

    public void updateView() {
        TextView amountTV = findViewById(R.id.amount);
        amountTV.setText(MONEY.format(mortgage.getAmount()));

        TextView yearTV = findViewById(R.id.years);
        yearTV.setText(MONEY.format(mortgage.getYears()));

        TextView rateTV = findViewById(R.id.rate);
        rateTV.setText(MONEY.format(mortgage.getRate()));

        TextView monthlyTV = findViewById(R.id.payment);
        monthlyTV.setText(MONEY.format(mortgage.monthlyPayment()));

        TextView totalTV = findViewById(R.id.total);
        totalTV.setText(MONEY.format(mortgage.totalPayment()));
    }

    public void modifyData(View v) {
        Intent myIntent = new Intent(this, DataActivity.class);
        this.startActivity(myIntent);
    }
}