package tech.rithm.jokedisplay.tasks;

import android.content.Context;
import android.util.Pair;


import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static junit.framework.TestCase.assertFalse;

/**
 * Created by rithm on 11/21/2016.
 */

public class JokeAsyncTaskTest {

    @Test
    public void verifyAsyncResponse(){
        String result = null;
        try{
            result  = new JokeEndpointsAsyncTask().execute().get();
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e){
            e.printStackTrace();
        }
       assertFalse(result.isEmpty());
    }
}
