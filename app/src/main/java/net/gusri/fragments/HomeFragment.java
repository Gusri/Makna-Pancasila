package net.gusri.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.gusri.pancasila.R;

//import android.support.app.Fragment;

/**
 * Created by ghostonk on 19/11/16.
 */

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Sign SejarahFragment ke Fragment_sejarah
        View mView = inflater.inflate(R.layout.fragment_home, container, false);
        return mView;
    }
}
