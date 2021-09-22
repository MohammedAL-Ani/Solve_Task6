package com.example.task6_thechance2.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.task6_thechance2.R
import com.example.task6_thechance2.base.BaseActivity
import com.example.task6_thechance2.databinding.ActivityMainBinding
import com.example.task6_thechance2.ui.fragment.BottomFragment
import com.example.task6_thechance2.ui.fragment.TopFragment
import com.example.task6_thechance2.util.Communicator

class MainActivity : BaseActivity<ActivityMainBinding>() ,Communicator {
    override val LOG_TAG: String = "MainActivity"

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate




    override fun setup() {

        initsubview( TopFragment(), R.id.topfragmentContainer)
        initsubview( BottomFragment(), R.id.bottomfragmentContainer)
    }

    private fun initsubview(fragment:Fragment,continerid:Int) {
        supportFragmentManager.beginTransaction().apply {
           add(continerid,fragment)
            commit()
        }

    }

    override fun passData(s: String) {

        val fragmentbottom = BottomFragment()
        val bundle = Bundle()
        bundle.putString(KEY_CONSTANT,s)
        fragmentbottom.arguments = bundle

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.bottomfragmentContainer,fragmentbottom)
            commit()
        }

    }

   companion object{


       const val KEY_CONSTANT = "PASSDATA"
   }

}
