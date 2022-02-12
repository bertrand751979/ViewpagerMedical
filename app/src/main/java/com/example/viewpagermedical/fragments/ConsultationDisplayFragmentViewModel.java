package com.example.viewpagermedical.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.viewpagermedical.ApplicationData;
import com.example.viewpagermedical.model.Consultation;

import java.util.ArrayList;

public class ConsultationDisplayFragmentViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Consultation>> myConsultationsList = new MutableLiveData<>();
    public LiveData<ArrayList<Consultation>> consultationsLiveData = myConsultationsList;

    public void toPostMyListConsultations (){
        myConsultationsList.postValue(ApplicationData.getInstance().getMyConsultationList());
    }

    public void toAddConsultation(Consultation consultation){
        ApplicationData.getInstance().addConsultation(consultation);
        toPostMyListConsultations();
    }

    public void toDeleted(Consultation consultation){
        ApplicationData.getInstance().deleteConsultation(consultation);
        toPostMyListConsultations();
    }



}
