package org.rmj.guanzongroup.marketplace.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.rmj.guanzongroup.marketplace.databinding.ActivityWriteProductReviewBinding;

public class Activity_WriteProductReview extends AppCompatActivity {

    private ActivityWriteProductReviewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWriteProductReviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}