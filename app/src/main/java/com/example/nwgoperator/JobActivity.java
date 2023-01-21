package com.example.nwgoperator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import com.example.nwgoperator.databinding.ActivityJobBinding;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class JobActivity extends AppCompatActivity {
    ActivityJobBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityJobBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        //Photo permissions
        if (ContextCompat.checkSelfPermission(JobActivity.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(JobActivity.this, new String[]{
                    Manifest.permission.CAMERA
            }, 100);
        }


        bind.photoBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 299);
        });

        bind.submitBtn.setOnClickListener(view -> {
            if (bind.editTextTextPersonName5.getText().toString().isEmpty() || bind.editTextTextPersonName2.getText().toString().isEmpty() || bind.editTextTextPersonName3.getText().toString().isEmpty() || bind.editTextTextPersonName4.getText().toString().isEmpty()) {
                Toast.makeText(this, "Cannot submit form with empty field", Toast.LENGTH_SHORT).show();
            }
            else {
                startActivity(new Intent(JobActivity.this, MainActivity.class));
                Toast.makeText(this, "Form submitted successfully", Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 299) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            bind.selectedimg.setImageBitmap(bitmap);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_ss", Locale.ENGLISH);
            String filename = formatter.format(new Date());
            StorageReference storageReference = FirebaseStorage.getInstance().getReference("images/" + filename);
//            storageReference.putFile(data.getExtras().get("data")).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(MainActivity.this, "LLLLLLLL", Toast.LENGTH_SHORT).show();
//                }
//            });

        }
    }


}