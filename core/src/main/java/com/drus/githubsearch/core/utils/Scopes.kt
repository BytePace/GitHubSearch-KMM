package com.drus.githubsearch.core.utils

import androidx.lifecycle.ViewModel
import dagger.MapKey
import javax.inject.Scope
import kotlin.reflect.KClass

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope