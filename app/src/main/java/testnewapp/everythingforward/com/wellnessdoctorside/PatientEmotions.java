package testnewapp.everythingforward.com.wellnessdoctorside;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PatientEmotions extends AppCompatActivity {
    TextView happinessTV,neutralTV,sadnessTV,disgustTV,fearTV,scaleTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_emotions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<String> getlist = getIntent().getStringArrayListExtra(Intent.EXTRA_TEXT);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        happinessTV = (TextView)findViewById(R.id.happiness_val);
        neutralTV = (TextView)findViewById(R.id.neutral_val);
        sadnessTV = (TextView)findViewById(R.id.sadness_val);
        disgustTV = (TextView)findViewById(R.id.disgust_val);
        fearTV = (TextView)findViewById(R.id.fear_val);
        scaleTV = (TextView)findViewById(R.id.scale_val);

        happinessTV.setText(getlist.get(0));
        neutralTV.setText(getlist.get(1));
        sadnessTV.setText(getlist.get(2));
        disgustTV.setText(getlist.get(3));
        fearTV.setText(getlist.get(4));
        scaleTV.setText(getlist.get(5));
    }

}
