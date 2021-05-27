package org.rmj.guanzongroup.guanzonapp.etc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.ImageData;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.Promotions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ImageDownloader {
    private static final String TAG = ImageDownloader.class.getSimpleName();
    private static final String MainFolder = "/GuanzonApps/";

    private Context mContext;
    private String DirFolder;

    public ImageDownloader(Context context, String DirectoryFolder){
        this.mContext = context;
        this.DirFolder = DirectoryFolder;
    }

    public void downloadEventImage(List<ImageData> EventDetail) {
        new EventBackgroundTask(mContext, EventDetail).execute();
    }

    public void downloadPromoImage(List<Promotions> PromoDetail){
        new PromoBackgroundTask(mContext, PromoDetail).execute();
    }

    class EventBackgroundTask extends AsyncTask<Integer, Integer, String>{

        List<ImageData> EventThumbnails;
        Context context;
        OutputStream loOutStream;

        EventBackgroundTask(Context context, List<ImageData> eventThumbnails){
            this.context = context;
            this.EventThumbnails = eventThumbnails;
        }

        @Override
        protected String doInBackground(Integer... integers) {
            File loFilePath = Environment.getExternalStorageDirectory() ;
            File loFolder = new File(loFilePath.getAbsolutePath() + "/Android/data/"+ MainFolder);
            File loSubFolder = new File(loFolder.getAbsolutePath() + "/" + DirFolder + "/");
            if(!loFolder.exists()){
                if(loFolder.mkdir()) {
                    Log.e(TAG, "File folder created.");
                } else {
                    Log.e(TAG, "Failed to create file folder.");
                }
            }
            for(int x = 0; x < EventThumbnails.size(); x++){
                try{
                    InputStream loStream = new URL(EventThumbnails.get(x).getImageAddressx()).openStream();
                    Bitmap loBitmap = BitmapFactory.decodeStream(loStream);
                    loSubFolder.mkdir();
                    File loFile = new File(loSubFolder, EventThumbnails.get(x).getImageFileName() + ".png");
                    if(!loFile.exists()) {
                        loOutStream = new FileOutputStream(loFile);
                        loBitmap.compress(Bitmap.CompressFormat.PNG, 50, loOutStream);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            this.cancel(true);
            super.onPostExecute(s);
        }
    }


    class PromoBackgroundTask extends AsyncTask<Integer, Integer, String>{

        List<Promotions> PromoThumbnails;
        Context context;
        OutputStream loOutStream;

        PromoBackgroundTask(Context context, List<Promotions> promoThumbnails){
            this.context = context;
            this.PromoThumbnails = promoThumbnails;
        }

        @Override
        protected String doInBackground(Integer... integers) {
            File loFilePath = Environment.getExternalStorageDirectory() ;
            File loFolder = new File(loFilePath.getAbsolutePath() + "/Android/data/"+ MainFolder);
            File loSubFolder = new File(loFolder.getAbsolutePath() + "/" + DirFolder + "/");
            if(!loFolder.exists()){
                if(loFolder.mkdir()) {
                    Log.e(TAG, "File folder created.");
                } else {
                    Log.e(TAG, "Failed to create file folder.");
                }
            }
            for(int x = 0; x < PromoThumbnails.size(); x++){
                try{
                    InputStream loStream = new URL(PromoThumbnails.get(x).getPromoLink()).openStream();
                    Bitmap loBitmap = BitmapFactory.decodeStream(loStream);
                    loSubFolder.mkdir();
                    File loFile = new File(loSubFolder, PromoThumbnails.get(x).getPromoImage() + ".png");
                    if(!loFile.exists()) {
                        loOutStream = new FileOutputStream(loFile);
                    }

                    loBitmap.compress(Bitmap.CompressFormat.PNG, 50, loOutStream);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            this.cancel(true);
            super.onPostExecute(s);
        }
    }
}
