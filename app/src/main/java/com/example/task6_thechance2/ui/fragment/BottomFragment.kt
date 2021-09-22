package com.example.task6_thechance2.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.task6_thechance2.base.BaseFragment
import com.example.task6_thechance2.databinding.FragmentBottomBinding
import com.example.task6_thechance2.ui.MainActivity


/**
 * A simple [Fragment] subclass.
 * Use the [BottomFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomFragment : BaseFragment<FragmentBottomBinding>() {
    override val Log_Tag: String = "BottomFragment"
    override val bindingInflater: (LayoutInflater) -> FragmentBottomBinding =FragmentBottomBinding::inflate

    override fun setup() {
     val result =  arguments?.getString(MainActivity.KEY_CONSTANT)
        binding.tvoutput.text = result

    }

}