package net.gusri.pancasila;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import net.gusri.fragments.HomeFragment;
import net.gusri.fragments.SejarahFragment;
import net.gusri.tabs1.TabSila1Fragment;
import net.gusri.tabs2.TabSila2Fragment;
import net.gusri.tabs3.TabSila3Fragment;
import net.gusri.tabs4.TabSila4Fragment;
import net.gusri.tabs5.TabSila5fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mNavDrawer;
    private ActionBarDrawerToggle mBarToggle;
    private NavigationView mNavView;
    private Toolbar mToolbar;
    private FragmentManager mManager = getSupportFragmentManager();
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.Bar);
        setSupportActionBar(mToolbar);
        mNavDrawer = (DrawerLayout) findViewById(R.id.activity_main);
        mBarToggle = new ActionBarDrawerToggle(this, mNavDrawer, R.string.open, R.string.close);
        mNavView = (NavigationView) findViewById(R.id.nav_View);

        mNavDrawer.addDrawerListener(mBarToggle);
        mBarToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mNavView.setNavigationItemSelectedListener(this);

        //Panggil HomeFragment ke menu utama
        mManager.beginTransaction().replace(R.id.cont_Frame, new HomeFragment()).commit();

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    @Override
    public void onBackPressed(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Apakah anda ingin keluar dari App?");
        builder.setCancelable(true);
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mBarToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_dasar) {
            mManager.beginTransaction().replace(R.id.cont_Frame, new HomeFragment()).commit();
            getSupportActionBar().setTitle(R.string.st_dasar);
        } else if (id == R.id.nav_sejarah) {
            mManager.beginTransaction().replace(R.id.cont_Frame, new SejarahFragment()).commit();
            getSupportActionBar().setTitle(R.string.tit_sejarah);
        } else if (id == R.id.nav_sila1) {
           // Toast.makeText(this, R.string.st_sila1, Toast.LENGTH_SHORT).show();
            mManager.beginTransaction().replace(R.id.cont_Frame, new TabSila1Fragment()).commit();
            getSupportActionBar().setTitle(R.string.Bar1);
        } else if (id == R.id.nav_sila2) {
            mManager.beginTransaction().replace(R.id.cont_Frame, new TabSila2Fragment()).commit();
            getSupportActionBar().setTitle(R.string.Bar2);
        } else if (id == R.id.nav_sila3) {
            mManager.beginTransaction().replace(R.id.cont_Frame, new TabSila3Fragment()).commit();
            getSupportActionBar().setTitle(R.string.Bar3);
        } else if (id == R.id.nav_sila4) {
            mManager.beginTransaction().replace(R.id.cont_Frame, new TabSila4Fragment()).commit();
            getSupportActionBar().setTitle(R.string.Bar4);
        } else if (id == R.id.nav_sila5) {
            mManager.beginTransaction().replace(R.id.cont_Frame, new TabSila5fragment()).commit();
            getSupportActionBar().setTitle(R.string.Bar5);
        } else if (id == R.id.nav_exit) {
            onBackPressed();
        }
        //Jika dipilih menu, maka navigasi Close
        mNavDrawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

