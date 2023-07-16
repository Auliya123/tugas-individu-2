package com.example.explore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.explore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replacedFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.home){
                replacedFragment(new HomeFragment());
            }

            if (item.getItemId() == R.id.form){
                replacedFragment(new FormFragment());
            }


            if (item.getItemId() == R.id.map){
                replacedFragment(new MapFragment());
            }

//            switch (item.getItemId()){
//
//                case R.id.home:
//                    replacedFragment(new HomeFragment());
//                    break;
//
//                case R.id.form:
//                    replacedFragment(new FormFragment());
//                    break;
//
//                case R.id.map:
//                    replacedFragment(new MapFragment());
//                    break;
//
//                default:
//                    break;
//            }
            return true;
        });
    }

    private void replacedFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();

    }
}