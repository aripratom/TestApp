package com.example.testapp.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.testapp.databinding.FragmentLoginBinding
import com.example.testapp.tools.Utils
import com.example.testapp.user.UserActivity


class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            Utils.etValidate(binding.etEmail, "Required") {
                Utils.etValidate(binding.etPassword, "Required") {
                    viewModel.register(Utils.etToString(binding.etEmail), Utils.etToString(binding.etPassword))
                }
            }
        }

        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.responseCode.observe(viewLifecycleOwner, Observer { code ->
            if(code == 200) {
                val intent = Intent(context, UserActivity::class.java)
                context?.startActivity(intent)
            } else {
                Toast.makeText(requireContext(), "Failed Login", Toast.LENGTH_LONG).show()
            }
        })
    }

}