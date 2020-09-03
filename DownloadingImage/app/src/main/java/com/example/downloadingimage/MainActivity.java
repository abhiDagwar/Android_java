package com.example.downloadingimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.BitSet;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void downloadImage(View view) {
        ImageDownloader task = new ImageDownloader();
        Bitmap myImage;

        try {
            myImage = task.execute("https://picsum.photos/500/600").get(); //500(width)/600(height) : You can add any width and height here to generate random image
            imageView.setImageBitmap(myImage);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setDoInput(true);

                connection.connect();

                InputStream in = connection.getInputStream();

                Bitmap bitmap = BitmapFactory.decodeStream(in);

                return bitmap;

            } catch (Exception e) {
                e.printStackTrace();

                return null;
            }
        }
    }
}