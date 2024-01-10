package mbk.io.lovecalc2

import android.app.Application
import androidx.room.Room
import dagger.hilt.android.HiltAndroidApp
import mbk.io.lovecalc2.room.AppDatabase

@HiltAndroidApp
class App : Application(){

    companion object{
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate(){
        super.onCreate()
        appDatabase =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java,"love-file")
                .allowMainThreadQueries().build()
    }
}