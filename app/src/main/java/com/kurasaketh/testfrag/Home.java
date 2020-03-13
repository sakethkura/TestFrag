package com.kurasaketh.testfrag;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Home extends Fragment {
    TextView home;
    EditText name;
    Button button;
    SharedPreferences sharedPreferences;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home, container, false);
        sharedPreferences = getActivity().getSharedPreferences("com.TestFrag.app", Context.MODE_PRIVATE);

        home = v.findViewById(R.id.home);
        button = v.findViewById(R.id.button);
        name = v.findViewById(R.id.namebox);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", String.valueOf(name.getText()));
                editor.apply();
                Log.i("msg", sharedPreferences.getString("name", "User"));
            }
        });

        return v;
    }

}
