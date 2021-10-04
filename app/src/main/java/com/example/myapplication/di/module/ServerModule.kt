package com.example.myapplication.di.module

import com.fasterxml.jackson.databind.SerializationFeature
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.jackson.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

@InstallIn(ServiceComponent::class)
@Module
object ServerModule {
    fun main(args: Array<String>) {
        embeddedServer(Netty, 8080) {
            install(StatusPages) {
                exception<Throwable> { e ->
                    call.respondText(e.localizedMessage, ContentType.Text.Plain, HttpStatusCode.InternalServerError)
                }
            }
            install(ContentNegotiation) {
                jackson {
                    enable(SerializationFeature.INDENT_OUTPUT)
                }
            }
            routing {
                get("/") {
                    call.respond(Response(status = "OK"))
                }
            }
        }.start(wait = true)
    }
    data class Response(val status: String)

}