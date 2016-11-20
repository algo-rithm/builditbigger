package tech.rithm.builditbigger;

import android.app.Activity;
import android.os.Bundle;

import tech.rithm.jokefactory.JokeFactory;

/**
 * Created by rithm on 11/20/2016.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        System.out.println(JokeFactory.getRandomJoke());
    }
}
