package com.samerzmd.testicesoapwithparameters;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alexgilleran.icesoap.envelope.SOAPEnvelope;
import com.alexgilleran.icesoap.exception.SOAPException;
import com.alexgilleran.icesoap.observer.SOAP11ListObserver;
import com.alexgilleran.icesoap.request.Request;
import com.alexgilleran.icesoap.request.RequestFactory;
import com.alexgilleran.icesoap.request.impl.RequestFactoryImpl;
import com.alexgilleran.icesoap.soapfault.SOAP11Fault;

import java.util.List;


public class MyActivity extends Activity {
    private RequestFactory requestFactory = new RequestFactoryImpl();
    private String url="http://ws1.parasoft.com/glue/calculator";
    private final String weathersSoapAction ="http://www.parasoft.com/wsdl/calculator/subtract";
    EditText x;
    EditText y;
    Button sub;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        x= (EditText) findViewById(R.id.x);
        y= (EditText) findViewById(R.id.y);
        sub= (Button) findViewById(R.id.cal);
        res= (TextView) findViewById(R.id.res);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SOAPEnvelope envelope=new getSubtractCalculatorEnvelope(x.getText().toString(),y.getText().toString());
                requestFactory.buildListRequest(url, envelope,
                        weathersSoapAction, SubtractResult.class).execute(soapObserver);
            }
        });

    }
    SOAP11ListObserver <SubtractResult> soapObserver=new SOAP11ListObserver<SubtractResult>() {
        @Override
        public void onNewItem(Request<List<SubtractResult>, SOAP11Fault> listSOAP11FaultRequest, SubtractResult subtractResult) {
            Log.d("items arraived:", subtractResult.result);
            res.setText(subtractResult.result);
        }

        @Override
        public void onCompletion(Request<List<SubtractResult>, SOAP11Fault> listSOAP11FaultRequest) {
            Log.d("complated:","all");

        }

        @Override
        public void onException(Request<List<SubtractResult>, SOAP11Fault> listSOAP11FaultRequest, SOAPException e) {
            Log.d("exception:",e.toString());
        }
    };
}
