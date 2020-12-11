package ritwik.samples.spacex.di.application.module

import dagger.Binds
import dagger.Module

import dagger.android.ContributesAndroidInjector

import dagger.multibindings.IntoMap

import sample.ritwik.common.mvvm.viewModel.ViewModelKey

/**
 * Abstract [Module] that consists of methods annotated with [ContributesAndroidInjector], [Binds],
 * [IntoMap] and [ViewModelKey].
 *
 * @author Ritwik Jamuar
 */
@Module
abstract class ComponentBinder
