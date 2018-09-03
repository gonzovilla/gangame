package com.cyclopsdev.gangame.data

import com.cyclopsdev.gangame.TopGame
import com.cyclopsdev.gangame.Deal
import com.cyclopsdev.gangamesdk.GangameApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object GangameDataSource {
    val apiService = GangameApiService()

    fun getDeals(): Observable<ArrayList<Deal>>{
        return apiService.apiClient
                .getDealsObservable()
                .map { listDeal ->
                    val deals:List<Deal> = listDeal.map { deal -> DealMapper.fromSdk(deal) }
                    val arrayList = arrayListOf<Deal>()
                    arrayList.addAll(deals)
                    arrayList
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())

    }

    fun getTopRated(): Observable<ArrayList<TopGame>>{
        return apiService.apiClient
                .getTopRatedGamesObservable()
                .map { listTopGames ->
                    val games:List<TopGame> = listTopGames.mapIndexed { index, game ->
                        TopGameMapper.fromSdk(game, index + 1)
                    }
                    val arrayList = arrayListOf<TopGame>()
                    arrayList.addAll(games)
                    arrayList
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())

    }

    fun getMostOwned(): Observable<ArrayList<TopGame>>{
        return apiService.apiClient
                .getMostOwnedGamesObservable()
                .map { listTopGames ->
                    val games:List<TopGame> = listTopGames.mapIndexed { index, game ->
                        TopGameMapper.fromSdk(game, index + 1)
                    }
                    val arrayList = arrayListOf<TopGame>()
                    arrayList.addAll(games)
                    arrayList
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())

    }
}