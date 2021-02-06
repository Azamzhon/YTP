package com.azamzhon.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.azamzhon.data.local.converter.ContentDetailsConverter
import com.azamzhon.data.local.converter.ImageInfoConverter
import com.azamzhon.data.local.converter.MediumConverter
import com.azamzhon.data.local.converter.SnippetConverter
import com.azamzhon.data.local.dao.YoutubeDao
import com.azamzhon.data.models.PlaylistItem

@Database(entities = [PlaylistItem::class], version = 1, exportSchema = false)
@TypeConverters(
    ContentDetailsConverter::class,
    ImageInfoConverter::class,
    MediumConverter::class,
    SnippetConverter::class
)
abstract class YoutubeDataBase : RoomDatabase() {

    abstract fun wordDao(): YoutubeDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: YoutubeDataBase? = null

        fun getDatabase(context: Context): YoutubeDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    YoutubeDataBase::class.java,
                    "word_database"
                )
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}