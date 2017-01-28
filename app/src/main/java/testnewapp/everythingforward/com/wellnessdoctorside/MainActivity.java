package testnewapp.everythingforward.com.wellnessdoctorside;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ImageView listPatientsIV;
    BroadcastReceiver receiver = null;
    IntentFilter filter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listPatientsIV = (ImageView)findViewById(R.id.listpatientsButton);

        listPatientsIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Processing", Toast.LENGTH_SHORT).show();
              /*  Intent intent = new Intent(MainActivity.this,GetData.class);
                startService(intent);*/
                Intent intenttwo = new Intent(MainActivity.this,DisplayPatients.class);
                startActivity(intenttwo);


            }
        });

        filter = new IntentFilter(GetData.ACTION_FINISHEDOBTAINING);

         receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                Intent intenttwo = new Intent(MainActivity.this,DisplayPatients.class);
                startActivity(intenttwo);

            }
        };




    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(receiver,filter);

        Utility.patientInfos.add(
                new PatientInfo("Santhosh", "6.500E-4", "0.003453724",
                        "0.00496736635",
                        "0.04312", "1.487E-4", "0.612", "0.311", "0.022", "0.5042")
        );
        Utility.patientInfos.add(
                new PatientInfo("Santhosh", "6.500E-4", "0.00257283",
                        "0.00496723",
                        "0.023312", "1.48123E-4", "0.61235", "0.1231", "0.0589", "0.6124")
        );
        Utility.patientInfos.add(
                new PatientInfo("Santhosh", "6.500E-4", "0.003453724",
                        "0.00496736635",
                        "0.04312", "1.487E-4", "0.612", "0.311", "0.022", "0.1452")
        );
        Utility.patientInfos.add(
                new PatientInfo("Santhosh", "6.500E-4", "0.003453724",
                        "0.00496736635",
                        "0.04312", "1.487E-4", "0.612", "0.311", "0.022", "0.1352")
        );

        Utility.patientInfos.add(
                new PatientInfo("Santhosh", "8.5471E-4", "0.001264",
                        "8.8117E-4",
                        "0.5274", "0.001500", "0.003988", "0.448", "0.01517", "0.00267")
        );

    }

    @Override
    protected void onPause() {
        super.onPause();

        if(receiver!=null) {

            unregisterReceiver(receiver);
        }


    }
}
