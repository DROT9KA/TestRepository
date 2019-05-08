//import android.app.Activity;
//import android.database.Cursor;
//import android.net.Uri;
//import android.provider.MediaStore;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//import java.util.ArrayList;
//
//import ua.study.awesome.androidlessons.testtask_skysoft.R;
//
//class MainActivity extends AppCompatActivity {
//    private static final int REQUEST_PERMISSIONS = 100;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        }
//
//    private ArrayList<String> getAllShownImagesPath(Activity activity) {
//        Uri uri;
//        Cursor cursor;
//        int column_index_data, column_index_folder_name;
//        ArrayList<String> listOfAllImages = new ArrayList<String>();
//        String absolutePathOfImage = null;
//        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
//
//        String[] projection = { MediaStore.MediaColumns.DATA,
//                MediaStore.Images.Media.BUCKET_DISPLAY_NAME };
//
//        cursor = activity.getContentResolver().query(uri, projection, null,
//                null, null);
//
//        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
//        column_index_folder_name = cursor
//                .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);
//        while (cursor.moveToNext()) {
//            absolutePathOfImage = cursor.getString(column_index_data);
//
//            listOfAllImages.add(absolutePathOfImage);
//        }
//        return listOfAllImages;
//    }
//
//}