package youp.zvh_android.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

import youp.zvh_android.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeasurementFragment extends Fragment {

    private View v;
    TextView dateText;

    public MeasurementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_measurement_step1, container, false);

        dateText = v.findViewById(R.id.dateText);

        dateText.setText(DateFormat.getDateTimeInstance().format(new Date()));

        return v;


    }

}
