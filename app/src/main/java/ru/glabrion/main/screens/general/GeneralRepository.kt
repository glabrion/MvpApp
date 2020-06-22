package ru.glabrion.main.screens.general

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class GeneralRepository : GeneralContractInterface.Repository, CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    override suspend fun getContent() =
        withContext(coroutineContext) {
            delay(1000)
            "HELLO MVP"
        }

}