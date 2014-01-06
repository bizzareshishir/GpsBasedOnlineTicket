package com.college.gpsbasedonlineticket;



import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class CentralRail extends Activity
{
	Spinner sp_source,sp_dest;
	Button proceed,clear;
	RadioGroup rgGroup;
	RadioButton rbButton_single,rbtnButton_return;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.central_rail);
		
		init();
	}
	
	public void init()
	{
		sp_source = (Spinner) findViewById(R.id.sp_central);
		sp_dest = (Spinner) findViewById(R.id.sp_central);
		rgGroup = (RadioGroup) findViewById(R.id.btn_rg);
		rbButton_single = (RadioButton) findViewById(R.id.rbtn_single);
		rbtnButton_return = (RadioButton) findViewById(R.id.rbtn_return);
		
	}
}
