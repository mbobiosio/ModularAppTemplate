package com.mbobiosio.account.presentation

import androidx.lifecycle.ViewModel
import com.mbobiosio.domain.SampleRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccountVM @Inject constructor(
    private val repository: SampleRepo
) : ViewModel() {
    fun getDescription() = repository.getDescription()
}
