package com.college.gpsbasedonlineticket;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class ThaneVashiRail extends Activity
{
	Spinner tsp_source,tsp_dest;
	Button tproceed,tclear;
	RadioGroup trgGroup;
	RadioButton trbButton_single,trbtnButton_return;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thane_vashi_rail);
		init();
	}
	
	public void init()
	{
		tsp_source = (Spinner) findViewById(R.id.tsp_central);
		tsp_dest = (Spinner) findViewById(R.id.tsp_central);
		trgGroup = (RadioGroup) findViewById(R.id.tbtn_rg);
		trbButton_single = (RadioButton) findViewById(R.id.trbtn_single);
		trbtnButton_return = (RadioButton) findViewById(R.id.trbtn_return);
	}
}
