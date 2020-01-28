package com.ravi.newsNyTimes.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.test.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Ravi Paul on 2020-01-27.
 */
public class UtilTest {

    private Util myUtil;

    @Before
    public void setUp() throws Exception {
        myUtil = new Util();
    }

    @Test
    public void isOnline() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        ConnectivityManager cm = (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        assertNotNull(cm);
    }

}