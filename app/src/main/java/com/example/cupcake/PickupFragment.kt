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
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.databinding.FragmentPickupBinding
import com.example.cupcake.model.OrderViewModel

/**
 * kelas pickupfragment digunakan untuk memilih waktu
 */
class PickupFragment : Fragment() {

    // untuk menghubungkan fragmentpickup dengan pickupfragment
    private var binding: FragmentPickupBinding? = null

    // membagi viewmodel supaya bisa digunakan di fragment ini
    private val sharedViewModel: OrderViewModel by activityViewModels()


    /**
     * membangun tampilan fragment yang terhubung
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentPickupBinding.inflate(inflater, container, false)
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
            // mengatur isi pickupfragment
            pickupFragment = this@PickupFragment
        }
    }

    /**
     * Navigate untuk melanjutkan ke halaman cara pengambilan
     */
    fun goToNextScreen() {
        findNavController().navigate(R.id.action_pickupFragment_to_summaryFragment)
    }

    /**
     * menghapus atau mengganti tampilan agar selanjutnya atau sebelumnya dapat tampil
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}