package org.rmj.guanzongroup.guanzonapp.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.rmj.guanzongroup.guanzonapp.R;

public class Activity_DashBoard extends AppCompatActivity {
    private static final String TAG = Activity_DashBoard.class.getSimpleName();
    private Activity_DashBoard instance;
    public Activity_DashBoard getInstance(){
        return instance;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        instance = this;
    }


}
