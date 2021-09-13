package com.example.mortgagecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        updateView();
    }

    public void updateView() {
        Mortgage mortgage = MainActivity.mortgage;
        if (mortgage.getYears() == 10) {
            RadioButton rb10 = findViewById(R.id.ten);
            rb10.setChecked(true);
        }
        else if (mortgage.getYears() == 15) {
            RadioButton rb15 = findViewById(R.id.fifteen);
            rb15.setChecked(true);
        }
        else if (mortgage.getYears() == 30) {
            RadioButton rb30 = findViewById(R.id.thirty);
            rb30.setChecked(true);
        }

        EditText amountET = findViewById(R.id.data_amount);
        amountET.setText(mortgage.getAmount() + " ");

        EditText rateET = findViewById(R.id.data_rate);
        rateET.setText(mortgage.getRate() + " ");
    }

    public void updateMortgage() {
        Mortgage mortgage = MainActivity.mortgage;
        RadioButton rb10 = findViewById(R.id.ten);
        RadioButton rb15 = findViewById(R.id.fifteen);

        int years = 30;

        if (rb10.isChecked()){
            years = 10;
        }
        else if (rb15.isChecked()){
            years = 15;
        }
        mortgage.setYears(years);

        EditText amountET = findViewById(R.id.data_amount);
        String amountString = amountET.getText().toString();
        double amount = Double.parseDouble(amountString);
        mortgage.setAmount(amount);

        EditText rateET = findViewById(R.id.data_rate);
        String rateString = rateET.getText().toString();
        double rate = Double.parseDouble(rateString);
        mortgage.setRate(rate);
    }

    public void goBack(View v) {
        updateMortgage();
        this.finish();
    }
}
