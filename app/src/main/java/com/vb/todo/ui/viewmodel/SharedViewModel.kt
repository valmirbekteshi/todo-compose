package com.vb.todo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vb.todo.data.models.TodoTask
import com.vb.todo.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {


    private val _allTask = MutableStateFlow<List<TodoTask>>(emptyList())
    val allTask : StateFlow<List<TodoTask>> = _allTask


    fun getAllTask(){
        viewModelScope.launch {
            repository.getAllTask.collect{
                _allTask.value = it
            }
        }
    }

}