package ghazimoradi.soheil.core.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ghazimoradi.soheil.core.database.TodoDataBase

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Provides
    fun provideToDoDao(dataBase: TodoDataBase) = dataBase.getTodoDao()

    @Provides
    fun provideDataBaseName(): String {
        return TodoDataBase.DATABASE_NAME
    }

    @Provides
    fun provideTodoDatabase(
        @ApplicationContext context: Context,
        dataBaseName: String
    ): TodoDataBase =
        Room.databaseBuilder(context, TodoDataBase::class.java, dataBaseName).build()
}