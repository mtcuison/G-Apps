package org.guanzongroup.com.creditapp.Obj;

import org.json.JSONObject;

public class MpCreditApp {
    private static final String TAG = MpCreditApp.class.getSimpleName();
    private final JSONObject params = new JSONObject(); //parent
    private final PersonalInfo poClient = new PersonalInfo();
    private final AddressInfo poAddxx = new AddressInfo();
    private final MeansInfo poMeans = new MeansInfo();
    private final OtherInfo poOther = new OtherInfo();
    private final String dTransact = "";
    private String cUnitType = "";
    private String sModelIDx = "";
    private String nDwnpymnt = "";
    private final String sInstlTrm = "";
    private String nAmortztn = "";
    private String nUnitPrce = "";
    private String nDiscount = "";
    private String sMiscExpn = "";
    private String message;

    public MpCreditApp() {
        try {
            params.put("dTransact", dTransact);
            params.put("cUnitType", cUnitType);
            params.put("sModelIDx", sModelIDx);
            params.put("nDwnpymnt", nDwnpymnt);
            params.put("sInstlTrm", sInstlTrm);
            params.put("nAmortztn", nAmortztn);
            params.put("nUnitPrce", nUnitPrce);
            params.put("nDiscount", nDiscount);
            params.put("sMiscExpn", sMiscExpn);
            params.put("address", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUnitType(String fsVal) {
        this.cUnitType = fsVal;
    }

    public void setModel(String fsVal) {
        this.sModelIDx = fsVal;
    }

    public void setDiscount(String fsVal) {
        this.nDiscount = fsVal;
    }

    public void setDownpayment(String fsVal) {
        this.nDwnpymnt = fsVal;
    }

    public void setAmortization(String fsVal) {
        this.nAmortztn = fsVal;
    }

    public void setInstallmentTerm(String fsVal) {
        this.nUnitPrce = fsVal;
    }

    public void setMiscellaneousExpense(String fsVal) {
        this.sMiscExpn = fsVal;
    }

    public PersonalInfo clientInfo() {
        return poClient;
    }

    public AddressInfo addressInfo() {
        return poAddxx;
    }

    public MeansInfo meansInfo() {
        return poMeans;
    }

    public OtherInfo otherInfo() {
        return poOther;
    }

    public boolean isDataValid() {
        if (nDwnpymnt.trim().isEmpty()) {
            message = "Unset downpayment detected.";
            return false;
        } else if (nAmortztn.trim().isEmpty()) {
            message = "Unset amortization detected.";
            return false;
        } else if (nUnitPrce.trim().isEmpty()) {
            message = "Unset unit price detected.";
            return false;
        } else if (sMiscExpn.trim().isEmpty()) {
            message = "Unset miscellaneous expense detected.";
            return false;
        } else if (cUnitType.trim().isEmpty()) {
            message = "Please select unit type.";
            return false;
        } else if (sModelIDx.trim().isEmpty()) {
            message = "Please select model.";
            return false;
        } else if (sInstlTrm.trim().isEmpty()) {
            message = "Please select installment term.";
            return false;
        } else if (!poClient.isDataValid()) {
            message = poClient.getMessage();
            return false;
        } else if (poAddxx.isDataValid()) {
            message = poAddxx.getMessage();
            return false;
        } else if (!meansInfo().isDataValid()) {
            message = meansInfo().getMessage();
            return false;
        } else if (!otherInfo().isDataValid()) {
            message = otherInfo().getMessage();
            return false;
        } else {
            return true;
        }
    }

    public String getData() {
        try {
            params.put("dTransact", dTransact);
            params.put("cUnitType", cUnitType);
            params.put("sModelIDx", sModelIDx);
            params.put("nDwnpymnt", nDwnpymnt);
            params.put("sInstlTrm", sInstlTrm);
            params.put("nAmortztn", nAmortztn);
            params.put("nUnitPrce", nUnitPrce);
            params.put("nDiscount", nDiscount);
            params.put("sMiscExpn", sMiscExpn);
            params.put("personal_info", poClient.getData());
            params.put("address", poAddxx.getData());
            params.put("means_info", meansInfo().getData());
            params.put("other_info", otherInfo().getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params.toString();
    }
}
