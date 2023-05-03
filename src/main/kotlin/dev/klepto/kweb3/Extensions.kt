package dev.klepto.kweb3

import dev.klepto.kweb3.abi.type.Address
import dev.klepto.kweb3.abi.type.util.Numeric
import dev.klepto.kweb3.net.web3j.Web3jClient
import java.math.BigInteger

/**
 * @project kweb3-extensions
 * @author andy@hlwgroup.dev - 1/6/2023 4:09 PM
 */

// math operators
operator fun <T : Numeric<*>> T.plus(other: Numeric<*>): T = add(other) as T
operator fun <T : Numeric<*>> T.minus(other: Numeric<*>): T = sub(other) as T
operator fun <T : Numeric<*>> T.times(other: Numeric<*>): T = mul(other) as T

val Web3jClient.publicKey: Address
    get() = session.credentials.address.toAddress()

// address transforms
fun String.toAddress() = Address(this)
fun BigInteger.toAddress() = Address(this)
fun Numeric<*>.toAddress() = Address(this)
fun ByteArray.toAddress() = Address(this)