package com.college.gpsbasedonlineticket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends Activity {
	String DISTANCE = "", FIRST = "", SECOND = "";
	Button btn_cent, btn_wes, btn_thane_vashi, btn_harbour;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		init();

		final Intent c = new Intent(this, CentralRail.class);
		final Intent w = new Intent(this, WesternRail.class);
		final Intent h = new Intent(this, HarbourRail.class);
		final Intent t = new Intent(this, ThaneVashiRail.class);

		btn_cent.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(c);
			}
		});
		btn_wes.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(w);
			}

		});
		btn_harbour.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(h);
			}

		});
		btn_thane_vashi.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(t);
			}

		});

	}

	public void init() {
		btn_cent = (Button) findViewById(R.id.btn_central);
		btn_wes = (Button) findViewById(R.id.btn_western);
		btn_thane_vashi = (Button) findViewById(R.id.btn_thane_vashi);
		btn_harbour = (Button) findViewById(R.id.btn_harbour);

	}

}