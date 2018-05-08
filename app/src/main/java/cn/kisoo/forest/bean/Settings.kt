package cn.kisoo.forest.bean


class Settings {
    fun update(settings: Settings?): Boolean {
        var mUpdate = false
        if (settings == null) {
            return mUpdate
        }
        if (notifyMe != settings.notifyMe) {
            mUpdate = true || mUpdate
            notifyMe = settings.notifyMe
        }
        if (keepLight != settings.keepLight) {
            mUpdate = true || mUpdate
            keepLight = settings.keepLight
        }
        if (openWhiteList != settings.openWhiteList) {
            mUpdate = true || mUpdate
            openWhiteList = settings.openWhiteList
        }
        if (senseMore != settings.senseMore) {
            mUpdate = true || mUpdate
            senseMore = settings.senseMore
        }
        if (destroyTask != settings.destroyTask) {
            mUpdate = true || mUpdate
            destroyTask = settings.destroyTask
        }
        if (appList != settings.appList) {
            mUpdate = true || mUpdate
            appList.clear()
            appList.addAll(settings.appList)
        }
        return mUpdate
    }

    var notifyMe = true
    var keepLight = false
    var openWhiteList = false
    var senseMore = false
    var destroyTask = true
    val appList = ArrayList<Application>()

}

class Application {

    var packageName = ""
    var appName = ""


}