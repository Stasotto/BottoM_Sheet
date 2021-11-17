package com.example.bottosheet.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.bottosheet.presentation.fragments.BottomSheetDialogFrag
import com.example.bottosheet.databinding.ActivityMainBinding
import com.example.bottosheet.presentation.viewmodel.ViewMode

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dataModel: ViewMode by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataModel.massage.observe(this,{
            binding.name.setText(it)
        })
    }

    override fun onResume() {
        super.onResume()
        binding.name.setOnClickListener {
            initBottomSheetDialog()
        }
    }

    private fun initBottomSheetDialog() {
        val bottomSheet = BottomSheetDialogFrag.newInstance()
        bottomSheet.show(supportFragmentManager, BottomSheetDialogFrag.TAG)
    }

}