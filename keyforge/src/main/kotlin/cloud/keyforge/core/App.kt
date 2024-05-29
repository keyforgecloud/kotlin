package cloud.keyforge.core

fun main() {
    KeyforgeAPI.accountToken = "eJxKuaCi95y1VIO2jwSJXax9z5mS4OFOLAcOjSunvNrO2zFiDTko23V5IzVoWSjk"

//    KeyforgeAPI.getAPIs(accountToken = "eJxKuaCi95y1VIO2jwSJXax9z5mS4OFOLAcOjSunvNrO2zFiDTko23V5IzVoWSjk").let {
//        println("Get APIS[0]: ${it.results.first()}")
//    }

    KeyforgeAPI
        .createAPI("My name")
        .let {
            println("Create API: $it")
        }
}