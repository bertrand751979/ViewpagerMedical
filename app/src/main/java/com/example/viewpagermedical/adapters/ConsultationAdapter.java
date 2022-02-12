package com.example.viewpagermedical.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagermedical.OnImageClickedActionDeleted;
import com.example.viewpagermedical.R;
import com.example.viewpagermedical.model.Consultation;
import com.example.viewpagermedical.viewHolders.ConsultationViewHolder;

import java.util.ArrayList;

public class ConsultationAdapter extends RecyclerView.Adapter<ConsultationViewHolder> {
    private ArrayList<Consultation>listConsultations;
    private OnImageClickedActionDeleted onImageClickedActionDeleted;

    public ConsultationAdapter(OnImageClickedActionDeleted onImageClickedActionDeleted) {
        this.onImageClickedActionDeleted = onImageClickedActionDeleted;
    }

    public void setListConsultations(ArrayList<Consultation> listConsultations) {
        this.listConsultations = listConsultations;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ConsultationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.raw_consultation,parent,false);
        return new ConsultationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConsultationViewHolder holder, int position) {
        holder.bind(listConsultations.get(position),onImageClickedActionDeleted);
    }

    @Override
    public int getItemCount() {
        return listConsultations.size();
    }
}
