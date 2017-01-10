package com.example.android.quakereport;

/**
 * Created by jennifernghinguyen on 1/6/17.
 */
public class EarthQuake {
    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;
    private String mUrl;

    public EarthQuake(double magnitude, String location, long TimeInMilliseconds, String url){
        this.mMagnitude=magnitude;
        this.mLocation=location;
        this.mTimeInMilliseconds=TimeInMilliseconds;
        this.mUrl=url;
    }

    public double getMagnitude(){
        return this.mMagnitude;
    }

    public String getLocation(){
        return this.mLocation;
    }

    public  long getTimeInMilliseconds(){
        return this.mTimeInMilliseconds;
    }

    public String getUrl(){
        return this.mUrl;
    }
}
