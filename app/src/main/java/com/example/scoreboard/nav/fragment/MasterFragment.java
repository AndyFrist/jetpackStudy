package com.example.scoreboard.nav.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.scoreboard.R;
import com.example.scoreboard.databinding.FragmentMasterBinding;
import com.example.scoreboard.nav.ComputerActivity;


public class MasterFragment extends Fragment {

    ComputerActivity activity ;

    private static final String TAG = "MasterFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        activity = (ComputerActivity) getActivity();
        final MyViewModel myViewModel = activity.myViewModel;
        FragmentMasterBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_master, container, false);


        Log.d(TAG, "onCreateView: "+ binding.hashCode());
        binding.setMasterVm(myViewModel);
        binding.setLifecycleOwner(getActivity());

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);
                controller.navigate(R.id.action_masterFragment_to_detailFragment);
            }
        });
        binding.seekBar.setProgress(myViewModel.getNumber().getValue());
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                myViewModel.getNumber().setValue(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        return binding.getRoot();
    }
}
