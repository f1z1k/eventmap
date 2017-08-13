package com.example.sigkill.eventmap;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.util.Date;

/**
 * Created by sigkill on 8/12/17.
 */

public class Event {
    public String id;
    public Date DateTime;
    public String Title;
    public String Description;
    public LatLng Coordinates;
    public Integer UserId;
    public Marker marker;
}
