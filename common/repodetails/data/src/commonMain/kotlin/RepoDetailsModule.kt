import ktor.KtorGHRepoBranchDetailsDataSource
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val repoDetailsModule = DI.Module {
    bind<KtorGHRepoBranchDetailsDataSource>() with provider {
        KtorGHRepoBranchDetailsDataSource(httpClient = instance())
    }


}