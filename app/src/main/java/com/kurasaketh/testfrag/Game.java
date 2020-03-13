package com.kurasaketh.testfrag;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Game extends Fragment {
    TextView timer;
    TextView name;
    Button button;
    SharedPreferences sharedPreferences;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        sharedPreferences = getActivity().getSharedPreferences("com.TestFrag.app", Context.MODE_PRIVATE);

        View v = inflater.inflate(R.layout.game, container, false);
        name = v.findViewById(R.id.name);
        name.setText(sharedPreferences.getString("name", "User"));
        button = v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        timer = v.findViewById(R.id.timer);



        new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                timer.setText("Timer: " + millisUntilFinished / 1000 + " seconds left");
            }

            public void onFinish() {
                timer.setText("Done!");
            }
        }.start();


        return v;
    }

}
