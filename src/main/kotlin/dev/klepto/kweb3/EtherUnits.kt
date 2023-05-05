package dev.klepto.kweb3

import dev.klepto.kweb3.abi.type.Uint
import java.math.BigDecimal
import java.math.BigInteger

/**
 * @project croswap-api
 * @author andy@hlwgroup.dev - 2/14/2023 7:08 PM
 */
fun String.parseEther(): BigInteger = EtherUnits.toWei(this, EtherUnits.ETHER).toBigIntegerExact()
fun String.formatEther(): BigDecimal = EtherUnits.fromWei(this, EtherUnits.ETHER)
fun String.parseUnits(decimals: Int): BigInteger = EtherUnits.toWei(this, EtherUnits.findUnit(decimals)).toBigIntegerExact()
fun String.formatUnits(decimals: Int): BigDecimal = EtherUnits.fromWei(toBigDecimal(), EtherUnits.findUnit(decimals))
fun BigInteger.parseEther(): BigInteger = EtherUnits.toWei(toBigDecimal(), EtherUnits.ETHER).toBigIntegerExact()
fun BigInteger.formatEther(): BigDecimal = EtherUnits.fromWei(toBigDecimal(), EtherUnits.ETHER)
fun BigInteger.parseUnits(decimals: Int): BigInteger = EtherUnits.toWei(toBigDecimal(), EtherUnits.findUnit(decimals)).toBigIntegerExact()
fun BigInteger.formatUnits(decimals: Int): BigDecimal = EtherUnits.fromWei(toBigDecimal(), EtherUnits.findUnit(decimals))
fun Uint.parseEther(): Uint = Uint(EtherUnits.toWei(value.toBigDecimal(), EtherUnits.ETHER).toBigIntegerExact())
fun Uint.formatEther(): BigDecimal = EtherUnits.fromWei(value.toBigDecimal(), EtherUnits.ETHER)
fun Uint.parseUnits(decimals: Int): Uint = Uint(EtherUnits.toWei(value.toBigDecimal(), EtherUnits.findUnit(decimals)).toBigIntegerExact())
fun Uint.formatUnits(decimals: Int): BigDecimal = EtherUnits.fromWei(value.toBigDecimal(), EtherUnits.findUnit(decimals))
fun BigDecimal.parseEther(): BigInteger = EtherUnits.toWei(this, EtherUnits.ETHER).toBigIntegerExact()
fun BigDecimal.formatEther(): BigDecimal = EtherUnits.fromWei(this, EtherUnits.ETHER)
fun BigDecimal.parseUnits(decimals: Int): BigInteger = EtherUnits.toWei(this, EtherUnits.findUnit(decimals)).toBigIntegerExact()
fun BigDecimal.formatUnits(decimals: Int): BigDecimal = EtherUnits.fromWei(this, EtherUnits.findUnit(decimals))

enum class EtherUnits(
    val _name: String,
    val exponent: Int
) {

    WEI("wei", 0),
    KWEI("kwei", 3),
    MWEI("mwei", 6),
    GWEI("gwei", 9),
    SZABO("szabo", 12),
    FINNEY("finney", 15),
    ETHER("ether", 18),
    KETHER("kether", 21),
    METHER("mether", 24),
    GETHER("gether", 27);

    val weiFactor = BigDecimal.TEN.pow(exponent)

    companion object {

        private val unitCache = mutableMapOf<Int, BigDecimal>()

        fun fromWei(number: String, unit: EtherUnits): BigDecimal {
            return fromWei(number.toBigDecimal(), unit)
        }

        fun fromWei(number: BigDecimal, unit: EtherUnits): BigDecimal {
            return number.divide(unit.weiFactor)
        }

        fun toWei(number: String, unit: EtherUnits): BigDecimal {
            return toWei(number.toBigDecimal(), unit)
        }

        fun toWei(number: BigDecimal, unit: EtherUnits): BigDecimal {
            return number.multiply(unit.weiFactor)
        }

        fun fromWei(number: String, unit: BigDecimal): BigDecimal {
            return fromWei(number.toBigDecimal(), unit)
        }

        fun fromWei(number: BigDecimal, unit: BigDecimal): BigDecimal {
            return number.divide(unit)
        }

        fun toWei(number: String, unit: BigDecimal): BigDecimal {
            return toWei(number.toBigDecimal(), unit)
        }

        fun toWei(number: BigDecimal, unit: BigDecimal): BigDecimal {
            return number.multiply(unit)
        }

        fun findUnit(decimals: Int): BigDecimal {
            for (unit in EtherUnits.values()) {
                if (unit.exponent == decimals)
                    return unit.weiFactor
            }
            return unitCache.computeIfAbsent(decimals) { BigDecimal.TEN.pow(decimals) }
        }
    }

}