package youp.zvh_android.fragments;




import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import youp.zvh_android.fragments.MeasurementStep1Fragment;
import youp.zvh_android.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    View view;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);

        if (container != null) {
            container.removeAllViews();
        }

        Button btn = view.findViewById(R.id.metingBtn);
        btn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.metingBtn:
                MeasurementStep1Fragment nextFrag = new MeasurementStep1Fragment();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content, nextFrag)
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
