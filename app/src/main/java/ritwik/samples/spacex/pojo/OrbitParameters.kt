package ritwik.samples.spacex.pojo

import com.squareup.moshi.Json

data class OrbitParameters (
	@field: Json ( name = "reference_system" )		val referenceSystem :		String?,
	@field: Json ( name = "regime" )				val regime :				String?,
	@field: Json ( name = "longitude" )				val longitude :				Double?,
	@field: Json ( name = "semi_major_axis_km" )	val semiMajorAxisKM :		Double?,
	@field: Json ( name = "eccentricity" )			val eccentricity :			Double?,
	@field: Json ( name = "periapsis_km" )			val periapsisKM :			Double?,
	@field: Json ( name = "apoapsis_km" )			val apoapsisKM :			Double?,
	@field: Json ( name = "inclination_deg" )		val inclinationDegree :		Double?,
	@field: Json ( name = "period_min" )			val minimumPeriod :			Double?,
	@field: Json ( name = "lifespan_years" )		val lifespanYears :			Double?,
	@field: Json ( name = "epoch" )					val epoch :					String?,
	@field: Json ( name = "mean_motion" )			val meanMotion :			Double?,
	@field: Json ( name = "raan" )					val raan :					Double?,
	@field: Json ( name = "arg_of_pericenter" )		val argumentOfPericenter :	Double?,
	@field: Json ( name = "mean_anomaly" )			val meanAnomaly :			Double?
)