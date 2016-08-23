package tribond.parkpdi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

import tribond.parkpdi.adapter.ImageAdapter;
import tribond.parkpdi.util.HorizontalSpaceItemDecoration;
import tribond.parkpdi.util.ImagePicker;

public class AddPhoto extends AppCompatActivity {


    final int SELECT_PHOTO = 2, CAPTURE_IMAGE = 1;
    private ImageView main;
    private RecyclerView imageList;
    private ImagePicker imagePicker;
    private String imagePath;
    private ArrayList<String> images;
    private ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                pickImage();
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initialize();
    }

    private void initialize() {
        images = new ArrayList<>();
        main = (ImageView) findViewById(R.id.iv_main);
        imagePicker = new ImagePicker(this, main);

        imageList = (RecyclerView) findViewById(R.id.rec_photo);
        imageList.addItemDecoration(new HorizontalSpaceItemDecoration(20));
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        imageList.setLayoutManager(layoutManager);

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("images", images);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        images = (ArrayList<String>) savedInstanceState.get("images");
    }

    public void pickImage() {
        final CharSequence[] options = {getResources().getString(R.string.take_photo), getResources().getString(R.string.choose_from_gallery), getResources().getString(R.string.cancel)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_Holo_Light_Dialog);
        builder.setTitle(getResources().getString(R.string.title_activity_add_photo));
        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {
                // TODO Auto-generated method stub

                switch (item) {
                    case 0:
                        if (Build.VERSION.SDK_INT < 23) {
                            takePhoto();
                        } else {
                            if (checkSelfPermission(android.Manifest.permission.CAMERA)
                                    != PackageManager.PERMISSION_GRANTED) {

                                requestPermissions(new String[]{android.Manifest.permission.CAMERA},
                                        CAPTURE_IMAGE);
                            } else {
                                takePhoto();
                            }
                        }

                        break;
                    case 1:
                        if (Build.VERSION.SDK_INT < 23) {
                            takePhoto();
                        } else {
                            if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                                    != PackageManager.PERMISSION_GRANTED) {

                                requestPermissions(new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                                        SELECT_PHOTO);
                            } else {
                                selectPhoto();
                            }
                        }
                        break;
                    case 2:
                        dialog.dismiss();
                        break;

                }

            }
        });
        Dialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
    }


    public void takePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File f = new File(Environment.getExternalStorageDirectory(), "temp.jpg");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
        startActivityForResult(intent, CAPTURE_IMAGE);

    }

    public void selectPhoto() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(photoPickerIntent, SELECT_PHOTO);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String img = imagePicker.onActivityResult(requestCode, resultCode, data);
            images.add(0, img);
            imageAdapter = new ImageAdapter(this, images, main);
            imageList.setAdapter(imageAdapter);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAPTURE_IMAGE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                takePhoto();
            } else {
                Snackbar.make(main, "You don't have permission of camera.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        } else if (requestCode == SELECT_PHOTO) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                selectPhoto();
            } else {
                Snackbar.make(main, "You don't have permission of read storage..", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }
    }

}
