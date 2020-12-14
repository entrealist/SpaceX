package ritwik.samples.spacex.mvvm.viewModel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

import ritwik.samples.spacex.R

import ritwik.samples.spacex.data.network.*

import ritwik.samples.spacex.data.ui.LaunchType

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.repository.MainRepository

import ritwik.samples.spacex.utility.constant.POPULATE_CAPSULES
import ritwik.samples.spacex.utility.constant.POPULATE_CORES
import ritwik.samples.spacex.utility.constant.POPULATE_LAUNCHES
import ritwik.samples.spacex.utility.constant.POPULATE_ROCKETS

import sample.ritwik.common.data.network.ResultWrapper

import sample.ritwik.common.mvvm.viewModel.BaseViewModel

import javax.inject.Inject

/**
 * ViewModel of [ritwik.samples.spacex.ui.activity.MainActivity].
 *
 * @param repository Instance of [MainRepository] for [repository].
 * @param model Instance of [MainModel] for [model].
 * @author Ritwik Jamuar
 */
class MainViewModel @Inject constructor(
    override val repository: MainRepository,
    override val model: MainModel
) : BaseViewModel<MainRepository, MainModel>() {

    /*--------------------------------- BaseViewModel Callbacks ----------------------------------*/

    override fun initializeLiveData() = Unit

    override fun initializeVariables() = Unit

    override fun onSessionExpired() = Unit

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**
     * Fetches the Launches of given [launchType] from making REST API Calls.
     *
     * @param launchType Instance of [LaunchType] denoting the type of Launch.
     */
    fun fetchLaunches(launchType: LaunchType) = if (!when (launchType) {
            LaunchType.UPCOMING -> model.isUpcomingLaunchesPopulated()
            LaunchType.COMPLETED -> model.isCompletedLaunchesPopulated()
        }
    ) {
        showProgress()
        launchNetworkDataLoad(
            when (launchType) {
                LaunchType.UPCOMING -> upcomingLaunchesAPICall
                LaunchType.COMPLETED -> completedLaunchesAPICall
            },
            handleLaunchesSuccess,
            handleLaunchesError,
            when (launchType) {
                LaunchType.UPCOMING -> processUpcomingLaunchesResponse
                LaunchType.COMPLETED -> processCompletedLaunchesResponse
            },
            ErrorResponse::class.java,
            handleLaunchesErrorCode
        )
    } else {
        notifyActionOnUI(POPULATE_LAUNCHES)
    }

    /**
     * Fetches all the rockets from making REST API Call.
     */
    fun fetchRockets() = if (!model.isRocketsPopulated()) {
        showProgress()
        launchNetworkDataLoad(
            allRocketsAPICall,
            handleAllRocketsSuccess,
            handleAllRocketsError,
            processAllRocketsResponse,
            ErrorResponse::class.java,
            handleAllRocketsErrorCode
        )
    } else {
        notifyActionOnUI(POPULATE_ROCKETS)
    }

    /**
     * Fetches all the capsules from making REST API Call.
     */
    fun fetchCapsules() = if (!model.isCapsulesPopulated()) {
        showProgress()
        launchNetworkDataLoad(
            allCapsulesAPICall,
            handleAllCapsulesSuccess,
            handleAllCapsulesError,
            processAllCapsulesResponse,
            ErrorResponse::class.java,
            handleAllCapsulesErrorCode
        )
    } else {
        notifyActionOnUI(POPULATE_CAPSULES)
    }

    /**
     * Fetches all the cores from making REST API Call.
     */
    fun fetchCores() = if (!model.isCoresPopulated()) {
        showProgress()
        launchNetworkDataLoad(
            allCoresAPICall,
            handleAllCoresSuccess,
            handleAllCoresError,
            processAllCoresResponse,
            ErrorResponse::class.java,
            handleAllCoresErrorCode
        )
    } else {
        notifyActionOnUI(POPULATE_CORES)
    }

    /*------------------------------------ Lambda Expressions ------------------------------------*/

    /**
     * Lambda Expression to notify about selection of an Upcoming Event.
     */
    val upcomingLaunchListener: (Int) -> Unit = { position ->
        // TODO: Use the position in model.upcomingLaunches to handle the click on Upcoming Launch.
    }

    /**
     * Lambda Expression to notify about selection of a Completed Event.
     */
    val completedLaunchListener: (Int) -> Unit = { position ->
        // TODO: Use the position in model.completedLaunches to handle the click on Completed Launch.
    }

    /**
     * Lambda Expression to notify about selection of a Rocket.
     */
    val rocketListener: (Int) -> Unit = { position ->
        // TODO: Use the position in model.rockets to handle the click on Rocket.
    }

    /**
     * Lambda Expression to notify about selection of a Capsule.
     */
    val capsuleListener: (Int) -> Unit = { position ->
        // TODO: Use the position in model.rockets to handle the click on Capsule.
    }

    /**
     * Lambda Expression to notify about selection of a Core.
     */
    val coreListener: (Int) -> Unit = { position ->
        // TODO: Use the position in model.rockets to handle the click on Core.
    }

    /**
     * Lambda Expression as the REST API Call Body for fetching the Upcoming Launches.
     */
    private val upcomingLaunchesAPICall: suspend () -> List<LaunchResponse> = {
        repository.getUpcomingLaunches()
    }

    /**
     * Lambda Expression as the REST API Call Body for fetching the Completed Launches.
     */
    private val completedLaunchesAPICall: suspend () -> List<LaunchResponse> = {
        repository.getCompletedLaunches()
    }

    /**
     * Lambda Expression as the REST API Call Body for fetching all the Rockets.
     */
    private val allRocketsAPICall: suspend () -> List<RocketResponse> = {
        repository.getAllRockets()
    }

    /**
     * Lambda Expression as the REST API Call Body for fetching all the Capsules.
     */
    private val allCapsulesAPICall: suspend () -> List<CapsuleResponse> = {
        repository.getAllCapsules()
    }

    /**
     * Lambda Expression as the REST API Call Body for fetching all the Cores.
     */
    private val allCoresAPICall: suspend () -> List<CoreResponse> = {
        repository.getAllCores()
    }

    /**
     * Lambda Expression to handle the Success of REST API to fetch the Launches.
     */
    private val handleLaunchesSuccess: () -> Unit = {
        hideProgress()
        notifyActionOnUI(POPULATE_LAUNCHES)
    }

    /**
     * Lambda Expression to handle the Success of REST API to fetch all the Rockets.
     */
    private val handleAllRocketsSuccess: () -> Unit = {
        hideProgress()
        notifyActionOnUI(POPULATE_ROCKETS)
    }

    /**
     * Lambda Expression to handle the Success of REST API to fetch all the Capsules.
     */
    private val handleAllCapsulesSuccess: () -> Unit = {
        hideProgress()
        notifyActionOnUI(POPULATE_CAPSULES)
    }

    /**
     * Lambda Expression to handle the Success of REST API to fetch all the Cores.
     */
    private val handleAllCoresSuccess: () -> Unit = {
        hideProgress()
        notifyActionOnUI(POPULATE_CORES)
    }

    /**
     * Lambda Expression to handle the Error of REST API to fetch the Launches.
     */
    private val handleLaunchesError: (throwable: Throwable) -> Unit = { throwable ->
        hideProgress()
        android.util.Log.e("MainViewModel", throwable.message ?: "")
        showPopUpWindow(throwable.message ?: repository.getStringFromResource(R.string.default_error_message))
    }

    /**
     * Lambda Expression to handle the Error of REST API to fetch all the Rockets.
     */
    private val handleAllRocketsError: (Throwable) -> Unit = { throwable ->
        hideProgress()
        android.util.Log.e("MainViewModel", throwable.message ?: "")
        showPopUpWindow(throwable.message ?: repository.getStringFromResource(R.string.default_error_message))
    }

    /**
     * Lambda Expression to handle the Error of REST API to fetch all the Capsules.
     */
    private val handleAllCapsulesError: (Throwable) -> Unit = { throwable ->
        hideProgress()
        android.util.Log.e("MainViewModel", throwable.message ?: "")
        showPopUpWindow(throwable.message ?: repository.getStringFromResource(R.string.default_error_message))
    }

    /**
     * Lambda Expression to handle the Error of REST API to fetch all the Cores.
     */
    private val handleAllCoresError: (Throwable) -> Unit = { throwable ->
        hideProgress()
        android.util.Log.e("MainViewModel", throwable.message ?: "")
        showPopUpWindow(throwable.message ?: repository.getStringFromResource(R.string.default_error_message))
    }

    /**
     * Lambda Expression to process the Response of REST API to fetch the Upcoming Launches.
     */
    private val processUpcomingLaunchesResponse: suspend (launchesFlow: Flow<List<LaunchResponse>>) -> Unit =
        { flow ->
            flow.collect { launches ->
                model.upcomingLaunches = model.extractLaunchesFromResponse(launches.sortedWith(upcomingLaunchesComparator))
            }
        }

    /**
     * Lambda Expression to process the Response of REST API to fetch the Completed Launches.
     */
    private val processCompletedLaunchesResponse: suspend (launchesFlow: Flow<List<LaunchResponse>>) -> Unit =
        { flow ->
            flow.collect { launches ->
                model.completedLaunches = model.extractLaunchesFromResponse(launches.sortedWith(completedLaunchesComparator))
            }
        }

    /**
     * Lambda Expression to process the Response of REST API to fetch all the Rockets.
     */
    private val processAllRocketsResponse: suspend (rocketsFlow: Flow<List<RocketResponse>>) -> Unit =
        { flow ->
            flow.collect { rockets ->
                model.rockets = model.extractRocketsFromResponse(rockets)
            }
        }

    /**
     * Lambda Expression to process the Response of REST API to fetch all the Capsules.
     */
    private val processAllCapsulesResponse: suspend (capsulesFlow: Flow<List<CapsuleResponse>>) -> Unit =
        { flow ->
            flow.collect { capsules ->
                model.capsules = model.extractCapsulesFromResponse(capsules)
            }
        }

    /**
     * Lambda Expression to process the Response of REST API to fetch all the Cores.
     */
    private val processAllCoresResponse: suspend (coresFlow: Flow<List<CoreResponse>>) -> Unit =
        { flow ->
            flow.collect { cores ->
                model.cores = model.extractCoresFromResponse(cores)
            }
        }

    /**
     * Lambda Expression to handle the Error Code of REST API to fetch the Launches.
     */
    private val handleLaunchesErrorCode: (Int, ErrorResponse) -> ResultWrapper.Error<List<LaunchResponse>> =
        { code, errorBody ->
            ResultWrapper.Error.RecoverableError(code, errorBody.error)
        }

    /**
     * Lambda Expression to handle the Error Code of REST API to fetch all the Rockets.
     */
    private val handleAllRocketsErrorCode: (Int, ErrorResponse) -> ResultWrapper.Error<List<RocketResponse>> =
        { code, errorBody ->
            ResultWrapper.Error.RecoverableError(code, errorBody.error)
        }

    /**
     * Lambda Expression to handle the Error Code of REST API to fetch all the Capsules.
     */
    private val handleAllCapsulesErrorCode: (Int, ErrorResponse) -> ResultWrapper.Error<List<CapsuleResponse>> =
        { code, errorBody ->
            ResultWrapper.Error.RecoverableError(code, errorBody.error)
        }

    /**
     * Lambda Expression to handle the Error Code of REST API to fetch all the Cores.
     */
    private val handleAllCoresErrorCode: (Int, ErrorResponse) -> ResultWrapper.Error<List<CoreResponse>> =
        { code, errorBody ->
            ResultWrapper.Error.RecoverableError(code, errorBody.error)
        }

    /*--------------------------------------- Comparators ----------------------------------------*/

    /**
     * Comparator to sort the [List] of [LaunchResponse] for Upcoming Launches.
     */
    private val upcomingLaunchesComparator = Comparator<LaunchResponse> { launch1, launch2 ->
        when {
            launch1.flightNumber ?: 0 > launch2.flightNumber ?: 0 -> 1
            launch1.flightNumber ?: 0 < launch2.flightNumber ?: 0 -> -1
            else -> 0
        }
    }

    /**
     * Comparator to sort the [List] of [LaunchResponse] for Completed Launches.
     */
    private val completedLaunchesComparator = Comparator<LaunchResponse> { launch1, launch2 ->
        when {
            launch1.flightNumber ?: 0 > launch2.flightNumber ?: 0 -> -1
            launch1.flightNumber ?: 0 < launch2.flightNumber ?: 0 -> 1
            else -> 0
        }
    }

}
