package com.vb.todo.data.repository

import com.vb.todo.data.TodoDao
import com.vb.todo.data.models.TodoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@ViewModelScoped
class TodoRepository @Inject constructor(private val todoDao: TodoDao) {

    val getAllTask: Flow<List<TodoTask>> = todoDao.getAllTask()

    val sortByLowPriority: Flow<List<TodoTask>> = todoDao.sortByLowPriority()

    val sortByHighPriority: Flow<List<TodoTask>> = todoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<List<TodoTask>> = todoDao.getSelectedTask(taskId)

    suspend fun addTask(todoTask: TodoTask) = todoDao.addTask(todoTask)
    suspend fun deleteTask(todoTask: TodoTask) = todoDao.deleteTask(todoTask)

    suspend fun deleteAllTask() = todoDao.deleteAllTask()

    fun searchDatabase(searchQuery: String): Flow<List<TodoTask>> =
        todoDao.searchTodoTask(searchQuery)
}