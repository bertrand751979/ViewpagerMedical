package com.example.viewpagermedical.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.viewpagermedical.R;
import com.example.viewpagermedical.adapters.MainAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainFragment extends Fragment {
    private MainAdapter mainAdapter;
    private ViewPager2 viewPager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_design,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainAdapter = new MainAdapter(this);
        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(mainAdapter);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("CONSULTATIONS");
                } else if (position == 1) {
                    tab.setText(" RISQUES");
                } else if (position == 2) {
                    tab.setText("SYMPTOMES");
                }

            }
        }).attach();
    }

}
