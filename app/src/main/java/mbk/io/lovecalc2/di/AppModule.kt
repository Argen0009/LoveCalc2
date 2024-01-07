package mbk.io.lovecalc2.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import mbk.io.lovecalc2.Utils
import mbk.io.lovecalc2.model.LoveApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): LoveApi{
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }
    @Provides
    fun provideUtils():Utils{
        return Utils()
    }

    @Provides
    @Singleton
    fun providePreferences(@ApplicationContext context: Context): SharedPreferences{
        return context.getSharedPreferences("fileName", Context.MODE_PRIVATE)
    }

}