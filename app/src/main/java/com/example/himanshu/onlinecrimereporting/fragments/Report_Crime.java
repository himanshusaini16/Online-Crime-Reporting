package com.example.himanshu.onlinecrimereporting.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.himanshu.onlinecrimereporting.R;


public class Report_Crime extends Fragment implements AdapterView.OnItemSelectedListener {

RadioGroup gender;
    RadioButton male,female;
    String fname, mname, lname, loc, contct, date, time, decsripcrime, victimname, add, cty, stte, postal,spinvalue;
    private static final String DATABASE_NAME = "crimereportdatabase";
    String[] crime_types = {"Select Crime Type:", "Road Traffic Incidents", "Missing Persons", "Fraud", "Antisocial Behaviour", "Lost or Stolen Vehicles", "Civil Disputes"
            , "Lost or found Property", "Kidnapping", "Assault", "Homicide", "Robbery", "Burglary", "Drunk Driving", "False Pretenses"};
    View v;
    ProgressDialog pd;
    Spinner spin;
    EditText first_name, middle_name, last_name, location, contact, crimedate, crimetime, description_crime, victim_name, address, city, state, postal_code;
    Button submit;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_report__crime, container, false);
gender=(RadioGroup)v.findViewById(R.id.radioGroupGender);
        male=(RadioButton)v.findViewById(R.id.radioButtonMale);
        female=(RadioButton)v.findViewById(R.id.radioButtonFemale);
        first_name = (EditText) v.findViewById(R.id.editFirstName);
        last_name = (EditText) v.findViewById(R.id.editLastName);
        middle_name = (EditText) v.findViewById(R.id.editMiddleName);
        location = (EditText) v.findViewById(R.id.editLocation);
        contact = (EditText) v.findViewById(R.id.editContact);
        crimedate = (EditText) v.findViewById(R.id.editDatePicker);
        crimetime = (EditText) v.findViewById(R.id.editTimePicker);
        description_crime = (EditText) v.findViewById(R.id.editCrimeDescription);
        victim_name = (EditText) v.findViewById(R.id.editVictimInfo);
        address = (EditText) v.findViewById(R.id.editAddress);
        city = (EditText) v.findViewById(R.id.editCity);
        state = (EditText) v.findViewById(R.id.editState);
        postal_code = (EditText) v.findViewById(R.id.editPostalCode);
        submit = (Button) v.findViewById(R.id.submit_form);



        spin = (Spinner) v.findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter<String> LTRadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, crime_types);
        LTRadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spin.setAdapter(LTRadapter);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname = first_name.getText().toString().trim();
                mname = middle_name.getText().toString().trim();
                lname = last_name.getText().toString().trim();
                loc = location.getText().toString().trim();
                contct = contact.getText().toString().trim();
                date = crimedate.getText().toString().trim();
                time = crimetime.getText().toString().trim();
                decsripcrime = description_crime.getText().toString().trim();
                victimname = victim_name.getText().toString().trim();
                add = address.getText().toString().trim();
                cty = city.getText().toString().trim();
                stte = state.getText().toString().trim();
                postal = postal_code.getText().toString().trim();



                if (fname.equals("")) {
                    first_name.setError("Please enter your Firstname");
                }

                if (lname.equals("")) {
                    last_name.setError("Please enter your Lastname");
                }
                if (contct.equals("")) {
                    contact.setError("Please enter Contact Number");
                }
                if (date.equals("")) {
                    crimedate.setError("Please enter CrimeDate");
                }
                if (time.equals("")) {
                    crimetime.setError("Please enter CrimeTime");
                }
                if (decsripcrime.equals("")) {
                    description_crime.setError("Please enter Crime Description");
                }
                if (victimname.equals("")) {
                    victim_name.setError("Please enter Victim Name");
                }
                if (add.equals("")) {
                    address.setError("Please enter Address of Crime");
                }
                if (cty.equals("")) {
                    city.setError("Please enter City Name");
                }
                if (stte.equals("")) {
                    state.setError("Please enter State Name");
                }
                if (postal.equals("")) {
                    postal_code.setError("Please enter Postal Code");
                } else {
                    submittedForm();
                    Handler hd = new Handler();
                    hd.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            done();
                            Toast.makeText(getActivity(),"Submitted Successfully",Toast.LENGTH_SHORT).show();
                        }
                    }, 3200);



                }

            }
        });




        return v;
    }

    public void submittedForm() {

        pd = new ProgressDialog(getActivity());
        pd.setMessage("Submitting Form...");
        pd.setCancelable(false);
        pd.show();

        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                pd.dismiss();
            }
        }, 3000);

    }

    public void done() {

        first_name.getText().clear();
        middle_name.getText().clear();
        last_name.getText().clear();
        location.getText().clear();
        contact.getText().clear();
        crimedate.getText().clear();
        crimetime.getText().clear();
        description_crime.getText().clear();
        victim_name.getText().clear();
        address.getText().clear();
        city.getText().clear();
        state.getText().clear();
        postal_code.getText().clear();
        gender.clearCheck();
        spin.setSelection(0);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinvalue = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }

}

