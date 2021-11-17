package com.example.bottosheet.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bottosheet.data.DataSource
import com.example.bottosheet.domain.NameInteractor


open class ViewMode: ViewModel() {
    val massage: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    val message: LiveData<String> get() = _messages
    private val _messages = MutableLiveData<String>()
    // ПРАВИЛЬНОЕ СОЗДАНИЕ (ПОЧИТАТЬ ПРО ЭТО)
    private val nameInteractor: NameInteractor = DataSource()

    val dataRecycler: LiveData<List<String>> get() = _dataRecycler
    private val _dataRecycler = MutableLiveData<List<String>>(nameInteractor.loadData())
}