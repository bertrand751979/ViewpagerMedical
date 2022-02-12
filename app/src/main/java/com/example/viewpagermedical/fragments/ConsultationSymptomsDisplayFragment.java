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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagermedical.ApplicationData;
import com.example.viewpagermedical.OnButtonSearchClickedAction;
import com.example.viewpagermedical.R;
import com.example.viewpagermedical.adapters.ConsultationAdapter;
import com.example.viewpagermedical.adapters.ConsultationSymptomAdapter;
import com.example.viewpagermedical.model.Consultation;

import java.util.ArrayList;

public class ConsultationSymptomsDisplayFragment extends Fragment {
    private RecyclerView recyclerView;
    private ConsultationSymptomAdapter consultationSymptomAdapter;
    private EditText editResearch;
    private Button buttonSearch;
    private ConsultationSymptomsDisplayFragmentViewModel viewModelSymptom;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationData.getInstance().getDisplaySymptoms();
        viewModelSymptom = new ViewModelProvider(this).get(ConsultationSymptomsDisplayFragmentViewModel.class);
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
                    viewModelSymptom.toPostSearchSymptoms(editResearch.getText().toString());}
        });
        setViewitem();
    }

    public void setViewitem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        consultationSymptomAdapter = new ConsultationSymptomAdapter();
        recyclerView.setAdapter(consultationSymptomAdapter);
        viewModelSymptom.toPostMyListSymptoms();
        recyclerView.setAdapter(consultationSymptomAdapter);
        //ecoute les changements de symptom live data(liste)
        viewModelSymptom.symptomLiveData.observe(getViewLifecycleOwner(), new Observer<ArrayList<Consultation>>() {
            @Override
            public void onChanged(ArrayList<Consultation> consultations) {
                consultationSymptomAdapter.setTheSymptomsList(consultations);

            }
        });
        viewModelSymptom.resultLifeData.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean ==false){
                    Toast.makeText(ConsultationSymptomsDisplayFragment.this.getContext(), "Pas de symptome", Toast.LENGTH_SHORT).show();
                } else if (aBoolean ==true){
                    Toast.makeText(ConsultationSymptomsDisplayFragment.this.getContext(), "Trouvé", Toast.LENGTH_SHORT).show();
                }

            }
        });
        viewModelSymptom.toPostMyListSymptoms();
    }



}
