@file:JsModule("@noble/secp256k1")

import org.khronos.webgl.Uint8Array
import kotlin.js.Promise

internal external fun sign(messageHash: String, privateKey: Uint8Array): Uint8Array

internal external fun signAsync(messageHash: Uint8Array, privateKey: Uint8Array): Uint8Array
internal external fun verify(signature: Uint8Array, messageHash: String, publicKey: Uint8Array): Boolean
internal external fun getPublicKey(privateKey: Uint8Array): Uint8Array

internal external object utils {
    fun isValidPrivateKey(key: Uint8Array): Boolean
    fun randomPrivateKey(): Uint8Array
}

internal external object etc {
    fun hexToBytes(hex: String): Uint8Array;
    fun bytesToHex(b: Uint8Array): String;
    fun concatBytes(arrs: Uint8Array): Uint8Array;
    fun bytesToNumberBE(b: Uint8Array): Long;
    fun numberToBytesBE(num: Long): Uint8Array;
    fun mod(a: Long, b: Long?): Long;
    fun invert(num: Long, md: Long?): Long;
    fun hmacSha256Async(key: Uint8Array, msgs: Uint8Array): Promise<Uint8Array>;
    fun hmacSha256Sync(alg: String, key: Uint8Array, message: Uint8Array);
    fun hashToPrivateKey(hash: Uint8Array): Uint8Array;
    fun randomBytes(len: Int): Uint8Array;
}