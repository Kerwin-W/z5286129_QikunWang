package com.example.detailactivity.z5286129_qikunwang;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DetailActivity extends AppCompatActivity {
    private TextView dt_income, dt_expenses, dt_interest, dt_loanTerm,dt_borrowAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dt_income = findViewById(R.id.dt_income);
        dt_expenses = findViewById(R.id.dt_expenses);
        dt_interest = findViewById(R.id.dt_interest);
        dt_loanTerm = findViewById(R.id.dt_loanTerm);
        dt_borrowAmount = findViewById(R.id.dt_borrowAmount);

        Intent intent = getIntent();
        double income2 = intent.getDoubleExtra("income", 0);
        double expenses2 = intent.getDoubleExtra("expenses", 0);
        double interestRate = intent.getDoubleExtra("interest", 0);
        int loanTerm2 = intent.getIntExtra("loanTerm", 0);
        double borrowAmount = intent.getDoubleExtra("borrowAmount", 0);

        dt_income.setText("" + income2);
        dt_expenses.setText("" +expenses2);
        dt_interest.setText(interestRate + "% p.a.");
        dt_loanTerm.setText(loanTerm2 + " years");
        dt_borrowAmount.setText("" + borrowAmount);
    }
}

