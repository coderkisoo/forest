package cn.kisoo.forest.constant

import android.app.Application
import cn.kisoo.forest.util.ToastUtils
import com.jude.beam.Beam
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Beam.init(this)
        ToastUtils.register(this)
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}