package com.app.akademikapp.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.app.akademikapp.R
import com.app.akademikapp.data.local.MahasiswaDbHelper
import com.app.akademikapp.data.model.Mahasiswa
import com.app.akademikapp.databinding.FragmentTambahMahasiswaBinding

class TambahMahasiswaFragment :
    Fragment(R.layout.fragment_tambah_mahasiswa) {

    private var _binding: FragmentTambahMahasiswaBinding? = null
    private val binding get() = _binding!!

    private lateinit var dbHelper: MahasiswaDbHelper

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentTambahMahasiswaBinding.bind(view)

        dbHelper = MahasiswaDbHelper(requireContext())

        binding.btnSimpanMahasiswa.setOnClickListener {
            saveData()
        }

        binding.btnKembaliTambahMahasiswa.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun saveData() {

        val mahasiswa = Mahasiswa(
            nim = binding.edtNim.text.toString(),
            nama = binding.edtNama.text.toString(),
            prodi = binding.edtProdi.text.toString(),
            semester = binding.edtSemester.text.toString().toIntOrNull() ?: 1,
            email = binding.edtEmail.text.toString()
        )

        val success = dbHelper.insertMahasiswa(mahasiswa)

        if (success) {
            Toast.makeText(
                requireContext(),
                "Data berhasil disimpan",
                Toast.LENGTH_SHORT
            ).show()

            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}