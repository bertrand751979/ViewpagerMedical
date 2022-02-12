package com.example.viewpagermedical.fragments;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.viewpagermedical.ApplicationData;
import com.example.viewpagermedical.model.Consultation;
import java.util.ArrayList;

public class ConsultationSymptomsDisplayFragmentViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Consultation>> mySymptomsList = new MutableLiveData<>();
    public LiveData<ArrayList<Consultation>> symptomLiveData = mySymptomsList;

    private MutableLiveData<Boolean> result = new MutableLiveData<>();
    public LiveData<Boolean> resultLifeData = result;


    public void toPostMyListSymptoms (){
        mySymptomsList.postValue(ApplicationData.getInstance().getMyListSymptoms());
    }


    public void toPostSearchSymptoms(String symptomResearch){
        if(ApplicationData.getInstance().searchSymptoms(symptomResearch)==true){
            mySymptomsList.postValue(ApplicationData.getInstance().getMySearchList());
            result.postValue(true);

        }else{
            result.postValue(false);
        }
    }

}
