package com.example.admin.housemd;

/**
 * Created by Adm on 14-Apr-17.
 */

public class DataProviderMother {

    public DataProviderMother(String mdis, String mdoc, String mmed) {

        this.setMdis(mdis);
        this.setMdoc(mdoc);
        this.setMmed(mmed);
    }


    String mdis, mdoc, mmed;

    public String getMdis() {
        return mdis;
    }

    public void setMdis(String mdis) {
        this.mdis = mdis;
    }

    public String getMdoc() {
        return mdoc;
    }

    public void setMdoc(String mdoc) {
        this.mdoc = mdoc;
    }

    public String getMmed() {
        return mmed;
    }

    public void setMmed(String mmed) {
        this.mmed = mmed;
    }
}
