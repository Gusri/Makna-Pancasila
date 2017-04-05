package net.gusri.tabs1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.gusri.pancasila.R;

import java.util.ArrayList;

/**
 * Created by ghostonk on 25/11/16.
 */

public class TabSila1Fragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private VPAdapterS1 mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Sign TabSila1Fragment ke Layout konten_tab
        View mView = inflater.inflate(R.layout.kontent_tab, container, false);
        mAdapter = new VPAdapterS1(getActivity().getSupportFragmentManager());
        mViewPager = (ViewPager) mView.findViewById(R.id.vp_Tab);
        mViewPager.setAdapter(mAdapter);

        mTabLayout = (TabLayout) mView.findViewById(R.id.tab_Layout);
        mTabLayout.setupWithViewPager(mViewPager);

        return mView;
    }

    public class VPAdapterS1 extends FragmentStatePagerAdapter {

        private final ArrayList<Fragment> mFragment;
        private final ArrayList<String> mTitle;

        public VPAdapterS1(FragmentManager fm) {
            super(fm);
            mFragment = new ArrayList<Fragment>(3);
            mFragment.add(new Sila1aFragment());
            mFragment.add(new Sila1bFragment());
            mFragment.add(new Sila1cFragment());

            mTitle = new ArrayList<String>(mFragment.size());
            mTitle.add(getString(R.string.Tab1));
            mTitle.add(getString(R.string.Tab2));
            mTitle.add(getString(R.string.Tab3));
        }

        @Override
        public Fragment getItem(int position) {
            return mFragment.get(position);
        }

        @Override
        public int getCount() {
            return mFragment.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle.get(position);
        }
    }


}
