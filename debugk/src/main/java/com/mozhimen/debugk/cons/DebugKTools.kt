package com.mozhimen.debugk.cons

import android.app.Activity
import com.mozhimen.kotlin.lintk.optins.OApiInit_InApplication
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_SYSTEM_ALERT_WINDOW
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.kotlin.utilk.androidx.appcompat.UtilKAppCompatDelegate
import com.mozhimen.debugk.annors.ADebugKTool
import com.mozhimen.debugk.temps.DebugKCrashKActivity
import com.mozhimen.debugk.temps.DebugKLogKActivity
import com.mozhimen.debugk.temps.DebugKParamsActivity
import com.mozhimen.optk.fps.OptKFps

/**
 * @ClassName DebugKTools
 * @Description TODO
 * @Author Kolin Zhao / Mozhimen
 * @Date 2022/1/18 15:12
 * @Version 1.0
 */
@OApiInit_InApplication
class DebugKTools {

//    @ADebugKTool("开启Https降级", "降级成Http,可以使用抓包工具,明文抓包")
//    fun degrade2Http(activity: Activity) {
//        UtilKNetDeal.degrade2Http()
//    }

    @ADebugKTool("查看本地参数", "查看构建参数,设备参数,硬件参数等")
    fun checkDeviceParams(activity: Activity) {
        activity.startContext<DebugKParamsActivity>()
    }

    @ADebugKTool("查看CrashK日志", "可以一键分享给研发,迅速定位偶现问题")
    fun toggleCrash(activity: Activity) {
        activity.startContext<DebugKCrashKActivity>()
    }

    @ADebugKTool("查看LogK日志", "可以一键分享给研发,迅速定位偶现问题")
    fun toggleLog(activity: Activity) {
        activity.startContext<DebugKLogKActivity>()
    }

    @OptIn(OPermission_SYSTEM_ALERT_WINDOW::class)
    @ADebugKTool("打开/关闭Fps", desc = "打开后可以查看页面实时的FPS")
    fun toggleFps(activity: Activity) {
        OptKFps.instance.toggle()
    }

    @ADebugKTool("打开/关闭暗黑模式", desc = "打开暗黑模式在夜间使用更温和")
    fun toggleMode(activity: Activity) {
        UtilKAppCompatDelegate.toggleUiMode()
    }
}