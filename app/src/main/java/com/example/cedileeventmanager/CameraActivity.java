package com.example.cedileeventmanager;

import android.content.Intent;
import android.graphics.PointF;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.dlazaro66.qrcodereaderview.QRCodeReaderView;

public class CameraActivity extends AppCompatActivity implements QRCodeReaderView.OnQRCodeReadListener {

    private QRCodeReaderView qrCodeReaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        qrCodeReaderView = findViewById(R.id.qrdecoderview);

        qrCodeReaderView.setOnQRCodeReadListener(this);

        // Use this function to enable/disable decoding
        qrCodeReaderView.setQRDecodingEnabled(true);

        // Use this function to change the autofocus interval (default is 5 secs)
        qrCodeReaderView.setAutofocusInterval(2000L);

        // Use this function to set back camera preview
        qrCodeReaderView.setBackCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        qrCodeReaderView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        qrCodeReaderView.stopCamera();
    }

    @Override
    public void onQRCodeRead(String text, PointF[] points) {

        Intent intent = new Intent(CameraActivity.this, InfoActivity.class);
        intent.putExtra("decoded", text);
        startActivity(intent);
    }
}
