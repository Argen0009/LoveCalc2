package mbk.io.lovecalc2.room

import androidx.room.Database
import androidx.room.RoomDatabase
import mbk.io.lovecalc2.model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getDoa(): LoveDoa
}