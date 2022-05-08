package com.mbobiosio.account.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.mbobiosio.account.R
import com.mbobiosio.account.databinding.FragmentAccountBinding
import com.mbobiosio.common.base.BaseBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment : BaseBindingFragment() {
    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<AccountVM>()

    override fun bindFragment(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupUI(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            val description = viewModel.getDescription().plus(getString(R.string.account))
            toolBar.title = description

            fab.setOnClickListener {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun unbindFragment() {
        _binding = null
    }
}
