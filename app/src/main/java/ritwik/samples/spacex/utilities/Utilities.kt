package ritwik.samples.spacex.utilities

import java.text.SimpleDateFormat

import java.util.*

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

/**
 *
 */
fun dateFormatter (
	utcDate : String,
	inputDateFormat : String,
	outputDateFormat : String
) : String {
	// Define an Input Format of Date and Time.
	val inputFormat = SimpleDateFormat ( inputDateFormat, Locale.ENGLISH )

	// Define an Output Format of Date and Time.
	val outputFormat = SimpleDateFormat ( outputDateFormat, Locale.ENGLISH )

	// Parse the UTC Date and Time to get Date.
	val date = inputFormat.parse ( utcDate )

	// Format the Date to our own Format of Date and Time.
	return outputFormat.format ( date )
}