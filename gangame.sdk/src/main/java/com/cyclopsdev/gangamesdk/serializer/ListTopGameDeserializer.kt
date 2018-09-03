package com.cyclopsdev.gangamesdk.serializer

import com.cyclopsdev.gangamesdk.TopGame
import com.google.gson.*
import java.lang.reflect.Type

class ListTopGameDeserializer : JsonDeserializer<ArrayList<TopGame>> {
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): ArrayList<TopGame> {
        val jsonTopGames = json.asJsonObject
                .entrySet()
                .map { (key, json) ->
                    json.asJsonObject
                }

        val gson = GsonBuilder()
                .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
                .create()

        val listTopGames: List<TopGame> = jsonTopGames.map { json ->

            gson.fromJson(json, TopGame::class.java)

        }

        val arrayListTopGames: ArrayList<TopGame> = arrayListOf()
        arrayListTopGames.addAll(listTopGames)

        return arrayListTopGames
    }
}