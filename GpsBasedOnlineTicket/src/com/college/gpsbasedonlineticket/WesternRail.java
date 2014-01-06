package com.college.gpsbasedonlineticket;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class WesternRail extends Activity
{
	Spinner wsp_source,wsp_dest;
	Button wproceed,wclear;
	RadioGroup wrgGroup;
	RadioButton wrbButton_single,wrbtnButton_return;	
	
	@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.western_rail);
			init();
		}
	public void init()
	{
		wsp_source = (Spinner) findViewById(R.id.wsp_central);
		wsp_dest = (Spinner) findViewById(R.id.wsp_central);
		wrgGroup = (RadioGroup) findViewById(R.id.wbtn_rg);
		wrbButton_single = (RadioButton) findViewById(R.id.wrbtn_single);
		wrbtnButton_return = (RadioButton) findViewById(R.id.wrbtn_return);
		
	}
}
