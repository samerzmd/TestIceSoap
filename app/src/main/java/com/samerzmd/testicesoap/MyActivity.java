package com.samerzmd.testicesoap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.alexgilleran.icesoap.envelope.SOAPEnvelope;
import com.alexgilleran.icesoap.exception.SOAPException;
import com.alexgilleran.icesoap.observer.SOAP11ListObserver;
import com.alexgilleran.icesoap.request.Request;
import com.alexgilleran.icesoap.request.RequestFactory;
import com.alexgilleran.icesoap.request.SOAP11ListRequest;
import com.alexgilleran.icesoap.request.impl.RequestFactoryImpl;
import com.alexgilleran.icesoap.soapfault.SOAP11Fault;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MyActivity extends Activity {
    private RequestFactory requestFactory = new RequestFactoryImpl();
    ArrayList weathersInfo =new ArrayList();
    private final String url="http://wsf.cdyne.com/WeatherWS/Weather.asmx";
    private final String weathersSoapAction ="http://ws.cdyne.com/WeatherWS/GetWeatherInformation";
    @InjectView(R.id.text) TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ButterKnife.inject(this);

        SOAPEnvelope envelope = new GetWeathersEnvelope();

        requestFactory.buildListRequest(url, envelope,
                weathersSoapAction, Weather.class).execute(soapObserver);

    }
    private SOAP11ListObserver<Weather> soapObserver = new SOAP11ListObserver<Weather>() {
        @Override
        public void onNewItem(
                Request<List<Weather>, SOAP11Fault> request,
                Weather item) {
            weathersInfo.add(item);//log it if needed to
            mTextView.setText(mTextView.getText()+" "+item.name+" "+item.id);

        }

        @Override
        public void onCompletion(
                Request<List<Weather>, SOAP11Fault> request) {
            setProgressBarIndeterminateVisibility(false);
        }

        @Override
        public void onException(
                Request<List<Weather>, SOAP11Fault> request,
                SOAPException e) {
            Log.e(this.getClass().getSimpleName(), e.getMessage(),
                    e);
            showDialog(0);
        }
    };

}
