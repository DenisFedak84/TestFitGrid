package com.example.testfitgridgraph.di
import android.content.Context
import androidx.room.Room
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.subscription.WebSocketSubscriptionTransport
import com.example.testfitgridgraph.db.LaunchDao
import com.example.testfitgridgraph.db.LaunchDatabase
import com.example.testfitgridgraph.rx.NotesApi
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class NetworkModule {

    private var instance: ApolloClient? = null

    @AppScope
    @Provides
    internal fun provideApiService(client: OkHttpClient, gson: GsonConverterFactory, rxAdapter: RxJava2CallAdapterFactory): NotesApi {
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(gson)
            .addCallAdapterFactory(rxAdapter)
            .build()

        return retrofit.create(NotesApi::class.java)
    }

    @AppScope
    @Provides
    internal fun provideHttpClient(logger: HttpLoggingInterceptor): OkHttpClient {
        val builder = OkHttpClient()
            .newBuilder()
            .addInterceptor(logger)
        return builder.build()
    }

    @AppScope
    @Provides
    internal fun provideInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @AppScope
    @Provides
    internal fun provideRxAdapter(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    internal fun provideGsonClient(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    companion object {
        private const val BASE_URL = "https://gorest.co.in"
    }

//    apollo-codegen download-schema https://gorest.co.in/public/v1/users --output schema.json

//    mkdir -p app/src/main/graphql/com.example.testfitgridgraph/./gradlew :app:downloadApolloSchema
//    --endpoint='https://gorest.co.in/'
//    --schema='app/src/main/graphql/com.example.testfitgridgraph/schema.json'

//    apollo schema:download --endpoint='https://gorest.co.in schema.json


    @AppScope
    @Provides
    internal fun provideGraphQlClient():ApolloClient{

        if (instance != null) {
            return instance!!
        }

        val okHttpClient = OkHttpClient.Builder().build()

        instance = ApolloClient.builder()
            .serverUrl("https://apollo-fullstack-tutorial.herokuapp.com/graphql")
            .subscriptionTransportFactory(WebSocketSubscriptionTransport.Factory("wss://apollo-fullstack-tutorial.herokuapp.com/graphql", okHttpClient))
            .okHttpClient(okHttpClient)
            .build()

        return instance!!
    }

    @Provides
    internal fun provideLaunchDao(context: Context): LaunchDao {
        return Room.databaseBuilder(context, LaunchDatabase::class.java, "launch").build().launchDao()
    }
}

