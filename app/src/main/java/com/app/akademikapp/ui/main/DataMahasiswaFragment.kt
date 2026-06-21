package com.app.akademikapp.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.akademikapp.MainActivity
import com.app.akademikapp.R
import com.app.akademikapp.data.local.MahasiswaDbHelper
import com.app.akademikapp.databinding.FragmentDataMahasiswaBinding
import com.app.akademikapp.ui.adapter.MahasiswaAdapter

class DataMahasiswaFragment :
    Fragment(R.layout.fragment_data_mahasiswa) {

    private var _binding: FragmentDataMahasiswaBinding? = null
    private val binding get() = _binding!!

    private lateinit var dbHelper: MahasiswaDbHelper
    private lateinit var adapter: MahasiswaAdapter

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentDataMahasiswaBinding.bind(view)

        dbHelper = MahasiswaDbHelper(requireContext())

        setupRecycler()
        loadData()

        binding.btnTambahMahasiswa.setOnClickListener {
            (activity as? MainActivity)?.replaceFragment(
                TambahMahasiswaFragment()
            )
        }

        binding.btnKembaliDataMahasiswa.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun setupRecycler() {

        adapter = MahasiswaAdapter(
            mutableListOf()
        ) { mahasiswa ->

            dbHelper.deleteMahasiswa(mahasiswa.id)
            loadData()
        }

        binding.rvMahasiswa.layoutManager =
            LinearLayoutManager(requireContext())

        binding.rvMahasiswa.adapter = adapter
    }

    private fun loadData() {

        val data = dbHelper.getAllMahasiswa()

        adapter.updateData(data)

        binding.tvEmptyMahasiswa.isVisible =
            data.isEmpty()

        binding.rvMahasiswa.isVisible =
            data.isNotEmpty()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvMahasiswa.adapter = null
        _binding = null
    }
}