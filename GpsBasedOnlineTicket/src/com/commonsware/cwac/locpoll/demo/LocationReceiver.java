/***
  Copyright (c) 2010 CommonsWare, LLC
  
  Licensed under the Apache License, Version 2.0 (the "License"); you may
  not use this file except in compliance with the License. You may obtain
  a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */

package com.commonsware.cwac.locpoll.demo;


import java.util.List;
import java.util.Locale;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.commonsware.cwac.tracker.service.network.LocationPollerNetwork;

public class LocationReceiver extends BroadcastReceiver {
	
	Context context;
	@Override
	public void onReceive(Context context, Intent intent) {
		
		this.context=context;
		getLocationFromNetwork(intent, context);

	}

	private void getLocationFromNetwork(Intent intent, Context context) {
		try {
			Bundle b = intent.getExtras();
			Location loc = (Location) b.get(LocationPollerNetwork.EXTRA_LOCATION);
			Log.e("locationlogs", loc+"--value of null");
			
			if (loc == null) {
				loc = (Location) b.get(LocationPollerNetwork.EXTRA_LASTKNOWN);
				if (loc != null) {
					
					//
					Log.e("locationlogs", loc.getLatitude()+","+loc.getLongitude());
			Toast.makeText(context, loc.getLatitude()+","+loc.getLongitude(), Toast.LENGTH_LONG).show();
			
		    Location params[]={loc};
			new AsyncAddress().execute(params);
					
				}
			}
			if (loc != null && loc.getProvider().equals(LocationManager.NETWORK_PROVIDER)) {
				
				//
				Toast.makeText(context, loc.getLatitude()+","+loc.getLongitude(), Toast.LENGTH_LONG).show();
				 Location params[]={loc};
				new AsyncAddress().execute(params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	class AsyncAddress extends AsyncTask<Location, Void, Void>{

		String lcoaton= "";
		
		Location loc = null;
		
		@Override
		protected Void doInBackground(Location... params) {
			// TODO Auto-generated method stub
			loc=params[0];
			
			lcoaton=getAddressFromLatLon(context, params[0].getLatitude(), params[0].getLongitude());
			
			return null;
			
		}
		
		public  float distFrom(double lat1, double lng1, double lat2, double lng2) {
		    double earthRadius = 3958.75;
		    double dLat = Math.toRadians(lat2-lat1);
		    double dLng = Math.toRadians(lng2-lng1);
		    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
		               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
		               Math.sin(dLng/2) * Math.sin(dLng/2);
		    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		    double dist = earthRadius * c;

		    int meterConversion = 1609;

		    return new Float(dist * meterConversion).floatValue();
		    }
		
		public  String getAddressFromLatLon(Context context, double latitude,
				double longitude) {
			try {
				Geocoder geocoder;
				List<Address> addresses;
				geocoder = new Geocoder(context, Locale.getDefault());
				addresses = geocoder.getFromLocation(latitude, longitude, 1);

				return addresses.get(0).getAddressLine(0) + " "
						+ addresses.get(0).getAddressLine(1) + " "
						+ addresses.get(0).getAddressLine(2);

			} catch (Exception e) {
				// TODO: handle exception
				Log.e("PEOPLE", "GET ADDRESS "+e.toString());
				return "";
			}

		}
		
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			Toast.makeText(context,lcoaton, Toast.LENGTH_LONG).show();
			 Toast.makeText(context, distFrom( loc.getLatitude(),  loc.getLongitude(), 19.218107,73.087329)+"" , Toast.LENGTH_LONG).show();
			super.onPostExecute(result);
		}
		
	}
}