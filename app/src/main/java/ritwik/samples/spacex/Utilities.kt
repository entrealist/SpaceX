package ritwik.samples.spacex

/**
 * Utility class for Containing Common Methods to be used across the application.
 * @author Ritwik Jamuar.
 */

/**Prints the Log Message in the LogCat.
 * @param tag String Denoting the Tag to be displayed.
 * @param message String Denoting the Message to be displayed.*/
fun printLog ( tag : String?, message : String? ) {
	android.util.Log.e ( tag, message ?: "No Message" )
}