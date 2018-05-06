package cn.kisoo.forest.bean


class Settings {

    var notifyMe = true
    var keepLight = false
    var openWhiteList = false
    var senseMore = true
    var destroyTask = true
    val appList = ArrayList<Application>()

}

class Application {

    var packageName = ""
    var appName = ""


}