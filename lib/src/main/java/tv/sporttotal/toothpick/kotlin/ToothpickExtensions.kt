package tv.sporttotal.toothpick.kotlin

import toothpick.config.Binding
import toothpick.config.Module
import javax.inject.Provider
import kotlin.reflect.KClass
import kotlin.to as toPair

inline fun <reified T> Module.bind(): Binding<T> = bind(T::class.java)
inline fun <reified T> Module.bindClass(target: () -> KClass<out Any>): Binding<T> = bind<T>().apply { to(target().java as Class<T>) }
inline fun <reified T> Module.bindClass(target: Class<out T>): Binding<T> = bind<T>().apply { to(target) }
inline fun <reified T> Module.bindClass(target: KClass<out Any>): Binding<T> = bind<T>().apply { to(target.java as Class<T>) }
inline fun <reified T> Module.bindInstance(target: () -> T): Binding<T> = bind<T>().apply { toInstance(target()) }
inline fun <reified T> Module.bindProvider(target: () -> Class<out Provider<T>>): Binding<T> = bind<T>().apply { toProvider(target()) }
inline fun <reified T> Module.bindProvider(target: KClass<out Provider<T>>): Binding<T> = bind<T>().apply { toProvider(target.java) }
inline fun <reified T> Module.bindProvider(target: Class<out Provider<T>>): Binding<T> = bind<T>().apply { toProvider(target) }
inline fun <reified T> Module.bindProviderInstance(target: Provider<T>): Binding<T> = bind<T>().apply { toProviderInstance(target) }

inline fun <reified T> Module.bindProviderInstance(noinline target: () -> T): Binding<T> = bind<T>().apply {
    toProviderInstance(target.asProvider()) }

fun <T> (() -> T).asProvider(): Provider<T> {
    return object : Provider<T> {
        override fun get(): T {
            return invoke()
        }
    }
}

fun module(bindings: Module.() -> Binding<*>) : Module = Module().apply { bindings() }

