package com.example.vetcare;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.vetcare.R.string.catsymptoms1;

public class CatFragment extends Fragment {

    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_cat, container, false);

        Spinner spinner = v.findViewById(R.id.cat_spinner);
        final TextView textview = v.findViewById(R.id.cat_spin_text);

        ArrayList<String> symptomsList = new ArrayList<>();
        symptomsList.add("Select Symptoms");
        symptomsList.add("Lumps; Swelling; Vomiting; Change in behaviour");
        symptomsList.add("Weight loss; Pale or inflames gums; vision problems; Fever; Respiratory distress");
        symptomsList.add("Sudden changes in behaviour; increased vocalization; disorientation; paralysis");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(Objects.requireNonNull(getContext()),
                android.R.layout.simple_spinner_dropdown_item, symptomsList);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Toast.makeText(getContext(),"Please Select Symptoms", Toast.LENGTH_SHORT).show();
                    textview.setText("Please Select Symptoms from the above list");
                }
                else if (position == 1){
                    textview.setText(Html.fromHtml(getString(catsymptoms1)));
                }
                else if (position == 2){
                    textview.setText(Html.fromHtml(getString(R.string.catsymptoms2)));
                }
                else if (position == 3){
                    textview.setText(Html.fromHtml(getString(R.string.catsymptoms3)));
                }
                else {
                    String sNumber = parent.getItemAtPosition(position).toString();
                    textview.setText(sNumber);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }
}