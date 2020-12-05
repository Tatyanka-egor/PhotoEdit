package com.example.photoedit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static Bitmap selectedImage;
    private static final int PICK_IMAGE=01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void PickPhoto(View view){
      Intent photoPickerIntent=new Intent(Intent.ACTION_PICK);
      photoPickerIntent.setType("image/*");
      startActivityForResult(photoPickerIntent,PICK_IMAGE);
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==PICK_IMAGE){
            try {
                Uri imageUri=data.getData();
                InputStream imageStream=getContentResolver().openInputStream(imageUri);
                selectedImage=BitmapFactory.decodeStream(ImageStream);
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}