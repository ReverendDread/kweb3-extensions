package dev.klepto.kweb3

import dev.klepto.kweb3.abi.type.Address
import dev.klepto.kweb3.abi.type.util.Numeric
import java.math.BigInteger

/**
 * @project kweb3-extensions
 * @author andy@hlwgroup.dev - 5/5/2023 3:38 PM
 */
fun String.toAddress() = Address(this)
fun BigInteger.toAddress() = Address(this)
fun Numeric<*>.toAddress() = Address(this)
fun ByteArray.toAddress() = Address(this)