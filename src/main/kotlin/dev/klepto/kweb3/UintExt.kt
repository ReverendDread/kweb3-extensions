package dev.klepto.kweb3

import dev.klepto.kweb3.abi.type.Uint

/**
 * @project kweb3-extensions
 * @author andy@hlwgroup.dev - 5/5/2023 3:45 PM
 */
fun Number.toUint(size: Int = 256): Uint = Uint(this, size)
val Number.uint8: Uint get() = toUint(8)
val Number.uint16: Uint get() = toUint(16)
val Number.uint24: Uint get() = toUint(24)
val Number.uint32: Uint get() = toUint(32)
val Number.uint40: Uint get() = toUint(40)
val Number.uint48: Uint get() = toUint(48)
val Number.uint56: Uint get() = toUint(56)
val Number.uint64: Uint get() = toUint(64)
val Number.uint72: Uint get() = toUint(72)
val Number.uint80: Uint get() = toUint(80)
val Number.uint88: Uint get() = toUint(88)
val Number.uint96: Uint get() = toUint(96)
val Number.uint104: Uint get() = toUint(104)
val Number.uint112: Uint get() = toUint(112)
val Number.uint120: Uint get() = toUint(120)
val Number.uint128: Uint get() = toUint(128)
val Number.uint136: Uint get() = toUint(136)
val Number.uint144: Uint get() = toUint(144)
val Number.uint152: Uint get() = toUint(152)
val Number.uint160: Uint get() = toUint(160)
val Number.uint168: Uint get() = toUint(168)
val Number.uint176: Uint get() = toUint(176)
val Number.uint184: Uint get() = toUint(184)
val Number.uint192: Uint get() = toUint(192)
val Number.uint200: Uint get() = toUint(200)
val Number.uint208: Uint get() = toUint(208)
val Number.uint216: Uint get() = toUint(216)
val Number.uint224: Uint get() = toUint(224)
val Number.uint232: Uint get() = toUint(232)
val Number.uint240: Uint get() = toUint(240)
val Number.uint248: Uint get() = toUint(248)
val Number.uint256: Uint get() = toUint(256)