package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class Pop extends Activity {

    static final int CAM_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popup);

        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);

        int width = display.widthPixels;
        int height = display.heightPixels;

        getWindow().setLayout((int)(width*0.7), (int)(height*0.7));

        FloatingActionButton camera = (FloatingActionButton) findViewById(R.id.floatingActionButton6);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

    }
    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    //public void openCamera() {
        //Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //File f = galleryAddPic();
       // takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(f));
       // startActivityForResult(takePictureIntent,CAM_REQUEST);
        //if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
        //    startActivityForResult(takePictureIntent, 1);
        //}
    //}

   // @Override
    //protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //if (requestCode == 1 && resultCode == RESULT_OK) {
            //Bundle extras = data.getExtras();
            //Bitmap imageBitmap = (Bitmap) extras.get("data");
        //}
   // }

    //private File galleryAddPic() {
        //Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
     //   File f = new File("sdcard/camera_app");
     //   if (!f.exists())
    //    {
     //       f.mkdir();
      //  }
       // File image_file = new File(f, "new_image.jpg");
        //Uri contentUri = Uri.fromFile(f);
        //mediaScanIntent.setData(contentUri);
        //this.sendBroadcast(mediaScanIntent);
      //  return image_file;
    //}

    //@Override
   // protected void onActivityResult(int requestCode, int resultCode, Intent data){
      //  String path = "sdcard/camera_app/cam_image.jpg";
      //  imageView.setImageDrawable(Drawable.createFromPath(path));
   // }
}
