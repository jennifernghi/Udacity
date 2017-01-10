package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.io.IOException;
import java.util.List;

/**
 * Created by jennifernghinguyen on 1/9/17.
 */

public class EarthquakeLoader extends AsyncTaskLoader{
    private String url;


    public EarthquakeLoader(Context context, String url) {
        super(context);
        this.url=url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<EarthQuake> loadInBackground() {
        List<EarthQuake> earthQuakes= null;
        if(this.url==null){
            return null;
        }

        try {
            earthQuakes =  QueryUtils.extractEarthquakes(QueryUtils.makeHttpRequest(QueryUtils.createURL(this.url)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return earthQuakes;
    }
}
