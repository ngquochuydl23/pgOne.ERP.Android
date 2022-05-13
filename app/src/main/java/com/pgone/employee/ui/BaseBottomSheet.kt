package com.pgone.employee.ui

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.pgone.employee.R

open class BaseBottomSheet : BottomSheetDialogFragment(){

    protected lateinit var fragmentContext: Context

    override fun getTheme(): Int {
        return R.style.BaseBottomSheetDialog
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), theme)
    }

    open fun navigateTo(activity: Class<*>) {
        val intent = Intent(context, activity)
        startActivity(intent)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentContext = requireContext()
    }

    fun getView(layout : Int , container : ViewGroup?) : View? {
        return LayoutInflater.from(context).inflate(layout, container)
    }
}