package org.rmj.guanzongroup.guanzonapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.guanzonapp.R;

public class Activity_TermsAndConditions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);
        TextView lblTermsAndConditions = findViewById(R.id.lbl_termsAndConditions);
        lblTermsAndConditions.setText(Html.fromHtml(getString(R.string.Privacy_Policy)));

        CheckBox cbAgree = findViewById(R.id.cb_agree);
        MaterialButton btnConfirm = findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loIntent = new Intent();
                if (cbAgree.isChecked()){
                    loIntent.putExtra("result", 1);
                    setResult(Activity.RESULT_OK, loIntent);
                } else {
                    Toast.makeText(Activity_TermsAndConditions.this, "Please accept the terms and policy to continue", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent loIntent = new Intent();
        loIntent.putExtra("result", 0);
        setResult(Activity.RESULT_OK, loIntent);
        finish();
    }
}