package com.mozhimen.debugk.temps

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mozhimen.basick.elemk.android.content.cons.CIntent
import com.mozhimen.basick.elemk.androidx.appcompat.bases.databinding.BaseActivityVDB
import com.mozhimen.basick.lintk.optins.OApiInit_InApplication
import com.mozhimen.basick.utilk.android.content.UtilKRes
import com.mozhimen.basick.utilk.android.content.createChooser
import com.mozhimen.basick.utilk.java.io.UtilKFileFormat
import com.mozhimen.debugk.BR
import com.mozhimen.debugk.R
import com.mozhimen.debugk.databinding.DebugkActivityLogkBinding
import com.mozhimen.debugk.databinding.DebugkItemCrashkFileBinding
import com.mozhimen.debugk.mos.MDebugKCrashK
import com.mozhimen.logk.LogKMgr
import com.mozhimen.logk.temps.printer.LogKPrinterFile
import com.mozhimen.xmlk.recyclerk.quick.AdapterKQuickRecyclerVB

/**
 * @property _dataSets ArrayList<MDebugKCrashK>
 */
class DebugKLogKActivity : BaseActivityVDB<DebugkActivityLogkBinding>() {

    private val _dataSets = ArrayList<MDebugKCrashK>()
    @OptIn(OApiInit_InApplication::class)
    override fun initView(savedInstanceState: Bundle?) {
        val logFiles = LogKMgr.instance.getPrinters().filterIsInstance<LogKPrinterFile>().getOrNull(0)?.getLogFiles()/*LogKPrinterFile.getInstance(0).getLogFiles()*/

        if (logFiles != null) {
            for (logFile in logFiles)
                _dataSets.add(MDebugKCrashK(logFile.name, logFile))
        }

        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        decoration.setDrawable(UtilKRes.gainDrawable(R.drawable.debugk_crashk_divider)!!)
        vdb.debugkLogkRecycler.addItemDecoration(decoration)

        vdb.debugkLogkRecycler.layoutManager = LinearLayoutManager(this)
        val adapterKRecycler =
                AdapterKQuickRecyclerVB<MDebugKCrashK, DebugkItemCrashkFileBinding>(
                        _dataSets,
                        R.layout.debugk_item_crashk_file,
                        BR.itemDebugKCrashK
                ) { holder, itemData, _, _ ->
                    holder.vdb.debugkCrashkFileShare.setOnClickListener {
                        val intent = Intent(CIntent.ACTION_SEND)
                        intent.putExtra("subject", "")
                        intent.putExtra("body", "")

                        val uri = UtilKFileFormat.file2uri(itemData.file)
                        intent.putExtra(CIntent.EXTRA_STREAM, uri)//添加文件
                        if (itemData.file.name.endsWith(".txt")) {
                            intent.type = "text/plain"//纯文本
                        } else {
                            intent.type = "application/octet-stream" //二进制文件流
                        }
                        startActivity(intent.createChooser("分享Log 日志文件"))
                    }
                }
        vdb.debugkLogkRecycler.adapter = adapterKRecycler
    }
}