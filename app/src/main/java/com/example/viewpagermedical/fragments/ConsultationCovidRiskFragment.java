package com.example.viewpagermedical.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagermedical.ApplicationData;
import com.example.viewpagermedical.R;
import com.example.viewpagermedical.adapters.ConsultationAdapter;
import com.example.viewpagermedical.adapters.ConsultationRiskAdapter;
import com.example.viewpagermedical.model.Consultation;

import java.util.ArrayList;

public class ConsultationCovidRiskFragment extends Fragment {
    private RecyclerView recyclerView;
    private ConsultationRiskAdapter consultationRiskAdapter;
    private ConsultationCovidRiskFragmentViewModel viewModelRisk;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationData.getInstance().getHightRisk();
        viewModelRisk = new ViewModelProvider(this).get(ConsultationCovidRiskFragmentViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        ApplicationData.getInstance().riskCovid();
        viewModelRisk.toPostMyRiskList();
        consultationRiskAdapter.setListRiskConsultations(ApplicationData.getInstance().myRiskList);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_risk_covid,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_list_risk_covid);
        setViewItem();
    }

    public void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        viewModelRisk.toPostMyRiskList();
        consultationRiskAdapter = new ConsultationRiskAdapter();
        recyclerView.setAdapter(consultationRiskAdapter);
        viewModelRisk.riskLiveData.observe(getViewLifecycleOwner(), new Observer<ArrayList<Consultation>>() {
            @Override
            public void onChanged(ArrayList<Consultation> consultations) {
                consultationRiskAdapter.setListRiskConsultations(consultations);
            }
        });
        viewModelRisk.toPostMyRiskList();
        Toast.makeText(ConsultationCovidRiskFragment.this.getContext(), "Risk list: "+ApplicationData.getInstance().myRiskList.size(), Toast.LENGTH_SHORT).show();

    }




}
