package cloud.keyforge.core

import cloud.keyforge.common.types.requests.CreateKeyRequestBody

fun main() {
    KeyforgeAPI.accountToken = "L4klt6r4TW3zaS213OSGTCii2nCSHUlKwuSZXn8TdtFAen5NmhwYqegW3AaWFnoR"

//    KeyforgeAPI.getAPIs(accountToken = "eJxKuaCi95y1VIO2jwSJXax9z5mS4OFOLAcOjSunvNrO2zFiDTko23V5IzVoWSjk").let {
//        println("Get APIS[0]: ${it.results.first()}")
//    }

/*    val apis = KeyforgeAPI.getAPIs()
    apis.results.forEach { api ->
        KeyforgeAPI.deleteAPI(api.id)
    }

    val api = KeyforgeAPI.createAPI("My API")
    println("API: $api")*/

    KeyforgeAPI.createKey(CreateKeyRequestBody(

    ), "api_ehgjKiw7jjQMj2SfgROxfA3v")
        .let(::println)

//    apis.forEach { api ->
//        println("API: ${api.id}")
//    }

//    KeyforgeAPI
//        .createAPI("My name")
//        .let {
//            println("Create API: $it")
//        }
}