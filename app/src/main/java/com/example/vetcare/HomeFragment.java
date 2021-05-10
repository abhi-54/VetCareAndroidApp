package com.example.vetcare;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.example.vetcare.R.string.home_string1;


public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_home, container, false);

        TextView textView = v.findViewById(R.id.home_text);
        textView.setText(Html.fromHtml(getString(home_string1)));

        Button button = v.findViewById(R.id.button_talktoDoc);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                getChildFragmentManager().beginTransaction().replace(R.id.layoutOfHome,
                        new DoctorFragment()).commit();
            }
        });

        return v;
    }
}
