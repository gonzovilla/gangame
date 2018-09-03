package com.cyclopsdev.gangamesdk.serializer

import com.cyclopsdev.gangamesdk.TopGame
import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class TopGameDeserializer: JsonDeserializer<TopGame> {

    companion object {
        const val BASE_IMG_URL = "http://cdn.akamai.steamstatic.com/steam/apps/%s/capsule_184x69.jpg"
    }

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): TopGame {
        val gson = Gson()
        val topGame = gson.fromJson(json, TopGame::class.java)
        val appId = json.asJsonObject["appid"].asInt.toString()

        val rawRating =  json.asJsonObject["score_rank"].asString
        val steamRating = if (rawRating.isEmpty()) 0 else Integer.parseInt(rawRating)
        val thumb = String.format(BASE_IMG_URL, appId)

        val rawOwners =  json.asJsonObject["owners"].asString

        //val owners = if (rawOwners.isEmpty()) 0 else if(rawOwners.equals("100,000,000 .. 200,000,000")) 100000000 else Integer.parseInt(rawOwners)

        topGame.thumb = thumb
        topGame.steamRating = steamRating
        topGame.owners = rawOwners
        topGame.price = topGame.price / 100

        return topGame
    }
}