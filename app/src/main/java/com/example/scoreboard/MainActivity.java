package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.scoreboard.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding viewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MyViewModel myViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()).create(com.example.scoreboard.MyViewModel.class);
        viewDataBinding.setData(myViewModel);

        viewDataBinding.setLifecycleOwner(this);

    }
}
