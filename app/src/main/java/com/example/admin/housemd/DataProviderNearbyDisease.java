package com.example.admin.housemd;

/**
 * Created by Adm on 16-Apr-17.
 */

public class DataProviderNearbyDisease {
    public DataProviderNearbyDisease(String symptoms) {
        this.setSymptoms(symptoms);
    }

    String symptoms;

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

}
