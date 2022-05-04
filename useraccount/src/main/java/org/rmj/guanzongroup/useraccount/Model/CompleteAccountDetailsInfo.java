package org.rmj.guanzongroup.useraccount.Model;

import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CompleteAccountDetailsInfo {
    private EClientInfo poClientx;
    private String sLastName = "";
    private String sFirstNme = "";
    private String sMiddName = "-";
    private String sSuffixNm = "";
    private String sBirthDte = "";
    private String sBirthPlc = "";
    private String sGenderxx = "";
    private String sCivilStx = "";
    private String sCitizenx = "";
    private String sTaxIdNox = "";
    private String sHouseNox = "";
    private String sAddressx = "";
    private String sTownCity = "";
    private String sBarangay = "";
    private String sMessagex = "";

    public CompleteAccountDetailsInfo() {
        this.poClientx = new EClientInfo();
    }

    public String getMessage() {
        return sMessagex;
    }

    public String getLastName() {
        return sLastName;
    }

    public void setLastName(String sLastName) {
        this.sLastName = sLastName;
    }

    public String getFirstName() {
        return sFirstNme;
    }

    public void setFirstName(String sFirstNme) {
        this.sFirstNme = sFirstNme;
    }

    public String getMiddName() {
        return sMiddName;
    }

    public void setMiddName(String sMiddName) {
        this.sMiddName = sMiddName;
    }

    public String getSuffixName() {
        return sSuffixNm;
    }

    public void setSuffixName(String sSuffixNm) {
        this.sSuffixNm = sSuffixNm;
    }

    public String getBirthDate() {
        try {
            SimpleDateFormat userFormat = new SimpleDateFormat("MM/dd/yyyy");
            SimpleDateFormat tableFormat = new SimpleDateFormat("yyyy-MM-dd");
            String lsFormatted = tableFormat.format(userFormat.parse(sBirthDte));
            return lsFormatted;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void setBirthDate(String sBirthDte) {
        this.sBirthDte = sBirthDte;
    }

    public String getBirthPlace() {
        return sBirthPlc;
    }

    public void setBirthPlace(String sBirthPlc) {
        this.sBirthPlc = sBirthPlc;
    }

    public String getGender() {
        return sGenderxx;
    }

    public void setGender(String sGenderxx) {
        this.sGenderxx = sGenderxx;
    }

    public String getCivilStat() {
        return sCivilStx;
    }

    public void setCivilStat(String sCivilStx) {
        this.sCivilStx = sCivilStx;
    }

    public String getCitizenship() {
        return sCitizenx;
    }

    public void setCitizenship(String sCitizenx) {
        this.sCitizenx = sCitizenx;
    }

    public String getTaxIdNumber() {
        return sTaxIdNox;
    }

    public void setTaxIdNumber(String sTaxIdNox) {
        this.sTaxIdNox = sTaxIdNox;
    }

    public String getHouseNumber() {
        return sHouseNox;
    }

    public void setHouseNumber(String sHouseNox) {
        this.sHouseNox = sHouseNox;
    }

    public String getAddress() {
        return sAddressx;
    }

    public void setAddress(String sAddressx) {
        this.sAddressx = sAddressx;
    }

    public String getTownCity() {
        return sTownCity;
    }

    public void setTownCity(String sTownCity) {
        this.sTownCity = sTownCity;
    }

    public String getBarangay() {
        return sBarangay;
    }

    public void setBarangay(String sBarangay) {
        this.sBarangay = sBarangay;
    }

    public boolean isDataValid() {
        if(sLastName.isEmpty()) {
            sMessagex = "Please enter Last Name";
            return false;
        } else if(sFirstNme.isEmpty()) {
            sMessagex = "Please enter First Name";
            return false;
        } else if(sBirthDte.isEmpty()) {
            sMessagex = "Please enter Birth Date";
            return false;
        } else if(sBirthPlc.isEmpty()) {
            sMessagex = "Please enter Birth Place";
            return false;
        } else if(sGenderxx.isEmpty()) {
            sMessagex = "Please select a Gender";
            return false;
        } else if(sCivilStx.isEmpty()) {
            sMessagex = "Please select a Civil Status";
            return false;
        } else if(sCitizenx.isEmpty()) {
            sMessagex = "Please enter Citizenship";
            return false;
        } else if(sHouseNox.isEmpty()) {
            sMessagex = "Please enter House Number";
            return false;
        } else if(sAddressx.isEmpty()) {
            sMessagex = "Please enter Street Address";
            return false;
        } else if(sTownCity.isEmpty()) {
            sMessagex = "Please enter Town or City Address";
            return false;
        } else if(sBarangay.isEmpty()) {
            sMessagex = "Please enter Barangay Address";
            return false;
        } else {
            return true;
        }
    }

    public EClientInfo getClientEntityValues() {
        if(isDataValid()) {
            poClientx.setLastName(getLastName());
            poClientx.setFrstName(getFirstName());
            poClientx.setMiddName(getMiddName());
            poClientx.setSuffixNm(getSuffixName());
            poClientx.setBirthDte(getBirthDate());
            poClientx.setBirthPlc(getBirthPlace());
            poClientx.setGenderCd(getGender());
            poClientx.setCvilStat(getCivilStat());
            poClientx.setCitizenx(getCitizenship());
            poClientx.setTaxIDNox(getTaxIdNumber());
            poClientx.setHouseNox(getHouseNumber());
            poClientx.setAddressx(getAddress());
            poClientx.setTownIDxx(getTownCity());
            poClientx.setBrgyIDxx(getBarangay());
            return poClientx;
        } else {
            return null;
        }
    }

}
