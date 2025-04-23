package com.mozhimen.debugk.cons

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CBuild
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_READ_PHONE_STATE
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_READ_PRIVILEGED_PHONE_STATE
import com.mozhimen.kotlin.utilk.wrapper.UtilKDevice
import com.mozhimen.kotlin.utilk.kotlin.boolean2str
import com.mozhimen.kotlin.utilk.wrapper.UtilKScreen
import com.mozhimen.kotlin.utilk.wrapper.UtilKNet
import com.mozhimen.kotlin.utilk.android.os.UtilKBuild
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.view.UtilKNavigationBar
import com.mozhimen.debugk.BuildConfig
import com.mozhimen.debugk.annors.ADebugKParams
import com.mozhimen.kotlin.utilk.android.util.px2dp
import com.mozhimen.kotlin.utilk.wrapper.UtilKActionBar
import com.mozhimen.kotlin.utilk.wrapper.UtilKStatusBar

/**
 * @ClassName DebugKParams
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/5/29 10:04
 * @Version 1.0
 */
@OptIn(OPermission_READ_PHONE_STATE::class, OPermission_READ_PRIVILEGED_PHONE_STATE::class)
class DebugKParams {
    /**
     * 设备参数
     */
    @ADebugKParams("设备参数")
    fun deviceParams(): String = ""

    @ADebugKParams("设备序列号")
    fun deviceSerialNo(): String = UtilKDevice.getSerialNumber()

    @ADebugKParams("设备短序列号")
    fun deviceSerialNoShort(): String = UtilKDevice.getSerialNumberShort()

    @ADebugKParams("设备IP")
    fun deviceIP(): String = UtilKNet.getStrIP() ?: CBuild.UNKNOWN

    @ADebugKParams("设备Rom版本")
    fun deviceRomVersion(): String = UtilKDevice.getRomVersion()

    @ADebugKParams("设备硬件版本")
    fun deviceHardwareVersion(): String = UtilKDevice.getHardwareVersion()

    @ADebugKParams("设备是否有sd卡")
    fun deviceHasSdcard(): String = UtilKDevice.hasSdcard().boolean2str()

    @ADebugKParams("设备是否有前置摄像")
    fun deviceHasFrontCamera(): String = UtilKDevice.hasFrontCamera().boolean2str()

    @ADebugKParams("设备是否有后置摄像头")
    fun deviceHasBackCamera(): String = UtilKDevice.hasBackCamera().boolean2str()

    @SuppressLint("MissingPermission")
    @ADebugKParams("设备默认IMEI")
    fun deviceIMEI(): String = if (UtilKBuildVersion.isAfterV_23_6_M()) UtilKDevice.getImei() else "版本23后查看"

    ////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 构建参数
     */
    @ADebugKParams("构建参数")
    fun buildParams(): String = ""

//    @ADebugKParams("构建版本")
//    fun buildConfigVersion(): String =
//        "code ${BuildConfig.VERSION_CODE} name ${BuildConfig.VERSION_NAME}"

    @ADebugKParams("构建环境")
    fun buildConfigEnvironment(): String = if (BuildConfig.DEBUG) "测试环境" else "正式环境"

    @ADebugKParams("构建时间")
    fun buildConfigTime(): String = BuildConfig.BUILD_TIME

    @ADebugKParams("构建类型")
    fun buildType(): String = UtilKBuild.get_TYPE()

    @ADebugKParams("构建标签聚合")
    fun buildTags(): String = UtilKBuild.get_TAGS() ?: CBuild.UNKNOWN

    @ADebugKParams("构建SDK版本")
    fun buildVersionSDKStr(): String = UtilKBuildVersion.get_SDK_INT_STR()

    @ADebugKParams("构建Release版本号")
    fun buildVersionRelease(): String = UtilKBuildVersion.get_RELEASE()

    @ADebugKParams("构建版本名称")
    fun buildVersionCodeName(): String = UtilKBuildVersion.get_CODENAME()

    @ADebugKParams("构建显示ID")
    fun buildDisplay(): String = UtilKBuild.get_DISPLAY()

    @ADebugKParams("构建变更列表号")
    fun buildId(): String = UtilKBuild.get_ID()

    @ADebugKParams("构建内部Host")
    fun buildHost(): String = UtilKBuild.get_HOST()

    @ADebugKParams("构建内部构建者")
    fun buildUser(): String = UtilKBuild.get_USER()

    @ADebugKParams("构建内部时间")
    fun buildTime(): String = UtilKBuild.get_TIME()

    @ADebugKParams("构建设备名")
    fun buildProduct(): String = UtilKBuild.get_PRODUCT()

    @ADebugKParams("构建设备品牌")
    fun buildBrand(): String = UtilKBuild.get_BRAND()

    @ADebugKParams("构建设备/硬件制造商")
    fun buildManufacture(): String = UtilKBuild.get_MANUFACTURER()

    @ADebugKParams("构建无线固件版本")
    fun buildRadioVersion(): String = UtilKBuild.getRadioVersion() ?: CBuild.UNKNOWN

    @ADebugKParams("构建最终用户名")
    fun buildModel(): String = UtilKBuild.get_MODEL()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @ADebugKParams("构建支持架构")
    fun buildSupportABIs(): String = UtilKBuild.get_SUPPORTED_ABIS_STR()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @ADebugKParams("构建支持32位架构")
    fun buildSupport32BitABIs(): String = UtilKBuild.get_SUPPORTED_32_BIT_ABIS_STR()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @ADebugKParams("构建支持64位架构")
    fun buildSupport64BitABIs(): String = UtilKBuild.get_SUPPORTED_64_BIT_ABIS_STR()

    @ADebugKParams("构建开发板名称")
    fun buildBoard(): String = UtilKBuild.get_BOARD()

    @ADebugKParams("构建工业设计名")
    fun buildDevice(): String = UtilKBuild.get_DEVICE()

    @ADebugKParams("构建硬件名称")
    fun buildHardware(): String = UtilKBuild.get_HARDWARE()

    @ADebugKParams("构建唯一标识版本字符")
    fun buildFingerPrint(): String = UtilKBuild.get_FINGERPRINT()

    @ADebugKParams("构建系统引导加载程序版本")
    fun buildBootLoader(): String = UtilKBuild.get_BOOTLOADER()

    ////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 屏幕参数
     */
    @ADebugKParams("屏幕参数")
    fun screenParams(): String = ""

    @ADebugKParams("屏幕尺寸")
    fun screenSize(): String = UtilKScreen.getSize_ofSysMetrics().toString()

    @ADebugKParams("屏幕真实分辨率px")
    fun screenResolution(): String =
        "设备分辨率: w " + UtilKScreen.getWidth() + " h " + UtilKScreen.getHeight()

    @ADebugKParams("屏幕当前分辨率px")
    fun screenResolution2(): String =
        "设备分辨率: w " + UtilKScreen.getWidth_ofDisplayMetrics_ofSys() + " h " + UtilKScreen.getHeight_ofDisplayMetrics_ofSys()

    @ADebugKParams("屏幕分辨率dp")
    fun screenResolutionDpi(): String =
        "设备分辨率: w " + UtilKScreen.getWidthDp_ofSysConfig() + " h " + UtilKScreen.getHeightDp_ofSysConfig()

    @ADebugKParams("屏幕密度px")
    fun screenDensity(): String = UtilKScreen.getDensity_ofSysMetrics().toString()

    @ADebugKParams("屏幕密度dp")
    fun screenDensityDpi(): String = UtilKScreen.getDensity_ofSysMetrics().toString()

    @ADebugKParams("状态栏高度")
    fun screenStatusBarHeight(): String = UtilKStatusBar.getHeight_resources().toString()

    @ADebugKParams("活动栏高度")
    fun screenActionBarHeight(): String = UtilKActionBar.getHeight_resources().toString()

    @ADebugKParams("活动栏高度DP")
    fun screenActionBarHeightDP(): String = UtilKActionBar.getHeight_resources().px2dp().toString()

    @ADebugKParams("导航栏高度")
    fun screenNavigationBarHeight(): String = UtilKNavigationBar.getHeight().toString()

    @ADebugKParams("屏幕竖屏")
    fun screenIsPortrait(): String = if (UtilKScreen.isOrientationPortrait_ofSysConfig()) "是" else "否"
}