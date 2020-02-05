package ritwik.samples.spacex.ui.main.mvvm

import retrofit2.Call

import ritwik.samples.spacex.application.database.RESTServices

import ritwik.samples.spacex.common.BaseRepository

import ritwik.samples.spacex.component.other.NetworkProcessor

import ritwik.samples.spacex.model.Core

import ritwik.samples.spacex.pojo.capsules.Capsule
import ritwik.samples.spacex.pojo.cores.ResponseCore
import ritwik.samples.spacex.pojo.launches.Launch
import ritwik.samples.spacex.pojo.rockets.Rocket

/**Repository of [MainViewModel].
 * @author Ritwik Jamuar.*/
class MainRepository private constructor(
    restServices: RESTServices
) : BaseRepository(restServices) {

    /*------------------------------------- Companion Object -------------------------------------*/

    companion object {

        /**Creates the Instance of [MainRepository].
         * @param restServices Instance of [RESTServices].
         * @return Instance of [MainRepository]*/
        fun create(restServices: RESTServices): MainRepository = MainRepository(restServices)

    }

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**Tells the [restServices] to fetch all the Upcoming Launches.
     * @return [androidx.lifecycle.LiveData] of [NetworkProcessor.Resource] of type [List] of [Launch].*/
    fun getUpcomingLaunches() = object : NetworkProcessor<List<Launch>, List<Launch>>() {
        override fun createCall(): Call<List<Launch>> = getRESTServices().getUpcomingLaunches()
        override fun convertData(initialData: List<Launch>): List<Launch> = initialData
    }.getData()

    /**Tells the [restServices] to fetch all the Past Launches.
     * @return [androidx.lifecycle.LiveData] of [NetworkProcessor.Resource] of type [List] of [Launch].*/
    fun getPastLaunches() = object : NetworkProcessor<List<Launch>, List<Launch>>() {
        override fun createCall(): Call<List<Launch>> = getRESTServices().getPastLaunches()
        override fun convertData(initialData: List<Launch>): List<Launch> = initialData
    }.getData()

    /**Tells the [restServices] to fetch all the Rockets.
     * @return [androidx.lifecycle.LiveData] of [NetworkProcessor.Resource] of type [List] of [Rocket].*/
    fun getAllRockets() = object : NetworkProcessor<List<Rocket>, List<Rocket>>() {
        override fun createCall(): Call<List<Rocket>> = getRESTServices().getAllRockets()
        override fun convertData(initialData: List<Rocket>): List<Rocket> = initialData
    }.getData()

    /**Tells the [restServices] to fetch all the Capsules.
     * @return [androidx.lifecycle.LiveData] of [NetworkProcessor.Resource] of type [List] of [Capsule].*/
    fun getAllCapsules() = object : NetworkProcessor<List<Capsule>, List<Capsule>>() {
        override fun createCall(): Call<List<Capsule>> = getRESTServices().getAllCapsules()
        override fun convertData(initialData: List<Capsule>): List<Capsule> = initialData
    }.getData()

    /**Tells the [restServices] to fetch all the Cores.
     * @return [androidx.lifecycle.LiveData] of [NetworkProcessor.Resource] of type [List] of [Core].*/
    fun getAllCores() = object : NetworkProcessor<List<Core>, List<ResponseCore>>() {
        override fun createCall(): Call<List<ResponseCore>> = getRESTServices().getAllCores()

        override fun convertData(initialData: List<ResponseCore>): List<Core> {
            val finalList = ArrayList<Core>()

            for (item in initialData) {
                val missions = ArrayList<String>()

                for (m in item.missions) {
                    missions.add(m.name)
                }

                finalList.add(
                    Core(
                        item.serial,
                        item.block,
                        item.launchTimeUTC,
                        missions,
                        item.attemptsRTLS,
                        item.landingsRTLS,
                        item.attemptsASDS,
                        item.landingsASDS,
                        item.details?:"NA"
                    )
                )
            }

            return finalList
        }
    }.getData()

}