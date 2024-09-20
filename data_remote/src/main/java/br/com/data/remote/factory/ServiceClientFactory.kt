package br.com.data.remote.factory

import br.com.data.remote.RequestInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object ServiceClientFactory {

    inline fun <reified T> createService(
        url: String, okHttpClient: OkHttpClient?
    ): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addClient(okHttpClient)
            .build()

        return retrofit.create(T::class.java)
    }

    fun Retrofit.Builder.addClient(okHttpClient: OkHttpClient?): Retrofit.Builder =
        when (okHttpClient != null) {
            true -> client(okHttpClient)
            else -> this
        }

    fun createOkHttpClient(
        requestInterceptor: RequestInterceptor, httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()

        with(clientBuilder) {
            addInterceptor(httpLoggingInterceptor)
            addInterceptor(requestInterceptor)

            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
        }

        return clientBuilder.build()
    }

    fun createHttpLoggingInterceptor() = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        this
    }

//    object UnitConverterFactory : Converter.Factory() {
//        override fun responseBodyConverter(
//            type: Type, annotations: Array<out Annotation>,
//            retrofit: Retrofit
//        ): Converter<ResponseBody, *>? {
//            return if (type == Unit::class.java) UnitConverter else null
//        }
//
//        private object UnitConverter : Converter<ResponseBody, Unit> {
//            override fun convert(value: ResponseBody) {
//                value.close()
//            }
//        }
//    }

}