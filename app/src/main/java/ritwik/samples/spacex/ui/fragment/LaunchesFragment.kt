package ritwik.samples.spacex.ui.fragment

import android.os.Bundle
import android.os.CountDownTimer

import android.view.View

import ritwik.samples.spacex.R

import ritwik.samples.spacex.data.ui.LaunchType

import ritwik.samples.spacex.databinding.FragmentLaunchesBinding

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.viewModel.MainViewModel

import ritwik.samples.spacex.ui.adapter.CompletedLaunchAdapter
import ritwik.samples.spacex.ui.adapter.UpcomingLaunchAdapter

import ritwik.samples.spacex.utility.constant.LAUNCH_TYPE
import ritwik.samples.spacex.utility.constant.POPULATE_LAUNCHES

import sample.ritwik.common.ui.fragment.BaseFragment

import java.util.concurrent.TimeUnit

/**
 * [BaseFragment] to show the list of Launches of given type.
 *
 * @author Ritwik Jamuar
 */
class LaunchesFragment : BaseFragment<FragmentLaunchesBinding, MainModel, MainViewModel>() {

    /*------------------------------------- Member Variables -------------------------------------*/

    /**
     * Reference of [LaunchType] to identify the type of Launch.
     */
    private lateinit var launchType: LaunchType

    /**
     * Reference of [CountDownTimer] to start/cancel the Count-Down.
     */
    private var countDownTimer: CountDownTimer? = null

    /*---------------------------------- BaseFragment Callbacks ----------------------------------*/

    override fun layoutRes(): Int = R.layout.fragment_launches

    override fun extractArguments(arguments: Bundle) = with(arguments) {
        if (containsKey(LAUNCH_TYPE)) {
            launchType = when (getInt(LAUNCH_TYPE)) {
                0 -> LaunchType.UPCOMING
                1 -> LaunchType.COMPLETED
                else -> LaunchType.UPCOMING
            }
        }
    }

    override fun initializeViews() {
        setUpView()
        requestData()
    }

    override fun showLoading() = binding?.placeholderShimmerLaunch?.let { shimmer ->
        shimmer.visibility = View.VISIBLE
        shimmer.startShimmer()
    } ?: Unit

    override fun hideLoading() = binding?.placeholderShimmerLaunch?.let { shimmer ->
        shimmer.stopShimmer()
        shimmer.visibility = View.GONE
    } ?: Unit

    override fun onUIDataChanged(uiData: MainModel) = Unit

    override fun onAction(uiData: MainModel) = when (uiData.action) {

        POPULATE_LAUNCHES -> binding?.let { dataBinding ->
            with(dataBinding) {
                when (launchType) {

                    LaunchType.UPCOMING -> {
                        isLaunchesEmpty = !uiData.isUpcomingLaunchesPopulated()
                        listLaunches.setItemViewCacheSize(uiData.upcomingLaunches.size)
                        (listLaunches.adapter as? UpcomingLaunchAdapter)?.replaceList(
                            uiData.upcomingLaunches
                        ) ?: Unit
                        handleCountDownTimer(uiData.calculateTimingForUpcomingLaunch())
                    }

                    LaunchType.COMPLETED -> {
                        isLaunchesEmpty = !uiData.isCompletedLaunchesPopulated()
                        listLaunches.setItemViewCacheSize(uiData.completedLaunches.size)
                        (listLaunches.adapter as? CompletedLaunchAdapter)?.replaceList(
                            uiData.completedLaunches
                        ) ?: Unit
                    }

                }
            }
        } ?: Unit

        else -> Unit

    }

    override fun cleanUp() = binding?.let { dataBinding ->
        dataBinding.listLaunches.adapter = null
    } ?: Unit

    override fun onDetach() {
        super.onDetach()
        cleanUpCountDownTimer()
    }

    /*------------------------------------- Private Methods --------------------------------------*/

    /**
     * Sets-up the views under [binding].
     */
    private fun setUpView() = binding?.let { dataBinding ->
        viewModel?.let { vm ->
            with(dataBinding) {
                isLaunchTypeUpcoming = launchType == LaunchType.UPCOMING
                isLaunchesEmpty = false
                listLaunches.adapter = when (launchType) {
                    LaunchType.UPCOMING -> UpcomingLaunchAdapter(vm.upcomingLaunchListener)
                    LaunchType.COMPLETED -> CompletedLaunchAdapter(vm.completedLaunchListener)
                }
            }
        }
    } ?: Unit

    /**
     * Requests the data through [viewModel].
     */
    private fun requestData() = viewModel?.fetchLaunches(launchType) ?: Unit

    /**
     * Provides the instance of [CountDownTimer].
     *
     * @param duration [Long] denoting the duration till which the [CountDownTimer] would run.
     * @return New Instance of [CountDownTimer].
     */
    private fun provideCountDownTimer(duration: Long) = object: CountDownTimer(duration, 1000) {

        override fun onTick(milliSecondsUntilFinished: Long) {
            binding?.valueTextLatestMissionRemainingTime?.let { timeView ->
                timeView.post {
                    timeView.text = provideFormattedTime(milliSecondsUntilFinished)
                }
            }
        }

        override fun onFinish() {
            binding?.valueTextLatestMissionRemainingTime?.visibility = View.GONE
        }

    }

    /**
     * Provides the given [time] in a Formatted [String] with the format below:
     *
     *
     * Day : Hour : Minute : Second
     *
     * @param time [Long] denoting the Time to be displayed in the format.
     * @return [String] denoting the given [time] in the Time Format.
     */
    private fun provideFormattedTime(time: Long): String {

        // Create a reference to store the current 'time'.
        var uptime = time

        // Get the no. of days from the given 'time'
        // and then subtract the 'day' equivalent Milli-Seconds from the 'time'.
        val day = TimeUnit.MILLISECONDS.toDays(uptime)
        uptime -= TimeUnit.DAYS.toMillis(day)

        // Get the no. of hours from the given 'time'
        // and then subtract the 'hour' equivalent Milli-Seconds from the 'time'.
        val hour = TimeUnit.MILLISECONDS.toHours(uptime)
        uptime -= TimeUnit.HOURS.toMillis(hour)

        // Get the no. of minutes from the given 'time'
        // and then subtract the 'minute' equivalent Milli-Seconds from the 'time'.
        val minute = TimeUnit.MILLISECONDS.toMinutes(uptime)
        uptime -= TimeUnit.MINUTES.toMillis(minute)

        // Get the no. of seconds from the given 'time'.
        val second = TimeUnit.MILLISECONDS.toSeconds(uptime)

        // Return the Formatted Time as String.
        return "$day : $hour : $minute : $second"

    }

    /**
     * Takes care of handling the [countDownTimer].
     *
     * @param countDownTime [Long] denoting the Count-Down Time from which the Timer would start.
     */
    private fun handleCountDownTimer(countDownTime: Long) {

        // Halt the further execution and clean the if the 'countDownTime' is 0.
        if (countDownTime == 0L) return

        // Clean-Up the previously instantiated Count-Down Timer.
        cleanUpCountDownTimer()

        // Initialize and Start the Count-Down Timer.
        countDownTimer = provideCountDownTimer(countDownTime)
        countDownTimer?.start()

    }

    /**
     * Clean-up the [countDownTimer] to avoid the Memory Leak.
     */
    private fun cleanUpCountDownTimer() {
        countDownTimer?.cancel() // Cancel the Count-Down Timer first.
        countDownTimer = null // De-reference the instance.
    }

}
