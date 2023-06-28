import org.kodein.di.DI

val composeNodeModule = DI.Module("composeNode") {
    importAll(
        coreModule,
        searchModule,
    )
}