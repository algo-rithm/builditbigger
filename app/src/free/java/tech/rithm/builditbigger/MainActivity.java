package tech.rithm.builditbigger;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import tech.rithm.builditbigger.R;
import tech.rithm.jokedisplay.JokeDisplayActivity;
import tech.rithm.jokefactory.JokeFactory;

/**
 * Created by rithm on 11/20/2016.
 */

public class MainActivity extends Activity{

    InterstitialAd mInterstitialAd;
    private boolean isConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        if (isConnected){
            setupAdService();
        } else {
            Toast.makeText(this, getString(R.string.no_internet_msg), Toast.LENGTH_LONG).show();
        }
    }

    private void setupAdService(){
        MobileAds.initialize(getApplicationContext(), getString(R.string.main_activity_banner));
        String android_id = Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID);

        AdView mAdView = (AdView) findViewById(R.id.banner);
        final AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice(android_id)
                .build();

        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.main_interstitial));

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                mInterstitialAd.loadAd(adRequest);
                Intent intent = new Intent(getApplicationContext(), JokeDisplayActivity.class);
                intent.putExtra(JokeDisplayActivity.JOKE_EXTRA, JokeFactory.getRandomJoke());
                startActivity(intent);
            }
        });

        mInterstitialAd.loadAd(adRequest);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    public void requestRandomJoke(View v){
        if(mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        } else if (isConnected){
            Intent intent = new Intent(getApplicationContext(), JokeDisplayActivity.class);
            intent.putExtra(JokeDisplayActivity.JOKE_EXTRA, JokeFactory.getRandomJoke());
            startActivity(intent);
        } else {
            Toast.makeText(this, getString(R.string.no_internet_msg), Toast.LENGTH_LONG).show();
        }
    }
}
