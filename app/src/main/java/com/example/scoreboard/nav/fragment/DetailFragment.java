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

import com.example.scoreboard.R;
import com.example.scoreboard.databinding.FragmentDetailBinding;
import com.example.scoreboard.databinding.FragmentMasterBinding;
import com.example.scoreboard.nav.ComputerActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    private static final String TAG = "DetailFragment";

    public DetailFragment() {
        // Required empty public constructor
    }

    ComputerActivity activity ;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        activity = (ComputerActivity) getActivity();
        final MyViewModel myViewModel = activity.myViewModel;
        FragmentDetailBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        Log.d(TAG, "onCreateView: "+myViewModel.hashCode());

        binding.setDetailVM(myViewModel);
        binding.setLifecycleOwner(getActivity());
        binding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);
                controller.navigate(R.id.action_detailFragment_to_masterFragment);
            }
        });
        return binding.getRoot();
    }
}
