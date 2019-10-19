package com.example.desafioconcrete.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafioconcrete.model.ItemPropities
import com.example.desafioconcrete.repository.BaseRepository

class MainViewModel : ViewModel() {

    private val repository = BaseRepository()
    private var repositoriesLiveData = MutableLiveData<ArrayList<ItemPropities>>()
    private val collectionAll = MutableLiveData<ArrayList<ItemPropities>>()

    var page = 1

    init {
        initRequest()
    }

    fun initRequest() {
        repository.getRepositories(page,{

         repositoriesLiveData.value =  it?.items
        },{
           // Log.i("aspk",it)
        })
    }

    fun loadMore(){
        page++
        repository.getRepositories(page,{
            if (it != null) {
                repositoriesLiveData.value?.addAll(it.items)
                collectionAll.value = it.items
            }

        },{
           // Log.i("aspk",it)
        })
    }

    fun getLiveData() = repositoriesLiveData

    fun getLiveDataValue() = repositoriesLiveData.value

    fun getCollectionAll() = collectionAll

}