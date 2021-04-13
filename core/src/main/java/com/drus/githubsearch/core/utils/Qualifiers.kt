package com.drus.githubsearch.core.utils

import androidx.lifecycle.ViewModel
import dagger.MapKey
import javax.inject.Qualifier
import kotlin.reflect.KClass

@Qualifier
@Retention
annotation class ApplicationContext

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)