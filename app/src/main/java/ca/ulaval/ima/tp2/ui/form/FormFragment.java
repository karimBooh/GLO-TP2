package ca.ulaval.ima.tp2.ui.form;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ca.ulaval.ima.tp2.DescriptionActiviy;
import ca.ulaval.ima.tp2.R;
import ca.ulaval.ima.tp2.ui.Profil;

public class FormFragment extends Fragment {


    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, final Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_form, container, false);

        final SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        Date date = new Date();

        try {
            date = format.parse("19-11-1995");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        final Profil profil = new Profil("Karim", "Boulaich", date, "111 274 529", true, "GLO");


        final EditText firstName = root.findViewById(R.id.firstNameInput);
        final EditText lastName = root.findViewById(R.id.lastNameInput);
        final EditText birthday = root.findViewById(R.id.brithdayInput);
        final Spinner program = root.findViewById(R.id.spinnerProgram);
        Button submit = root.findViewById(R.id.submit);

        final RadioGroup radioGroup = root.findViewById(R.id.radioGroup);
        final RadioButton male = root.findViewById(R.id.radioMale);
        male.setChecked(true);

        firstName.setText(profil.getFirstname());
        lastName.setText(profil.getLastname());
        birthday.setText(format.format(profil.getBirthday()));

        String[] items = new String[]{"GEL", "GIF", "GLO", "IFT"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_dropdown_item,items);
        program.setAdapter(adapter);

        final Calendar newCalendar = Calendar.getInstance();
        final DatePickerDialog  StartTime = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                birthday.setText(format.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));


        birthday.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                StartTime.show();
                return false;
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!firstName.getText().toString().equals("") &&
                        !lastName.getText().toString().equals("") &&
                        !birthday.getText().toString().equals("") &&
                radioGroup.getCheckedRadioButtonId() != -1)
                {
                    profil.setFirstname(firstName.getText().toString());
                    profil.setLastname(lastName.getText().toString());
                    profil.setSex(male.isChecked());
                    profil.setProgram(program.getSelectedItem().toString());
                    try {
                        profil.setBirthday(format.parse(birthday.getText().toString()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Intent intent = new Intent(getContext(), DescriptionActiviy.class);
                    intent.putExtra("profil", profil);
                    startActivity(intent);
                }
            }
        });

        return root;
    }
}