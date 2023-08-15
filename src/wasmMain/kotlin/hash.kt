@file:JsModule("@noble/hashes")

import org.khronos.webgl.Uint8Array

internal external fun hmac(type: JsAny, key: Uint8Array, message: Uint8Array): Uint8Array