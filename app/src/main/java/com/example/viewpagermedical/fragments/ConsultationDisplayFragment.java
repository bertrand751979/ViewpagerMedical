package com.example.viewpagermedical.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagermedical.ApplicationData;
import com.example.viewpagermedical.adapters.ConsultationAdapter;
import com.example.viewpagermedical.OnImageClickedActionDeleted;
import com.example.viewpagermedical.R;
import com.example.viewpagermedical.model.Consultation;

public class ConsultationDisplayFragment extends Fragment {
    private EditText editName;
    private EditText editAge;
    private EditText editSymptom;
    private RecyclerView recyclerView;
    private ConsultationAdapter consultationAdapter;
    private Button btnAdd;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        consultationAdapter.setListConsultations(ApplicationData.getInstance().myConsultationList);
        consultationAdapter.notifyDataSetChanged();
        Toast.makeText(ConsultationDisplayFragment.this.getContext(), "Consultation"+ApplicationData.getInstance().myConsultationList.size(), Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_consultation,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_list_consultation);
        editName = view.findViewById(R.id.edit_name);
        editAge = view.findViewById(R.id.edit_age);
        editSymptom = view.findViewById(R.id.edit_symptom);
        btnAdd = view.findViewById(R.id.btn_add_consultation);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addConsultation();
            }
        });
        setViewItem();
    }

    private void addConsultation(){
        Consultation consultation = new Consultation();
        consultation.setNameSurname(editName.getText().toString());
        consultation.setAge(Integer.parseInt(editAge.getText().toString()));
        consultation.setSymptom(editSymptom.getText().toString());
        ApplicationData.getInstance().myConsultationList.add(consultation);
        consultationAdapter.setListConsultations(ApplicationData.getInstance().myConsultationList);
        consultationAdapter.notifyDataSetChanged();
        ApplicationData.getInstance().setDisplayList(consultation);
        Toast.makeText(ConsultationDisplayFragment.this.getContext(), "Consultation"+ApplicationData.getInstance().myConsultationList.size(), Toast.LENGTH_SHORT).show();
    }

    private void setViewItem(){
        recyclerView.setLayoutManager( new LinearLayoutManager(this.getContext()));
        OnImageClickedActionDeleted onImageClickedActionDeleted = new OnImageClickedActionDeleted() {
            @Override
            public void delete(Consultation consultation) {
                ApplicationData.getInstance().myConsultationList.remove(consultation);
                consultationAdapter.setListConsultations(ApplicationData.getInstance().myConsultationList);
                consultationAdapter.notifyDataSetChanged();
                Toast.makeText(ConsultationDisplayFragment.this.getContext(), "Consultation supprimée", Toast.LENGTH_SHORT).show();
            }
        };
        consultationAdapter = new ConsultationAdapter(ApplicationData.getInstance().myConsultationList,onImageClickedActionDeleted);
        recyclerView.setAdapter(consultationAdapter);
    }

}
