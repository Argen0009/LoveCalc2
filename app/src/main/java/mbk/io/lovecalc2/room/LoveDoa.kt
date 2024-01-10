package mbk.io.lovecalc2.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import mbk.io.lovecalc2.model.LoveModel

@Dao
interface LoveDoa {
    @androidx.room.Query("SELECT * FROM `love-table`")
    fun getAll(): List<LoveModel>

    @Insert
    fun insert(vararg users: LoveModel)

    @Query("SELECT * FROM `love-table` ORDER BY firstName ASC")
    fun getAllInAlphabeticalOrder(): List<LoveModel>

    @Query("SELECT * FROM `love-table` ORDER BY :columnName ASC")
    fun getAllSorted(columnName: String): List<LoveModel>
}