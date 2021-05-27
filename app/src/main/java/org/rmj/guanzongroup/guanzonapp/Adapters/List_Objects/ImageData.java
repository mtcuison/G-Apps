package org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects;

public class ImageData {
    private String ImageFileName;
    private String ImageAddressx;

    public ImageData(String imageFileName,
                     String imageAddressx){
        this.ImageFileName = imageFileName;
        this.ImageAddressx = imageAddressx;
    }

    public String getImageFileName() {
        return ImageFileName;
    }

    public String getImageAddressx() {
        return ImageAddressx;
    }
}
