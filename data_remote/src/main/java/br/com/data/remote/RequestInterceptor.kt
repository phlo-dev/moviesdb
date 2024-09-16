package br.com.data.remote

import br.com.data.remote.service.API_KEY_QUERY
import br.com.data.remote.service.API_QUERY_VALUE
import br.com.data.remote.service.LANGUAGE_PT_VALUE
import br.com.data.remote.service.LANGUAGE_QUERY
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val baseRequest = chain.request()

        val url = baseRequest.url
            .newBuilder()
            .addQueryParameter(API_KEY_QUERY, API_QUERY_VALUE)
            .addQueryParameter(LANGUAGE_QUERY, LANGUAGE_PT_VALUE)
            .build()

        val requestBuilder = baseRequest.newBuilder()
            .url(url)

        val request = requestBuilder.build()

        return chain.proceed(request)
    }

}