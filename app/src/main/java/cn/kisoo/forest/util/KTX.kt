package cn.kisoo.forest.util

public inline fun <T, R> withNotNull(receiver: T, block: T.() -> R) {
    receiver?.let(block)
}