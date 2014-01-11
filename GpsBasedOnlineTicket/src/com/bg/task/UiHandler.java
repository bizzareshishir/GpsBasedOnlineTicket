package com.bg.task;

import android.content.Context;
import android.os.Handler;

public class UiHandler extends Handler{

	Context applicationContext;

	public void setApplicationContext(Context applicationContext) {
		this.applicationContext = applicationContext;
	}

	public Context getApplicationContext() {
		return applicationContext;
	}

	public static final int HIT_WEBSERVICE_REQUEST_FARE_DETAILS= 100;
	public static final int HIT_WEBSERVICE_PROCESS_FARE_DETAILS= 101;
	
}
