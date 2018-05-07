package cn.kisoo.forest.model

import cn.kisoo.forest.R
import cn.kisoo.forest.bean.Result
import cn.kisoo.forest.bean.ResultEmpty
import cn.kisoo.forest.bean.Task
import cn.kisoo.forest.bean.User
import cn.kisoo.forest.constant.StatusCode
import cn.kisoo.forest.constant.URL
import cn.kisoo.forest.presenter.activity.LoginActivityPresenter
import cn.kisoo.forest.presenter.activity.RegisterActivityPresenter
import cn.kisoo.forest.retrofit.UserService
import cn.kisoo.forest.util.ToastUtils
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitModel {

    val service = Retrofit.Builder()
            .baseUrl(URL.baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())//新的配置
            .build()
            .create(UserService::class.java)

    fun uploadTasks(tasks: List<Task>) {

    }

    fun login(account: String, password: String, listener: LoginActivityPresenter.LoginListener) {
        service.login(account, password)
                .subscribeOn(Schedulers.newThread())//请求在新的线程中执行
                .observeOn(Schedulers.io())         //请求完成后在io线程中执行
                .doOnNext { it ->
                    if (StatusCode.LOGINSUCCESS == it.code) {
                        UserAccountModel.initUser(it?.data)
                    }
                }
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(object : Observer<Result<User>> {
                    override fun onComplete() {

                        ToastUtils.shortToast(R.string.login_success)
                    }

                    override fun onSubscribe(d: Disposable) {}

                    override fun onNext(t: Result<User>) {
                        if (StatusCode.LOGINSUCCESS == t.code) {
                            listener.success()
                        } else {
                            listener.fail()
                            ToastUtils.shortToast(t.message)
                        }
                    }

                    override fun onError(e: Throwable) {
                        listener.fail()
                        ToastUtils.shortToast(e.localizedMessage)
                    }

                })
    }

    fun register(account: String, name: String, headType: String, password: String, schoolNum: String, registerListener: RegisterActivityPresenter.RegisterListener) {
        service.register(account, headType, name, schoolNum, password)
                .subscribeOn(Schedulers.newThread())//请求在新的线程中执行
                .observeOn(Schedulers.io())         //请求完成后在io线程中执行
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(object : Observer<ResultEmpty> {
                    override fun onComplete() {
                        ToastUtils.shortToast(R.string.login_success)
                    }

                    override fun onSubscribe(d: Disposable) {}

                    override fun onNext(t: ResultEmpty) {
                        if (StatusCode.REGISTERSUCCESS == t.code) {
                            registerListener.onSuccess()
                        } else {
                            registerListener.onFail()
                            ToastUtils.shortToast(t.message)
                        }
                    }

                    override fun onError(e: Throwable) {
                        registerListener.onFail()
                        ToastUtils.shortToast(e.localizedMessage)
                    }

                })
    }

}