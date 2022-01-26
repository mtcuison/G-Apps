package org.rmj.guanzongroup.appcore.Account.Obj;

import java.util.List;

public class AccountDetail {

    private String sFullName;
    private String sGenderxx;
    private String sBirthDte;
    private String sBirthPlc;
    private String sCitizenx;
    private String sTaxIdxxx;
    private String sEmailAdd;
    private String sMobileNo;
    private String sPassword;
    private List<AddressInfo> aAddressx;

    public class AddressInfo{
        private String sHouseNox;
        private String sLotNoxxx;
        private String sBrgyName;
        private String sTownName;
        private String sProvName;

        public AddressInfo(String HouseNo, String LotNo, String Barangay, String Town, String Province) {
            this.sHouseNox = HouseNo;
            this.sLotNoxxx = LotNo;
            this.sBrgyName = Barangay;
            this.sTownName = Town;
            this.sProvName = Province;
        }

        public String getHouseNumber() {
            return sHouseNox;
        }

        public String getLotNumber() {
            return sLotNoxxx;
        }

        public String getBarangayName() {
            return sBrgyName;
        }

        public String getTownName() {
            return sTownName;
        }

        public String getProvinceName() {
            return sProvName;
        }
    }

    public AccountDetail() {
    }

    public String getFullName() {
        return sFullName;
    }

    public String getGender() {
        return sGenderxx;
    }

    public String getBirthDate() {
        return sBirthDte;
    }

    public String getBirthPlace() {
        return sBirthPlc;
    }

    public String getCitizenship() {
        return sCitizenx;
    }

    public String getsTaxIdxxx() {
        return sTaxIdxxx;
    }

    public String getEmail() {
        return sEmailAdd;
    }

    public String getMobileNo() {
        return sMobileNo;
    }

    public String getPassword() {
        return sPassword;
    }

    public List<AddressInfo> getAddresses() {
        return aAddressx;
    }
}
