package org.guanzongroup.com.creditapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.RadioButton;

import org.guanzongroup.com.creditapp.R;

import java.util.Objects;

public class Activity_LoanTerm extends AppCompatActivity {

    private Toolbar toolbar;

    private RadioButton rb24Month,
                        rb18Month,
                        rb12Month,
                        rb6Monthx,
                        rb3Monthx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_term);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Apply For A Loan");
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        rb24Month = findViewById(R.id.rb_24months);
        rb18Month = findViewById(R.id.rb_18months);
        rb12Month = findViewById(R.id.rb_12months);
        rb6Monthx = findViewById(R.id.rb_6months);
        rb3Monthx = findViewById(R.id.rb_3months);
    }
}