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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.viewpagermedical.ApplicationData;
import com.example.viewpagermedical.adapters.ConsultationAdapter;
import com.example.viewpagermedical.OnImageClickedActionDeleted;
import com.example.viewpagermedical.R;
import com.example.viewpagermedical.model.Consultation;
import java.util.ArrayList;

public class ConsultationDisplayFragment extends Fragment {
    private EditText editName;
    private EditText editAge;
    private EditText editSymptom;
    private RecyclerView recyclerView;
    private ConsultationAdapter consultationAdapter;
    private Button btnAdd;
    private ConsultationDisplayFragmentViewModel viewModelDisplay;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModelDisplay = new ViewModelProvider(this).get(ConsultationDisplayFragmentViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        consultationAdapter.setListConsultations(ApplicationData.getInstance().myConsultationList);
        //consultationAdapter.notifyDataSetChanged();
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
                viewModelDisplay.toAddConsultation(new Consultation(editName.getText().toString(),Integer.parseInt(editAge.getText().toString()),editSymptom.getText().toString()));
                Toast.makeText(ConsultationDisplayFragment.this.getContext(), "Consultation"+ApplicationData.getInstance().myConsultationList.size(), Toast.LENGTH_SHORT).show();
            }
        });
        setViewItem();
    }

    private void setViewItem(){
        recyclerView.setLayoutManager( new LinearLayoutManager(this.getContext()));
        OnImageClickedActionDeleted onImageClickedActionDeleted = new OnImageClickedActionDeleted() {
            @Override
            public void delete(Consultation consultation) {
                viewModelDisplay.toDeleted(consultation);
                Toast.makeText(ConsultationDisplayFragment.this.getContext(), "Consultation supprimée", Toast.LENGTH_SHORT).show();
            }
        };
        viewModelDisplay.toPostMyListConsultations();
        consultationAdapter = new ConsultationAdapter(onImageClickedActionDeleted);
        recyclerView.setAdapter(consultationAdapter);
        viewModelDisplay.consultationsLiveData.observe(getViewLifecycleOwner(), new Observer<ArrayList<Consultation>>() {
            @Override
            public void onChanged(ArrayList<Consultation> consultations) {
                consultationAdapter.setListConsultations(consultations);
            }
        });
        viewModelDisplay.toPostMyListConsultations();
    }

}
