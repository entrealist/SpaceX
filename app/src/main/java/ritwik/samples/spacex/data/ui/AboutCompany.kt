package ritwik.samples.spacex.data.ui

/**
 * Data Class encapsulating the details of the Company : SpaceX.
 *
 * @param id [String] denoting the Company ID.
 * @param name [String] denoting the name of the Company.
 * @param founded [String] denoting the Founder's Name.
 * @param employees [Int] denoting the count of Employees working for this Company.
 * @param vehicles [Int] denoting the count of Vehicles of this Company.
 * @param launchSites [Int] denoting the count of Launching Sites available for this Company.
 * @param testingSites [Int] denoting the count of Testing Sites available for this Company.
 * @param headExecutives Instance of [CompanyHeadExecutives] encapsulating the
 *   details of Head Executives.
 * @param valuation [Long] denoting the valuation amount of this Company.
 * @param summary [String] denoting the summary of this Company.
 * @param headQuarters Instance of [CompanyHeadQuarters] encapsulating the address of Headquarter.
 * @param links Instance of [CompanyLinks] encapsulating the Links of this Company.
 * @author Ritwik Jamuar
 */
data class Company(
    val id: String,
    val name: String,
    val founder: String,
    val founded: String,
    val employees: Int,
    val vehicles: Int,
    val launchSites: Int,
    val testingSites: Int,
    val headExecutives: CompanyHeadExecutives,
    val valuation: Long,
    val summary: String,
    val headQuarters: CompanyHeadQuarters,
    val links: CompanyLinks
)

/**
 * Data Class encapsulating the details of the Head Executives of this [Company].
 *
 * @param chiefExecutiveOfficer [String] denoting the name of CEO.
 * @param chiefTechnologyOfficer [String] denoting the name of CTO.
 * @param chiefOperationsOfficer [String] denoting the name of COO.
 * @param chiefTechnologyOfficerPropulsion [String] denoting the name of CTO (Propulsion).
 * @author Ritwik Jamuar
 */
data class CompanyHeadExecutives(
    val chiefExecutiveOfficer: String,
    val chiefTechnologyOfficer: String,
    val chiefOperationsOfficer: String,
    val chiefTechnologyOfficerPropulsion: String,
)

/**
 * Data Class encapsulating the Headquarter Details of the [Company].
 *
 * @param address [String] denoting the Headquarter Initial Address.
 * @param city [String] denoting the name of City on which Headquarter is situated.
 * @param state [String] denoting the name of State on which Headquarter is situated.
 */
data class CompanyHeadQuarters(val address: String, val city: String, val state: String)

/**
 * Data Class encapsulating the links of the [Company].
 *
 * @param website [String] denoting the URL to Company Website.
 * @param flickr [String] denoting the Image URL of Company.
 * @param twitterSpaceX [String] denoting the URL to Twitter Handle of SpaceX.
 * @param twitterElon [String] denoting the URL to Twitter Handle of Elon Musk.
 * @author Ritwik Jamuar
 */
data class CompanyLinks(
    val website: String,
    val flickr: String,
    val twitterSpaceX: String,
    val twitterElon: String
)
