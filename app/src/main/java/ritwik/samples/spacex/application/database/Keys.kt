package ritwik.samples.spacex.application.database

/**Enumeration for encapsulating different types of Launches.*/
enum class LaunchType {

    /**Denotes the Upcoming Launches.*/
    UPCOMING,

    /**Denotes the Past Launches.*/
    PAST

}

const val ENDPOINT_SLASH = "/"
const val ENDPOINT_LAUNCHES = "launches"
const val ENDPOINT_LAUNCHES_TYPE_UPCOMING = "upcoming"
const val ENDPOINT_LAUNCHES_TYPE_PAST = "past"
const val ENDPOINT_ROCKETS = "rockets"
const val ENDPOINT_CAPSULES = "capsules"
const val ENDPOINT_CORES = "cores"
const val ENDPOINT_INFO = "info"