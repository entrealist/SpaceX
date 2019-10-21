package ritwik.samples.spacex.utilities

import android.content.Context

import android.net.ConnectivityManager
import android.net.NetworkInfo

import ritwik.samples.spacex.application.App

import java.text.SimpleDateFormat

import java.util.*

/**
 * Utility class for Containing Common Methods to be used across the application.
 * @author Ritwik Jamuar.
 */

/**Checks whether there is Internet Connectivity or not.
 * @return true, when there is Internet Connectivity, false otherwise.*/
fun hasNetwork (): Boolean {

	// Initial Flag.
	var isConnected = false

	// Get the Application's Context.
	val context : Context = App.instance

	// Get ConnectivityManager from Context.
	val connectivityManager = context.getSystemService ( Context.CONNECTIVITY_SERVICE ) as ConnectivityManager

	// Get the NetworkInfo of Active Network.
	val activeNetwork : NetworkInfo? = connectivityManager.activeNetworkInfo

	// Set the Flag to true only when the Active Network is connected.
	if ( activeNetwork != null && activeNetwork.isConnected ) {
		isConnected = true
	}

	// Return the Flag.
	return isConnected

}

/**Prints the Log Message in the LogCat.
 * @param tag String Denoting the Tag to be displayed.
 * @param message String Denoting the Message to be displayed.*/
fun printLog ( tag : String?, message : String? ) {
	android.util.Log.e ( tag, message ?: "No Message" )
}

/**Formats a given [date] with it's [inputDateFormat] and gives another Date as [String] of
 * the [outputDateFormat].
 * @param date [String] denoting the Date.
 * @param inputDateFormat [String] denoting the format of [date].
 * @param outputDateFormat [String] denoting the format of conversion.
 * @return [String] denoting the Date in the [String] format of [outputDateFormat].*/
fun dateFormatter (
	date : String,
	inputDateFormat : String,
	outputDateFormat : String
) : String {

	// Define an Input Format of Date and Time.
	val inputFormat = SimpleDateFormat ( inputDateFormat, Locale.ENGLISH )

	// Define an Output Format of Date and Time.
	val outputFormat = SimpleDateFormat ( outputDateFormat, Locale.ENGLISH )

	// Parse the UTC Date and Time to get Date.
	val parsedDate = inputFormat.parse ( date )

	// Format the Date to our own Format of Date and Time.
	return outputFormat.format ( parsedDate )

}