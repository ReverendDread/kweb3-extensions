package dev.klepto.kweb3

import dev.klepto.kweb3.abi.type.Address
import dev.klepto.kweb3.net.web3j.Web3jClient

/**
 * @project kweb3-extensions
 * @author andy@hlwgroup.dev - 1/6/2023 4:09 PM
 */

val Web3jClient.publicKey: Address
    get() = session.credentials.address.toAddress()