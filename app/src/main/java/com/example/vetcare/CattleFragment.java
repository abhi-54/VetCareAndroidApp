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

import static com.example.vetcare.R.string.cattlesymptoms1;

public class CattleFragment extends Fragment {

    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_cattle, container, false);

        Spinner spinner = v.findViewById(R.id.cattle_spinner);
        final TextView textview = v.findViewById(R.id.cattle_spin_text);

        ArrayList<String> symptomsList = new ArrayList<>();
        symptomsList.add("Select Symptoms");
        symptomsList.add("Fever(around 40ºC); saliva hanging out from mouth");
        symptomsList.add("Difficulty breathing; high temperature");
        symptomsList.add("Fever (41ºC-43ºC); high swelling; stops ruminating");
        symptomsList.add("Sudden changes in behaviour; difficulty swallowing");

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
                    textview.setText(Html.fromHtml(getString(cattlesymptoms1)));
                }
                else if (position == 2){
                    textview.setText(Html.fromHtml(getString(R.string.cattlesymptoms2)));
                }
                else if (position == 3){
                    textview.setText(Html.fromHtml(getString(R.string.cattlesymptoms3)));
                }
                else if (position == 4){
                    textview.setText(Html.fromHtml(getString(R.string.cattlesymptoms4)));
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