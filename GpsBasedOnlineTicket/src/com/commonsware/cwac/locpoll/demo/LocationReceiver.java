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


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import com.commonsware.cwac.tracker.service.network.LocationPollerNetwork;

public class LocationReceiver extends BroadcastReceiver {
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		getLocationFromNetwork(intent, context);

	}

	private void getLocationFromNetwork(Intent intent, Context context) {
		try {
			Bundle b = intent.getExtras();
			Location loc = (Location) b.get(LocationPollerNetwork.EXTRA_LOCATION);
			if (loc == null) {
				loc = (Location) b.get(LocationPollerNetwork.EXTRA_LASTKNOWN);
				if (loc != null) {
					
					
				}
			}
			if (loc != null && loc.getProvider().equals(LocationManager.NETWORK_PROVIDER)) {
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}