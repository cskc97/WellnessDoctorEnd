package testnewapp.everythingforward.com.wellnessdoctorside;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayPatients extends AppCompatActivity {

    ListView listView;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_patients);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView)findViewById(R.id.listview);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ArrayList<String> usernamesList = new ArrayList<String>();
        Utility.populatearraylist(usernamesList);


         arrayAdapter = new ArrayAdapter(getApplicationContext(),R.layout.listviewitem,R.id.listitemviewid,usernamesList);












    }

    @Override
    protected void onStart() {
        super.onStart();

        listView.setAdapter(arrayAdapter);

    }


    @Override
    protected void onResume() {
        super.onResume();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PatientInfo info = Utility.patientInfos.get(position);

                ArrayList<String> arrayList = new ArrayList<String>();
                arrayList.add(info.getHappy());
                arrayList.add(info.getNeutral());
                arrayList.add(info.getSadness());
                arrayList.add(info.getDisgust());
                arrayList.add(info.getFear());
                arrayList.add(info.getScale());

                Intent intent = new Intent(DisplayPatients.this,PatientEmotions.class);
                intent.putStringArrayListExtra(Intent.EXTRA_TEXT,arrayList);
                startActivity(intent);


              //  Toast.makeText(DisplayPatients.this, , Toast.LENGTH_SHORT).show();



            }
        });



    }
}
