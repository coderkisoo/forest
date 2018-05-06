package cn.kisoo.forest.model

import android.annotation.SuppressLint
import android.content.Context
import cn.kisoo.forest.bean.Application
import cn.kisoo.forest.bean.Settings
import cn.kisoo.forest.bean.Whitelist
import com.google.gson.Gson
import io.realm.Realm

@SuppressLint("StaticFieldLeak")
object UserSettingModel {

    const val KEY_NOTIFY_ME = "key_notify_me"
    const val KEY_OPEN_WHITE_LIST = "key_open_white_list"
    const val KEY_KEEP_LIGHT = "key_keep_light"
    const val KEY_SENSE_MORE = "key_sense_more"
    const val KEY_DESTROY_TASK = "key_destroy_task"

    var mContext: Context? = null

    var mWhiteList: Whitelist = lazy {
        var list = Realm.getDefaultInstance().where(Whitelist::class.java).equalTo("uId", UserAccountModel.UID()).findFirst()
        if (list == null) {
            list = Whitelist()
        }
        list
    }.value


    var mSettings: Settings = lazy {
        var settings = Gson().fromJson(mWhiteList.wlistName, Settings::class.java)
        if (settings == null) {
            settings = Settings()
        }
        settings
    }.value

    fun init(context: Context) {
        this.mContext = context
    }

    private fun getSettings() = mSettings

    fun updateSettings(key: String, open: Boolean) {
        when (key) {
            KEY_NOTIFY_ME -> mSettings.notifyMe = open
            KEY_KEEP_LIGHT -> mSettings.keepLight = open
            KEY_SENSE_MORE -> mSettings.senseMore = open
            KEY_DESTROY_TASK -> mSettings.destroyTask = open
            KEY_OPEN_WHITE_LIST -> mSettings.openWhiteList = open
        }
        val result = Realm.getDefaultInstance().where(Whitelist::class.java).equalTo("uId", UserAccountModel.UID()).findFirst()
        if (result == null) {
            Realm.getDefaultInstance().executeTransaction {
                val list = it.createObject(Whitelist::class.java, UserAccountModel.UID())
                list.wlistName = Gson().toJson(mSettings)
            }
        } else {
            Realm.getDefaultInstance().beginTransaction()
            result.wlistName = Gson().toJson(mSettings)
            Realm.getDefaultInstance().commitTransaction()
        }
    }

    fun updateSettingsApplist(list: ArrayList<Application>) {
        mSettings.appList.clear()
        mSettings.appList.addAll(list)
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        val result = realm.where(Whitelist::class.java).equalTo("uId", UserAccountModel.UID()).findFirst()
        result.wlistName = Gson().toJson(mSettings)
        realm.commitTransaction()
    }

    fun uploadSettings() {
        val result = Realm.getDefaultInstance().where(Whitelist::class.java).equalTo("uId", UserAccountModel.UID()).findFirst()
        //todo 转化result 上传 即可
    }

    fun clearData() {
        Realm.getDefaultInstance().executeTransaction{
            it.delete(Whitelist::class.java)
        }
    }

    fun currentAppList(): ArrayList<Application> = mSettings.appList

    fun recoverySettings() {
        mSettings.notifyMe = true
        mSettings.keepLight = false
        mSettings.openWhiteList = false
        mSettings.senseMore = false
        mSettings.destroyTask = true
        val result = Realm.getDefaultInstance().where(Whitelist::class.java).equalTo("uId", UserAccountModel.UID()).findFirst()
        if (result == null) {
            Realm.getDefaultInstance().executeTransaction {
                val list = it.createObject(Whitelist::class.java, UserAccountModel.UID())
                list.wlistName = Gson().toJson(mSettings)
            }
        } else {
            Realm.getDefaultInstance().beginTransaction()
            result.wlistName = Gson().toJson(mSettings)
            Realm.getDefaultInstance().commitTransaction()
        }
    }

    fun currentSettings(): Settings = mSettings

}