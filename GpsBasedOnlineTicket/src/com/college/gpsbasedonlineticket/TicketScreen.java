package com.college.gpsbasedonlineticket;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import com.commonsware.cwac.locpoll.demo.LocationReceiver;
import com.commonsware.cwac.tracker.service.network.LocationPollerNetwork;

public class TicketScreen extends Activity{
	
	
	public static final int PERIOD = 60000; // 1 minute
	
	private PendingIntent piNtw = null;
	private AlarmManager mgrNtw = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.ticket_layout);
		
		initiate();
	}
	
	
	private void initiate() {
		// TODO Auto-generated method stub
		Log.e("newlog", "initiate");
		mgrNtw = (AlarmManager) getSystemService(ALARM_SERVICE);
		piNtw = PendingIntent.getBroadcast(this, 0,
				getIntentNetwork(LocationManager.GPS_PROVIDER), 0);
		mgrNtw.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
				SystemClock.elapsedRealtime(), PERIOD, piNtw);
		
		Toast.makeText(this, "Tracking commenced", Toast.LENGTH_LONG).show();
		
	}
	
	Intent getIntentNetwork(String PROVIDER) {

		Intent intent = new Intent(this, LocationPollerNetwork.class);

		intent.putExtra(LocationPollerNetwork.EXTRA_INTENT, new Intent(this,
				LocationReceiver.class));
		intent.putExtra(LocationPollerNetwork.EXTRA_PROVIDER, PROVIDER);

		return intent;
	}
}
