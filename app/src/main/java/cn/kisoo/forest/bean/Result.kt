package cn.kisoo.forest.bean

class Result<T> {
    var code: String = "0"
    var message: String? = ""
    val data: T? = null
}