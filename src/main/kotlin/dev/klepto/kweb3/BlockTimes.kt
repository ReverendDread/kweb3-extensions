package dev.klepto.kweb3

import dev.klepto.kweb3.net.web3j.Web3jClient
import org.web3j.protocol.core.DefaultBlockParameter

/**
 * @project kweb3-extensions
 * @author andy@hlwgroup.dev - 5/10/2023 6:26 PM
 */
val blockSamples = 10_000

fun Web3jClient.averageBlockTime(): Long {
    val web3j = session.web3j
    val samples = blockSamples.toBigInteger()
    val currentBlockNumber = web3j.ethBlockNumber().send().blockNumber
    val currentBlock = web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(currentBlockNumber), false).send().block
    val previousBlock = web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(currentBlockNumber - samples), false).send().block
    val time = currentBlock.timestamp - previousBlock.timestamp

    return time.toLong() / samples.toLong()
}