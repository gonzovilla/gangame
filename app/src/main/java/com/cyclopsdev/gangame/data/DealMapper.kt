package com.cyclopsdev.gangame.data

import com.cyclopsdev.gangamesdk.Deal

object DealMapper {

    fun fromSdk(deal: Deal): com.cyclopsdev.gangame.Deal{
        return com.cyclopsdev.gangame.Deal(
                deal.title,
                deal.salePrice,
                deal.normalPrice,
                deal.metacriticScore,
                deal.steamRating,
                deal.thumb)
    }
}