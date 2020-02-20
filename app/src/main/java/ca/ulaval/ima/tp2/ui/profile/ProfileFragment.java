package ca.ulaval.ima.tp2.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ca.ulaval.ima.tp2.R;
import ca.ulaval.ima.tp2.ui.Profil;

public class ProfileFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        final SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        Date date = new Date();

        try {
            date = format.parse("19-11-1995");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        final Profil profile = new Profil("Karim", "Boulaich", date, "111 274 529", true, "GLO");
        TextView firstnameText = root.findViewById(R.id.textFirstname);
        TextView lastNameText = root.findViewById(R.id.textlastname);
        TextView birthdayText = root.findViewById(R.id.textBirthday);
        TextView sexText = root.findViewById(R.id.textSex);
        TextView programText = root.findViewById(R.id.textProgram);
        TextView descriptionText = root.findViewById(R.id.textDescription);

        firstnameText.setText(profile.getFirstname());
        lastNameText.setText(profile.getLastname());
        birthdayText.setText(new SimpleDateFormat("dd-mm-yyyy").format(profile.getBirthday().getTime()));
        if(profile.getSex())
            sexText.setText("Masculin");
        else
            sexText.setText("Feminin");
        programText.setText(profile.getProgram());

        InputStream is = getResources().openRawResource(R.raw.ma_description);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        String entireFile = "";
        try {
            while((line = br.readLine()) != null) {
                entireFile += (line + "\n");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        descriptionText.setText(entireFile);
        return root;
    }
}