/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.cupcake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.cupcake.databinding.FragmentSummaryBinding
import com.example.cupcake.model.OrderViewModel

/**
 * kelas summaryfragment digunakan untuk manampilkan hasil pesanan
 */
class SummaryFragment : Fragment() {

    // untuk menghubungkan fragmentsummary dengan summaryfragment
    private var binding: FragmentSummaryBinding? = null

    // membagi viewmodel supaya bisa digunakan di fragment ini
    private val sharedViewModel: OrderViewModel by activityViewModels()

    /**
     * membangun tampilan fragment yang terhubung
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSummaryBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    /**
     * menampilkan tampilan yang telah terbangun dari fragment yang terhubung
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            // menentukan fragment sebagai pemiih lifecycle
            lifecycleOwner = viewLifecycleOwner
            // menetapkan model tampilan ke properti dari kelas binding
            viewModel = sharedViewModel
            // mengatur isi summaryfragment
            summaryFragment = this@SummaryFragment
        }
    }

    /**
     * Navigate untuk melanjutkan ke halaman cara pengambilan
     */
    fun sendOrder() {
        Toast.makeText(activity, "Send Order", Toast.LENGTH_SHORT).show()
    }

    /**
     * menghapus atau mengganti tampilan agar selanjutnya atau sebelumnya dapat tampil
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}