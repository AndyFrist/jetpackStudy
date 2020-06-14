package com.example.scoreboard.nav.fragment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<Integer> number;

//    public MyViewModel(@NonNull Application application) {
//        super(application);
//    }

    public MutableLiveData<Integer> getNumber(){
        if (number == null) {
            number = new MutableLiveData<>();
            number.setValue(0);
        }

        return number;
    }

    public void add(int x) {
        number.setValue(number.getValue() + x);
        if (number.getValue() < 0) {
            number.setValue(0);
        }
    }
}
