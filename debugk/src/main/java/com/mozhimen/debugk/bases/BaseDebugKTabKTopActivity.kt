package com.mozhimen.debugk.bases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_INTERNET
import com.mozhimen.adaptk.systembar.initAdaptKSystemBar
import com.mozhimen.kotlin.utilk.wrapper.UtilKRes
import com.mozhimen.kotlin.utilk.android.util.dp2px
import com.mozhimen.kotlin.utilk.kotlin.UtilKLazyJVM.lazy_ofNone
import com.mozhimen.debugk.databinding.DebugkActivityTabkTopBinding
import com.mozhimen.xmlk.layoutk.tab.commons.ITabSelectedListener
import com.mozhimen.xmlk.layoutk.tab.top.mos.MTabTop
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB


/**
 * @ClassName DebugUIKActivity
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2022/11/16 15:25
 * @Version 1.0
 */
abstract class BaseDebugKTabKTopActivity : BaseActivityVDB<DebugkActivityTabkTopBinding>() {
    private val _tabList: ArrayList<DebugKUITabTopItem> by lazy_ofNone { getTabList() }

    abstract fun getTabList(): ArrayList<DebugKUITabTopItem>

    override fun initFlag() {
        initAdaptKSystemBar()
    }

    @OptIn(OPermission_INTERNET::class)
    override fun initView(savedInstanceState: Bundle?) {
        vdb.debugkUiTabTop.setTabTopHeight(20f.dp2px())
        vdb.debugkUiTabTop.inflateTabItem(_tabList)
        vdb.debugkUiTabTop.addTabItemSelectedListener(object : ITabSelectedListener<MTabTop> {
            override fun onTabItemSelected(index: Int, prevItem: MTabTop?, currentItem: MTabTop) {
                showLayoutView((currentItem as DebugKUITabTopItem).viewId)
            }
        })
        vdb.debugkUiTabTop.defaultSelected(_tabList[0])
    }

    private fun showLayoutView(viewId: Int) {
        vdb.debugkUiLayoutContainer.removeAllViews()
        val view = LayoutInflater.from(this).inflate(viewId, null)
        vdb.debugkUiLayoutContainer.addView(view, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
    }

    data class DebugKUITabTopItem(
        val tabName: String,
        val viewId: Int
    ) : MTabTop(tabName, UtilKRes.gainColor(com.mozhimen.xmlk.R.color.cok_blue_287ff1), UtilKRes.gainColor(com.mozhimen.xmlk.R.color.cok_blue_287ff1))
}