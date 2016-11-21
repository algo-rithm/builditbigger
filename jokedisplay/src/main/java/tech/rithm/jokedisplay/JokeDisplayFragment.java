package tech.rithm.jokedisplay;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import tech.rithm.jokedisplay.loaders.JokeLoader;

/**
 * Created by rithm on 11/21/2016.
 */

public class JokeDisplayFragment extends Fragment implements LoaderManager.LoaderCallbacks<String>{

    private ProgressBar progressBar;

    public static final int JOKE_LOADER_ID = 1;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_display_layout, viewGroup, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        progressBar = (ProgressBar) getView().findViewById(R.id.joke_progressbar);
        progressBar.setVisibility(View.VISIBLE);

        Button nextJoke = (Button) getView().findViewById(R.id.next_joke_button);
        nextJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                getLoaderManager().restartLoader(JOKE_LOADER_ID, null, JokeDisplayFragment.this);
            }
        });

        LoaderManager lm = getActivity().getLoaderManager();
        lm.initLoader(JOKE_LOADER_ID, null, JokeDisplayFragment.this);
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args){
        Loader loader = null;
        switch (id){
            case JOKE_LOADER_ID:
                loader = new JokeLoader(getActivity());
                break;
        }

        return loader;
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String jokeResult){
        switch(loader.getId()){
            case JOKE_LOADER_ID:

                progressBar.setVisibility(View.GONE);
                TextView joke = (TextView) getView().findViewById(R.id.joke_text);
                joke.setText(jokeResult);

                break;

        }
    }

    @Override
    public void onLoaderReset(Loader<String> loader){
        switch(loader.getId()){
            case JOKE_LOADER_ID:
                progressBar.setVisibility(View.VISIBLE);
        }
    }

}
