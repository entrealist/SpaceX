package ritwik.samples.spacex.pojo

import com.squareup.moshi.Json

data class Links (
	@field: Json ( name = "mission_patch" )			val missionPatch : 		String,
	@field: Json ( name = "mission_patch_small" )	val missionPatchSmall : String,
	@field: Json ( name = "reddit_campaign" )		val redditCampaign :	String,
	@field: Json ( name = "reddit_launch" )			val redditLaunch :		String,
	@field: Json ( name = "reddit_recovery" )		val redditRecovery :	String,
	@field: Json ( name = "reddit_media" )			val redditMedia :		String,
	@field: Json ( name = "presskit" )				val pressKit :			String,
	@field: Json ( name = "article_link" )			val articleLink :		String,
	@field: Json ( name = "wikipedia" )				val wikipedia :			String,
	@field: Json ( name = "video_link" )			val videoLink :			String,
	@field: Json ( name = "youtube_id" )			val youtubeID :			String,
	@field: Json ( name = "flickr_images" )			val flickerImages :		List < String >
)