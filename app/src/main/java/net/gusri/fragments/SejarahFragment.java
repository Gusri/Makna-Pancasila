package net.gusri.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import net.gusri.pancasila.R;

/**
 * Created by ghostonk on 21/11/16.
 */

public class SejarahFragment extends Fragment {
    private ImageView mGambar;
    private TextView mKeterangan;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Sign SejarahFragment ke Fragment_sejarah
        View mView = inflater.inflate(R.layout.fragment_sejarah, container, false);

        mGambar = (ImageView) mView.findViewById(R.id.img_BPUPKI);
        mGambar.setImageResource(R.drawable.sejarah);

        mKeterangan = (TextView) mView.findViewById(R.id.txt_ketBPUPKI);
        mKeterangan.setText(R.string.Gambar1);

        //Panggil html ke Fragment
        final WebView mWb = (WebView) mView.findViewById(R.id.wv_sejarah);
        mWb.loadUrl("file:///android_asset/web/pagesejarah.html");
        mWb.getSettings().setJavaScriptEnabled(true);
        return mView;
    }
}


