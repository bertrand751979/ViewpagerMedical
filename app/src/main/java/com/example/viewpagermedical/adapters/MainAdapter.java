package com.example.viewpagermedical.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.viewpagermedical.fragments.ConsultationCovidRiskFragment;
import com.example.viewpagermedical.fragments.ConsultationDisplayFragment;
import com.example.viewpagermedical.fragments.ConsultationSymptomsDisplayFragment;

public class MainAdapter extends FragmentStateAdapter {
    public MainAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0){
            Fragment fragment = new ConsultationDisplayFragment();
            return fragment;
        }else if(position==1){
            Fragment fragment = new ConsultationCovidRiskFragment();
            return fragment;
        }else {
            Fragment fragment = new ConsultationSymptomsDisplayFragment();
            return fragment;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
