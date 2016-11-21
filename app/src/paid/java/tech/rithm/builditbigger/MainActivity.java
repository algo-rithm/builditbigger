package tech.rithm.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.zip.Inflater;

import tech.rithm.jokefactory.JokeFactory;
import tech.rithm.jokedisplay.JokeDisplayActivity;


/**
 * Created by rithm on 11/20/2016.
 */
public class MainActivity extends Activity {

    private boolean isConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        System.out.println(JokeFactory.getRandomJoke());
        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    public void requestRandomJoke(View v){

        if(isConnected){
            Intent intent = new Intent(getApplicationContext(), JokeDisplayActivity.class);
            intent.putExtra(JokeDisplayActivity.JOKE_EXTRA, JokeFactory.getRandomJoke());
            startActivity(intent);
        }
        else {
            Toast.makeText(this, getString(R.string.no_internet_msg),Toast.LENGTH_LONG).show();
        }


    }
}