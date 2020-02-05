package ritwik.samples.spacex

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

/**Converts an UTC Date Time to Formatted Date Time for display in the UI.
 * @param utcDate [String] containing UTC Date and Time.
 * @return [String] containing formatted Date and Time.
 * Refer below Link for more detail on SimpleDateFormat:
 * https://www.journaldev.com/17899/java-simpledateformat-java-date-format */
fun convertUTCDateTime ( utcDate : String? ) : String {
	return if (utcDate == null) {
		"NA"
	} else {
		// Define an Input Format of Date and Time.
		val inputFormat = SimpleDateFormat ( "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH )

		// Define an Output Format of Date and Time.
		val outputFormat = SimpleDateFormat ( "dd MMM yyyy, hh:mm a", Locale.ENGLISH )

		// Parse the UTC Date and Time to get Date.
		val date = inputFormat.parse ( utcDate )

		// Format the Date to our own Format of Date and Time.
		outputFormat.format ( date )
	}
}