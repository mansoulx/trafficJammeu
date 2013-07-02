package sn.gotech.trafficjammeu;

import sn.gotech.trafficjammeu.MyLocation.LocationResult;
import sn.gotech.trafficjammeu.R;
import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends Activity implements OnMapLongClickListener, LocationListener  {

	static final LatLng HAMBURG = new LatLng(53.558, 9.927);
	static final LatLng KIEL = new LatLng(53.551, 9.993);
	private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                .getMap();
            
            if (map!=null){
              Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG)
                  .title("Hamburg"));
              Marker kiel = map.addMarker(new MarkerOptions()
                  .position(KIEL)
                  .title("Kiel")
                  .snippet("Kiel is cool")
                  .icon(BitmapDescriptorFactory
                      .fromResource(R.drawable.ic_launcher)));
              
            //Move the camera instantly to hamburg with a zoom of 15.
//              map.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG, 15));
//
//              // Zoom in, animating the camera.
//              map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null); 
              map.setMyLocationEnabled(true);
              map.setOnMapLongClickListener(this);
              
              LocationResult locationResult = new LocationResult() {
				
				@Override
				public void goToLocation(Location location) {
					// TODO Auto-generated method stub
					
				}
			};
            	MyLocation myLocation = new MyLocation();
            	myLocation.getLocation(this, locationResult);
            }
    }

	@Override
	public void onMapLongClick(LatLng point) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "blabla", 5000).show();
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
	    map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude())));
        map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null); 
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
}
