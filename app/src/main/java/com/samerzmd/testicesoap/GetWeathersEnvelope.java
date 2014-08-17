package com.samerzmd.testicesoap;

import android.util.Log;

import com.alexgilleran.icesoap.envelope.impl.BaseSOAP11Envelope;

/**
 * Created by CubicArt on 8/4/14.
 */
public class GetWeathersEnvelope extends BaseSOAP11Envelope {
    private final static String AON_AWARE_NAMESPACE = "http://ws.cdyne.com/WeatherWS/";

    public GetWeathersEnvelope() {
        declarePrefix("weat", AON_AWARE_NAMESPACE);
        getBody().addNode(super.getNamespace(), "GetWeatherInformation");
        Log.d(getClass().getName(),super.getNamespace());
    }
}
