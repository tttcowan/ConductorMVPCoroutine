package com.appsauce.mvpappsauce.remote

import com.appsauce.mvpappsauce.app.Constants
import com.appsauce.mvpappsauce.util.DebugUtil
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.Completable
import io.reactivex.CompletableTransformer
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceProd : ApiService {

    private val gson: Gson = GsonBuilder().create()


    private fun okHttpClient(): OkHttpClient {
        var builder = OkHttpClient.Builder()
        if (DebugUtil.isDebug()) {
            builder = builder.addNetworkInterceptor(StethoInterceptor())
        }
        return builder.build()
    }

    private val service: RetrofitApi =
            Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient())
                    .baseUrl(Constants.ENDPOINT)
                    .build()
                    .create(RetrofitApi::class.java)

    override fun init(): Completable {
        return service.call()
                .compose(completableManageThreads())
    }

    /**
     * Manage single threads.
     */
    private fun <T> singleManageThreads(): SingleTransformer<T, T> {
        return SingleTransformer { single ->
            single.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    /**
     * Manage completable threads.
     */
    private fun completableManageThreads(): CompletableTransformer {
        return CompletableTransformer { completable ->
            completable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }


}