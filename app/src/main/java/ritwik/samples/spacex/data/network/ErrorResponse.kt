package ritwik.samples.spacex.data.network

import com.squareup.moshi.Json

import sample.ritwik.common.data.network.BaseErrorResponse

/**
 * [BaseErrorResponse] denoting the Error Response POJO Class.
 *
 * @param error [String] denoting the Error Description.
 * @author Ritwik Jamuar
 */
data class ErrorResponse(
    @field: Json(name = "error") val error: String
) : BaseErrorResponse()
