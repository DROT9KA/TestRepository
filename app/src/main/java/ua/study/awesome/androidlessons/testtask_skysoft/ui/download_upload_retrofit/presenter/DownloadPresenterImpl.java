package ua.study.awesome.androidlessons.testtask_skysoft.ui.download_upload_retrofit.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.study.awesome.androidlessons.testtask_skysoft.retrofit.DownloadImageRetrofit;
import ua.study.awesome.androidlessons.testtask_skysoft.retrofit.UploadImageRetrofit;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.download_upload_retrofit.DownloadFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.download_upload_retrofit.api.ImageDownloadAPI;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.download_upload_retrofit.api.ImageUploadAPI;
import ua.study.awesome.androidlessons.testtask_skysoft.utils.ImageSaverUtil;

public class DownloadPresenterImpl implements DownloadPresenter {

    private DownloadFragment view;

    private final int RESULT_LOAD_IMG = 1;

    @Override
    public void atachView(DownloadFragment downloadFragment) {
        this.view = downloadFragment;
    }

    @Override
    public void downloadImage() {
        ImageDownloadAPI download = DownloadImageRetrofit.getInstance().getRetrofit().create(ImageDownloadAPI.class);

        Call<ResponseBody> call = download.getImage();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                boolean success = false;
                if (response.body() != null) {
                    success = ImageSaverUtil.writeResponseBodyToDisk(view.getActivity(), response.body());
                }

                Toast.makeText(view.getContext(), "Nice " + success, Toast.LENGTH_SHORT).show();
                showDownloadedImage();
                view.hideProgress();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(view.getContext(), "Fail", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void uploadImage() {
        String filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString() + "/Android.jpg";
        File file = new File(filePath);
        RequestBody fileRequestBody = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("upload", file.getName(), fileRequestBody);

        String descriptionString = "Request description ";
        RequestBody description = RequestBody.create(MultipartBody.FORM, descriptionString);

        ImageUploadAPI imageUploadAPI = UploadImageRetrofit.getInstance().getRetrofit().create(ImageUploadAPI.class);
        Call call = imageUploadAPI.uploadImage(part, description);

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                view.showToast("onResponce: ", response);
                view.hideProgress();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                view.showToast("onFailure", null);
                view.hideProgress();
            }
        });
    }

    private void showDownloadedImage(){
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString() + "/Android.jpg";
        Bitmap bmp = BitmapFactory.decodeFile(path);
        view.showPicture(bmp);
    }

//    private void testshowImage(){
//
//        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
//        photoPickerIntent.setType("image/*");
//        view.startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
//    }
}