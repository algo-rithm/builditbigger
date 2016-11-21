package tech.rithm.jokedisplay.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import tech.rithm.builditbigger.backend.myApi.MyApi;

/**
 * Created by rithm on 11/20/2016.
 */

public class JokeLoader extends AsyncTaskLoader<String> {
    private String joke;
    private static MyApi myApi = null;
    private Context mContext;

    public JokeLoader(Context context){
        super(context);
    }

    @Override
    protected void onStartLoading(){
        if (joke != null){
            deliverResult(joke);
        }
        if (takeContentChanged() || joke == null){
            forceLoad();
        }
    }

    @Override
    protected void onStopLoading(){
        cancelLoad();
    }

    @Override
    protected void onForceLoad(){
        super.onForceLoad();
    }

    @Override
    public String loadInBackground(){
        if(myApi == null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),new AndroidJsonFactory(),null)
                    .setRootUrl("https://builditbigger-150117.appspot.com/_ah/api/");
            myApi = builder.build();
        }
        try{
            return myApi.getJoke().execute().getData();
        } catch (IOException e){
            return e.getMessage();
        }

    }

    @Override
    public void deliverResult(String jokeResult){
        joke = jokeResult;
        super.deliverResult(jokeResult);
    }

    @Override
    protected void onReset(){
        super.onReset();
        onStopLoading();
        if(joke != null) joke = null;
    }

    @Override
    public void onCanceled(String jokeResult){
        onContentChanged();
    }
}
