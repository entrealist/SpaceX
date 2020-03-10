package ritwik.samples.spacex.ui.main.mvvm

import retrofit2.Call

import ritwik.samples.spacex.application.database.RESTServices

import ritwik.samples.spacex.common.BaseRepository

import ritwik.samples.spacex.component.other.NetworkProcessor

import ritwik.samples.spacex.model.*
import ritwik.samples.spacex.pojo.*

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
    fun getUpcomingLaunches() = object : NetworkProcessor<List<Launch>, List<ResponseLaunch>>() {

        override fun createCall(): Call<List<ResponseLaunch>> = getRESTServices().getUpcomingLaunches()

        override fun convertData(initialData: List<ResponseLaunch>): List<Launch> {
            val launches = ArrayList<Launch>()
            for (responseLaunch in initialData) {
                launches.add(responseLaunch.convertToModelData())
            }
            return launches
        }

    }.getData()

    /**Tells the [restServices] to fetch all the Past Launches.
     * @return [androidx.lifecycle.LiveData] of [NetworkProcessor.Resource] of type [List] of [Launch].*/
    fun getPastLaunches() = object : NetworkProcessor<List<Launch>, List<ResponseLaunch>>() {

        override fun createCall(): Call<List<ResponseLaunch>> = getRESTServices().getPastLaunches()

        override fun convertData(initialData: List<ResponseLaunch>): List<Launch> {
            val launches = ArrayList<Launch>()
            for (responseLaunch in initialData) {
                launches.add(responseLaunch.convertToModelData())
            }
            return launches
        }

    }.getData()

    /**Tells the [restServices] to fetch all the Rockets.
     * @return [androidx.lifecycle.LiveData] of [NetworkProcessor.Resource] of type [List] of [Rocket].*/
    fun getAllRockets() = object : NetworkProcessor<List<Rocket>, List<ResponseRocket>>() {

        override fun createCall(): Call<List<ResponseRocket>> = getRESTServices().getAllRockets()

        override fun convertData(initialData: List<ResponseRocket>): List<Rocket> {
            val rockets = ArrayList<Rocket>()
            for (responseRocket in initialData) {
                rockets.add(responseRocket.convertToModelData())
            }
            return rockets
        }

    }.getData()

    /**Tells the [restServices] to fetch all the Capsules.
     * @return [androidx.lifecycle.LiveData] of [NetworkProcessor.Resource] of type [List] of [Capsule].*/
    fun getAllCapsules() = object : NetworkProcessor<List<Capsule>, List<ResponseCapsule>>() {

        override fun createCall(): Call<List<ResponseCapsule>> = getRESTServices().getAllCapsules()

        override fun convertData(initialData: List<ResponseCapsule>): List<Capsule> {
            val capsules = ArrayList<Capsule>()
            for (responseCapsule in initialData) {
                capsules.add(responseCapsule.convertToModelData())
            }
            return capsules
        }

    }.getData()

    /**Tells the [restServices] to fetch all the Cores.
     * @return [androidx.lifecycle.LiveData] of [NetworkProcessor.Resource] of type [List] of [Core].*/
    fun getAllCores() = object : NetworkProcessor<List<Core>, List<ResponseCore>>() {
        override fun createCall(): Call<List<ResponseCore>> = getRESTServices().getAllCores()

        override fun convertData(initialData: List<ResponseCore>): List<Core> {
            val finalList = ArrayList<Core>()
            for (item in initialData) {
                finalList.add(item.convertToModelData())
            }
            return finalList
        }
    }.getData()

	/**
	 * Tells the [restServices] to fetch information about the company.
	 * @return [androidx.lifecycle.LiveData] of [NetworkProcessor.Resource] of type [Company].
	 */
	fun getAboutTheCompany() = object : NetworkProcessor<Company, ResponseCompany>() {
		override fun createCall() : Call<ResponseCompany> = getRESTServices().getInfo()
		override fun convertData(initialData : ResponseCompany) : Company = initialData.convertToModelData()
	}.getData()

}