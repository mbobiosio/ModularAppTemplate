package com.mbobiosio.favorite.presentation

import androidx.lifecycle.ViewModel
import com.mbobiosio.domain.SampleRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteVM @Inject constructor(private val repository: SampleRepo): ViewModel() {
    fun getDescription() = repository.getDescription()
}