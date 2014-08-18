package com.samerzmd.testicesoap;

import com.alexgilleran.icesoap.annotation.XMLField;
import com.alexgilleran.icesoap.annotation.XMLObject;

/**
 * Created by CubicArt on 8/4/14.
 */
@XMLObject("//WeatherDescription")
public class Weather {
    @XMLField("WeatherID")
    public String id;

    @XMLField("Description")
    public String name;
}
