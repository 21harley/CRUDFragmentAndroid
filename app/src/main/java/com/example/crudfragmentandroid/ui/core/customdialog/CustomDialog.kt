package com.example.crudfragmentandroid.ui.core.customdialog

import android.app.ActionBar
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.crudfragmentandroid.databinding.ModalBinding

class CustomDialog(
    private val textDescription:String,
    private val buttonText1:String,
    private val buttonText2:String,
    private val onSubmitButttonOneClickListener: ()->Unit,
    private val onSubmitButtonTwoClickListener: ()->Unit
): DialogFragment() {
    private lateinit var binding: ModalBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = ModalBinding.inflate(LayoutInflater.from(context))
        val builder = AlertDialog.Builder (requireActivity())
        builder.setView(binding.root)

        binding.textDialog.text=textDescription
        if(buttonText1!=""){
            binding.buttonDialog1.visibility=View.VISIBLE
            binding.buttonDialog1.text=buttonText1
            binding.buttonDialog1.setOnClickListener {
                onSubmitButttonOneClickListener()
                dismiss()
            }
        }else{
            binding.buttonDialog1.visibility=View.GONE
        }

        if(buttonText2!=""){
            binding.buttonDialog2.visibility=View.VISIBLE
            binding.buttonDialog2.text=buttonText2
            binding.buttonDialog2.setOnClickListener {
                onSubmitButtonTwoClickListener()
                dismiss()
            }
        }else{
            binding.buttonDialog2.visibility=View.GONE
        }

        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.setGravity(Gravity.CENTER)
        return dialog
    }

}