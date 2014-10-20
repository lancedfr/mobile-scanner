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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


//import tohhier.scanner.IntentIntegrator;
//import tohhier.scanner.IntentResult;

public class ScannerActivity extends Activity {
public String tempBarcode;
private ProgressBar spinner;
private AsyncTimer timer;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner); // this works without the scanner app
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);
        OnClickListener listnr=new OnClickListener() {

            @Override

            public void onClick(View v) {

                //Intent i= new Intent("AnotherActivity");
                //startActivity(i);
                TextView result = (TextView) findViewById(R.id.resultText);
                if(tempBarcode != null) {
                    spinner.setVisibility(View.VISIBLE);
                    startThread();

                }else {
                    spinner = (ProgressBar)findViewById(R.id.progressBar1);
                    spinner.setVisibility(View.GONE);
                    result.setText("No barcode acquired");
                }
            }

        };

        Button btn =(Button) findViewById(R.id.buttonSearch);

        btn.setOnClickListener(listnr);
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

           tempBarcode = barcode;

            EditText barcodeText = (EditText)findViewById(R.id.barcodeText);
            EditText typeText = (EditText)findViewById(R.id.typeText);

            barcodeText.setText(barcode);
            typeText.setText(type);

        }

    }

    private void startThread()
    {
        if(timer!=null&&timer.getIsRunning()==true)
        {
            Toast.makeText(this, "Already searching...", Toast.LENGTH_SHORT).show();
            return;
        }
        timer = new AsyncTimer(this,spinner);
        timer.execute();
    }
    private void stopThread()
    {
        if(timer==null || timer.getIsRunning()==false)
        {
            Toast.makeText(this, "Not searching!", Toast.LENGTH_SHORT).show();
            return;
        }
        timer.cancel(true);
    }


}

//testing repo commit