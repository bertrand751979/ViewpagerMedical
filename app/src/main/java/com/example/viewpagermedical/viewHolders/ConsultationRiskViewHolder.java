package com.example.viewpagermedical.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagermedical.R;
import com.example.viewpagermedical.model.Consultation;

public class ConsultationRiskViewHolder extends RecyclerView.ViewHolder {
    private TextView vhRiskName;
    private TextView vhRiskAge;
    private TextView vhRiskSymptom;


    public ConsultationRiskViewHolder(@NonNull View view) {
        super(view);
        vhRiskName = view.findViewById(R.id.raw_risk_name);
        vhRiskAge = view.findViewById(R.id.raw_risk_age);
        vhRiskSymptom = view.findViewById(R.id.raw_risk_symptom);
    }

    public TextView getVhRiskName() {
        return vhRiskName;
    }

    public void setVhRiskName(TextView vhRiskName) {
        this.vhRiskName = vhRiskName;
    }

    public TextView getVhRiskAge() {
        return vhRiskAge;
    }

    public void setVhRiskAge(TextView vhRiskAge) {
        this.vhRiskAge = vhRiskAge;
    }

    public TextView getVhRiskSymptom() {
        return vhRiskSymptom;
    }

    public void setVhRiskSymptom(TextView vhRiskSymptom) {
        this.vhRiskSymptom = vhRiskSymptom;
    }

    public void bind(Consultation consultation){
        vhRiskName.setText(consultation.getNameSurname());
        vhRiskAge.setText(String.valueOf(consultation.getAge()));
        vhRiskSymptom.setText(consultation.getSymptom());
    }
}
