package ritwik.samples.spacex.utility.constant

/**
 * Constant [String] denoting the Date-Time Format used by
 * [ritwik.samples.spacex.data.network.LaunchResponse].
 *
 *
 * Example of such date format: 2021-01-01T00:00:00.000Z
 */
const val LAUNCH_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

/**
 * Constant [String] denoting the Date-Time Format used by
 * [ritwik.samples.spacex.data.network.HistoricEventResponse].
 *
 *
 * Example of such date format: 2008-09-28T23:15:00Z
 */
const val HISTORIC_EVENT_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"

/**
 * Constant [String] denoting the Date-Time Format used across package [ritwik.samples.spacex.ui].
 *
 *
 * Example of such date format: 28 Sep 2008, 11:15 PM
 */
const val UI_DATE_TIME_FORMAT = "dd MMM yyyy, hh:mm a"
