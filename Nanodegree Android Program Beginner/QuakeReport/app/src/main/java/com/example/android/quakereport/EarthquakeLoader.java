package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by jennifernghinguyen on 1/9/17.
 */

public class EarthquakeLoader extends AsyncTaskLoader {
    private String url;

    public static final String LOG_TAG = EarthquakeLoader.class.getName();

    public EarthquakeLoader(Context context, String url) {
        super(context);
        this.url = url;
        Log.i(LOG_TAG, "in EarthquakeLoader() constructor");
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "in onStartLoading() ");
        forceLoad();
    }

    @Override
    public List<EarthQuake> loadInBackground() {
        Log.i(LOG_TAG, "in loadInBackground() ");
        List<EarthQuake> earthQuakes = null;
        if (this.url == null) {
            return null;
        }


        earthQuakes = QueryUtils.fetchEarthquakeData(this.url);

        return earthQuakes;
    }
}
