package com.example.admin.housemd;

/**
 * Created by Adm on 14-Apr-17.
 */

public class DataProviderMedicalHistory {
    public DataProviderMedicalHistory(String disease, String doctor, String medication) {
        this.setDisease(disease);
        this.setDoctor(doctor);
        this.setMedication(medication);
    }

    String disease,doctor,medication;

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }
}
