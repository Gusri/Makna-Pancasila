package net.gusri.tabs1;

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
 * Created by ghostonk on 26/11/16.
 */

public class Sila1aFragment extends Fragment{
    private ImageView mLambang;
    private TextView mKeterangan;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Sign Sila1aFragment ke Layout fragment_tab1
        View mView = inflater.inflate(R.layout.fragment_tab1, container, false);

        mLambang = (ImageView) mView.findViewById(R.id.img_Lambang);
        mLambang.setImageResource(R.drawable.img_sila1);

        mKeterangan = (TextView) mView.findViewById(R.id.txt_lambang);
        mKeterangan.setText(R.string.Gambar2);

        final WebView mWb = (WebView) mView.findViewById(R.id.wv_Tab1);
        mWb.loadUrl("file:///android_asset/web/sila1/pagelmbA.html");
        mWb.getSettings().setJavaScriptEnabled(true);

        return mView;
    }
}
