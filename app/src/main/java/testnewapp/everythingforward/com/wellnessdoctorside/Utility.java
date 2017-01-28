package testnewapp.everythingforward.com.wellnessdoctorside;

import java.util.ArrayList;

/**
 * Created by santh on 1/22/2017.
 */

public class Utility {

    public static ArrayList<PatientInfo> patientInfos;

    static {

        patientInfos = new ArrayList<PatientInfo>();

    }

    public static void populatearraylist(ArrayList<String> arrayList)
    {

        for(int counter=0;counter<patientInfos.size();counter++)
        {

            arrayList.add(patientInfos.get(counter).getUsername());




        }



    }
}
