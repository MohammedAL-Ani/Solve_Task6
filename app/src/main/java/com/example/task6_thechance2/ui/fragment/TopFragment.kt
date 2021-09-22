package com.example.task6_thechance2.ui.fragment

import android.util.Log
import android.view.LayoutInflater
import androidx.core.widget.doOnTextChanged
import com.example.task6_thechance2.base.BaseFragment
import com.example.task6_thechance2.databinding.FragmentTopBinding
import com.example.task6_thechance2.util.Communicator
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit
import javax.security.auth.Subject


class TopFragment : BaseFragment<FragmentTopBinding>() {
    override val Log_Tag: String = "TopFragment"
    override val bindingInflater: (LayoutInflater) -> FragmentTopBinding =
        FragmentTopBinding::inflate

    override fun setup() {
        val communicator = activity as Communicator
        val observable = getObservable()

        setSubsicraber(observable,communicator)

    }

    private fun setSubsicraber(p_observable: Observable<String> , p_communicator:Communicator) {
        val subject = BehaviorSubject.create<String>()
        p_observable.subscribe(subject)
        subject.subscribe({
            p_communicator.passData(it)
            Log.v(Log_Tag, it.toString())
        },
            {
                p_communicator.passData(it.message.toString())
            })
    }

    private fun getObservable(): Observable<String> {

       return Observable.create<String> { it ->
           binding.etinput.doOnTextChanged { text, start, before, count ->
               it.onNext(text.toString())
           }
       }.debounce(1500, TimeUnit.MILLISECONDS)

    }

}