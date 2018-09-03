package com.cyclopsdev.gangame.data

import com.cyclopsdev.gangamesdk.TopGame

object TopGameMapper {
    fun fromSdk(topGame: TopGame, position: Int): com.cyclopsdev.gangame.TopGame{

        val owners = if (topGame.owners.isEmpty()) 0 else if(topGame.owners.equals("5,000,000 .. 10,000,000")) 50000000 else if(topGame.owners.equals("10,000,000 .. 20,000,000")) 10000000 else if(topGame.owners.equals("20,000,000 .. 50,000,000")) 20000000 else if(topGame.owners.equals("50,000,000 .. 100,000,000")) 50000000 else if(topGame.owners.equals("100,000,000 .. 200,000,000")) 100000000 else if(topGame.owners.contains("..")) 4444444 else Integer.parseInt(topGame.owners)

        return com.cyclopsdev.gangame.TopGame(
                topGame.title,
                owners,
                topGame.steamRating,
                topGame.publisher,
                topGame.price,
                position,
                topGame.thumb)
    }
}