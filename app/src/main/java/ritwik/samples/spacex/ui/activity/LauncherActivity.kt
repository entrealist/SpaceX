package ritwik.samples.spacex.ui.activity

import android.content.Intent

import android.view.View

import androidx.lifecycle.ViewModelProvider

import com.squareup.picasso.Picasso

import dagger.android.AndroidInjection

import ritwik.samples.spacex.R

import ritwik.samples.spacex.databinding.ActivityLauncherBinding

import ritwik.samples.spacex.mvvm.model.LauncherModel

import ritwik.samples.spacex.mvvm.viewModel.LauncherViewModel

import ritwik.samples.spacex.utility.constant.NAVIGATE_TO_MAIN

import sample.ritwik.common.data.ui.ErrorData

import sample.ritwik.common.mvvm.viewModel.VMFactory

import sample.ritwik.common.ui.activity.BaseActivity

import sample.ritwik.common.utility.helper.NetworkUtils

import javax.inject.Inject

/**
 * [BaseActivity] to show the launcher screen.
 *
 * @author Ritwik Jamuar
 */
class LauncherActivity : BaseActivity<LauncherModel, LauncherViewModel, ActivityLauncherBinding>() {

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

    override val viewModel: LauncherViewModel
        get() = ViewModelProvider(this, vmFactory).get(LauncherViewModel::class.java)

    override val networkUtils: NetworkUtils
        get() = networkUtility

    override val picasso: Picasso
        get() = picassoLibrary

    override fun layoutRes(): Int = R.layout.activity_launcher

    override fun inject() = AndroidInjection.inject(this)

    override fun showLoading() = Unit

    override fun hideLoading() = Unit

    override fun showError(errorData: ErrorData) = Unit

    override fun toolbarView(): View? = null

    override fun extractArguments() = Unit

    override fun initialize() = viewModel.onStarted()

    override fun attachObservers() = Unit

    override fun onUIDataChanged(uiData: LauncherModel) = Unit

    override fun onAction(uiData: LauncherModel) = when(uiData.action) {

        NAVIGATE_TO_MAIN -> {
            with(Intent(this, MainActivity::class.java)) {
                startActivity(this)
                finish()
            }
        }

        else -> Unit

    }

    override fun cleanUp() = Unit

}
