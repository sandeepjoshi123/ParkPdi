package tribond.parkpdi.util;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ImagePicker {
    private static final int IMAGE_MAX_SIZE = 1024;
    final int SELECT_PHOTO = 2, CAPTURE_IMAGE = 1;
    ImageView imageView;
    Context context;
    String picturePath;
    private int maxlogoSige = 500;

    public ImagePicker(Context context, ImageView imageView) {
        this.imageView = imageView;
        this.context = context;
    }

    public static String fileToBase64(String path) throws IOException {

        byte[] bytes = fileToByteArray(path);
        return Base64.encodeToString(bytes, 0);
    }

    public static byte[] fileToByteArray(String path) throws IOException {
        File imagefile = new File(path);
        byte[] data = new byte[(int) imagefile.length()];
        FileInputStream fis = new FileInputStream(imagefile);
        fis.read(data);
        fis.close();
        return data;
    }


    public String onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_PHOTO && null != imageReturnedIntent) {
                Uri selectedImage = imageReturnedIntent.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                if (selectedImage != null) {
                    Cursor cursor = context.getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    picturePath = cursor.getString(columnIndex);
                    cursor.close();
                    saveFile();
                }

            } else if (requestCode == CAPTURE_IMAGE) {
                final File f = new File(Environment.getExternalStorageDirectory(), "temp.jpg");
                picturePath = f.getAbsolutePath();
                saveFile();

            }

        }
        return picturePath;
    }


    private void saveFile() {
        Bitmap bit = CommonUtil.ShrinkBitmap(picturePath, maxlogoSige, maxlogoSige);
        bit = CommonUtil.rotateImageIfRequired(bit, picturePath);
        imageView.setImageBitmap(bit);
    }

    public void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);
        byte[] buf = new byte[IMAGE_MAX_SIZE];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }


}