package ritwik.samples.spacex.data.ui

/**
 * Data Class encapsulating the details of all Historic Events of SpaceX of a particular [year].
 *
 * @param year [Int] denoting the Year.
 * @param events [List] of [HistoricEvent] denoting the collection of Events during the [year].
 * @author Ritwik Jamuar
 */
data class HistoricEvents(val year: Int, val events: List<HistoricEvent>)

/**
 * Data Class encapsulating the details of a Historic Event of SpaceX.
 *
 * @param id [String] denoting the Event ID.
 * @param title [String] denoting the Title of the Historic Event.
 * @param details [String] denoting the Details of the Historic Event.
 * @param date [String] denoting the Date of the Event.
 * @param links Instance of [HistoricEventLinks] encapsulating the Links of this Historic Event.
 * @author Ritwik Jamuar
 */
data class HistoricEvent(
    val id: String,
    val title: String,
    val details: String,
    val date: String,
    val links: HistoricEventLinks
)

/**
 * Data Class encapsulating the Links of the [HistoricEvent].
 *
 * @param article [String] denoting the URL of the Article.
 */
data class HistoricEventLinks(val article: String)
