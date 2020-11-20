import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TrackGPS extends Service implements LocationListener {
    private final Context ctxt; //reference to current activity
    boolean checkGPS = false; //check if GPS available
    boolean checkNetwork = false; //check if WIFI location available
    boolean canGetLocation = false; //true if GPS or WIFI available

    Location loc; //variable to store current location
    protected  LocationManager locationManager;
    double latitude;
    double longitude;

    private static final long MINDISTANCE = 10; //min distance required to update location
    private static final long MINDELAY = 1000 * 60; //min time between updates

    public TrackGPS(Context ctxt){
        this.ctxt = ctxt;
        getLocation();
    }

    public double getLatitude(){
        if(loc!= null) return loc.getLatitude();
        return latitude;
    }

    public double getLongitude(){
        if(loc != null) return loc.getLongitude();
        return longitude;
    }

    public boolean canGetLocation(){
        return this.canGetLocation;
    }




    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }

    private Location getLocation() {
        try{
            locationManager = (LocationManager) ctxt.getSystemService(LOCATION_SERVICE);

            //get GPS status
            checkGPS = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            //get network status
            checkNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            if(!checkGPS && !checkNetwork){
                Toast.makeText(ctxt, "no service provider available", Toast.LENGTH_LONG).show();
            }else{
                canGetLocation = true;
                //get provider, prefer to use network if both available
                String provider = checkNetwork ? LocationManager.NETWORK_PROVIDER : LocationManager.GPS_PROVIDER;
                try{
                    locationManager.requestLocationUpdates(provider, MINDELAY, MINDISTANCE, this);
                    if(locationManager != null){
                        loc = locationManager.getLastKnownLocation(provider);
                        if(loc != null){
                            latitude = loc.getLatitude();
                            longitude = loc.getLongitude();
                        }
                    }

                } catch (SecurityException e){
                    Toast.makeText(ctxt, "no permission to access provider", Toast.LENGTH_LONG).show();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return loc;

    }

}
