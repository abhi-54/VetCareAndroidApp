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

import static com.example.vetcare.R.string.sheepgoatsymptoms1;
import static com.example.vetcare.R.string.sheepgoatsymptoms2;
import static com.example.vetcare.R.string.sheepgoatsymptoms3;
import static com.example.vetcare.R.string.sheepgoatsymptoms4;
import static com.example.vetcare.R.string.sheepgoatsymptoms5;

public class SheepandGoatFragment extends Fragment {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_sheepandgoat, container, false);

        Spinner spinner = v.findViewById(R.id.sheepgoat_spinner);
        final TextView textview = v.findViewById(R.id.sheepgoat_spin_text);

        ArrayList<String> symptomsList = new ArrayList<>();
        symptomsList.add("Select Symptoms");
        symptomsList.add("Sudden rectal temperature (40°-41°C); dullness; coughing; serous discharge from eyes & nostrils");
        symptomsList.add("Symptoms of pneumonia; skin lesions");
        symptomsList.add("Wound infection; unsteady walking; suffocation; muscle stiffness");
        symptomsList.add("Moist, swollen skin; weight gain; severe lameness");
        symptomsList.add("Red ulcers develop around mouth");

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
                    textview.setText(Html.fromHtml(getString(sheepgoatsymptoms1)));
                }
                else if (position == 2){
                    textview.setText(Html.fromHtml(getString(sheepgoatsymptoms2)));
                }
                else if (position == 3){
                    textview.setText(Html.fromHtml(getString(sheepgoatsymptoms3)));
                }
                else if (position == 4){
                    textview.setText(Html.fromHtml(getString(sheepgoatsymptoms4)));
                }
                else if (position == 5){
                    textview.setText(Html.fromHtml(getString(sheepgoatsymptoms5)));
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
