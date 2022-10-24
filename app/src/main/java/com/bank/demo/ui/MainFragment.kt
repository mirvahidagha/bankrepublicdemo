package com.bank.demo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bank.demo.databinding.FragmentFirstBinding
import com.bank.demo.models.Eur
import com.bank.demo.models.Usd
import com.bank.demo.viewmodels.CashViewmodel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val cashViewModel: CashViewmodel by viewModel()
    private var _binding: FragmentFirstBinding? = null
    private var usd: Usd? = null
    private var eur: Eur? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        cashViewModel.currencyLiveData.observe(viewLifecycleOwner) {
            eur = it[0].cash.eur
            usd = it[0].cash.usd

            if (eur != null && usd != null)
                binding.apply {
                    convert.isEnabled = true
                    editAzn.setText("1")
                    editAzn.setSelection(editAzn.length())
                    editUsd.setText("${1 / usd!!.buy}")
                    editEur.setText("${1 / eur!!.buy}")
                    convert.setOnClickListener {
                        val first = editAzn.text.toString().toDouble()
                        editUsd.setText("${first / usd!!.buy}")
                        editEur.setText("${first / eur!!.buy}")
                    }
                }

        }

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}