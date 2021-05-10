package com.example.vetcare;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DoctorFragment extends Fragment {

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_doctor, container, false);

        TextView doctor1 = v.findViewById(R.id.layoutTextDoc1);
        TextView doctor2 = v.findViewById(R.id.layoutTextDoc2);

        doctor1.setText(Html.fromHtml(getString(R.string.doctor1)));
        doctor2.setText(Html.fromHtml(getString(R.string.doctor2)));

        return v;

    }
}