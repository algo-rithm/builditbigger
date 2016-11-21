package tech.rithm.jokedisplay;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.widget.Toast;

import tech.rithm.jokedisplay.tasks.JokeEndpointsAsyncTask;


/**
 * Created by rithm on 11/20/2016.
 */

public class JokeDisplayActivity extends Activity {

    public static final String JOKE_EXTRA = "joke_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_layout);




        //String joke = getIntent().getStringExtra(JOKE_EXTRA);

        //new JokeEndpointsAsyncTask().execute(new Pair<Context, String>(this, "Test for sayHi"));

        //Toast.makeText(this, joke, Toast.LENGTH_LONG).show();
    }
}
