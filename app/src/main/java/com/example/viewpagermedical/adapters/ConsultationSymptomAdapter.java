package com.example.viewpagermedical.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagermedical.R;
import com.example.viewpagermedical.model.Consultation;
import com.example.viewpagermedical.viewHolders.ConsultationSymptomsViewHolder;

import java.util.ArrayList;

public class ConsultationSymptomAdapter extends RecyclerView.Adapter<ConsultationSymptomsViewHolder> {
    private ArrayList<Consultation> theSymptomsList = new ArrayList<>();

    public ConsultationSymptomAdapter() {

    }

    public void setTheSymptomsList(ArrayList<Consultation> theSymptomsList) {
        this.theSymptomsList = theSymptomsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ConsultationSymptomsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_symptoms,parent,false);
        return new ConsultationSymptomsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConsultationSymptomsViewHolder holder, int position) {
        holder.bind(theSymptomsList.get(position));
    }

    @Override
    public int getItemCount() {
        return theSymptomsList.size();
    }
}
