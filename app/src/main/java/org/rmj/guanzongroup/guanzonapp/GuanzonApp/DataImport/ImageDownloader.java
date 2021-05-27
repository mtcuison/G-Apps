package org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport;

import android.os.AsyncTask;

public class ImageDownloader {
    private static final String TAG = ImageDownloader.class.getSimpleName();

    public void downloadImages(String URL) {

    }

    class DoBackgroundTask extends AsyncTask<Integer, Integer, String>{


        @Override
        protected String doInBackground(Integer... integers) {
            return "Download finished.";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }
}
