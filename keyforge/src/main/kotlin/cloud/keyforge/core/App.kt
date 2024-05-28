package cloud.keyforge.core

import cloud.keyforge.common.Constants.KEYFORGE_API_URL
import cloud.keyforge.common.KeyforgeClient
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main() {

    KeyforgeAPI.getAPIs(accountToken = "eJxKuaCi95y1VIO2jwSJXax9z5mS4OFOLAcOjSunvNrO2zFiDTko23V5IzVoWSjk").let {
        println(it)
    }

}