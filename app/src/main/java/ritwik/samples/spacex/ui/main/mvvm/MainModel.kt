package ritwik.samples.spacex.ui.main.mvvm

import ritwik.samples.spacex.pojo.Launch

/**Model Class for [ritwik.samples.spacex.ui.main.MainActivity].
 * @author Ritwik Jamuar.*/
data class MainModel (
	var launches : List < Launch >? // List Storing Launches of Rockets.
)