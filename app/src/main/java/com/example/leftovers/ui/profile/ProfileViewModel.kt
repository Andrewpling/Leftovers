package com.example.leftovers.ui.profile


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    private val _id: MutableState<String> = mutableStateOf("")
    val id: State<String> = _id

    private val _imgpath: MutableState<String> = mutableStateOf("")
    val img_path: State<String> = _imgpath

    private val _name: MutableState<String> = mutableStateOf("")
    val name: State<String> = _name

    private val _location: MutableState<String> = mutableStateOf("")
    val location: State<String> = _location

    private val _distance: MutableState<String> = mutableStateOf("")
    val distance: State<String> = _distance

    private val _isReady: MutableState<Boolean> = mutableStateOf(false)
    val is_ready: State<Boolean> = _isReady

    fun setId(id: String){
        _id.value = id
    }

    fun setImgPath(img_path: String){
        _imgpath.value = img_path
    }

    fun setName(name: String){
         _name.value = name
    }

    fun setLocation(location: String){
        _location.value = location
    }

    fun setDistance(distance: String){
        _distance.value = distance
    }

    fun setIsReady(is_ready: Boolean){
        _isReady.value = is_ready
    }

}