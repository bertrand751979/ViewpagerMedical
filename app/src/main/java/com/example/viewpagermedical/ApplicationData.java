package com.example.viewpagermedical;

import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.viewpagermedical.fragments.ConsultationSymptomsDisplayFragment;
import com.example.viewpagermedical.model.Consultation;

import java.util.ArrayList;

public class ApplicationData {
    public Consultation hightRisk;
    public Consultation displaySymptoms;
    public ArrayList<Consultation> myRiskList = new ArrayList<>();
    public ArrayList<Consultation> myConsultationList = new ArrayList<>();
    public  ArrayList<Consultation> myListSymptoms = new ArrayList<>();
    public ArrayList<Consultation> mySearchList = new ArrayList<>();

    private ApplicationData() {
    }

    private static ApplicationData INSTANCE = null;

    public static ApplicationData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApplicationData();
        }
        return INSTANCE;
    }

    public ArrayList<Consultation> getMyConsultationList() {
        return myConsultationList;
    }

    public void setMyConsultationList(ArrayList<Consultation> myConsultationList) {
        this.myConsultationList = myConsultationList;
    }

    public ArrayList<Consultation> getMySearchList() {
        return mySearchList;
    }

    public void setMySearchList(ArrayList<Consultation> mySearchList) {
        this.mySearchList = mySearchList;
    }

    public Consultation getHightRisk() {
        return hightRisk;
    }

    public void setHightRisk(Consultation hightRisk) {
        this.hightRisk = hightRisk;
    }

    public Consultation getDisplaySymptoms() {
        return displaySymptoms;
    }

    public void setDisplaySymptoms(Consultation displaySymptoms) {
        this.displaySymptoms = displaySymptoms;
    }

    public ArrayList<Consultation> getMyListSymptoms() {
        return myListSymptoms;
    }

    public void setMyListSymptoms(ArrayList<Consultation> myListSymptoms) {
        this.myListSymptoms = myListSymptoms;
    }

    public ArrayList<Consultation> getMyRiskList() {
        return myRiskList;
    }

    public void setMyRiskList(ArrayList<Consultation> myRiskList) {
        this.myRiskList = myRiskList;
    }

    public void riskCovid(){
        myRiskList.clear();
        for(Consultation consultationRisk : ApplicationData.getInstance().myConsultationList){
                if((consultationRisk.getAge()>50)&&(consultationRisk.getSymptom().toLowerCase().contains("fievre"))){
                     if((consultationRisk.getSymptom().toLowerCase().contains("toux"))) {
                         if ((consultationRisk.getSymptom().toLowerCase().contains("respiration"))) {
                             ApplicationData.getInstance().myRiskList.add(consultationRisk);
                             ApplicationData.getInstance().setHightRisk(consultationRisk);
                         }
                     }
                 }
        }
    }


    public boolean searchSymptoms(String researchSymptoms) {
        boolean searchResult =false;
        mySearchList.clear();
        for(Consultation consultationSearch: ApplicationData.getInstance().myConsultationList){
            if(consultationSearch.getSymptom().toLowerCase().contains(researchSymptoms)){
                searchResult = true;
                mySearchList.add(consultationSearch);

            }
        }
        return searchResult;
    }

    public void addConsultation(Consultation consultation){
        myConsultationList.add(consultation);
    }
    public void deleteConsultation(Consultation consultation){
        myConsultationList.remove(consultation);
    }



}


