import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.misapps.ep_angelute_sensoresgeolocalizacion_291125.R;

public class MainActivity extends AppCompatActivity implements OnSensorDataListener {

    private MapaFragment mapaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            SensorFragment sensorFragment = new SensorFragment();
            mapaFragment = new MapaFragment();


            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.sensor_fragment_container, sensorFragment)
                    .replace(R.id.map_fragment_container, mapaFragment, "mapa_fragment_tag")
                    .commit();
        } else {

            mapaFragment = (MapaFragment) getSupportFragmentManager().findFragmentByTag("mapa_fragment_tag");
        }
    }



    @Override
    public void onSensorDataChanged(float[] values) {

    }

    @Override
    public void onDeviceMoved() {

        if (mapaFragment != null) {
            mapaFragment.onDeviceMoved();
        }
    }
}
