package com.app.myapplication5

import com.app.myapplication5.utilities.roomdatabases.Data

/*class DataPOJO{

    var status:Boolean= false
    var is_deactivated:Boolean= false
    var message: String?=null
    var data: Data?=null

    class Data(
        var `data`: List<com.app.myapplication5.utilities.roomdatabases.Data>?,
        val page: Int,
        val per_page: Int,
        val support: Support?,
        val total: Int,
        val total_pages: Int,
    )
}*/

data class DataPOJO(
    var `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support?,
    val total: Int,
    val total_pages: Int,
)
