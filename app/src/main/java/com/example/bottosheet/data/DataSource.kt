package com.example.bottosheet.data

import android.content.res.Resources
import com.example.bottosheet.R
import com.example.bottosheet.domain.NameInteractor

class DataSource: NameInteractor {

    private var arrayName: List<String> = (Resources.getSystem().getStringArray(R.array.array_of_name)).toList()

    override fun loadData(): List<String> {
        return arrayName
    }
}