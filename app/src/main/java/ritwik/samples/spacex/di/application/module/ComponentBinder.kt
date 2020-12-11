package ritwik.samples.spacex.di.application.module

import androidx.lifecycle.ViewModel

import dagger.Binds
import dagger.Module

import dagger.android.ContributesAndroidInjector

import dagger.multibindings.IntoMap

import ritwik.samples.spacex.di.activity.LauncherModule
import ritwik.samples.spacex.di.activity.MainModule

import ritwik.samples.spacex.mvvm.viewModel.LauncherViewModel
import ritwik.samples.spacex.mvvm.viewModel.MainViewModel

import ritwik.samples.spacex.ui.activity.LauncherActivity
import ritwik.samples.spacex.ui.activity.MainActivity

import sample.ritwik.common.mvvm.viewModel.ViewModelKey

/**
 * Abstract [Module] that consists of methods annotated with [ContributesAndroidInjector], [Binds],
 * [IntoMap] and [ViewModelKey].
 *
 * @author Ritwik Jamuar
 */
@Module
abstract class ComponentBinder {

    /*--------------------------------- Activity Binding Methods ---------------------------------*/

    /**
     * Provides the instance of [LauncherActivity].
     *
     * @return Instance of [LauncherActivity].
     */
    @ContributesAndroidInjector(modules = [LauncherModule::class])
    abstract fun contributesLauncherActivity(): LauncherActivity

    /**
     * Provides the instance of [MainActivity].
     *
     * @return Instance of [MainActivity].
     */
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributesMainActivity(): MainActivity

    /*-------------------------------- ViewModel Binding Methods ---------------------------------*/

    /**
     * Provides the [ViewModel] from [LauncherViewModel].
     *
     * @param viewModel Instance of [LauncherViewModel].
     * @return Instance of [ViewModel].
     */
    @Binds
    @IntoMap
    @ViewModelKey(LauncherViewModel::class)
    abstract fun providesLauncherViewModel(viewModel: LauncherViewModel): ViewModel

    /**
     * Provides the [ViewModel] from [MainViewModel].
     *
     * @param viewModel Instance of [MainViewModel].
     * @return Instance of [ViewModel].
     */
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun providesMainViewModel(viewModel: MainViewModel): ViewModel

}
