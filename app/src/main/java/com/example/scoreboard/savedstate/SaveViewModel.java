package com.example.scoreboard.savedstate;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class SaveViewModel extends ViewModel {

    private SavedStateHandle handle;

    public SaveViewModel(SavedStateHandle handle) {

        this.handle = handle;
    }

    public MutableLiveData<Integer> getNumber(){
        if (!handle.contains("key")) {
            handle.set("key",0);
        }

        return handle.getLiveData("key");
    }

    public void add(){
        getNumber().setValue(getNumber().getValue() + 1);
    }
}
