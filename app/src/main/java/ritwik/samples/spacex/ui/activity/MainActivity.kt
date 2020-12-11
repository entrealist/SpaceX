package ritwik.samples.spacex.ui.activity

import android.view.View

import androidx.lifecycle.ViewModelProvider

import com.squareup.picasso.Picasso

import dagger.android.AndroidInjection

import ritwik.samples.spacex.R

import ritwik.samples.spacex.databinding.ActivityMainBinding

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.viewModel.MainViewModel

import sample.ritwik.common.data.ui.ErrorData

import sample.ritwik.common.mvvm.viewModel.VMFactory

import sample.ritwik.common.ui.activity.BaseActivity

import sample.ritwik.common.utility.helper.NetworkUtils

import javax.inject.Inject

/**
 * [BaseActivity] to show the Main Contents of this application.
 *
 * @author Ritwik Jamuar
 */
class MainActivity : BaseActivity<MainModel, MainViewModel, ActivityMainBinding>() {

    /*---------------------------------------- Components ----------------------------------------*/

    /**
     * Reference of [VMFactory] of this [BaseActivity]
     * injected from [sample.ritwik.common.di.module.ViewModelModule].
     */
    @Inject
    lateinit var vmFactory: VMFactory

    /**
     * Reference of [NetworkUtils], injected from [sample.ritwik.common.di.module.CommonModule].
     */
    @Inject
    lateinit var networkUtility: NetworkUtils

    /**
     * Reference of [Picasso] injected from [sample.ritwik.common.di.module.PicassoModule].
     */
    @Inject
    lateinit var picassoLibrary: Picasso

    /*---------------------------------- BaseActivity Callbacks ----------------------------------*/

    override val viewModel: MainViewModel
        get() = ViewModelProvider(this, vmFactory).get(MainViewModel::class.java)

    override val networkUtils: NetworkUtils
        get() = networkUtility

    override val picasso: Picasso
        get() = picassoLibrary

    override fun layoutRes(): Int = R.layout.activity_main

    override fun inject() = AndroidInjection.inject(this)

    override fun showLoading() = Unit

    override fun hideLoading() = Unit

    override fun showError(errorData: ErrorData) = Unit

    override fun toolbarView(): View? = null

    override fun extractArguments() = Unit

    override fun initialize() = Unit

    override fun attachObservers() = Unit

    override fun onUIDataChanged(uiData: MainModel) = Unit

    override fun onAction(uiData: MainModel) = Unit

    override fun cleanUp() = Unit

}
