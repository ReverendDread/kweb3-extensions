package dev.klepto.kweb3

import dev.klepto.kweb3.abi.type.Uint
import dev.klepto.kweb3.abi.type.util.Numeric
import java.math.BigInteger

/**
 * @project kweb3-extensions
 * @author andy@hlwgroup.dev - 5/5/2023 3:38 PM
 */
operator fun <T : Numeric<*>> T.plus(other: Numeric<*>): T = add(other) as T
operator fun <T : Numeric<*>> T.minus(other: Numeric<*>): T = sub(other) as T
operator fun <T : Numeric<*>> T.times(other: Numeric<*>): T = mul(other) as T
operator fun Uint.times(other: BigInteger): BigInteger = value * other
operator fun BigInteger.times(other: Uint): BigInteger = this * other.value