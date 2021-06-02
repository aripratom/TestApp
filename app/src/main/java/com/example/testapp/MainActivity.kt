package com.example.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.login.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mFragmentManager = supportFragmentManager
        val mHomeFragment = LoginFragment()
        val fragment = mFragmentManager.findFragmentByTag(LoginFragment::class.java.simpleName)
        if (fragment !is LoginFragment) {
            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, mHomeFragment, LoginFragment::class.java.simpleName)
                .commit()
        }
    }
}