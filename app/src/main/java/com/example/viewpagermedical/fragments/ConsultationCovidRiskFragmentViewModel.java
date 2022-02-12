package com.example.viewpagermedical.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.viewpagermedical.ApplicationData;
import com.example.viewpagermedical.model.Consultation;

import java.util.ArrayList;

public class ConsultationCovidRiskFragmentViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Consultation>> myRiskList = new MutableLiveData<>();
    public LiveData<ArrayList<Consultation>> riskLiveData = myRiskList;


    public void toPostMyRiskList (){
        myRiskList.postValue(ApplicationData.getInstance().getMyRiskList());
    }



}
