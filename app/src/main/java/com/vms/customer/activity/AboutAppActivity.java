package com.vms.customer.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vms.customer.BuildConfig;
import com.vms.customer.R;
import com.vms.customer.network.ApiUrl;
import com.vms.customer.utils.AppFonts;
import com.vms.customer.utils.PlatformUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutAppActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    @BindView(R.id.copyright_label)
    TextView tvCopyRight;

    @BindView(R.id.facebook_img)
    ImageView imgFacebook;

    @BindView(R.id.twitter_image)
    ImageView imgTwitter;

    @BindView(R.id.youtube_image)
    ImageView imgYouTube;

    @BindView(R.id.contact_us_value)
    TextView email;

    @BindView(R.id.contact_us_phone)
    TextView phone;

    @BindView(R.id.app_version)
    TextView tvAppVersion;

    @BindView(R.id.git_version)
    TextView tvGitVersion;

    @BindView(R.id.about_app_description)
    TextView tvAbtApp;

    @BindView(R.id.contact_us)
    TextView tvContactUs;

    @BindView(R.id.contact_phone)
    TextView tvPhoneText;

    @BindView(R.id.address)
    TextView tvAddress;

    @BindView(R.id.address_value_1)
    TextView tvAddressValue;




    private Context mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        ButterKnife.bind(this);
        mContext = this;

        String versionName = PlatformUtils.getClientVersion(this);
        tvAppVersion.setText(getString(R.string.app_version, versionName, BuildConfig.GIT_COMMIT_COUNT));
        tvCopyRight.setText(getString(R.string.copyright_label, PlatformUtils.getCalenderYear()));
        imgFacebook.setOnClickListener(this);
        imgTwitter.setOnClickListener(this);
        imgYouTube.setOnClickListener(this);
        email.setOnClickListener(this);
        phone.setOnClickListener(this);

        tvCopyRight.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        email.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        phone.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tvAppVersion.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tvGitVersion.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tvAbtApp.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tvContactUs.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tvPhoneText.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tvAddress.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tvAddressValue.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));

        if (mToolBar != null) {
            setSupportActionBar(mToolBar);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(R.string.about_app);

            mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.facebook_img :
                //openBrowser((getFacebookPageURL(this)));
                openFacebookApp();
                break;
            case R.id.twitter_image :
                openBrowser(ApiUrl.TWITTER_URL);
                break;
            case R.id.youtube_image:
                openBrowser(ApiUrl.YOU_TUBE_URL);
                break;
            case R.id.contact_us_value:
                openEmailIntent();
                break;
            case R.id.contact_us_phone:
                OpenDialer();
                break;
            default:
                break;
        }
    }

    private void OpenDialer() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+phone.getText().toString()));
        startActivity(intent);
    }

    /**
     * open email intent for contact
     */
    private void openEmailIntent(){

        if (PlatformUtils.isNetworkAvailable(AboutAppActivity.this)) {
            final Intent _Intent = new Intent(android.content.Intent.ACTION_SEND, Uri.fromParts(
                    "mailto", email.getText().toString(), null));
            _Intent.setType("message/rfc822");
            _Intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ email.getText().toString()});
            _Intent.setPackage("com.google.android.gm");
            try {
                startActivity(Intent.createChooser(_Intent, getString(R.string.contact_uss)));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(AboutAppActivity.this, getString(R.string.email_activity_error_mesage), Toast.LENGTH_SHORT).show();
            }
        } else {
            showNetworkErrorDialog();
        }
    }

    /**
     * open facebook and twitter link
     * @param url
     */
    private void openBrowser(String url){
        if(PlatformUtils.isNetworkAvailable(this)) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            PackageManager packageManager = AboutAppActivity.this.getPackageManager();
            Uri uri = Uri.parse(url);
            browserIntent.setDataAndType(uri, "text/html");
            List<ResolveInfo> list = packageManager.queryIntentActivities(browserIntent, 0);
            for (ResolveInfo resolveInfo : list) {
                String activityName = resolveInfo.activityInfo.name;
                if (activityName != null) {
                    browserIntent =
                            packageManager.getLaunchIntentForPackage(resolveInfo.activityInfo.packageName);
                    ComponentName comp =
                            new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                    browserIntent.setAction(Intent.ACTION_VIEW);
                    browserIntent.addCategory(Intent.CATEGORY_BROWSABLE);
                    browserIntent.setComponent(comp);
                    browserIntent.setData(uri);
                    startActivity(browserIntent);
                }
            }
        }else{
            showNetworkErrorDialog();
        }
    }

    private void openFacebookApp() {
        String facebookUrl = ApiUrl.FB_URL;
        String facebookID = ApiUrl.FACEBOOK_PAGE_ID;

        try {
            int versionCode = getApplicationContext().getPackageManager().getPackageInfo("com.facebook.katana", 0).versionCode;

            if(!facebookID.isEmpty()) {
                // open the Facebook app using facebookID (fb://profile/facebookID or fb://page/facebookID)
                Uri uri = Uri.parse("fb://page/" + facebookID);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            } else if (versionCode >= 3002850 && !facebookUrl.isEmpty()) {
                // open Facebook app using facebook url
                Uri uri = Uri.parse("fb://facewebmodal/f?href=" + facebookUrl);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            } else {
                // Facebook is not installed. Open the browser
                Uri uri = Uri.parse(facebookUrl);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        } catch (PackageManager.NameNotFoundException e) {
            // Facebook is not installed. Open the browser
            Uri uri = Uri.parse(facebookUrl);
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
    }

}
