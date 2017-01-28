package testnewapp.everythingforward.com.wellnessdoctorside;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by santh on 1/21/2017.
 */

public class GetData extends IntentService {

    private String POST_URL = "http://10.0.2.2/WellnessDashboard/getdata.php";
    public GetData()
    {
        super("GetData");
    }
    public GetData(String name) {
        super(name);
    }

    public static String ACTION_FINISHEDOBTAINING="finished";
    String response = null;


        @Override
        protected void onHandleIntent (Intent intent){



        Log.e("Inside GetData", "Inside GetData");

            try {
                response = HttpRequest.post(POST_URL).body();
                Log.e("InsideGetData",response);

            }
            catch(Exception e)
            {
                showToast("Network Error");

            }





        try {
            if(response!=null) {
                JSONArray array = new JSONArray(response);
                int counter = 0;
                while (!(array.isNull(counter))) {

                    JSONObject object = (JSONObject) array.get(counter);
                 Utility.patientInfos.add(
                            new PatientInfo((String) object.get("username"),
                                    object.getString("anger"),
                                    object.getString("contempt"),
                                    object.getString("disgust"),
                                    object.getString("fear"),
                                    object.getString("happy"),
                                    object.getString("neutral"),
                                    object.getString("sadness"),
                                    object.getString("surprise"),
                                    object.getString("scale"))
                    );


                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }





        Intent broadcast = new Intent(ACTION_FINISHEDOBTAINING);
        sendBroadcast(broadcast);



    }




    public void showToast(String message) {
        final String msg = message;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }

}
