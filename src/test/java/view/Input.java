package view;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import android.app.Activity;
import android.content.*;
import android.graphics.Color;
import android.location.*;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
        implements OnClickListener {

    private LocationManager locationMangaer = null;
    private LocationListener locationListener = null;
    private Button btnGetLocation = null;
    private TextView v_longitude = null;
    private TextView v_latitude = null;
    private TextView v_location = null;
    private TextView v_speed = null;
    private TextView v_altitude = null;
    private TextView v_sat = null;
    private TextView v_gps_status = null;
    private TextView v_update_status = null;
    String longitude = "";
    String latitude = "";
    String location = "";
    String speed = "";
    String altitude = "";
    String sat_nr = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //portrait mode
        v_longitude = (TextView) findViewById(R.id.Lon_view);
        v_latitude = (TextView) findViewById(R.id.Lat_view);
        v_location = (TextView) findViewById(R.id.Loc_view);
        v_speed = (TextView) findViewById(R.id.Spd_view);
        v_altitude = (TextView) findViewById(R.id.Alt_view);
        v_sat = (TextView) findViewById(R.id.Sat_view);
        v_gps_status = (TextView) findViewById(R.id.Gps_status);
        v_update_status = (TextView) findViewById(R.id.Update_status);

        btnGetLocation = (Button) findViewById(R.id.button);
        btnGetLocation.setOnClickListener(this);
        locationMangaer = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
    }

    @Override
    public void onClick(View v) {
        //Check if GPS is enabled
        locationListener = new APPLocationListener();
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            v_gps_status.setText("Wait for signal");
            v_gps_status.setTextColor(Color.parseColor("#0066ff"));
            locationMangaer.requestLocationUpdates(LocationManager
                    .GPS_PROVIDER, 5000, 10, locationListener);
        } else {
            v_gps_status.setText("No GPS-Access!!!");
            v_gps_status.setTextColor(Color.parseColor("#ff0000"));
        }
    }

    private class APPLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location loc) {
            //Try to get city name
            String city_name = null;
            Geocoder gcd = new Geocoder(getBaseContext(),
                    Locale.getDefault());
            List
                    addresses;
            try {
                addresses = gcd.getFromLocation(loc.getLatitude(), loc
                        .getLongitude(), 1);
                if (addresses.size() > 0)
                    city_name = addresses.get(0).getLocality();
            } catch (IOException e) {
                city_name = "unknown";
                e.printStackTrace();
            }
            latitude = "" + loc.getLatitude(); //Get latitude
            longitude = "" + loc.getLongitude(); //Get longitude
            location = "" + city_name; //Get city name
            speed = "" + loc.getSpeed() + " m/s"; //Get speed in meters per second
            altitude = "" + loc.getAltitude() + " m"; //Get height in meters
            sat_nr = "" + loc.getExtras().getInt("satellites"); //available satellites
            v_latitude.setText(latitude);
            v_longitude.setText(longitude);
            v_location.setText(location);
            v_speed.setText(speed);
            v_altitude.setText(altitude);
            v_sat.setText(sat_nr);
            v_gps_status.setText("GPS working");
            v_gps_status.setTextColor(Color.parseColor("#33cc33"));
            Calendar c = Calendar.getInstance(); //Get time on system
            v_update_status.setText("Last update: " + c.get(Calendar.HOUR_OF_DAY) + ":" +
                    c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));
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
        public void onStatusChanged(String provider,
                                    int status, Bundle extras) {
            // TODO Auto-generated method stub
        }
    }
}