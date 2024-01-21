package com.mozhimen.debugk.test

import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.KeyEvent
import android.view.MotionEvent
import com.mozhimen.basick.elemk.android.view.bases.BaseFlingSimpleOnGestureCallback
import com.mozhimen.basick.elemk.androidx.appcompat.bases.databinding.BaseActivityVB
import com.mozhimen.debugk.DebugK
import com.mozhimen.debugk.test.databinding.ActivityDebugkBinding

class DebugKActivity : BaseActivityVB<ActivityDebugkBinding>() {

    override fun initView(savedInstanceState: Bundle?) {
        vb.debugkTxt.setOnClickListener {
            toggleDebugDialog()
        }
    }

    private val _gestureDetector: GestureDetector by lazy {
        GestureDetector(this, object : BaseFlingSimpleOnGestureCallback() {
            override fun onFlingLeft() {
                toggleDebugDialog()
            }
        })
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            toggleDebugDialog()
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return _gestureDetector.onTouchEvent(event)
    }

    fun toggleDebugDialog() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "toggleDebugDialog: open")
            DebugK.toggleDialog(this.supportFragmentManager)
        }
    }
}