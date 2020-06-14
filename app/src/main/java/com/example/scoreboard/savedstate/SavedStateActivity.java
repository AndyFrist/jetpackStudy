package com.example.scoreboard.savedstate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.database.DatabaseUtils;
import android.os.Bundle;

import com.example.scoreboard.R;
import com.example.scoreboard.databinding.ActivitySavedStateBinding;

public class SavedStateActivity extends AppCompatActivity {
    ActivitySavedStateBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_saved_state);

        SaveViewModel model = new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this)).get(SaveViewModel.class);
        binding.setSaveVM(model);
        binding.setLifecycleOwner(this);
    }
}
 