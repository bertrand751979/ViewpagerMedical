package com.example.viewpagermedical.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagermedical.ApplicationData;
import com.example.viewpagermedical.R;
import com.example.viewpagermedical.adapters.ConsultationRiskAdapter;

public class ConsultationCovidRiskFragment extends Fragment {
    private RecyclerView recyclerView;
    private ConsultationRiskAdapter consultationRiskAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationData.getInstance().getHightRisk();

    }


    @Override
    public void onResume() {
        super.onResume();
        ApplicationData.getInstance().riskCovid();
        consultationRiskAdapter.setListRiskConsultations(ApplicationData.getInstance().myRiskList);
        consultationRiskAdapter.notifyDataSetChanged();
        Toast.makeText(ConsultationCovidRiskFragment.this.getContext(), "Risk list: "+ApplicationData.getInstance().myRiskList.size(), Toast.LENGTH_SHORT).show();
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
        consultationRiskAdapter = new ConsultationRiskAdapter(ApplicationData.getInstance().myRiskList);
        recyclerView.setAdapter(consultationRiskAdapter);
        Toast.makeText(ConsultationCovidRiskFragment.this.getContext(), "Risk list: "+ApplicationData.getInstance().myRiskList.size(), Toast.LENGTH_SHORT).show();
    }




}
