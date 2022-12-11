package com.stathis.secondassignment.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.stathis.secondassignment.abstraction.UiModel
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.NonNls

@Parcelize
@Entity(tableName = "countries")
data class Country(
    @NonNull
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "capital")
    var capital: String,

    @ColumnInfo(name = "population")
    var population: Long

) : UiModel, Parcelable {
    override fun equals(obj: UiModel): Boolean = when (obj) {
        is Country -> name == obj.name && capital == obj.capital && population == obj.population
        else -> false
    }
}
