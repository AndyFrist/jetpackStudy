package com.example.scoreboard;

import android.app.Application;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.scoreboard.savedstate.SavedStateActivity;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MyViewModel extends AndroidViewModel {
    public MyViewModel(@NonNull Application application) {

        super(application);
    }

    MutableLiveData<Integer> aScore = null;
    MutableLiveData<Integer> bScore = null;

    int aBack = 0;
    int bBack = 0;

    public MutableLiveData<Integer> getaScore() {
        if (aScore == null) {
            aScore = new MutableLiveData<>();
            aScore.setValue(0);
        }
        return aScore;
    }

    public MutableLiveData<Integer> getbScore() {
        if (bScore == null) {
            bScore = new MutableLiveData<>();
            bScore.setValue(0);
        }
        return bScore;
    }


    public void addATeam(int score) {
        aBack = aScore.getValue();
        bBack = bScore.getValue();
       aScore.setValue(aScore.getValue() + score);
    }

    public void addBTeam(int score) {
        aBack = aScore.getValue();
        bBack = bScore.getValue();
        bScore.setValue(bScore.getValue() + score);
    }

    public void undo(View view) {
        Toast.makeText(view.getContext(),"撤销",Toast.LENGTH_LONG).show();
        aScore.setValue(aBack);
        bScore.setValue(bBack);
    }

    public void reset(View view) {
        Toast.makeText(view.getContext(),"归零",Toast.LENGTH_LONG).show();
        aScore.setValue(0);
        bScore.setValue(0);


        view.getContext().startActivity(new Intent(view.getContext(), SavedStateActivity.class));
    }
}
