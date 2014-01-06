package com.college.gpsbasedonlineticket;



import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class RegistrationForm extends Activity
{
	
	EditText edt_name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration_1);
		
		init();
	}
	
	private void init()
	{
		
	}
}
