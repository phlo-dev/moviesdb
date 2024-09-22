package br.com.data.remote.factory

import br.com.data.remote.RequestInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object ServiceClientFactory {
    const val JSON_CONTENT_TYPE = "application/json"

    inline fun <reified T> createService(
        url: String, okHttpClient: OkHttpClient?
    ): T {
        val contentType = JSON_CONTENT_TYPE.toMediaType()
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(Json.asConverterFactory(contentType))
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