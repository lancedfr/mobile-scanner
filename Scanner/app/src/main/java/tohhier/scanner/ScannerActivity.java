package tohhier.scanner;

import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


//import tohhier.scanner.IntentIntegrator;
//import tohhier.scanner.IntentResult;

public class ScannerActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner); // this works without the scanner app
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //hide action bar
        final ActionBar actionBar = getActionBar();
        actionBar.hide();
        //hide status bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        //load scanner
        IntentIntegrator.initiateScan(this);

    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
           String barcode;
           String type;

           barcode = scanResult.getContents();
           type = scanResult.getFormatName();

            EditText barcodeText = (EditText)findViewById(R.id.barcodeText);
            EditText typeText = (EditText)findViewById(R.id.typeText);

            barcodeText.setText(barcode);
            typeText.setText(type);


        }

    }

}