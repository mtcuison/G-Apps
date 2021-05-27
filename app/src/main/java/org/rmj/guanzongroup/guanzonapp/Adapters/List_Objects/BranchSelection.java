package org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects;

public class BranchSelection {
    private String BranchCde;
    private String BranchNme;
    private String BranchAdd;

    public BranchSelection(String branchCde,
                           String branchNme,
                           String branchAdd){
        this.BranchCde = branchCde;
        this.BranchNme = branchNme;
        this.BranchAdd = branchAdd;
    }

    public String getBranchCde() {
        return BranchCde;
    }

    public String getBranchNme() {
        return BranchNme;
    }

    public String getBranchAdd() {
        return BranchAdd;
    }
}
