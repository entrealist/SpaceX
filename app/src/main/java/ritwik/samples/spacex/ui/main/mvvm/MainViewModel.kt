package ritwik.samples.spacex.ui.main.mvvm

import androidx.lifecycle.LiveData

import ritwik.samples.spacex.application.database.LaunchType

import ritwik.samples.spacex.common.BaseViewModel

import ritwik.samples.spacex.component.other.NetworkProcessor

import ritwik.samples.spacex.convertUTCDateTime

import ritwik.samples.spacex.pojo.capsules.Capsule
import ritwik.samples.spacex.pojo.launches.Launch
import ritwik.samples.spacex.pojo.rockets.Rocket

import ritwik.samples.spacex.ui.main.MainActivity

/**ViewModel of [MainActivity].
 * @author Ritwik Jamuar.*/
class MainViewModel private constructor(
    repository: MainRepository
) : BaseViewModel<MainRepository>(repository) {

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

    /**Request the [repository] to fetch the Launches of given [type].
     * @param type Specify the type of Launches to fetch. It is described in [LaunchType].
     * @return [LiveData] of [NetworkProcessor.Resource] of type [List] of [Launch].*/
    fun getLaunches(type: LaunchType): LiveData<NetworkProcessor.Resource<List<Launch>>> =
        when (type) {
            LaunchType.UPCOMING -> getRepository().getUpcomingLaunches()
            LaunchType.PAST -> getRepository().getPastLaunches()
        }

    /**Requests the [repository] to fetch all the Rockets.
     * @return [LiveData] of [NetworkProcessor.Resource] of type [List] of [Rocket].*/
    fun getRockets(): LiveData<NetworkProcessor.Resource<List<Rocket>>> =
        getRepository().getAllRockets()

    /**Requests the [repository] to fetch all the Capsules.
     * @return [LiveData] of [NetworkProcessor.Resource] of type [List] of [Capsule]*/
    fun getCapsules(): LiveData<NetworkProcessor.Resource<List<Capsule>>> =
        getRepository().getAllCapsules()

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

}