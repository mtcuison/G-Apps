package org.guanzongroup.com.creditapp.Obj;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class MeansInfo {
    private static final String TAG = MeansInfo.class.getSimpleName();

    private JSONObject params = new JSONObject();

    private Employed employed = new Employed();
    private SelfEmployed selfEmployed = new SelfEmployed();
    private Pensioner pensioner = new Pensioner();
    private Finance finance = new Finance();
    private OtherIncome otherIncome = new OtherIncome();

    private String message;

    public MeansInfo() {

    }

    public String getMessage() {
        return message;
    }

    public Employed employment() {
        return employed;
    }

    public SelfEmployed business() {
        return selfEmployed;
    }

    public Pensioner pension() {
        return pensioner;
    }

    public Finance finance() {
        return finance;
    }

    public OtherIncome otherincome() {
        return otherIncome;
    }

    public String getSourceCD() throws JSONException {
        if (params.has("cSourceCD")) {
            return params.getString("cSourceCD");
        }
        return "";
    }

    public void setSourceCD(String cSourceCD) throws JSONException {
        params.put("cSourceCD", cSourceCD);
    }

    public boolean isDataValid() throws JSONException {
        if (!employed.isDataValid()) {
            message = employed.getMessage();
            return false;
        } else if (!selfEmployed.isDataValid()) {
            message = selfEmployed.getMessage();
            return false;
        } else if (!pension().isDataValid()) {
            message = pensioner.getMessage();
            return false;
        } else if (!finance.isDataValid()) {
            message = finance.getMessage();
            return false;
        } else if (!otherIncome.isDataValid()) {
            message = otherIncome.getMessage();
            return false;
        } else {
            return true;
        }
    }

    public void setData(String fsVal) throws JSONException {
        JSONObject loJson = new JSONObject(fsVal);
        params = loJson.getJSONObject("means_info");
        employed.setData(params.toString());
        selfEmployed.setData(params.toString());
        pensioner.setData(params.toString());
        finance.setData(params.toString());
        otherIncome.setData(params.toString());
    }

    public JSONObject getData() throws JSONException {
        params.put("employed", employed.getData());
        params.put("self_employed", selfEmployed.getData());
        params.put("pensioner", pensioner.getData());
        params.put("financed", finance.getData());
        params.put("other_income", otherIncome.getData());
        Log.d(TAG, params.toString());
        return params;
    }

    public static class Employed {
        private JSONObject params = new JSONObject();

        private String message;

        public Employed() {

        }

        public String getMessage() {
            return message;
        }

        public void setBusinessIndustry(String fsVal) throws JSONException {
            params.put("sIndstWrk", fsVal);
        }

        public void setPosition(String fsVal) throws JSONException {
            params.put("sPosition", fsVal);
        }

        public void setSalary(String fsVal) throws JSONException {
            params.put("nSalaryxx", fsVal);
        }

        public String getBusinessIndustry(String fsVal) throws JSONException {
            if (params.has("sIndstWrk")) {
                return params.getString("sIndstWrk");
            }
            return "";
        }

        public String getPosition(String fsVal) throws JSONException {
            if (params.has("sPosition")) {
                return params.getString("sPosition");
            }
            return "";
        }

        public String getSalary(String fsVal) throws JSONException {
            if (params.has("nSalaryxx")) {
                return params.getString("nSalaryxx");
            }
            return "";
        }

        public boolean isDataValid() throws JSONException {
            if (params.getString("sIndstWrk").trim().isEmpty()) {
                message = "Please enter work industry.";
                return false;
            } else if (params.getString("sPosition").trim().isEmpty()) {
                message = "Please enter job title.";
                return false;
            } else if (params.getString("nSalaryxx").trim().isEmpty()) {
                message = "Please enter estimated salary.";
                return false;
            } else {
                return true;
            }
        }

        public JSONObject getData() {
            Log.d(TAG, params.toString());
            return params;
        }

        public void setData(String fsVal) throws JSONException {
            JSONObject loJson = new JSONObject(fsVal);
            params = loJson.getJSONObject("employed");
        }
    }

    public static class SelfEmployed {
        private JSONObject params = new JSONObject();

        private String message;

        public SelfEmployed() {

        }

        public String getMessage() {
            return message;
        }

        public void setBusinessIndustry(String fsVal) throws JSONException {
            params.put("sIndstBus", fsVal);
        }

        public void setEstIncome(String fsVal) throws JSONException {
            params.put("nBusIncom", fsVal);
        }

        public String getBusinessIndustry(String fsVal) throws JSONException {
            if (params.has("sIndstBus")) {
                return params.getString("sIndstBus");
            }
            return "";
        }

        public String getEstIncome(String fsVal) throws JSONException {
            if (params.has("nBusIncom")) {
                return params.getString("nBusIncom");
            }
            return "";
        }

        public boolean isDataValid() throws JSONException {
            if (params.getString("sIndstBus").trim().isEmpty()) {
                message = "Please enter work industry.";
                return false;
            } else if (params.getString("nBusIncom").trim().isEmpty()) {
                message = "Please enter estimated monthly income.";
                return false;
            } else {
                return true;
            }
        }

        public JSONObject getData() {
            Log.d(TAG, params.toString());
            return params;
        }

        public void setData(String fsVal) throws JSONException {
            JSONObject loJson = new JSONObject(fsVal);
            params = loJson.getJSONObject("self_employed");
        }
    }

    public static class Pensioner {
        private JSONObject params = new JSONObject();

        private String message;

        public Pensioner() {

        }

        public String getMessage() {
            return message;
        }

        public void setPensionType(String fsVal) throws JSONException {
            params.put("cPenTypex", fsVal);
        }

        public void setPensionAmount(String fsVal) throws JSONException {
            params.put("nPensionx", fsVal);
        }

        public String getPensionType(String fsVal) throws JSONException {
            if (params.has("cPenTypex")) {
                return params.getString("cPenTypex");
            }
            return "";
        }

        public String getPensionAmount(String fsVal) throws JSONException {
            if (params.has("nPensionx")) {
                return params.getString("nPensionx");
            }
            return "";
        }

        public boolean isDataValid() throws JSONException {
            if (params.getString("cPenTypex").trim().isEmpty()) {
                message = "Please enter type of pension.";
                return false;
            } else if (params.getString("nPensionx").trim().isEmpty()) {
                message = "Please enter estimated pension amount.";
                return false;
            } else {
                return true;
            }
        }

        public JSONObject getData() {
            Log.d(TAG, params.toString());
            return params;
        }

        public void setData(String fsVal) throws JSONException {
            JSONObject loJson = new JSONObject(fsVal);
            params = loJson.getJSONObject("pensioner");
        }
    }

    public static class Finance {
        private JSONObject params = new JSONObject();

        private String message;

        public Finance() {

        }

        public String getMessage() {
            return message;
        }

        public void setFinancierRelation(String fsVal) throws JSONException {
            params.put("sReltnCde", fsVal);
        }

        public void setAmount(String fsVal) throws JSONException {
            params.put("nEstIncme", fsVal);
        }

        public String getFinancierRelation(String fsVal) throws JSONException {
            if (params.has("sReltnCde")) {
                return params.getString("sReltnCde");
            }
            return "";
        }

        public String getAmount(String fsVal) throws JSONException {
            if (params.has("nEstIncme")) {
                return params.getString("nEstIncme");
            }
            return "";
        }

        public boolean isDataValid() throws JSONException {
            if (params.getString("sReltnCde").trim().isEmpty()) {
                message = "Please enter relationship with the financier.";
                return false;
            } else if (params.getString("nEstIncme").trim().isEmpty()) {
                message = "Please enter estimated amount.";
                return false;
            } else {
                return true;
            }
        }

        public JSONObject getData() {
            Log.d(TAG, params.toString());
            return params;
        }

        public void setData(String fsVal) throws JSONException {
            JSONObject loJson = new JSONObject(fsVal);
            params = loJson.getJSONObject("financed");
        }
    }

    public static class OtherIncome {
        private JSONObject params = new JSONObject();

        private String message;

        public OtherIncome() {

        }

        public String getMessage() {
            return message;
        }

        public void setOtherIncome(String fsVal) throws JSONException {
            params.put("sOthrIncm", fsVal);
        }

        public void setEstIncome(String fsVal) throws JSONException {
            params.put("nOthrIncm", fsVal);
        }

        public String getOtherIncome(String fsVal) throws JSONException {
            if (params.has("sOthrIncm")) {
                return params.getString("sOthrIncm");
            }
            return "";
        }

        public String getEstIncome(String fsVal) throws JSONException {
            if (params.has("nOthrIncm")) {
                return params.getString("nOthrIncm");
            }
            return "";
        }


        public boolean isDataValid() throws JSONException {
            if (params.getString("sOthrIncm").trim().isEmpty()) {
                message = "Please enter other income";
                return false;
            } else if (params.getString("nOthrIncm").trim().isEmpty()) {
                message = "Please enter estimated income.";
                return false;
            } else {
                return true;
            }
        }

        public JSONObject getData() {
            Log.d(TAG, params.toString());
            return params;
        }

        public void setData(String fsVal) throws JSONException {
            JSONObject loJson = new JSONObject(fsVal);
            params = loJson.getJSONObject("other_income");
        }
    }
}
