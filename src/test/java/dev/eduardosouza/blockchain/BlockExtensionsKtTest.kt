package dev.eduardosouza.blockchain

import org.junit.jupiter.api.Test
import java.time.Instant

class BlockExtensionsKtTest {

    @Test
    fun `testando`() {

        val genesis = Block(
            hash = "0",
            timestamp = Instant.now()
        )

        val blockChain = BlockChain(genesis, difficult = 1)

        blockChain.addBlock("A", "B", 1)
        blockChain.addBlock("A", "B", 2)
        blockChain.addBlock("A", "B", 3)
        blockChain.addBlock("A", "B", 4)
        blockChain.addBlock("A", "B", 5)
        blockChain.addBlock("A", "B", 6)
        // blockChain.addBlock("A", "B", 7)
        // blockChain.addBlock("A", "B", 8)
        // blockChain.addBlock("A", "B", 9)
        // blockChain.addBlock("A", "B", 10)
        // blockChain.addBlock("A", "B", 11)
        // blockChain.addBlock("A", "B", 12)
        // blockChain.addBlock("A", "B", 13)
        // blockChain.addBlock("A", "B", 14)

        println(blockChain.isValid())
    }

}
