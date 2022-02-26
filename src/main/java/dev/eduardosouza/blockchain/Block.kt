package dev.eduardosouza.blockchain

import com.google.gson.Gson
import java.security.MessageDigest
import java.time.Instant

data class Block(
    var data: Map<String, Any> = emptyMap(),
    var hash: String = "",
    var previousHash: String = "",
    var timestamp: Instant,
    var pow: Long = 0L
) {

    fun calculateHash(): String {

        val json = Gson().toJson(this.data)
        // println("JSON: $json")
        var blockData = "${this.previousHash}${json}${this.timestamp.epochSecond}${this.pow}"
        // println("BlockData: $blockData")
        var blockHash: ByteArray = MessageDigest.getInstance("SHA256").digest(blockData.toByteArray())
        val hex = blockHash.toHex()
        // println(hex)

        return hex

    }

    fun mine(difficult: Int) {
        val start = Instant.now().epochSecond

        do {
            this.pow++
            this.hash = this.calculateHash()
        }while (!this.hash.startsWith("0".repeat(difficult)))

        val end = Instant.now().epochSecond
        println("Mining new block took ${end - start} seconds")
    }
}
