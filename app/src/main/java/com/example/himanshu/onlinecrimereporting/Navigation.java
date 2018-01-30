package com.example.himanshu.onlinecrimereporting;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import com.example.himanshu.onlinecrimereporting.fragments.About_Us;
import com.example.himanshu.onlinecrimereporting.fragments.Home;
import com.example.himanshu.onlinecrimereporting.fragments.Login;
import com.example.himanshu.onlinecrimereporting.fragments.Report_Crime;
import com.example.himanshu.onlinecrimereporting.fragments.View_Criminals;

public class Navigation extends AppCompatActivity {
    DrawerLayout drawer = null;
    FragmentTransaction fragmentTransaction = null;
    NavigationView navigationView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        checkFirstRun();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_mainn, new Home());
        fragmentTransaction.commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home1:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.content_mainn, new Home());
                        fragmentTransaction.commit();
                        fragmentTransaction.addToBackStack(null);
                        getSupportActionBar().setTitle("Online Crime Reporting");
                        drawer.closeDrawers();
                        break;

                    case R.id.nav_crime:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.content_mainn, new Report_Crime());
                        fragmentTransaction.commit();
                        fragmentTransaction.addToBackStack(null);
                        getSupportActionBar().setTitle("Report A Crime");
                        drawer.closeDrawers();
                        break;


                    case R.id.nav_viewcriminals:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.content_mainn, new View_Criminals());
                        fragmentTransaction.commit();
                        fragmentTransaction.addToBackStack(null);
                        getSupportActionBar().setTitle("View Criminals Details");
                        drawer.closeDrawers();
                        break;

                    case R.id.nav_login:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.content_mainn, new Login());
                        fragmentTransaction.commit();
                        fragmentTransaction.addToBackStack(null);
                        getSupportActionBar().setTitle("Login/Register");
                        drawer.closeDrawers();
                        break;


                    case R.id.nav_fdbkapp:
                        Intent email = new Intent(Intent.ACTION_SEND);
                        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"himanshusaini299@gmail.com"});
                        email.putExtra(Intent.EXTRA_SUBJECT, "(Online Crime Reporting) User Feedback:");
                        email.setType("message/rfc822");
                        startActivity(Intent.createChooser(email, "Send Email:"));
                        break;

                    case R.id.nav_share:
                        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Online Crime Reporting Application.\n\n");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Report a crime online:");
                        startActivity(Intent.createChooser(sharingIntent, "Share via:"));

                        drawer.closeDrawers();
                        break;

                    case R.id.nav_aboutus:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.content_mainn, new About_Us());
                        fragmentTransaction.commit();
                        fragmentTransaction.addToBackStack(null);
                        getSupportActionBar().setTitle("About Us");
                        drawer.closeDrawers();
                        break;

                }

                return true;
            }
        });
    }


    public void checkFirstRun() {
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun) {
            showDialog(0);
            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstRun", false)
                    .apply();
        }
    }

    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("LEGAL DISCLAIMER: ... ");
        builder.setMessage("Be advised that it is a crime to make a false police report. Anyone found to have submitted a false police report will be prosecuted under the law." +
                "\n\nClick 'Agree' to continue." +
                "\nClick 'Disagree' to exit the app.")
                .setCancelable(false)
                .setPositiveButton("Agree", new DialogInterface.OnClickListener() {
                    public static final String PREFS_NAME = "";

                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putBoolean("accepted", true);
                        // Commit the edits!
                        editor.commit();
                    }
                })
                .setNegativeButton("Disagree", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //nm.cancel(R.notification.running); // cancel the NotificationManager (icon)
                        System.exit(0);
                    }
                });
        AlertDialog alert = builder.create();
        return alert;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void onClickButton(View view) {
        ScrollView sview=(ScrollView) findViewById(R.id.scrollView);

        Button btn=(Button) findViewById(R.id.buttonSignup);
        int pos=btn.getTop();
        sview.scrollTo(0,pos);

    }
}

