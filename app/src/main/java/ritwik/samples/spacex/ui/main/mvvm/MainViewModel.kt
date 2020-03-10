package ritwik.samples.spacex.ui.main.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import ritwik.samples.spacex.application.database.LaunchType

import ritwik.samples.spacex.common.BaseViewModel

import ritwik.samples.spacex.component.other.NetworkProcessor

import ritwik.samples.spacex.convertUTCDateTime
import ritwik.samples.spacex.model.*

import ritwik.samples.spacex.ui.main.MainActivity

import java.util.*

import kotlin.Comparator

/**ViewModel of [MainActivity].
 * @author Ritwik Jamuar.*/
class MainViewModel private constructor(
    repository: MainRepository
) : BaseViewModel<MainRepository>(repository) {

    // LiveData.
    private val allUpComingLaunchesLiveData: MutableLiveData<List<Launch>> = MutableLiveData()
    private val allPastLaunchesLiveData: MutableLiveData<List<Launch>> = MutableLiveData()
    private val allRocketsLiveData: MutableLiveData<List<Rocket>> = MutableLiveData()
    private val allCapsulesLiveData: MutableLiveData<List<Capsule>> = MutableLiveData()
    private val allCoresLiveData: MutableLiveData<List<Core>> = MutableLiveData()
    private val aboutTheCompanyLiveData: MutableLiveData<Company> = MutableLiveData()

    /*--------------------------------------- Builder Class --------------------------------------*/

    /**Builder Pattern of creating [MainViewModel].*/
    class Builder {

        private lateinit var repository: MainRepository

        /**Sets the Repository of [MainViewModel].
         * @param repository Instance of [MainRepository].*/
        fun setRepository(repository: MainRepository) = apply { this.repository = repository }

        /**Creates the instance of [MainViewModel].
         * @return New Instance of [MainViewModel].*/
        fun build() = MainViewModel(repository)

    }

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**Provides the [LiveData] of [List] of UpComing [Launch]s to it's observers.
     * @return [LiveData] of [List] of [Launch].*/
    fun getAllUpComingLaunchesLiveData() : LiveData<List<Launch>> = allUpComingLaunchesLiveData

    /**Provides the [LiveData] of [List] of [Launch]s to it's observers.
     * @return [LiveData] of [List] of [Launch].*/
    fun getAllPastLaunchesLiveData() : LiveData<List<Launch>> = allPastLaunchesLiveData

    /**Request the [repository] to fetch the Launches of given [type].
     * @param type Specify the type of Launches to fetch. It is described in [LaunchType].
     * @return [LiveData] of [NetworkProcessor.Resource] of type [List] of [Launch].*/
    fun getLaunches(type: LaunchType): LiveData<NetworkProcessor.Resource<List<Launch>>> =
        when (type) {
            LaunchType.UPCOMING -> getRepository().getUpcomingLaunches()
            LaunchType.PAST -> getRepository().getPastLaunches()
        }

    /**Process the Response received by fetching all the Launches differentiated by [launchType].
     * @param resources [NetworkProcessor.Resource] of type [List] of [Rocket].
     * @param launchType Specify the type of Launches to process. It is described in [LaunchType].*/
    fun onLaunchesResponse(resources: NetworkProcessor.Resource<List<Launch>>, launchType: LaunchType) {
        when(resources.state) {
            NetworkProcessor.State.LOADING -> {
                // Show Progress Bar.
            }

            NetworkProcessor.State.SUCCESS -> {
                resources.data?.let { launches ->
                    when(launchType) {
                        LaunchType.UPCOMING -> {
                            allUpComingLaunchesLiveData.postValue(launches)
                        }

                        LaunchType.PAST -> {
                            // Sort the past launches in Descending Order.
                            Collections.sort(launches, descendingLaunchesComparator)

                            // Add the List of Past Launches to the Adapter.
                            allPastLaunchesLiveData.postValue(launches)
                        }
                    }
                }
            }

            NetworkProcessor.State.ERROR -> {

            }
        }
    }

    /**Provides the [LiveData] of [List] of [Capsule]s to it's observers.
     * @return [LiveData] of [List] of [Capsule].*/
    fun getAllRocketsLiveData() = allRocketsLiveData

    /**Requests the [repository] to fetch all the Rockets.
     * @return [LiveData] of [NetworkProcessor.Resource] of type [List] of [Rocket].*/
    fun getRockets(): LiveData<NetworkProcessor.Resource<List<Rocket>>> =
        getRepository().getAllRockets()

    /**Process the Response received by fetching all the Rockets.
     * @param resources [NetworkProcessor.Resource] of type [List] of [Rocket].*/
    fun onRocketsResponse(resources: NetworkProcessor.Resource<List<Rocket>>) {
        when (resources.state) {
            NetworkProcessor.State.LOADING -> {
                // Show Progress Bar.
            }

            NetworkProcessor.State.SUCCESS -> {
                resources.data?.let { capsules ->
                    allRocketsLiveData.postValue(capsules)
                }
            }

            NetworkProcessor.State.ERROR -> {
                // Show the Error.
            }
        }
    }

    /**Provides the [LiveData] of [List] of [Capsule]s to it's observers.
     * @return [LiveData] of [List] of [Capsule].*/
    fun getAllCapsulesLiveData() = allCapsulesLiveData

    /**Requests the [repository] to fetch all the Capsules.
     * @return [LiveData] of [NetworkProcessor.Resource] of type [List] of [Capsule]*/
    fun getCapsules(): LiveData<NetworkProcessor.Resource<List<Capsule>>> =
        getRepository().getAllCapsules()

    /**Process the Response received by fetching all the Capsules.
     * @param resources [NetworkProcessor.Resource] of type [List] of [Capsule].*/
    fun onCapsulesResponse(resources: NetworkProcessor.Resource<List<Capsule>>) {
        when (resources.state) {
            NetworkProcessor.State.LOADING -> {
                // Show Progress Bar.
            }

            NetworkProcessor.State.SUCCESS -> {
                resources.data?.let { capsules ->
                    allCapsulesLiveData.postValue(capsules)
                }
            }

            NetworkProcessor.State.ERROR -> {
                // Show the Error.
            }
        }
    }

    /**Provides the [LiveData] of [List] of [Core]s to it's observers.
     * @return [LiveData] of [List] of [Core].*/
    fun getAllCoresLiveData() : LiveData<List<Core>> = allCoresLiveData

    /**Requests the [repository] to fetch all the Cores.
     * @return [LiveData] of [NetworkProcessor.Resource] of type [List] of [Core].*/
    fun getCores(): LiveData<NetworkProcessor.Resource<List<Core>>> =
        getRepository().getAllCores()

    /**Process the Response received by fetching all the Cores.
     * @param resource [NetworkProcessor.Resource] of type [List] of [Core].*/
    fun onCoresResponse(resource: NetworkProcessor.Resource<List<Core>>) {
        when (resource.state) {
            NetworkProcessor.State.LOADING -> {
                // Show Progress Bar.
            }

            NetworkProcessor.State.SUCCESS -> {
                resource.data?.let { cores ->
                    allCoresLiveData.postValue(cores)
                }
            }

            NetworkProcessor.State.ERROR -> {
                // Show the Error.
            }
        }
    }

    /**Provides the [LiveData] of [Company] to it's observers.
     * @return [LiveData] of [Company].*/
    fun getAboutTheCompanyLiveData() : LiveData<Company> = aboutTheCompanyLiveData

    /**
     * Requests the [repository] to fetch information about the company.
     * @return [LiveData] of [NetworkProcessor.Resource] of type [Company].
     */
    fun getAboutTheCompany() : LiveData<NetworkProcessor.Resource<Company>> =
        getRepository().getAboutTheCompany()

    /**Process the Response received by fetching about the Company.
     * @param resource [NetworkProcessor.Resource] of type [Company].*/
    fun onAboutTheCompanyResponse(resource: NetworkProcessor.Resource<Company>) {
        when (resource.state) {
            NetworkProcessor.State.LOADING -> {
                // Show Progress Bar.
            }

            NetworkProcessor.State.SUCCESS -> {
                resource.data?.let { company ->
                    aboutTheCompanyLiveData.postValue(company)
                }
            }

            NetworkProcessor.State.ERROR -> {
                // Show the Error.
            }
        }
    }

    /**On-Click Method for performing actions when a [Launch] Event from [List] of [Launch]es is
     * selected:
     * @param launch Instance of [Launch].*/
    fun onLaunchClicked(launch: Launch) {
        // TODO : Perform some action when a Launch is clicked in the UI.
    }

    /**Gets the Date Time.
     * @param utcDate [String] containing UTC Date and Time.
     * @return [String] containing formatted Date and Time.*/
    fun getDateTime(utcDate: String?): String = convertUTCDateTime(utcDate)

    /*------------------------------------- List Comparators -------------------------------------*/

    /**[Comparator] for Comparing two [Launch]es and put them in descending order.*/
    private val descendingLaunchesComparator = Comparator <Launch> {
            launch1 : Launch, launch2 : Launch ->
        when {
            launch1.flightNumber!! == launch2.flightNumber!! -> 0
            launch1.flightNumber > launch2.flightNumber -> -1
            launch1.flightNumber < launch2.flightNumber -> 1
            else -> 0
        }
    }

}