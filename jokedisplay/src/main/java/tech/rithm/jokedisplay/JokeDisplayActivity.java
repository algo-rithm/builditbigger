package tech.rithm.jokedisplay;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by rithm on 11/20/2016.
 */

public class JokeDisplayActivity extends Activity {

    public static final String JOKE_EXTRA = "joke_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        String joke = getIntent().getStringExtra(JOKE_EXTRA);

        Toast.makeText(this, joke, Toast.LENGTH_LONG).show();
    }
}
