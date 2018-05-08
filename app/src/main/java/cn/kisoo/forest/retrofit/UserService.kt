package cn.kisoo.forest.retrofit

import cn.kisoo.forest.bean.Result
import cn.kisoo.forest.bean.ResultEmpty
import cn.kisoo.forest.bean.User
import cn.kisoo.forest.constant.URL
import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {

    @POST(URL.REGISTER_URL)
    fun register(@Query("uUsername") uUsername: String,
                 @Query("uPicture") uPicture: String,
                 @Query("uName") uName: String,
                 @Query("uSchoolnumber") uSchoolnumber: String,
                 @Query("uPassword") uPassword: String): Observable<ResultEmpty>

    @POST(URL.LOGIN_URL)
    fun login(@Query("username") username: String,
              @Query("password") password: String): Observable<Result<User>>

    @POST(URL.MODIFY_PWD_URL)
    fun modifyPwd(@Query("uId") uId: String,
                  @Query("uPassword") uPassword: String): Observable<Result<User>>


    @POST(URL.MODIFY_USER_URL)
    fun modifyName(@Query("uId") uId: String,
                   @Query("uName") uName: String): Observable<Result<User>>

    @POST(URL.MODIFY_USER_URL)
    fun modifySchoolNum(@Query("uId") uId: String,
                        @Query("uSchoolnumber") uSchoolnumber: String): Observable<Result<User>>

    @POST(URL.MODIFY_USER_URL)
    fun modifyHead(@Query("uId") uId: String,
                   @Query("uPicture") uPicture: String): Observable<Result<User>>

    @POST(URL.GET_USER_URL)
    fun getUser(@Query("uid") uId: String): Observable<Result<*>>

    @POST(URL.INSERT_TASK_URL)
    fun insertTask(@Query("tId") tId: String,
                   @Query("uId") uId: String,
                   @Query("tLength") tLength: String,
                   @Query("StringStartTime") tStarttime: String?,
                   @Query("tSuccessLength") tSuccessLength: String,
                   @Query("isSuccess") isSuccess: String): Observable<Result<*>>

    @POST(URL.GET_TASK_LIST_URL)
    fun getTaskList(@Query("tId") tId: String,
                    @Query("uId") uId: String,
                    @Query("tLength") tLength: String,
                    @Query("tStarttime") tStarttime: String,
                    @Query("tSuccessLength") tSuccessLength: String,
                    @Query("isSuccess") isSuccess: String): Observable<Result<*>>

    @POST(URL.GET_WHITE_LIST)
    fun getWhiteList(@Query("uid") uid: String): Observable<Result<String>>

    @POST(URL.UPLOAD_WHITE_LIST)
    fun insertWhiteList(@Query("uId") uid: String,
                        @Query("wlistName") wlistName: String?): Observable<Result<Any>>

    @POST(URL.MODIFY_WHITE_LIST)
    fun modifyWhiteList(@Query("uid") uid: String,
                        @Query("wlistName") wlistName: String): Observable<Result<*>>

    @POST(URL.USER_COURSE)
    fun getCourse(@Query("uSchoolnumber") uSchoolnumber: String): Observable<Result<*>>


}