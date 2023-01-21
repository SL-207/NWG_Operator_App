package com.example.nwgoperator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;
//import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import kotlinx.coroutines.Job;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button jobBtn = findViewById(R.id.jobbtn);
        jobBtn.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this, JobActivity.class));
        });
        Button scheduleBtn = findViewById(R.id.schedulebtn);
        scheduleBtn.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this, JobActivity.class));
        });
        Button gpsBtn = findViewById(R.id.gpsbtn);
        gpsBtn.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this, JobActivity.class));
        });



    }



}
