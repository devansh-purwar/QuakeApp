package com.example.android.quakereport;

public class EarthQuake {
    private String eqPlace ;
    private double mag;
    private long mTimeInMilliseconds ;
    private String url;

    EarthQuake(String a , double b, long c,String d){
        this.eqPlace = a;
        this.mag = b;
        this.mTimeInMilliseconds = c;
        this.url=d;
    }

    public double getMag() {
        return mag;
    }
    public String getUrl() { return url; }
    public String getEqPlace() {
        return eqPlace;
    }
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
