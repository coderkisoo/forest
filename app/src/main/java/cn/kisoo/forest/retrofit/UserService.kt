package cn.kisoo.forest.retrofit

import cn.kisoo.forest.bean.Result
import cn.kisoo.forest.bean.User
import cn.kisoo.forest.constant.URL
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET(URL.REGISTER_URL)
    fun register(@Query("user") user: User): Observable<Result<*>>
}