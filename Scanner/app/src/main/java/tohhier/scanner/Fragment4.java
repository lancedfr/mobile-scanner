package tohhier.scanner;

import android.app.ActionBar;
import android.app.ListFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import tohhier.scanner.classes.Product;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Fragment4 extends Fragment{

    private TextView products;
    private View tempView;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getActivity().getActionBar().hide();

        View decorView = getActivity().getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fragment4,container, false);
        tempView = rootView;

        new HttpAsyncTask().execute("http://mobilescanner.co.za/mobile-scanner-server/rest/products");




        Button b = (Button)rootView.findViewById(R.id.button10);
        b.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                new HttpAsyncTask().execute("http://mobilescanner.co.za/mobile-scanner-server/rest/products");


            }

        });

        return rootView;
    }

    public static String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if(inputStream != null) {
                result = convertInputStreamToString(inputStream);
            }else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }


    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            products = (TextView) tempView.findViewById(R.id.allProducts);


            try {

                Gson gson = new Gson();
                @SuppressWarnings("serial")
                Type collectionType = new TypeToken<List<Product>>() {
                }.getType();
                ArrayList<Product> navigation = gson.fromJson(result, collectionType);
                String x = "";

                for(int i = 0; i < navigation.size();i++) {

                  x +="Product Id: "+navigation.get(i).getId()+"\n"+"Barcode Number: " + navigation.get(i).getBarcode() + "\n" +"Product Name: "+ navigation.get(i).getName() + "\n_____________________________________\n\n";
                }

                products.setText(x);

            } catch (Exception e) {
                Toast.makeText(getActivity(), "error", Toast.LENGTH_LONG).show();
            }
        }
    }

}
