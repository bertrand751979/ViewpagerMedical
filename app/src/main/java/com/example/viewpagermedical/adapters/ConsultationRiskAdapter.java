package com.example.viewpagermedical.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagermedical.R;
import com.example.viewpagermedical.model.Consultation;
import com.example.viewpagermedical.viewHolders.ConsultationRiskViewHolder;

import java.util.ArrayList;

public class ConsultationRiskAdapter extends RecyclerView.Adapter<ConsultationRiskViewHolder> {
    private ArrayList<Consultation>listRiskConsultations;

    public ConsultationRiskAdapter(ArrayList<Consultation> listRiskConsultations) {
        this.listRiskConsultations = listRiskConsultations;
    }

    public void setListRiskConsultations(ArrayList<Consultation> listRiskConsultations) {
        this.listRiskConsultations = listRiskConsultations;
    }

    @NonNull
    @Override
    public ConsultationRiskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_risk_consultation,parent,false);
        return new ConsultationRiskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConsultationRiskViewHolder holder, int position) {
        holder.bind(listRiskConsultations.get(position));
    }

    @Override
    public int getItemCount() {
        return listRiskConsultations.size();
    }
}
