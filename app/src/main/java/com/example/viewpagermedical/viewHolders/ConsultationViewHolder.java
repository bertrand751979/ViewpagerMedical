package com.example.viewpagermedical.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagermedical.OnImageClickedActionDeleted;
import com.example.viewpagermedical.R;
import com.example.viewpagermedical.model.Consultation;

public class ConsultationViewHolder extends RecyclerView.ViewHolder {
    private TextView vhName;
    private TextView vhAge;
    private TextView vhSymptom;
    private ImageView vhDelete;

    public ConsultationViewHolder(@NonNull View view) {
        super(view);
        vhName = view.findViewById(R.id.raw_name);
        vhAge = view.findViewById(R.id.raw_age);
        vhSymptom = view.findViewById(R.id.raw_symptom);
        vhDelete = view.findViewById(R.id.raw_img_cancel);
    }

    public TextView getVhName() {
        return vhName;
    }

    public void setVhName(TextView vhName) {
        this.vhName = vhName;
    }

    public TextView getVhAge() {
        return vhAge;
    }

    public void setVhAge(TextView vhAge) {
        this.vhAge = vhAge;
    }

    public TextView getVhSymptom() {
        return vhSymptom;
    }

    public void setVhSymptom(TextView vhSymptom) {
        this.vhSymptom = vhSymptom;
    }

    public ImageView getVhDelete() {
        return vhDelete;
    }

    public void setVhDelete(ImageView vhDelete) {
        this.vhDelete = vhDelete;
    }

    public void bind(Consultation consultation, OnImageClickedActionDeleted onImageClickedActionDeleted){
        vhName.setText(consultation.getNameSurname());
        vhAge.setText(String.valueOf(consultation.getAge()));
        vhSymptom.setText(consultation.getSymptom());
        vhDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onImageClickedActionDeleted.delete(consultation);
            }
        });
    }
}
