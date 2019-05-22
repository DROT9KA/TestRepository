package ua.study.awesome.androidlessons.testtask_skysoft.utils;

import android.app.Activity;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;

public class ImageSaverUtil {

    static String TAG = "TAG";

    public static boolean writeResponseBodyToDisk(Activity activity, ResponseBody body) {
        try {
            File futureStudioIconFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Android.jpg");

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();          //to read the file
                outputStream = new FileOutputStream(futureStudioIconFile);     //to save the file

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);

                    fileSizeDownloaded += read;
                    Log.d(TAG, "file download: " + fileSizeDownloaded + " of " + fileSize);
                }

                outputStream.flush();

                MediaStore.Images.Media.insertImage(activity.getContentResolver(),
                        futureStudioIconFile.getAbsolutePath(),
                        futureStudioIconFile.getName(),
                        futureStudioIconFile.getName());      //register in gallery

                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }

}