package dev.eduardosouza.blockchain

import java.time.Instant

data class BlockChain(
    var genesis: Block,
    var chain: List<Block> = mutableListOf(genesis),
    var difficult: Int = 1
) {

    fun addBlock(from: String, to: String, amount: Long) {

        var lastBlock = this.chain.last()
        var newBlock = Block(
            data = mapOf(
                "from" to from,
                "to" to to,
                "amount" to amount
            ),
            previousHash = lastBlock.hash,
            timestamp = Instant.now()
        )

        newBlock.mine(this.difficult)
        this.chain += newBlock
        this.difficult++

        println("New block added")
        println("Difficult is now: ${this.difficult}")
    }

    fun isValid(): Boolean {

        for(i in 1 until (this.chain.size)) {

            val currentBlock = this.chain[i]
            val previousBlock = this.chain[i-1]

            println("Previous: $previousBlock")
            println("Current $currentBlock")

            if (currentBlock.hash != currentBlock.calculateHash()
                && currentBlock.previousHash != previousBlock.hash) {
                return false
            }
        }

        return true
    }
}
