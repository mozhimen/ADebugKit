package com.mozhimen.debugk.annors

import androidx.annotation.Keep

/**
 * @ClassName DebugK
 * @Description TODO
 * @Author Kolin Zhao / Mozhimen
 * @Date 2022/1/18 16:27
 * @Version 1.0
 */
@Keep
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class ADebugKTool(val title: String, val desc: String)
