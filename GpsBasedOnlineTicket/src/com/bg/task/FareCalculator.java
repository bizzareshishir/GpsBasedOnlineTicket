package com.bg.task;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.data.Place;

public class FareCalculator extends AsyncTask<Void, Void, Void>{
	

	ArrayList<String> list = new ArrayList<String>();
	ProgressDialog pd;
	
	Context context;
	Place place;
	Handler uihandler;
	public FareCalculator(Context context,Handler handler,Place place) {
		// TODO Auto-generated constructor stub
		this.context=context;
		this.place=place;
		this.uihandler=handler;
	}

	@Override
	protected void onPreExecute() {

		pd = new ProgressDialog(context);
		pd.setMessage("Getting Fare Details");
		pd.show();
		super.onPreExecute();
	}

	public void OnDestory1() {
		if (pd != null) {
			pd.dismiss();
		}
	}

	@Override
	protected Void doInBackground(Void... params) {
		// Create URL string
		String URL = "http://mumbailifeline.com/m/timetable.php?sfrom="
				+ place.from + "&sto=" + place.to + "&time1=11%3A00+AM&Submit=Search";
		
		Log.e("newlog", URL);
		try {
			Document doc = null;
			InputStream is = null;
			String url = URL;
			is = new URL(url).openStream();
			doc = Jsoup.parse(is, "utf-8", url);
			is.close();

			org.jsoup.select.Elements tables = doc.select("#static-style");
			Log.e("TAG", tables.get(0).text().toString());

			String SPLIT[] = tables.get(0).text().toString().split(" ");
			for (int i = 0; i < SPLIT.length; i++) {
				if (isNumeric(SPLIT[i])) {
					Log.e("TAG", SPLIT[i]);
					list.add(SPLIT[i]);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			Log.e("TAG", e.toString());
		}

		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		pd.dismiss();
		Place palceObj = new Place();
		try {
			palceObj.from =place.from;
			palceObj.to =place.to;
			
			if(place.way){
			palceObj.distance = list.get(0);
			palceObj.firstclass = list.get(1);
			palceObj.secondclass = list.get(2);
			}else{
				palceObj.distance =(2* Integer.parseInt(list.get(0)))+"";
				palceObj.firstclass = (2* Integer.parseInt(list.get(1)))+"";
				palceObj.secondclass = (2* Integer.parseInt(list.get(2)))+"";
			}
				
			
			Log.e("newlog",palceObj.toString());
			setTextDetails();

		} catch (Exception e) {
			// TODO: handle exception
			Log.e("TAG", e.toString());
		}

		Message msg = uihandler.obtainMessage();
		msg.what=UiHandler.HIT_WEBSERVICE_PROCESS_FARE_DETAILS;
		msg.obj = palceObj;
		uihandler.sendMessage(msg);
		
		
		super.onPostExecute(result);
	}

	private void setTextDetails() {

		// Place of 24 pass value fare b/w two
		// station as per login ---
		{
			//Log.e("newlog", "" + (24 * Integer.parseInt(SECOND.trim())));
			
		} 
		{
			//Log.e("newlog",""+ (3 * 24 * Integer.parseInt(SECOND.trim())));
			
		}
	}

	public boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
		// match a number with
		// optional '-' and decimal.
	}



}

