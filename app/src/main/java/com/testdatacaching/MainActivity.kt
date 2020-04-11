package com.testdatacaching

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        supportFragmentManager.beginTransaction().add(R.id.layout, FragmentHome()
            .getInstance("Fragment One initialized.")).commit()
    }
}
