package com.example.movieapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Movie(
    val id: Int = -1,
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val original_title: String = "",
    val original_language: String = "",
    val overview: String = "",
    val popularity: Double = -1.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = -1.0,
    val vote_count: Int = -1,
    val movie_type:String = ""
)

data class MovieList(val results: List<Movie> = listOf())

//Room
@Entity
data class MovieEntity(
    @PrimaryKey
    val id: Int = -1,
    @ColumnInfo("adult")
    val adult: Boolean = false,
    @ColumnInfo("backdrop_path")
    val backdrop_path: String = "",
    @ColumnInfo("original_title")
    val original_title: String = "",
    @ColumnInfo("original_language")
    val original_language: String = "",
    @ColumnInfo("overview")
    val overview: String = "",
    @ColumnInfo("popularity")
    val popularity: Double = -1.0,
    @ColumnInfo("poster_path")
    val poster_path: String = "",
    @ColumnInfo("release_date")
    val release_date: String = "",
    @ColumnInfo("title")
    val title: String = "",
    @ColumnInfo("video")
    val video: Boolean = false,
    @ColumnInfo("vote_average")
    val vote_average: Double = -1.0,
    @ColumnInfo("vote_count")
    val vote_count: Int = -1,
    @ColumnInfo("movie_type")
    val movie_type:String = ""
)

fun List<MovieEntity>.toMovieList() : MovieList {
   val resultList = mutableListOf<Movie>()
    this.forEach { movieEntity ->
        resultList.add(movieEntity.toMovie())
    }
    return MovieList(resultList)
}

fun MovieEntity.toMovie(): Movie = Movie(
   this.id,
    this.adult,
    this.backdrop_path,
    this.original_title,
    this.original_language,
    this.overview,
    this.popularity,
    this.poster_path,
    this.release_date,
    this.title,
    this.video,
    this.vote_average,
    this.vote_count,
    this.movie_type
)
