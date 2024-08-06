package com.example.vatecareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class DashbordActivity extends AppCompatActivity{
    Button button;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private FirebaseAuth firebaseAuth;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);
        NavigationView navigationView = findViewById(R.id.navigationView);
        button = findViewById(R.id.btnhealth_check);
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setCheckedItem(R.id.home);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                return true;
            }
        });
    }

//   z     toggle.syncState();
//        code of fragmentation call with selectLinsterner
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
////            Fragment fragment = null;
//    }
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Fragment fragment = null;
//               int id = item.getItemId();
//                Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();
//               if(id==R.id.profile){  fragment = new AboutUsFragment()
////                 ;
//                   loadFragment(fragment);
////                   startActivity(new Intent(DashbordActivity.this,BuffaloActivity.class));
//                   Toast.makeText(DashbordActivity.this, "This is profile",Toast.LENGTH_SHORT).show();
//
//               }
//               else if(id==R.id.home){
//                   Toast.makeText(DashbordActivity.this, "This is profile", Toast.LENGTH_SHORT).show();
//                   loadFragment(new AboutUsFragment());
//               }
//               else if(id==R.id.Aboutus){
//                   Toast.makeText(DashbordActivity.this, "This is Aboutus", Toast.LENGTH_SHORT).show();
//               }
//               else if(id==R.id.support){
//                   Toast.makeText(DashbordActivity.this, "This is for support", Toast.LENGTH_SHORT).show();
//              }
//               else {
//                   Toast.makeText(DashbordActivity.this, "This is setting", Toast.LENGTH_SHORT).show();
//               }
//                 drawerLayout.closeDrawer(GravityCompat.START);
//
//                return true;
//            }
//
//
////        });



//
//    @Override
//    public void onBackPressed() {
//        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
//            drawerLayout.closeDrawer(GravityCompat.START);
//        }
//        else{
//            super.onBackPressed();
//        }
//    }
//
//    private void loadFragment(Fragment fragment) {
//        FragmentManager fm= getSupportFragmentManager();
//        FragmentTransaction ft =fm.beginTransaction();
//        ft.add(R.id.container,fragment);
//
//   }
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.home_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }


    public void profile(View view) {
        startActivity(new Intent(DashbordActivity.this,ProfileActivity.class));
        Toast.makeText(DashbordActivity.this, "This is profile", Toast.LENGTH_SHORT).show();
    }

    public void home(View view) {
        Toast.makeText(DashbordActivity.this, "This is home", Toast.LENGTH_SHORT).show();
    }

    public void About_disease(View view) {
        Toast.makeText(DashbordActivity.this, "This is About disease", Toast.LENGTH_SHORT).show();
    }

    public void AboutUs(View view) {

        startActivity(new Intent(DashbordActivity.this,AboutUsMainActivity.class));
        Toast.makeText(DashbordActivity.this, "This is about us", Toast.LENGTH_SHORT).show();
    }

    public void health_check(View view) {
        Intent i = new Intent(DashbordActivity.this,HealthCheckActivity.class);
        startActivity(i);
        Toast.makeText(DashbordActivity.this, "This is health check", Toast.LENGTH_SHORT).show();
    }

    public void feedback(View view) {
        Toast.makeText(DashbordActivity.this, "This is feedback", Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        Fragment fragment = null;
//        switch (item.getItemId()){
//            case R.id.profile:
//                Intent intent = new Intent(DashbordActivity.this,Ma)
//        }
//    }
}