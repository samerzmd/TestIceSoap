package com.samerzmd.testicesoapwithparameters;

import com.alexgilleran.icesoap.envelope.impl.BaseSOAP11Envelope;
import com.alexgilleran.icesoap.xml.XMLParentNode;

/**
 * Created by CubicArt on 8/18/14.
 */
public class getSubtractCalculatorEnvelope extends BaseSOAP11Envelope {
    public static final String NAME_SPACE="http://www.parasoft.com/wsdl/calculator/";
    public getSubtractCalculatorEnvelope(String x, String y){
        declarePrefix("cal",NAME_SPACE);
        XMLParentNode defineSubtract=getBody().addNode(super.getNamespace(), "subtract");
        defineSubtract.addTextNode(NAME_SPACE, "x", x);
        defineSubtract.addTextNode(NAME_SPACE,"y", y);
    }
}
