data class Movie(
  val id: String,
  val title: String
)

interface MovieRepository {
  fun getTrendingMovies(): List<Movie>
  fun getPopularMovies(): List<Movie>
  fun getFavoriteMovies(): List<Movie>
}

class MovieRepositoryApiV1: MovieRepository {
  override fun getTrendingMovies(): List<Movie> {
    TODO("Not yet implemented")
  }
  
  override fun getPopularMovies(): List<Movie> {
    TODO("Not yet implemented")
  }
  
  override fun getFavoriteMovies(): List<Movie> {
    TODO("Not yet implemented")
  }
}

class MovieRepositoryApiV2 (private val v1: MovieRepositoryApiV1): MovieRepository by v1 {
  override fun getTrendingMovies(): List<Movie> {
    TODO("Not yet implemented")
  }
}

fun provideMovieRepository(): MovieRepository {
  return MovieRepositoryApiV2(
    MovieRepositoryApiV1()
  )
}

fun main() {
  provideMovieRepository().getPopularMovies()
  provideMovieRepository().getTrendingMovies()
  provideMovieRepository().getFavoriteMovies()
}