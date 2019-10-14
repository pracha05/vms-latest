package com.vms.customer.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vms.customer.R;
import com.vms.customer.intents.IntentFactory;
import com.vms.customer.utils.AppFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.tv_cus_profile)
    ImageView tv_cus_profile;
    @BindView(R.id.tv_cus_dashboard)
    TextView tv_cus_dashboard;
    @BindView(R.id.tv_cus_contact)
    TextView tv_cus_contact;
    @BindView(R.id.tv_cus_loadbookings)
    TextView tv_cus_loadbookings;
    @BindView(R.id.tv_cus_bookingsummery)
    TextView tv_cus_bookingsummery;
    @BindView(R.id.tv_cus_incprovider)
    TextView tv_cus_incprovider;
    @BindView(R.id.tv_cus_refcode)
    TextView tv_cus_refcode;
    @BindView(R.id.tv_cus_support)
    TextView tv_cus_support;
    @BindView(R.id.tv_cus_wallet)
    TextView tv_cus_wallet;
    @BindView(R.id.tv_cus_loginedname)
    TextView tv_cus_loginedname;
    @BindView(R.id.tv_cus_logout)
    TextView tv_cus_logout;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.tv_searchview)
    TextView tv_searchview;

    @BindView(R.id.tv_cust_wallet)
    TextView tvWalletAmount;

    @BindView(R.id.tv_version)
    TextView tvVersion;

    @BindView(R.id.btn_membership)
    Button btnMembership;

    @BindView(R.id.tv_message)
    TextView tvMembershipMessage;

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        tv_cus_loadbookings.setOnClickListener(this);
        tv_cus_bookingsummery.setOnClickListener(this);
        tv_cus_profile.setOnClickListener(this);
        tv_cus_dashboard.setOnClickListener(this);
        tv_cus_contact.setOnClickListener(this);

        tv_cus_incprovider.setOnClickListener(this);
        tv_cus_refcode.setOnClickListener(this);
        tv_cus_support.setOnClickListener(this);
        tv_cus_wallet.setOnClickListener(this);
        tv_cus_logout.setOnClickListener(this);
        tv_searchview.setOnClickListener(this);
        tvMore.setOnClickListener(this);
        btnMembership.setOnClickListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        bottomNavigationView = findViewById(R.id.bottomnavigationView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        tv_cus_dashboard.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tv_cus_contact.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tv_cus_loadbookings.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tv_cus_bookingsummery.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tv_cus_incprovider.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tv_cus_refcode.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tv_cus_support.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tv_cus_wallet.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tv_cus_loginedname.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tv_cus_logout.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tvMore.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tv_searchview.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tvWalletAmount.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tvWalletAmount.setText("\u20B9 10,000");
        tvVersion.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        btnMembership.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
      //  tvMembershipMessage.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.b_navigation_home:
                       // Toast.makeText(HomeActivity.this, "home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.b_navigation_contact:
                        Intent inte = new Intent(HomeActivity.this, ContactAllList.class);
                        startActivity(inte);
                        overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                        break;
                    case R.id.b_navigation_booking:
                        startActivity(IntentFactory.createAddLoadActivity(HomeActivity.this));
                        overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                        break;
                    case R.id.b_navigation_offer:
                        startActivity(IntentFactory.createReferenceCodeActivity(HomeActivity.this));
                        overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                        break;
                    case R.id.b_navigation_profile:
                        startActivity(IntentFactory.createProfileActivity(HomeActivity.this));
                        overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                        break;
                }
                return true;
            }
        });
    }


    @Override
    public void onBackPressed() {
        drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_notification) {
            startActivity(IntentFactory.startNotificationActivity(HomeActivity.this));
            overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cus_contact:
                startActivity(IntentFactory.createAllContactActivity(HomeActivity.this));
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);

                break;
            case R.id.tv_cus_loadbookings:
                startActivity(IntentFactory.createAddLoadActivity(HomeActivity.this));
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);

                break;

            case R.id.tv_cus_incprovider:
                startActivity(IntentFactory.createInsuranceProviderActivity(HomeActivity.this));
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);

                break;
            case R.id.tv_cus_refcode:
                startActivity(IntentFactory.createReferenceCodeActivity(HomeActivity.this));
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);

                break;
            case R.id.tv_cus_profile:
                startActivity(IntentFactory.createProfileActivity(HomeActivity.this));
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);

                break;
            case R.id.tv_cus_bookingsummery:
                startActivity(IntentFactory.createBookingSummaryActivity(HomeActivity.this));
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);

                break;
            case R.id.tv_cus_support:
                startActivity(IntentFactory.createCustomerSupportActivity(HomeActivity.this));
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);

                break;
            case R.id.tv_cus_wallet:
                startActivity(IntentFactory.createWalletActivity(HomeActivity.this));
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                break;
            case R.id.tv_more:
                startActivity(IntentFactory.startMoreActivity(HomeActivity.this));
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                break;
            case R.id.tv_cus_logout:
                finish();
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                break;
            case R.id.tv_searchview:
//                    Intent ff = new Intent(HomeActivity.this, AddLoadActivity.class);
//                    startActivity(ff);
//                overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);

                break;

            case R.id.btn_membership:
                startActivity(IntentFactory.startMembershipActivity(HomeActivity.this));
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                break;
        }

        drawer.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
            }
        }, 300);
    }
}





