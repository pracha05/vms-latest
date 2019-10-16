package com.vms.customer.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.vms.customer.R;
import com.vms.customer.intents.IntentFactory;

public class MoreActivity  extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    private Context mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        ButterKnife.bind(this);
        mContext = this;
        if (mToolBar != null) {
            setSupportActionBar(mToolBar);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(R.string.more);

            mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                }
            });
        }

        final ListView listView = (ListView) findViewById(R.id.list);
        String[] more = getResources().getStringArray(R.array.more_data);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, more);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);
                if (itemValue.equals(getString(R.string.about_us_title))) {
                    startActivity(IntentFactory.startAboutUsActivity(MoreActivity.this));
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                }
                else if (itemValue.equals(getString(R.string.title_about_app))) {
                    startActivity(IntentFactory.startAboutAppActivity(MoreActivity.this));
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                }
                else if (itemValue.equals(getString(R.string.title_terms_use))) {
                    startActivity(IntentFactory.startTermsOfUseActivity(MoreActivity.this));
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                }
                else if (itemValue.equals(getString(R.string.title_privacy_policy))) {
                    startActivity(IntentFactory.startPrivacyActivity(MoreActivity.this));
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}