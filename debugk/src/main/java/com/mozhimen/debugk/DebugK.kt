package com.mozhimen.debugk

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.debugk.temps.DebugKDialogFragment

/**
 * @ClassName DebugK
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/5/27 12:03
 * @Version 1.0
 */
object DebugK : IUtilK {
    fun toggleDialog(fragmentManager: FragmentManager) {
        try {
            val target = DebugKDialogFragment::class.java.getConstructor().newInstance() as DialogFragment
            target.show(fragmentManager, "debugk_dialog")
        } catch (e: Exception) {
            e.printStackTrace()
            e.message?.e(TAG)
        }
    }
}