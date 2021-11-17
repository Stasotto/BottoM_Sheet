package com.example.bottosheet.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottosheet.R
import com.example.bottosheet.presentation.recycler.Adapter
import com.example.bottosheet.presentation.viewmodel.ViewMode
import com.example.bottosheet.databinding.FragmentBlankBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetDialogFrag : BottomSheetDialogFragment() {
    private val adapter by lazy { Adapter() }
    private lateinit var binding: FragmentBlankBinding
    
    private val dataModel: ViewMode by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    companion object {
        const val TAG = "First"
        @JvmStatic
        fun newInstance() = BottomSheetDialogFrag()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBlankBinding.bind(view)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(activity)

        dataModel.dataRecycler.observe(this,{arrayName ->
            adapter.addStrings(arrayName)
        })
        adapter.setOnItemClickListener { string ->
            dataModel.massage.value = string
            dismiss()
        }
    }
}

