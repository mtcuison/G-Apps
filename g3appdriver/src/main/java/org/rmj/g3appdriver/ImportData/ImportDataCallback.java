package org.rmj.g3appdriver.ImportData;

public interface ImportDataCallback {
    void OnSuccessImportData();
    void OnFailedImportData(String message);
}
