package com.dangvanduc90.photoeditorsticker.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.dangvanduc90.photoeditorsticker.R;
import com.dangvanduc90.photoeditorsticker.common.CommonVL;

import stream.custompermissionsdialogue.PermissionsDialogue;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton ibtnCamera;
    private ImageButton ibtnGallery;
    private ImageButton ibtnRate;
    private ImageButton ibtnShare;
    private ImageButton ibtnInfo;
    private ImageButton ibtnMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPermissions();

        initView();
    }

    private void initView() {
        ibtnCamera = (ImageButton) findViewById(R.id.ibtnCamera);
        ibtnGallery = (ImageButton) findViewById(R.id.ibtnGallery);
        ibtnRate = (ImageButton) findViewById(R.id.ibtnRate);
        ibtnShare = (ImageButton) findViewById(R.id.ibtnShare);
        ibtnInfo = (ImageButton) findViewById(R.id.ibtnInfo);
        ibtnMore = (ImageButton) findViewById(R.id.ibtnMore);
    }

    private void initPermissions() {
        PermissionsDialogue.Builder permissionsDialogue = new PermissionsDialogue.Builder(this)
                .setMessage(getString(R.string.app_name) + " is a sample permissions app and requires the following permissions: ")
                .setShowIcon(false)
                .setRequireStorage(PermissionsDialogue.REQUIRED)
                .setOnContinueClicked(new PermissionsDialogue.OnContinueClicked() {
                    @Override
                    public void OnClick(View view, Dialog dialog) {
                        dialog.dismiss();
                    }
                })
                .setDecorView(getWindow().getDecorView())
                .build();
        permissionsDialogue.show();
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, CommonVL.REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CommonVL.REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            mImageView.setImageBitmap(imageBitmap);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibtnCamera:
                break;
            case R.id.ibtnGallery:
                break;
            case R.id.ibtnRate:
                break;
            case R.id.ibtnShare:
                break;
            case R.id.ibtnInfo:
                break;
            case R.id.ibtnMore:
                break;
            default:
                break;
        }
    }
}
