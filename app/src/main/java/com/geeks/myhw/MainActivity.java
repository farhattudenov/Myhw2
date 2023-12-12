package com.geeks.myhw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }
    public class ScondActivity extends ScondActivity1 implements FirstFragment.OnButtonClickListener, com.geeks.myhw.ScondActivity {

        private String mValue;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new FirstFragment())
                    .commit();
        }


        @Override
        protected void onButtonClicked(String value) {
            mValue = value;
            SecondFragment secondFragment = new SecondFragment();
            Bundle args = new Bundle();
            args.putString("value", mValue);
            secondFragment.setArguments(args);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, secondFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

}