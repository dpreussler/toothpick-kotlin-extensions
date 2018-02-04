package tv.sporttotsl.toothpick.kotlin.test

import org.junit.Test
import toothpick.config.Module
import tv.sporttotal.toothpick.kotlin.*
import javax.inject.Provider

class ToothpickExtensionsTest {


    @Test
    fun `call all the things`() {

        val newModule : Module = module {

            bind<Repository>().to(DataBaseRepository::class.java)

            bindClass<Repository>(DataBaseRepository::class.java)
            bindClass<Repository>(DataBaseRepository::class)

            bindInstance<Scheduler> { DefaultScheduler() }

            bindProviderInstance(ApiProvider())
            bindProviderInstance<Api>{ RestApi() }
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