package org.rmj.guanzongroup.useraccount.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.rmj.guanzongroup.useraccount.R;


public class Activity_TermsAndConditions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);
        TextView lblTermsAndConditions = findViewById(R.id.lbl_termsAndConditions);

        if(getIntent().hasExtra("cTermsDsp")){
            int cTermsDsp = getIntent().getIntExtra("cTermsDsp", 0);
            if(cTermsDsp == 0){
//                lblTermsAndConditions.setText(Html.fromHtml(getString(R.string.Terms_and_Conditions)));
            } else {
//                lblTermsAndConditions.setText(Html.fromHtml(getString(R.string.Privacy_Policy)));
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent loIntent = new Intent();
        loIntent.putExtra("result", 0);
        setResult(Activity.RESULT_OK, loIntent);
        finish();
    }
}