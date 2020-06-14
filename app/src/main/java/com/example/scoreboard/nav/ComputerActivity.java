package com.example.scoreboard.nav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.scoreboard.R;
import com.example.scoreboard.nav.fragment.MyViewModel;

public class ComputerActivity extends AppCompatActivity {
   public MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);

        //fragment 使用同一个viewmodel 才能达到数据共享，
        // ViewModelProviders.of()老api可以做到单利。，可以自己在各自的fragment中去写viewmodel
        // 现在新方法不可以，所以暂时这么做了

        myViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MyViewModel.class);
    }
}
