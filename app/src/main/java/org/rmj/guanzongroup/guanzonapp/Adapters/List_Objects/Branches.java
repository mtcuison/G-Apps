package org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects;

public class Branches {
    private String BranchName;
    private String BranchAdds;
    private String BranchDesc;
    private String BranchCode;
    private String BranchCntc;
    private String BranchMobl;
    private String BranchMail;

    public Branches(String Name,
                    String Adds,
                    String Desc,
                    String Code,
                    String Cntc,
                    String Mobl,
                    String Mail){
        this.BranchName = Name;
        this.BranchAdds = Adds;
        this.BranchDesc = Desc;
        this.BranchCode = Code;
        this.BranchCntc = Cntc;
        this.BranchMobl = Mobl;
        this.BranchMail = Mail;
    }

    public String getBranchName() {
        return BranchName;
    }

    public String getBranchAdds() {
        return BranchAdds;
    }

    public String getBarnchDesc() {
        return BranchDesc;
    }

    public String getBranchCode() {
        return BranchCode;
    }

    public String getBranchCntc() {
        return BranchCntc;
    }

    public String getBranchMobl() {
        return BranchMobl;
    }

    public String getBranchMail() {
        return BranchMail;
    }
}
