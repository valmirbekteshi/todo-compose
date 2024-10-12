package com.vb.todo.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.vb.todo.data.models.Priority
import com.vb.todo.data.models.TodoTask
import kotlinx.coroutines.flow.Flow


@Dao
interface TodoDao {

    @Query("Select * FROM todo_table ORDER BY id ASC ")
    fun getAllTask(): Flow<List<TodoTask>>

    @Query("Select * from todo_table WHERE id=:taskId")
    fun getSelectedTask(taskId: Int): Flow<List<TodoTask>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addTask(todoTask: TodoTask)

    @Update
    fun updateTask(todoTask: TodoTask)

    @Delete
    fun deleteTask(todoTask: TodoTask)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTask()

    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery ")
    fun searchTodoTask(searchQuery: String): Flow<List<TodoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1  WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Flow<List<TodoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1  WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<TodoTask>>
}