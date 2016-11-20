package tech.rithm.builditbigger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import tech.rithm.jokefactory.JokeFactory;
import tech.rithm.jokedisplay.JokeDisplayActivity;

/**
 * Created by rithm on 11/20/2016.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        System.out.println(JokeFactory.getRandomJoke());

    }

    @Override
    protected void onStart(){
        super.onStart();

        Intent intent = new Intent(this, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.JOKE_EXTRA, JokeFactory.getRandomJoke());
        startActivity(intent);
    }
}
