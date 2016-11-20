package tech.rithm.jokedisplay.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.Gravity;
import android.widget.Toast;

import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.extensions.android.http.AndroidHttp;


import java.io.IOException;

import tech.rithm.builditbigger.backend.myApi.MyApi;

/**
 * Created by rithm on 11/20/2016.
 */

public class JokeEndpointsAsyncTask extends AsyncTask<Pair<Context,String>, Void, String> {

    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params){
        if(myApiService == null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-150117.appspot.com/_ah/api/");

            /*
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
             */
            myApiService = builder.build();
        }

        context = params[0].first;
        String joke = params[0].second;

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e){
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result){
        Toast toast = Toast.makeText(context, result, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, Gravity.CENTER, 0);
        toast.show();
    }
}
