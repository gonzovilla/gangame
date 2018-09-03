package com.cyclopsdev.gangamesdk

object Routes {

    //  https://steamspy.com/api.php?request=top100in2weeks
    //  https://steamspy.com/api.php?request=top100owned
    //  https://www.cheapshark.com/api/1.0/deals?storeID=1

    const val CHEAP_SHARK_STEAM_STORE = 1

    const val BASE_URL = "https://steamspy.com/api.php/"
    const val BASE_URL_STEAM_SPY = "https://steamspy.com/api.php"
    const val BASE_URL_CHEAP_SHARK = "https://www.cheapshark.com/api/1.0"

    const val GET_TOP_100_GAMES = BASE_URL_STEAM_SPY + "?request=top100in2weeks"
    const val GET_MOST_OWNED_GAMES = BASE_URL_STEAM_SPY + "?request=top100owned"
    const val GET_DEALS = BASE_URL_CHEAP_SHARK + "/deals?storeID=" + CHEAP_SHARK_STEAM_STORE

}