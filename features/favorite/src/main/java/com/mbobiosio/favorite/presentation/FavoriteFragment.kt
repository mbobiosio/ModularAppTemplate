package com.mbobiosio.favorite.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.mbobiosio.common.base.BaseBindingFragment
import com.mbobiosio.favorite.R
import com.mbobiosio.favorite.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseBindingFragment() {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<FavoriteVM>()

    override fun bindFragment(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupUI(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            val description = viewModel.getDescription().plus(getString(R.string.favorite))

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
