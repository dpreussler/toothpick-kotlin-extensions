package tv.sporttotsl.toothpick.kotlin.test

import org.junit.Test
import toothpick.Scope
import toothpick.config.Module
import tv.sporttotal.toothpick.kotlin.*
import javax.inject.Provider

class ToothpickExtensionsTest {

    var nullable : String? = null

    @Test
    fun `call all the things`() {

        @Suppress("UNUSED_VARIABLE")
        val newModule : Module = module {

            bind<Repository>().to(DataBaseRepository::class.java)

            bindClass<Repository>(DataBaseRepository::class.java)
            bindClass<Repository>(DataBaseRepository::class)

            bindInstance<Scheduler> { DefaultScheduler() }

            bindProvider(ApiProvider::class)

            bindProviderInstance(ApiProvider())

            nullable?.let {
                bindProviderInstance<Api>{ RestApi() }
            }
        }
    }

    @Test
    fun `create scope`() {
        @Suppress("UNUSED_VARIABLE")

        val aSimpleScope : Scope = simpleScope("") {
            bindClass<Repository>(DataBaseRepository::class.java)
        }

        val anotherScope : Scope = scope("") {
            module {
                bindClass<Repository>(DataBaseRepository::class.java)
            }

            module {
                bindProviderInstance(ApiProvider())
            }
        }
    }

    interface Api
    class RestApi: Api

    class ApiProvider : Provider<Api> {
        override fun get(): Api {
            return RestApi()
        }
    }
    interface Scheduler {

    }

    class DefaultScheduler : Scheduler {

    }

    interface Repository {

    }

    class DataBaseRepository : Repository {

    }

}