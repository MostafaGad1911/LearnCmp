package mostafa.projects.learccmp.di

import mostafa.projects.learccmp.data.AuthRepositoryImpl
import mostafa.projects.learccmp.domain.AuthRepository
import mostafa.projects.learccmp.domain.LoginUseCase
import mostafa.projects.learccmp.network.createHttpClient
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.module

private val appModule = module {
    single { createHttpClient() }
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    factory { LoginUseCase(get()) }
}

private var application: KoinApplication? = null

fun initKoin(): Koin {
    application?.let { return it.koin }
    return startKoin { modules(appModule) }.also { application = it }.koin
}
