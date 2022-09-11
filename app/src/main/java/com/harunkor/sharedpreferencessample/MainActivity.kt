package com.harunkor.sharedpreferencessample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.harunkor.sharedpreferencessample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private const val PATIKA = "PATIKA"
    }

    private lateinit var sharedPreferencesUtils: SharedPreferencesUtils
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        init()
    }

    private fun init(){
        sharedPreferencesUtils = SharedPreferencesUtils(this)
        binding.apply {
            button.setOnClickListener(this@MainActivity)
            edtText.setText(sharedPreferencesUtils.readDataString(PATIKA,"FMSS"))
        }
    }

    override fun onClick(p0: View?) {
        sharedPreferencesUtils.writeDataString(PATIKA,binding.edtText.text.toString())
    }


}