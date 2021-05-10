package com.example.vetcare;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.vetcare.R.string.poultrysymptoms1;
import static com.example.vetcare.R.string.poultrysymptoms2;
import static com.example.vetcare.R.string.poultrysymptoms3;

public class PoultryFragment extends Fragment {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_poultry, container, false);

        Spinner spinner = v.findViewById(R.id.poultry_spinner);
        final TextView textview = v.findViewById(R.id.poultry_spin_text);

        ArrayList<String> symptomsList = new ArrayList<>();
        symptomsList.add("Select Symptoms");
        symptomsList.add("Dark red/white spots; facial swelling; respiratory distress; drop in egg production");
        symptomsList.add("Watery discharge from nostrils; paralysis; trembling");
        symptomsList.add("Feathers roughened; paralysis of legs, wings, neck; vision impairment; irregular pupils");

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
                    textview.setText(Html.fromHtml(getString(poultrysymptoms1)));
                }
                else if (position == 2){
                    textview.setText(Html.fromHtml(getString(poultrysymptoms2)));
                }
                else if (position == 3){
                    textview.setText(Html.fromHtml(getString(poultrysymptoms3)));
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