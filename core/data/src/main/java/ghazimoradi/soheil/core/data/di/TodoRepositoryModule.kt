package ghazimoradi.soheil.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ghazimoradi.soheil.core.data.TodoRepository
import ghazimoradi.soheil.core.data.TodoRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class TodoRepositoryModule {
    @Binds
    abstract fun bindTodoRepositoryImpl(todoRepositoryImpl: TodoRepositoryImpl): TodoRepository
}