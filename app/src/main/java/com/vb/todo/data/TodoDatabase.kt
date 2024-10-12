package com.vb.todo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vb.todo.data.models.TodoTask


@Database(entities = [TodoTask::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao


}