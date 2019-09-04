package ritwik.samples.spacex.pojo.launches

import com.squareup.moshi.Json

data class RocketFirstStage (
	@field: Json ( name = "cores" ) val cores : List <Cores>?
)