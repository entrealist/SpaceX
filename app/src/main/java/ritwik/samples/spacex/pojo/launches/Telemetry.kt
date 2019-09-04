package ritwik.samples.spacex.pojo.launches

import com.squareup.moshi.Json

data class Telemetry (
	@field: Json ( name = "flight_club" ) val flightClub : String?
)