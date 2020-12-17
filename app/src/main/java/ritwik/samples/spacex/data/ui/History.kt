package ritwik.samples.spacex.data.ui

/**
 * Data Class encapsulating the details of a Historic Event of SpaceX.
 *
 * @param id [String] denoting the Event ID.
 * @param title [String] denoting the Title of the Historic Event.
 * @param details [String] denoting the Details of the Historic Event.
 * @param date Instance of [HistoricEventDate] encapsulating the Date of this Historic Event.
 * @param links Instance of [HistoricEventLinks] encapsulating the Links of this Historic Event.
 * @author Ritwik Jamuar
 */
data class HistoricEvent(
    val id: String,
    val title: String,
    val details: String,
    val date: HistoricEventDate,
    val links: HistoricEventLinks
)

/**
 * Data Class encapsulating the Dates of the [HistoricEvent].
 *
 * @param utcEventDate [String] denoting the Date-Time of Event in UTC Format.
 * @param unixEventDate [Long] denoting the Date-Time of Event in UNIX Format.
 * @author Ritwik Jamuar
 */
data class HistoricEventDate(val utcEventDate: String, val unixEventDate: Long)

/**
 * Data Class encapsulating the Links of the [HistoricEvent].
 *
 * @param article [String] denoting the URL of the Article.
 */
data class HistoricEventLinks(val article: String)
