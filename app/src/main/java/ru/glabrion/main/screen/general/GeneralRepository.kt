package ru.glabrion.main.screen.general

import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import kotlin.coroutines.CoroutineContext

class GeneralRepository : GeneralContractInterface.Repository, KoinComponent, CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    override suspend fun getContent() =
        withContext(coroutineContext) {
            delay(2000)
            "HELLO"
        }

}