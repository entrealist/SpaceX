package ritwik.samples.spacex.ui.main.mvvm

import ritwik.samples.spacex.application.database.RESTServices

/**Repository of [MainViewModel].
 * @author Ritwik Jamuar.*/
class MainRepository (
	private val restServices : RESTServices?
) {
	/**Getter of [RESTServices].
	 * @return Instance of interface [RESTServices].*/
	fun getRepository () : RESTServices? {
		return restServices
	}
}