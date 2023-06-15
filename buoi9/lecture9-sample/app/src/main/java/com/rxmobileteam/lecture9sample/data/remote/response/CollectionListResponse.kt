package com.rxmobileteam.lecture9sample.data.remote.response

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class CollectionListResponseItem(
  @Json(name = "id") val id: String, // 72aaifCJ0Sk
  @Json(name = "title") val title: String, // On the Court
  @Json(name = "description") val description: String?, // Get ready for IWD with this beautiful collection by Fillipe Ditadi on Unsplash+.➕
  @Json(name = "published_at") val publishedAt: String, // 2023-03-01T16:04:40Z
  @Json(name = "last_collected_at") val lastCollectedAt: String, // 2023-03-13T14:49:16Z
  @Json(name = "updated_at") val updatedAt: String, // 2023-03-13T14:49:16Z
  @Json(name = "curated") val curated: Boolean, // false
  @Json(name = "featured") val featured: Boolean, // true
  @Json(name = "total_photos") val totalPhotos: Int, // 43
  @Json(name = "private") val `private`: Boolean, // false
  @Json(name = "share_key") val shareKey: String, // 039154cf3406c1d5f3a6d87e0cf4a5e3
  @Json(name = "tags") val tags: List<Tag>,
  @Json(name = "links") val links: Links,
  @Json(name = "user") val user: User,
  @Json(name = "cover_photo") val coverPhoto: CoverPhoto,
  @Json(name = "preview_photos") val previewPhotos: List<PreviewPhoto>
) {
  @Keep
  data class Tag(
    @Json(name = "type") val type: String, // landing_page
    @Json(name = "title") val title: String, // sport
    @Json(name = "source") val source: Source?
  ) {
    @Keep
    data class Source(
      @Json(name = "ancestry") val ancestry: Ancestry,
      @Json(name = "title") val title: String, // Sports images
      @Json(name = "subtitle") val subtitle: String, // Download free sports images
      @Json(name = "description") val description: String, // Few images capture the verve, energy, and tension of human life better than sports images. Capturing bodies in motion is no easy feat, so Unsplash has curated an only-the-finest selection of sporting images that cover everything from yoga and dancing to football and baseball
      @Json(name = "meta_title") val metaTitle: String, // Best 100+ Sports Pictures | Download Free Images on Unsplash
      @Json(name = "meta_description") val metaDescription: String, // Choose from hundreds of free sports pictures. Download HD sports photos for free on Unsplash.
      @Json(name = "cover_photo") val coverPhoto: CoverPhoto
    ) {
      @Keep
      data class Ancestry(
        @Json(name = "type") val type: Type,
        @Json(name = "category") val category: Category?,
        @Json(name = "subcategory") val subcategory: Subcategory?
      ) {
        @Keep
        data class Type(
          @Json(name = "slug") val slug: String, // images
          @Json(name = "pretty_slug") val prettySlug: String // Images
        )

        @Keep
        data class Category(
          @Json(name = "slug") val slug: String, // sports
          @Json(name = "pretty_slug") val prettySlug: String // Sports
        )

        @Keep
        data class Subcategory(
          @Json(name = "slug") val slug: String, // basketball
          @Json(name = "pretty_slug") val prettySlug: String // Basketball
        )
      }

      @Keep
      data class CoverPhoto(
        @Json(name = "id") val id: String, // hawN8XnaJuY
        @Json(name = "slug") val slug: String, // hawN8XnaJuY
        @Json(name = "created_at") val createdAt: String, // 2019-06-09T14:35:21Z
        @Json(name = "updated_at") val updatedAt: String, // 2023-06-05T10:06:47Z
        @Json(name = "promoted_at") val promotedAt: String?, // 2016-09-18T18:40:52Z
        @Json(name = "width") val width: Int, // 3012
        @Json(name = "height") val height: Int, // 4016
        @Json(name = "color") val color: String, // #0c4059
        @Json(name = "blur_hash") val blurHash: String, // LT8s6UM|bvWVQRt7bHjsI:t6nhf6
        @Json(name = "description") val description: String?, // Outdoor basketball in Venice
        @Json(name = "alt_description") val altDescription: String, // person on swimming pool
        @Json(name = "urls") val urls: Urls,
        @Json(name = "links") val links: Links,
        @Json(name = "likes") val likes: Int, // 232
        @Json(name = "liked_by_user") val likedByUser: Boolean, // false
        @Json(name = "current_user_collections") val currentUserCollections: List<Any>,
        @Json(name = "sponsorship") val sponsorship: Any?, // null
        @Json(name = "topic_submissions") val topicSubmissions: TopicSubmissions?,
        @Json(name = "premium") val premium: Boolean?, // false
        @Json(name = "plus") val plus: Boolean?, // false
        @Json(name = "user") val user: User
      ) {
        @Keep
        data class Urls(
          @Json(name = "raw") val raw: String, // https://images.unsplash.com/photo-1560089000-7433a4ebbd64?ixlib=rb-4.0.3
          @Json(name = "full") val full: String, // https://images.unsplash.com/photo-1560089000-7433a4ebbd64?ixlib=rb-4.0.3&q=85&fm=jpg&crop=entropy&cs=srgb
          @Json(name = "regular") val regular: String, // https://images.unsplash.com/photo-1560089000-7433a4ebbd64?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max
          @Json(name = "small") val small: String, // https://images.unsplash.com/photo-1560089000-7433a4ebbd64?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max
          @Json(name = "thumb") val thumb: String, // https://images.unsplash.com/photo-1560089000-7433a4ebbd64?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max
          @Json(name = "small_s3") val smallS3: String // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1560089000-7433a4ebbd64
        )

        @Keep
        data class Links(
          @Json(name = "self") val self: String, // https://api.unsplash.com/photos/hawN8XnaJuY
          @Json(name = "html") val html: String, // https://unsplash.com/photos/hawN8XnaJuY
          @Json(name = "download") val download: String, // https://unsplash.com/photos/hawN8XnaJuY/download
          @Json(name = "download_location") val downloadLocation: String // https://api.unsplash.com/photos/hawN8XnaJuY/download
        )

        @Keep
        data class TopicSubmissions(
          @Json(name = "athletics") val athletics: Athletics?,
          @Json(name = "health") val health: Health?,
          @Json(name = "people") val people: People?,
          @Json(name = "wallpapers") val wallpapers: Wallpapers?,
          @Json(name = "nature") val nature: Nature?,
          @Json(name = "architecture-interior") val architectureInterior: ArchitectureInterior?,
          @Json(name = "color-of-water") val colorOfWater: ColorOfWater?,
          @Json(name = "textures-patterns") val texturesPatterns: TexturesPatterns?,
          @Json(name = "current-events") val currentEvents: CurrentEvents?,
          @Json(name = "spirituality") val spirituality: Spirituality?,
          @Json(name = "experimental") val experimental: Experimental?,
          @Json(name = "arts-culture") val artsCulture: ArtsCulture?,
          @Json(name = "business-work") val businessWork: BusinessWork?,
          @Json(name = "animals") val animals: Animals?
        ) {
          @Keep
          data class Athletics(
            @Json(name = "status") val status: String, // approved
            @Json(name = "approved_on") val approvedOn: String // 2021-01-13T14:55:28Z
          )

          @Keep
          data class Health(
            @Json(name = "status") val status: String, // approved
            @Json(name = "approved_on") val approvedOn: String // 2020-04-06T14:20:25Z
          )

          @Keep
          data class People(
            @Json(name = "status") val status: String, // approved
            @Json(name = "approved_on") val approvedOn: String // 2020-04-06T14:20:24Z
          )

          @Keep
          data class Wallpapers(
            @Json(name = "status") val status: String, // approved
            @Json(name = "approved_on") val approvedOn: String // 2020-04-06T14:20:10Z
          )

          @Keep
          data class Nature(
            @Json(name = "status") val status: String, // approved
            @Json(name = "approved_on") val approvedOn: String // 2020-04-06T14:20:12Z
          )

          @Keep
          data class ArchitectureInterior(
            @Json(name = "status") val status: String, // approved
            @Json(name = "approved_on") val approvedOn: String // 2020-04-06T14:20:14Z
          )

          @Keep
          data class ColorOfWater(
            @Json(name = "status") val status: String, // approved
            @Json(name = "approved_on") val approvedOn: String // 2022-04-21T15:04:21Z
          )

          @Keep
          data class TexturesPatterns(
            @Json(name = "status") val status: String, // approved
            @Json(name = "approved_on") val approvedOn: String // 2020-04-06T14:20:11Z
          )

          @Keep
          data class CurrentEvents(
            @Json(name = "status") val status: String, // approved
            @Json(name = "approved_on") val approvedOn: String // 2021-03-01T12:52:57Z
          )

          @Keep
          data class Spirituality(
            @Json(name = "status") val status: String, // approved
            @Json(name = "approved_on") val approvedOn: String // 2020-04-06T14:20:22Z
          )

          @Keep
          data class Experimental(
            @Json(name = "status") val status: String, // approved
            @Json(name = "approved_on") val approvedOn: String // 2020-04-06T14:20:23Z
          )

          @Keep
          data class ArtsCulture(
            @Json(name = "status") val status: String, // approved
            @Json(name = "approved_on") val approvedOn: String // 2020-04-06T14:20:25Z
          )

          @Keep
          data class BusinessWork(
            @Json(name = "status") val status: String, // approved
            @Json(name = "approved_on") val approvedOn: String // 2021-08-18T15:18:17Z
          )

          @Keep
          data class Animals(
            @Json(name = "status") val status: String, // approved
            @Json(name = "approved_on") val approvedOn: String // 2020-06-03T13:38:01Z
          )
        }

        @Keep
        data class User(
          @Json(name = "id") val id: String, // lfi6pSENbQ8
          @Json(name = "updated_at") val updatedAt: String, // 2023-06-03T11:04:43Z
          @Json(name = "username") val username: String, // serenarepice
          @Json(name = "name") val name: String, // Serena Repice Lentini
          @Json(name = "first_name") val firstName: String, // Serena
          @Json(name = "last_name") val lastName: String?, // Repice Lentini
          @Json(name = "twitter_username") val twitterUsername: String?, // serenarepice
          @Json(name = "portfolio_url") val portfolioUrl: String?, // https://www.instagram.com/serenarepice/
          @Json(name = "bio") val bio: String?, // Photographer based in Rome //Follow on Instagram for more @serenarepice
          @Json(name = "location") val location: String?, // Rome, Italy
          @Json(name = "links") val links: Links,
          @Json(name = "profile_image") val profileImage: ProfileImage,
          @Json(name = "instagram_username") val instagramUsername: String?, // serenarepice
          @Json(name = "total_collections") val totalCollections: Int, // 2
          @Json(name = "total_likes") val totalLikes: Int, // 452
          @Json(name = "total_photos") val totalPhotos: Int, // 252
          @Json(name = "accepted_tos") val acceptedTos: Boolean, // true
          @Json(name = "for_hire") val forHire: Boolean, // true
          @Json(name = "social") val social: Social
        ) {
          @Keep
          data class Links(
            @Json(name = "self") val self: String, // https://api.unsplash.com/users/serenarepice
            @Json(name = "html") val html: String, // https://unsplash.com/@serenarepice
            @Json(name = "photos") val photos: String, // https://api.unsplash.com/users/serenarepice/photos
            @Json(name = "likes") val likes: String, // https://api.unsplash.com/users/serenarepice/likes
            @Json(name = "portfolio") val portfolio: String, // https://api.unsplash.com/users/serenarepice/portfolio
            @Json(name = "following") val following: String, // https://api.unsplash.com/users/serenarepice/following
            @Json(name = "followers") val followers: String // https://api.unsplash.com/users/serenarepice/followers
          )

          @Keep
          data class ProfileImage(
            @Json(name = "small") val small: String, // https://images.unsplash.com/profile-fb-1544872764-aa6d1a869637.jpg?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
            @Json(name = "medium") val medium: String, // https://images.unsplash.com/profile-fb-1544872764-aa6d1a869637.jpg?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
            @Json(name = "large") val large: String // https://images.unsplash.com/profile-fb-1544872764-aa6d1a869637.jpg?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
          )

          @Keep
          data class Social(
            @Json(name = "instagram_username") val instagramUsername: String?, // serenarepice
            @Json(name = "portfolio_url") val portfolioUrl: String?, // https://www.instagram.com/serenarepice/
            @Json(name = "twitter_username") val twitterUsername: String?, // serenarepice
            @Json(name = "paypal_email") val paypalEmail: Any? // null
          )
        }
      }
    }
  }

  @Keep
  data class Links(
    @Json(name = "self") val self: String, // https://api.unsplash.com/collections/72aaifCJ0Sk
    @Json(name = "html") val html: String, // https://unsplash.com/collections/72aaifCJ0Sk/march-madness
    @Json(name = "photos") val photos: String, // https://api.unsplash.com/collections/72aaifCJ0Sk/photos
    @Json(name = "related") val related: String // https://api.unsplash.com/collections/72aaifCJ0Sk/related
  )

  @Keep
  data class User(
    @Json(name = "id") val id: String, // iwi9-4OXLYY
    @Json(name = "updated_at") val updatedAt: String, // 2023-06-14T14:15:51Z
    @Json(name = "username") val username: String, // unsplashplus
    @Json(name = "name") val name: String, // Unsplash+ Collections
    @Json(name = "first_name") val firstName: String, // Unsplash+
    @Json(name = "last_name") val lastName: String, // Collections
    @Json(name = "twitter_username") val twitterUsername: String?, // inky_pixels
    @Json(name = "portfolio_url") val portfolioUrl: String?, // http://inkypixelsdesign.com
    @Json(name = "bio") val bio: String?, // saved by grace // UX Design Manager // hobby photographer
    @Json(name = "location") val location: String?, // Boston
    @Json(name = "links") val links: Links,
    @Json(name = "profile_image") val profileImage: ProfileImage,
    @Json(name = "instagram_username") val instagramUsername: String?, // InkyPixels
    @Json(name = "total_collections") val totalCollections: Int, // 76
    @Json(name = "total_likes") val totalLikes: Int, // 0
    @Json(name = "total_photos") val totalPhotos: Int, // 0
    @Json(name = "accepted_tos") val acceptedTos: Boolean, // true
    @Json(name = "for_hire") val forHire: Boolean, // false
    @Json(name = "social") val social: Social
  ) {
    @Keep
    data class Links(
      @Json(name = "self") val self: String, // https://api.unsplash.com/users/unsplashplus
      @Json(name = "html") val html: String, // https://unsplash.com/@unsplashplus
      @Json(name = "photos") val photos: String, // https://api.unsplash.com/users/unsplashplus/photos
      @Json(name = "likes") val likes: String, // https://api.unsplash.com/users/unsplashplus/likes
      @Json(name = "portfolio") val portfolio: String, // https://api.unsplash.com/users/unsplashplus/portfolio
      @Json(name = "following") val following: String, // https://api.unsplash.com/users/unsplashplus/following
      @Json(name = "followers") val followers: String // https://api.unsplash.com/users/unsplashplus/followers
    )

    @Keep
    data class ProfileImage(
      @Json(name = "small") val small: String, // https://images.unsplash.com/profile-1665554405255-ccc2811bef70image?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
      @Json(name = "medium") val medium: String, // https://images.unsplash.com/profile-1665554405255-ccc2811bef70image?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
      @Json(name = "large") val large: String // https://images.unsplash.com/profile-1665554405255-ccc2811bef70image?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
    )

    @Keep
    data class Social(
      @Json(name = "instagram_username") val instagramUsername: String?, // InkyPixels
      @Json(name = "portfolio_url") val portfolioUrl: String?, // http://inkypixelsdesign.com
      @Json(name = "twitter_username") val twitterUsername: String?, // inky_pixels
      @Json(name = "paypal_email") val paypalEmail: Any? // null
    )
  }

  @Keep
  data class CoverPhoto(
    @Json(name = "id") val id: String, // mzt0A967scs
    @Json(name = "slug") val slug: String, // mzt0A967scs
    @Json(name = "created_at") val createdAt: String, // 2023-03-10T14:13:07Z
    @Json(name = "updated_at") val updatedAt: String, // 2023-04-15T00:20:56Z
    @Json(name = "promoted_at") val promotedAt: String?, // 2022-12-20T11:44:03Z
    @Json(name = "width") val width: Int, // 4672
    @Json(name = "height") val height: Int, // 7008
    @Json(name = "color") val color: String, // #262626
    @Json(name = "blur_hash") val blurHash: String, // LNBp;G?w%2aJRkt7V@WAOuWZWARO
    @Json(name = "description") val description: String?, // Tek it married
    @Json(name = "alt_description") val altDescription: String?, // a man holding a basketball standing next to a fence
    @Json(name = "urls") val urls: Urls,
    @Json(name = "links") val links: Links,
    @Json(name = "likes") val likes: Int, // 2
    @Json(name = "liked_by_user") val likedByUser: Boolean, // false
    @Json(name = "current_user_collections") val currentUserCollections: List<Any>,
    @Json(name = "sponsorship") val sponsorship: Any?, // null
    @Json(name = "topic_submissions") val topicSubmissions: TopicSubmissions?,
    @Json(name = "user") val user: User
  ) {
    @Keep
    data class Urls(
      @Json(name = "raw") val raw: String, // https://plus.unsplash.com/premium_photo-1678401337531-87cede7f059a?ixlib=rb-4.0.3
      @Json(name = "full") val full: String, // https://plus.unsplash.com/premium_photo-1678401337531-87cede7f059a?ixlib=rb-4.0.3&q=85&fm=jpg&crop=entropy&cs=srgb
      @Json(name = "regular") val regular: String, // https://plus.unsplash.com/premium_photo-1678401337531-87cede7f059a?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max
      @Json(name = "small") val small: String, // https://plus.unsplash.com/premium_photo-1678401337531-87cede7f059a?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max
      @Json(name = "thumb") val thumb: String, // https://plus.unsplash.com/premium_photo-1678401337531-87cede7f059a?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max
      @Json(name = "small_s3") val smallS3: String // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/unsplash-premium-photos-production/premium_photo-1678401337531-87cede7f059a
    )

    @Keep
    data class Links(
      @Json(name = "self") val self: String, // https://api.unsplash.com/photos/mzt0A967scs
      @Json(name = "html") val html: String, // https://unsplash.com/photos/mzt0A967scs
      @Json(name = "download") val download: String, // https://unsplash.com/photos/mzt0A967scs/download
      @Json(name = "download_location") val downloadLocation: String // https://api.unsplash.com/photos/mzt0A967scs/download
    )

    @Keep
    data class TopicSubmissions(
      @Json(name = "arts-culture") val artsCulture: ArtsCulture?,
      @Json(name = "business-work") val businessWork: BusinessWork?,
      @Json(name = "architecture-interior") val architectureInterior: ArchitectureInterior?,
      @Json(name = "interiors") val interiors: Interiors?,
      @Json(name = "health") val health: Health?,
      @Json(name = "athletics") val athletics: Athletics?,
      @Json(name = "girls-vs-stereotypes") val girlsVsStereotypes: GirlsVsStereotypes?,
      @Json(name = "food-drink") val foodDrink: FoodDrink?,
      @Json(name = "nature") val nature: Nature?,
      @Json(name = "textures-patterns") val texturesPatterns: TexturesPatterns?,
      @Json(name = "experimental") val experimental: Experimental?,
      @Json(name = "spirituality") val spirituality: Spirituality?,
      @Json(name = "animals") val animals: Animals?,
      @Json(name = "wallpapers") val wallpapers: Wallpapers?,
      @Json(name = "technology") val technology: Technology?
    ) {
      @Keep
      data class ArtsCulture(
        @Json(name = "status") val status: String, // approved
        @Json(name = "approved_on") val approvedOn: String // 2021-02-05T15:53:47Z
      )

      @Keep
      data class BusinessWork(
        @Json(name = "status") val status: String, // approved
        @Json(name = "approved_on") val approvedOn: String // 2022-08-05T10:00:38Z
      )

      @Keep
      data class ArchitectureInterior(
        @Json(name = "status") val status: String, // approved
        @Json(name = "approved_on") val approvedOn: String // 2021-09-28T19:05:43Z
      )

      @Keep
      data class Interiors(
        @Json(name = "status") val status: String, // approved
        @Json(name = "approved_on") val approvedOn: String // 2021-09-07T13:01:39Z
      )

      @Keep
      data class Health(
        @Json(name = "status") val status: String, // approved
        @Json(name = "approved_on") val approvedOn: String // 2020-10-23T10:37:20Z
      )

      @Keep
      data class Athletics(
        @Json(name = "status") val status: String, // approved
        @Json(name = "approved_on") val approvedOn: String // 2020-10-23T10:37:06Z
      )

      @Keep
      data class GirlsVsStereotypes(
        @Json(name = "status") val status: String // rejected
      )

      @Keep
      data class FoodDrink(
        @Json(name = "status") val status: String // rejected
      )

      @Keep
      data class Nature(
        @Json(name = "status") val status: String // rejected
      )

      @Keep
      data class TexturesPatterns(
        @Json(name = "status") val status: String, // approved
        @Json(name = "approved_on") val approvedOn: String // 2020-05-08T09:45:00Z
      )

      @Keep
      data class Experimental(
        @Json(name = "status") val status: String, // approved
        @Json(name = "approved_on") val approvedOn: String // 2021-02-22T11:35:51Z
      )

      @Keep
      data class Spirituality(
        @Json(name = "status") val status: String // rejected
      )

      @Keep
      data class Animals(
        @Json(name = "status") val status: String, // approved
        @Json(name = "approved_on") val approvedOn: String // 2022-05-27T13:46:38Z
      )

      @Keep
      data class Wallpapers(
        @Json(name = "status") val status: String // rejected
      )

      @Keep
      data class Technology(
        @Json(name = "status") val status: String // rejected
      )
    }

    @Keep
    data class User(
      @Json(name = "id") val id: String, // SF31D1ZrLVk
      @Json(name = "updated_at") val updatedAt: String, // 2023-06-14T10:44:13Z
      @Json(name = "username") val username: String, // yunustug
      @Json(name = "name") val name: String, // Yunus Tuğ
      @Json(name = "first_name") val firstName: String, // Yunus
      @Json(name = "last_name") val lastName: String?, // Tuğ
      @Json(name = "twitter_username") val twitterUsername: String?, // bumpyshot
      @Json(name = "portfolio_url") val portfolioUrl: String?, // https://bio.link/yunustug
      @Json(name = "bio") val bio: String?, // Freelance Photographer
      @Json(name = "location") val location: String?, // Turkey
      @Json(name = "links") val links: Links,
      @Json(name = "profile_image") val profileImage: ProfileImage,
      @Json(name = "instagram_username") val instagramUsername: String?, // yunusstug
      @Json(name = "total_collections") val totalCollections: Int, // 25
      @Json(name = "total_likes") val totalLikes: Int, // 13
      @Json(name = "total_photos") val totalPhotos: Int, // 2880
      @Json(name = "accepted_tos") val acceptedTos: Boolean, // true
      @Json(name = "for_hire") val forHire: Boolean, // true
      @Json(name = "social") val social: Social
    ) {
      @Keep
      data class Links(
        @Json(name = "self") val self: String, // https://api.unsplash.com/users/yunustug
        @Json(name = "html") val html: String, // https://unsplash.com/@yunustug
        @Json(name = "photos") val photos: String, // https://api.unsplash.com/users/yunustug/photos
        @Json(name = "likes") val likes: String, // https://api.unsplash.com/users/yunustug/likes
        @Json(name = "portfolio") val portfolio: String, // https://api.unsplash.com/users/yunustug/portfolio
        @Json(name = "following") val following: String, // https://api.unsplash.com/users/yunustug/following
        @Json(name = "followers") val followers: String // https://api.unsplash.com/users/yunustug/followers
      )

      @Keep
      data class ProfileImage(
        @Json(name = "small") val small: String, // https://images.unsplash.com/profile-1679003057258-f755aeb489faimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
        @Json(name = "medium") val medium: String, // https://images.unsplash.com/profile-1679003057258-f755aeb489faimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
        @Json(name = "large") val large: String // https://images.unsplash.com/profile-1679003057258-f755aeb489faimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
      )

      @Keep
      data class Social(
        @Json(name = "instagram_username") val instagramUsername: String?, // yunusstug
        @Json(name = "portfolio_url") val portfolioUrl: String?, // https://bio.link/yunustug
        @Json(name = "twitter_username") val twitterUsername: String?, // bumpyshot
        @Json(name = "paypal_email") val paypalEmail: Any? // null
      )
    }
  }

  @Keep
  data class PreviewPhoto(
    @Json(name = "id") val id: String, // mzt0A967scs
    @Json(name = "slug") val slug: String, // mzt0A967scs
    @Json(name = "created_at") val createdAt: String, // 2023-03-10T14:13:07Z
    @Json(name = "updated_at") val updatedAt: String, // 2023-04-15T00:20:56Z
    @Json(name = "blur_hash") val blurHash: String, // LNBp;G?w%2aJRkt7V@WAOuWZWARO
    @Json(name = "urls") val urls: Urls
  ) {
    @Keep
    data class Urls(
      @Json(name = "raw") val raw: String, // https://plus.unsplash.com/premium_photo-1678401337531-87cede7f059a?ixlib=rb-4.0.3
      @Json(name = "full") val full: String, // https://plus.unsplash.com/premium_photo-1678401337531-87cede7f059a?ixlib=rb-4.0.3&q=85&fm=jpg&crop=entropy&cs=srgb
      @Json(name = "regular") val regular: String, // https://plus.unsplash.com/premium_photo-1678401337531-87cede7f059a?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max
      @Json(name = "small") val small: String, // https://plus.unsplash.com/premium_photo-1678401337531-87cede7f059a?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max
      @Json(name = "thumb") val thumb: String, // https://plus.unsplash.com/premium_photo-1678401337531-87cede7f059a?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max
      @Json(name = "small_s3") val smallS3: String // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/unsplash-premium-photos-production/premium_photo-1678401337531-87cede7f059a
    )
  }
}
