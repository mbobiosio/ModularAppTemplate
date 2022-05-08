package com.mbobiosio.home.presentation

import androidx.lifecycle.ViewModel
import com.mbobiosio.domain.SampleRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val repository: SampleRepo
) : ViewModel() {
    fun getDescription() = repository.getDescription()
}
