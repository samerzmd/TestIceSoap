package com.samerzmd.testicesoapwithparameters;

import com.alexgilleran.icesoap.annotation.XMLField;
import com.alexgilleran.icesoap.annotation.XMLObject;

/**
 * Created by CubicArt on 8/18/14.
 */
@XMLObject("//subtractResponse")
public class SubtractResult {
    @XMLField("Result")
    String result;
}
