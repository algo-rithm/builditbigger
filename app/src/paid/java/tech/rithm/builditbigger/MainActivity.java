package tech.rithm.builditbigger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import java.util.zip.Inflater;

import tech.rithm.jokefactory.JokeFactory;
import tech.rithm.jokedisplay.JokeDisplayActivity;


/**
 * Created by rithm on 11/20/2016.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        System.out.println(JokeFactory.getRandomJoke());

    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    public void requestRandomJoke(View v){

        Intent intent = new Intent(getApplicationContext(), JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.JOKE_EXTRA, JokeFactory.getRandomJoke());
        startActivity(intent);

    }
}