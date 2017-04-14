package com.example.admin.housemd;

/**
 * Created by Adm on 14-Apr-17.
 */

public class DataProviderFather {

    public DataProviderFather(String fdis, String fdoc, String fmed) {

        this.setFdis(fdis);
        this.setFdoc(fdoc);
        this.setFmed(fmed);
    }


    String fdis, fdoc, fmed;

    public String getFdis() {
        return fdis;
    }

    public void setFdis(String fdis) {
        this.fdis = fdis;
    }

    public String getFdoc() {
        return fdoc;
    }

    public void setFdoc(String fdoc) {
        this.fdoc = fdoc;
    }

    public String getFmed() {
        return fmed;
    }

    public void setFmed(String fmed) {
        this.fmed = fmed;
    }
}
