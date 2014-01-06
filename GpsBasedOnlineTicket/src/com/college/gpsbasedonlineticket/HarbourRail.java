package com.college.gpsbasedonlineticket;



import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class HarbourRail extends Activity
{
	Spinner hsp_source,hsp_dest;
	Button hproceed,hclear;
	RadioGroup hrgGroup;
	RadioButton hrbButton_single,hrbtnButton_return;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.harbour_rail);
		init();
	}
	
	public void init()
	{
		hsp_source =(Spinner) findViewById(R.id.hsp_central);
		hsp_dest = (Spinner) findViewById(R.id.hsp_central);
		hrgGroup = (RadioGroup) findViewById(R.id.hbtn_rg);
		hrbButton_single = (RadioButton) findViewById(R.id.hrbtn_single);
		hrbtnButton_return = (RadioButton)findViewById(R.id.hrbtn_return);
		
	}
}
