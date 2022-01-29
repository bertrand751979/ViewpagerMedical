package com.example.viewpagermedical.fragments;

import android.os.Bundle;
import android.util.Log;
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
import com.example.viewpagermedical.R;
import com.example.viewpagermedical.adapters.ConsultationSymptomAdapter;
import com.example.viewpagermedical.model.Consultation;

import java.util.ArrayList;

public class ConsultationSymptomsDisplayFragment extends Fragment {
    private RecyclerView recyclerView;
    private ConsultationSymptomAdapter consultationSymptomAdapter;
    private EditText editResearch;
    private Button buttonSearch;
    //private ArrayList<Consultation> mySearchList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationData.getInstance().getDisplaySymptoms();

    }

    @Override
    public void onResume() {
        super.onResume();
        //consultationSymptomAdapter.setTheSymptomsList(mySearchList);
        consultationSymptomAdapter.setTheSymptomsList(ApplicationData.getInstance().mySearchList);
        consultationSymptomAdapter.notifyDataSetChanged();


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_symptoms,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_list_symptoms);
        editResearch = view.findViewById(R.id.edit_search_symptoms);
        buttonSearch = view.findViewById(R.id.btn_search);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ApplicationData.getInstance().searchSymptoms(editResearch.getText().toString())==true){
                    consultationSymptomAdapter.setTheSymptomsList(ApplicationData.getInstance().mySearchList);
                    consultationSymptomAdapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(ConsultationSymptomsDisplayFragment.this.getContext(), "Echec recherche", Toast.LENGTH_SHORT).show();
                }
            }
        });
        setViewitem();
    }

    public void setViewitem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        consultationSymptomAdapter = new ConsultationSymptomAdapter(ApplicationData.getInstance().myListSymptoms);
        recyclerView.setAdapter(consultationSymptomAdapter);
    }

}
