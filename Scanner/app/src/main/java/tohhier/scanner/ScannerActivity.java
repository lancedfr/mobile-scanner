package tohhier.scanner;

import android.app.Activity;
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
      //  IntentIntegrator.setResultDisplayDuration(getIntent(),50000);
        IntentIntegrator.initiateScan(this);

       // IntentIntegrator integrator = new IntentIntegrator(this);
       // integrator.initiateScan();
       /* IntentIntegrator integrator = new IntentIntegrator(ScannerActivity.this);
        integrator.addExtra("SCAN_WIDTH", 800);
        integrator.addExtra("SCAN_HEIGHT", 300);
        integrator.addExtra("RESULT_DISPLAY_DURATION_MS", 3000L);
        integrator.addExtra("PROMPT_MESSAGE", "Scan Product Barcode");

        integrator.initiateScan(IntentIntegrator.PRODUCT_CODE_TYPES);*/


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