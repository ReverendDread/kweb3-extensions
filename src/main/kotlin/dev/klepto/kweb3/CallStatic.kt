package dev.klepto.kweb3

import dev.klepto.kweb3.abi.type.Address
import dev.klepto.kweb3.contract.ContractCodec
import dev.klepto.kweb3.net.web3j.Web3jClient
import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.protocol.core.methods.request.Transaction

/**
 * @project kweb3-extensions
 * @author andy@hlwgroup.dev - 5/2/2023 6:51 PM
 */
data class CallStaticResponse(
    val isReverted: Boolean = false,
    val revertCode: Int? = null,
    val revertReason: String? = null,
)

fun Web3jClient.callStatic(from: Address = publicKey, to: Address, runnable: Runnable): CallStaticResponse {
    val logs = getLogs(runnable)
    require(logs.size == 1) { "expected 1 log, got ${logs.size}" }
    return logs.first().run {
        val encoded = abiEncode(this)
        val transaction = Transaction.createEthCallTransaction(from.toHex(), to.toHex(), encoded)
        val call = session.web3j.ethCall(transaction, DefaultBlockParameter.valueOf("latest")).send()
        CallStaticResponse(
            isReverted = call.error != null,
            revertCode = call.error?.code,
            revertReason = call.error?.message,
        )
    }
}