package com.example.sigkill.eventmap;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.util.Date;
import java.util.UUID;

/**
 * Created by sigkill on 8/12/17.
 */

public class Event {
    UUID id;
    public Date DateTime;
    public String Title;
    public String Description;
    public LatLng Coordinates;
    public Integer UserId;
    public Marker marker;
}
