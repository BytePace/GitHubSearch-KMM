import ktor.KtorGHReposDataSource
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton

val searchModule = DI.Module {
    bind<KtorGHReposDataSource>() with provider {
        KtorGHReposDataSource(instance())
    }

    bind<GHReposRepository>() with singleton {
        GHReposRepositoryImpl(instance())
    }
}