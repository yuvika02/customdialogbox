package com.example.customdialogbox


import android.widget.Toast
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.databinding.DataBindingUtil.inflate
import androidx.test.espresso.Root
import com.example.customdialogbox.databinding.ActivityMainBinding.inflate
import com.example.customdialogbox.databinding.LayoutDialogBinding.inflate

class MainActivity2  : AppCompatActivity() {
    lateinit var binding: MainActivity2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivity2.inflate(layoutInflater)
        setContentView(binding.Root)

        binding.btnUpdate.setOnClickListener {
            var dialogBinding = layout_dialogbinding.inflate(layoutInflater)
            var dialog = Dialog(this)
            dialog.setContentView(dialogBinding.root)
            dialogBinding.etName.setText(binding.tvName1.text.toString())
            dialogBinding.etAge.setText((binding.tvAge1.text.toString()))
            if (binding.tvGender1.text.toString().equals("she")) {
                dialogBinding.rbShe.ischecked = true
            } else if (binding.tvGender1.text.toString().equals("he")) {
                dialogBinding.rbHee.isChecked = true
            } else if (binding.tvGender1.text.toString().equals("other")) {
                dialogBinding.rbOther.isChecked = true
                dialogBinding.etDescription.visibility = View.GONE
                dialogBinding.etDescription.setText(binding.tvDescription.text.toString())
            }

            dialogBinding.rgGender.setOnCheckedChangeListener { group, id ->
                when (id) {
                    R.id.rbOther -> dialogBinding.etDescription.visibility = View.VISIBLE

                    else-> {
                        dialogBinding.etDescription.visibility = View.GONE
                    }
                }
            }
            dialogBinding.btnSubmit.setOnClickListener {
                if (dialogBinding.etName.text.toString().isNullOrEmpty()) {
                    Toast.makeText(this, "ENTER NAME", Toast.LENGTH_LONG).show()
                } else if (dialogBinding.etAge.text.toString().isNullOrEmpty()) {
                    Toast.makeText(this, "ENTER AGE", Toast.LENGTH_LONG).show()
                } else if (dialogBinding.etDescription.text.toString().isNullOrEmpty()) {
                    Toast.makeText(this, "ENTER DESCRIPTION", Toast.LENGTH_LONG)
                    if (dialogBinding.rbShe.isChecked) {
                        binding.tvName1.setText("SHE")
                    } else if (dialogBinding.rbHee.isChecked) {
                        binding.tvName1.setText("HE")
                    } else if (dialogBinding.rbOther.isChecked) {
                        binding.tvGender1.setText("OTHER")
                    }
                    dialog.dismiss()
                }

            }
            dialog.show()
        }

    }
}