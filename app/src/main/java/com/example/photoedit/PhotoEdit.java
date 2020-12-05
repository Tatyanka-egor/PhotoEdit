package com.example.photoedit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PhotoEdit extends AppCompatActivity {
    Bitmap selectedImage;
    ImageView photoView
    private static final int PICK_IMAGE=01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();


    }
    private void Init(){
        photoView=findViewById(R.id.imageView);
        setImageBitmap=MainActivity.selectedImage;
        photoView.srtImageBitmap(selectedImage);
    }
    public void PickPhoto(View view){
      Intent photoPickerIntent=new Intent(Intent.ACTION_PICK);
      photoPickerIntent.setType("image/*");
      startActivityForResult(photoPickerIntent,PICK_IMAGE);
    }
    public void Rotate_90(View view){
        Matrix matrix=new Matrix();
        matrix.setRotate((float)90);
        selectedImage=Bitmap.createbitmap(selectedImage,0,0,selectedImage.getWidth(),selectedImage.getHight,false);
        photoView.ImageBitmap(selectedImage);

    }
    public void Reflect(View view){
        Matrix matrix=new Matrix();
        matrix.setScale(-1,1);
        selectedImage=Bitmap.createbitmap(selectedImage,0,0,selectedImage.getWidth(),selectedImage.getHight,true);
        photoView.ImageBitmap(selectedImage);

    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==PICK_IMAGE){
            try {
                Uri imageUri=data.getData();
                InputStream imageStream=getContentResolver().openInputStream(imageUri);
                selectedImage=BitmapFactory.decodeStream(ImageStream);

                Intent intent= new Intent(MainActivity.this,PhotoEdit.class);
                startActivity(intent);
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}