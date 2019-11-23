package com.androidstudioprojects.parseinstagram;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.androidstudioprojects.parseinstagram.fragments.ComposeFragment;
import com.androidstudioprojects.parseinstagram.fragments.PostFragment;
import com.androidstudioprojects.parseinstagram.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            bottomNavigationView = findViewById(R.id.bottom_navigation);
            final FragmentManager fragmentManager = getSupportFragmentManager();

            bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment;
                    switch (item.getItemId()) {
                        case R.id.action_home:
                            fragment = new PostFragment() ;
//                            Toast.makeText(MainActivity.this, "Home!", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.action_compose:
                            fragment = new ComposeFragment();
//                            Toast.makeText(MainActivity.this, "compose!", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.action_profile:
                        default:
                            fragment = new ProfileFragment();
//                            Toast.makeText(MainActivity.this, "profile!", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    fragmentManager.beginTransaction().replace(R.id.flcontainer, fragment).commit();
                    return true;
                }
            });
        }
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }
}