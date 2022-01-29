package com.example.viewpagermedical.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagermedical.R;
import com.example.viewpagermedical.model.Consultation;

public class ConsultationSymptomsViewHolder extends RecyclerView.ViewHolder {
    private TextView vhDiseaseName;
    private TextView vhDiseaseAge;
    private TextView vhDiseaseSymptom;

    public ConsultationSymptomsViewHolder(@NonNull View view) {
        super(view);
        vhDiseaseName = view.findViewById(R.id.raw_diseas_name);
        vhDiseaseAge = view.findViewById(R.id.raw_diseas_age);
        vhDiseaseSymptom = view.findViewById(R.id.raw_diseas_symptom);
    }

    public TextView getVhDiseaseName() {
        return vhDiseaseName;
    }

    public void setVhDiseaseName(TextView vhDiseaseName) {
        this.vhDiseaseName = vhDiseaseName;
    }

    public TextView getVhDiseaseAge() {
        return vhDiseaseAge;
    }

    public void setVhDiseaseAge(TextView vhDiseaseAge) {
        this.vhDiseaseAge = vhDiseaseAge;
    }

    public TextView getVhDiseaseSymptom() {
        return vhDiseaseSymptom;
    }

    public void setVhDiseaseSymptom(TextView vhDiseaseSymptom) {
        this.vhDiseaseSymptom = vhDiseaseSymptom;
    }
    public void bind(Consultation consultation){
        vhDiseaseName.setText(consultation.getNameSurname());
        vhDiseaseAge.setText(String.valueOf(consultation.getAge()));
        vhDiseaseSymptom.setText(consultation.getSymptom());
    }
}
