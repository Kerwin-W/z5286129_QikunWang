package com.example.detailactivity.z5286129_qikunwang;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText income, expenses, interest, loanTerm;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        income = findViewById(R.id.m_income);
        expenses = findViewById(R.id.m_expenses);
        interest = findViewById(R.id.m_interest);
        loanTerm = findViewById(R.id.m_loanTerm);

        button = findViewById(R.id.m_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                borrowAmount();
            }
        });
    }

    private void borrowAmount() {
        double income2 = Double.parseDouble(income.getText().toString());
        double expenses2 = Double.parseDouble(expenses.getText().toString());
        double interestRate = Double.parseDouble(interest.getText().toString());
        int loanTerm2 = Integer.parseInt(loanTerm.getText().toString());

        double borrowAmount = calculate(income2,expenses2,interestRate,loanTerm2);

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("income",income2);
        intent.putExtra("expenses",expenses2);
        intent.putExtra("interest",interestRate);
        intent.putExtra("loanTerm",loanTerm2);
        intent.putExtra("borrowAmount",borrowAmount);
        startActivity(intent);

    }

    private double calculate(double income2, double expenses2, double interestRate, int loanTerm2) {

        double borrowAmount2 = (income2 - expenses2) / interestRate * (1 - Math.pow(1 + interestRate, -loanTerm2));
        return borrowAmount2;
    }
}

