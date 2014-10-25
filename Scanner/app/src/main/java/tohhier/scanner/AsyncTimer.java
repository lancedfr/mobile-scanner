package tohhier.scanner;

/**
 * Created by tohhier on 2014/10/20.
 */

        import android.content.Context;
        import android.os.AsyncTask;
        import android.util.Log;
        import android.view.View;
        import android.widget.ProgressBar;
        import android.widget.TextView;
        import android.widget.Toast;

        import org.apache.http.HttpEntity;
        import org.apache.http.HttpResponse;
        import org.apache.http.StatusLine;
        import org.apache.http.client.ClientProtocolException;
        import org.apache.http.client.HttpClient;
        import org.apache.http.client.methods.HttpGet;
        import org.apache.http.impl.client.DefaultHttpClient;
        import org.apache.http.message.BasicNameValuePair;
        import org.json.JSONArray;
        import org.json.JSONObject;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.UnsupportedEncodingException;


public class AsyncTimer extends AsyncTask<Void,Integer,Boolean>{
    private boolean isRunning;
    private boolean stop;
    private int seconds;
    private Context context;
    private View rootView;
    private onprogressUpdateListener listener;
    public ProgressBar spinner;

    public AsyncTimer(Context c, View rootView)
    {
        context = c;
        this.rootView = rootView;
    }
    public void setonprogressUpdateListener(onprogressUpdateListener l)
    {
        listener = l;
    }
    @Override
    protected Boolean doInBackground(Void... arg0) {

        stop  = false;
        isRunning = true;
        seconds = 0;
        this.publishProgress(seconds);
        while(seconds<10&&stop!=true)
        {
            try {
                Thread.sleep(1000);



            } catch (InterruptedException e) {

                Log.e("", e.getMessage());
            }
            seconds++;
            this.publishProgress(seconds);

        }

        if(stop==false)
            return true;
        else
            return false;
    }

    @Override
    protected void onCancelled() {
        stop = true;
        isRunning = false;
        Toast.makeText(context, "Search stopped ", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostExecute(Boolean result) {
        isRunning = false;
        if(result==true) {
            spinner = (ProgressBar) rootView.findViewById(R.id.progressBar1);
            spinner.setVisibility(View.INVISIBLE);
        }
    }


    protected void onprogressUpdate(Integer... values) {
        listener.progressUpdate(values[0]);
    }
    public boolean getIsRunning()
    {
        return isRunning;
    }

    public interface onprogressUpdateListener
    {
        public void progressUpdate(int i);
    }


}


