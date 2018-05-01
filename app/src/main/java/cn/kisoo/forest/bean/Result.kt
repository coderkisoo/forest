package cn.kisoo.forest.bean

class Result<T> {
    var code: Int = 0
    var message: String? = ""
    val data: T? = null
}