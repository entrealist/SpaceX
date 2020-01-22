package ritwik.samples.spacex.component.other

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**Utility Class for [retrofit2.Retrofit] that encapsulates the act of performing REST API Calls
 * over the Network.
 * @author Ritwik Jamuar*/
abstract class NetworkProcessor<
        TypeResource,
        TypeREST
        > {

    // Data Variables.
    private lateinit var data: MutableLiveData<Resource<TypeResource>>

    /**[retrofit2.Retrofit]'s [Callback] that intercepts the network request.*/
    private val networkCallback = object : Callback<TypeREST> {
        override fun onResponse(call: Call<TypeREST>, response: Response<TypeREST>) {
            when (response.code()) {
                200 -> {
                    val responseData = response.body()
                    if (responseData == null) {
                        data.postValue(
                            Resource(State.ERROR, null, "Data does not exist")
                        )
                    } else {
                        CoroutineScope(Dispatchers.IO)
                            .launch {
                                data.postValue(
                                    Resource(State.SUCCESS, convertData(responseData), null)
                                )
                            }
                    }
                }

                else -> data.postValue(
                    Resource(State.ERROR, null, "Something went wrong")
                )
            }
        }

        override fun onFailure(call: Call<TypeREST>, t: Throwable) =
            data.postValue(
                Resource(State.ERROR, null, t.message)
            )
    }

    /*------------------------------------ Initializer Block -------------------------------------*/

    init {
        initializeLiveData()
        performNetworkCall()
    }

    /*------------------------------------- Private Methods -------------------------------------*/

    /**Initializes the [LiveData].*/
    private fun initializeLiveData() {
        data = MutableLiveData()
    }

    /**Performs the Network Call.*/
    private fun performNetworkCall() {
        // Sets the First State of Request to be Loading.
        data.postValue(Resource(State.LOADING, null, null))

        // Fetches the Response of the Request from Network.
        createCall().enqueue(networkCallback)
    }

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**Provides the [LiveData] of [Resource] of type [TypeResource].
     * @return [LiveData] of [Resource] of type [TypeResource].*/
    fun getData(): LiveData<Resource<TypeResource>> = data

    /*------------------------------------- Abstract Methods -------------------------------------*/

    /**Creates the REST API Call from [retrofit2.Retrofit]'s REST API Interface.*/
    protected abstract fun createCall(): Call<TypeREST>

    /**Tells the implementor to provide [TypeResource] from [TypeREST].
     * The purpose of this method is to convert the data of form [TypeREST] to data of form [TypeResource].
     * If both [TypeResource] and [TypeREST] are same type, then,
     * just return [initialData] to this method,
     * otherwise provide your own implementation on the data conversion.
     * @param initialData Data contained in [TypeREST].
     * @return Data contained in [TypeResource].*/
    protected abstract fun convertData(initialData: TypeREST): TypeResource

    /*--------------------------------------- Enumerations ---------------------------------------*/

    /**Enumeration for encapsulating different States of REST Request.*/
    enum class State {

        /**Denotes that REST API has successfully fetched the Data.*/
        SUCCESS,

        /**Denotes that Some Error has encountered while fetching the Data.*/
        ERROR,

        /**Denotes that Loading is in progress.*/
        LOADING

    }

    /*--------------------------------------- Inner Classes --------------------------------------*/

    /**Data Class that holds the critical information about the REST Response, such as it's State,
     * any message that can be conveyed and of course holding the Data from REST API.
     * @param state [State] of the REST API.
     * @param data Data Object of type [Type].
     * @param message [String] denoting the Message to be conveyed about the REST Request.
     * @author Ritwik Jamuar*/
    data class Resource<
            Type
            >(
        val state: State,
        val data: Type?,
        val message: String?
    )

}