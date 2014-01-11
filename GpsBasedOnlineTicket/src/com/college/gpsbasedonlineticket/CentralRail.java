package com.college.gpsbasedonlineticket;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.bg.task.FareCalculator;
import com.bg.task.UiHandler;
import com.data.Place;

public class CentralRail extends Activity
{
	Context context;
	
	Spinner sp_source,sp_dest;
	Button proceed,clear;
	RadioGroup rgGroup;
	RadioButton rbButton_single,rbtnButton_return;
	
	Button btn_submit_ticket;
	TextView txt_submit_ticket;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.central_rail);
		
		init();
		
		proceed.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				uihandler.sendEmptyMessage(UiHandler.HIT_WEBSERVICE_REQUEST_FARE_DETAILS);
			}
		});
		
		
		btn_submit_ticket.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(context, TicketScreen.class));
				finish();
			}
		});
	}
	
	public void init()
	{
		//distance between source and station should be 500 meters
		
		sp_source = (Spinner) findViewById(R.id.sp_central_from);
		sp_dest = (Spinner) findViewById(R.id.sp_central_to);
		rgGroup = (RadioGroup) findViewById(R.id.btn_rg);
		rbButton_single = (RadioButton) findViewById(R.id.rbtn_single);
		rbtnButton_return = (RadioButton) findViewById(R.id.rbtn_return);
		
		proceed=(Button)findViewById(R.id.btn_proceed);
		
		context = CentralRail.this;
		uihandler.setApplicationContext(context);
		
		btn_submit_ticket=(Button)findViewById(R.id.btn_submit_ticket);
		txt_submit_ticket=(TextView)findViewById(R.id.txt_submit_ticket);
	}
	
	
	UiHandler uihandler = new UiHandler(){
		
		public void handleMessage(android.os.Message msg) {
			
			switch (msg.what) {
			case HIT_WEBSERVICE_REQUEST_FARE_DETAILS:
			
				Place placeObj= new Place();
				placeObj.from = sp_source.getSelectedItem().toString();
				placeObj.to = sp_dest.getSelectedItem().toString();
				
				if(rbButton_single.isChecked()){
					placeObj.way = true;
				}else placeObj.way = false;
				
				new FareCalculator(context, uihandler, placeObj).execute();
				break;
				
			case HIT_WEBSERVICE_PROCESS_FARE_DETAILS:
				
				if (msg != null && msg.obj != null) {
					
					Place  placeDetails = (Place) msg.obj;
					if(placeDetails!=null){
						txt_submit_ticket.setText(placeDetails.toString());
						Log.e("newlog", placeDetails.toString());
					}
				}
				
				break;

			default:
				break;
			}
			
			
		};
		
		
	};
}
