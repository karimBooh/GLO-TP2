package ca.ulaval.ima.tp2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

import ca.ulaval.ima.tp2.ui.Profil;

public class DescriptionActiviy extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        getSupportActionBar().hide();

        Profil profile = getIntent().getParcelableExtra("profil");


        TextView firstnameText = findViewById(R.id.textFirstname);
        TextView lastNameText = findViewById(R.id.textlastname);
        TextView birthdayText = findViewById(R.id.textBirthday);
        TextView sexText = findViewById(R.id.textSex);
        TextView programText = findViewById(R.id.textProgram);
        TextView descriptionText = findViewById(R.id.textDescription);
        ImageView back = findViewById(R.id.back);

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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
