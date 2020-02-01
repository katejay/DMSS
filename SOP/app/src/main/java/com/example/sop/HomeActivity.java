package com.example.sop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity {

    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_home);

        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, SOP1.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, SOP2.class);
                startActivity(i);
            }
        });

        getSupportActionBar().setTitle("Standard Operating Procedure");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.icon_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1:
                Toast.makeText(this,"Enter the message to search", Toast.LENGTH_LONG).show();

                return true;

            case R.id.item2:
                Toast.makeText(this,"About us selected", Toast.LENGTH_LONG).show();
                Intent aboutus = new Intent(HomeActivity.this, AboutUs.class);
                startActivity(aboutus);
                return true;

            case R.id.item3:
                Toast.makeText(this,"Contact us selected", Toast.LENGTH_LONG).show();
                String url = "https://dmss.business.site/#details";
                Intent contactus = new Intent(Intent.ACTION_VIEW);
                contactus.setData(Uri.parse(url));
                startActivity(contactus);
                return true;

            case R.id.item4:
                Toast.makeText(this,"Settings selected", Toast.LENGTH_LONG).show();
                return true;

            case R.id.item5:
                Toast.makeText(this,"Share App", Toast.LENGTH_LONG).show();
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                String shareBody = "https://dmss.business.site/";
                String shareSub = "SOP BY DMSS";
                share.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                share.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(share,"Share Using"));
                return true;

            case R.id.item6:
                Toast.makeText(this,"Rate App", Toast.LENGTH_LONG).show();
                String appstore = "https://dmss.business.site/";
                Intent rateapp = new Intent(Intent.ACTION_VIEW);
                rateapp.setData(Uri.parse(appstore));
                startActivity(rateapp);
                return true;

            case R.id.item7:
                Toast.makeText(this,"More Apps", Toast.LENGTH_LONG).show();
                String profile = "https://www.shorturl.at/cp137";
                Intent moreapp = new Intent(Intent.ACTION_VIEW);
                moreapp.setData(Uri.parse(profile));
                startActivity(moreapp);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}