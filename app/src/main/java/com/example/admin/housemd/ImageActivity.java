package com.example.admin.housemd;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.opencv.core.Core.NORM_MINMAX;
import static org.opencv.core.Core.extractChannel;
import static org.opencv.core.Core.normalize;
import static org.opencv.imgproc.Imgproc.COLORMAP_JET;
import static org.opencv.imgproc.Imgproc.applyColorMap;

public class ImageActivity extends AppCompatActivity {

    ImageView imageView1, imageView2;


    private static final int TAKE_PICTURE = 1;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView1 = (ImageView) findViewById(R.id.iv1);
        imageView2 = (ImageView) findViewById(R.id.iv2);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File photo = new File(Environment.getExternalStorageDirectory(),  "Pic.jpg");
        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                Uri.fromFile(photo));
        imageUri = Uri.fromFile(photo);
        startActivityForResult(intent, TAKE_PICTURE);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_PICTURE:
                if (resultCode == Activity.RESULT_OK) {
                    Uri selectedImage = imageUri;
                    getContentResolver().notifyChange(selectedImage, null);
                    ContentResolver cr = getContentResolver();
                    Bitmap bitmap;
                    Intent i = new Intent(ImageActivity.this, ResultActivity.class);
                    startActivity(i);
                }
        }
    }


    public static Bitmap createContrast(Bitmap src, double value) {
        // image size
        int width = src.getWidth();
        int height = src.getHeight();
        // create output bitmap
        Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
        // color information
        int A, R, G, B;
        int pixel;
        // get contrast value
        double contrast = Math.pow((100 + value) / 100, 2);

        // scan through all pixels
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                // get pixel color
                pixel = src.getPixel(x, y);
                A = Color.alpha(pixel);
                // apply filter contrast for every channel R, G, B
                R = Color.red(pixel);
                R = (int) (((((R / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                if (R < 0) {
                    R = 0;
                } else if (R > 255) {
                    R = 255;
                }

                G = Color.red(pixel);
                G = (int) (((((G / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                if (G < 0) {
                    G = 0;
                } else if (G > 255) {
                    G = 255;
                }

                B = Color.red(pixel);
                B = (int) (((((B / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                if (B < 0) {
                    B = 0;
                } else if (B > 255) {
                    B = 255;
                }

                // set new pixel color to output bitmap
                bmOut.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }

        return bmOut;
    }

    public Bitmap drawRects(Bitmap bitmap) {
        Mat mat = new Mat();
        Utils.bitmapToMat(bitmap, mat);
        List<MatOfPoint> contours = new ArrayList<>();
        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGB2GRAY);
        Imgproc.threshold(mat, mat, 120, 255, Imgproc.THRESH_BINARY);
        Imgproc.findContours(mat, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
        int no_of_rects = 0;
        double total_ratio = 0.0;
        for (int i = 0; i < contours.size(); i++) {
            if (Imgproc.contourArea(contours.get(i)) > 50) {
                Rect rect = Imgproc.boundingRect(contours.get(i));
                if (rect.height > 40 && rect.width > 40) {
                    no_of_rects++;
                    //System.out.println(rect.x +","+rect.y+","+rect.height+","+rect.width);
                    Imgproc.rectangle(mat, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255));
                    double ratio = (rect.height > rect.width) ? ((double) rect.height) / rect.width : ((double) rect.width) / rect.height;
                    total_ratio = total_ratio + ratio;
                }
            }
        }

        Log.d("AVERAGE: ", (total_ratio) / (double) no_of_rects + "");

        Utils.matToBitmap(mat, bitmap);
        return bitmap;
    }


    protected void genHeatMap(Bitmap image) {

        Mat img = new Mat(image.getHeight(), image.getWidth(), CvType.CV_32FC4);
        Utils.bitmapToMat(image, img);
        img.convertTo(img, CvType.CV_8UC1);
        Mat imgChR = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC1);
        extractChannel(img, imgChR, 0);
        normalize(imgChR, imgChR, 0, 255, NORM_MINMAX);
        Mat heatOut = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC4);
        applyColorMap(imgChR, heatOut, COLORMAP_JET);
        Bitmap pimage = Bitmap.createBitmap(heatOut.cols(), heatOut.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(heatOut, pimage);
        imageView2.setImageBitmap(pimage);

    }

}