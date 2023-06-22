
data class User(
  val id: Int,
  val username: String,
)

// ~ ITarget
interface AuthRepository {
  // ~ request
  fun login(username: String, password: String): User
}

// ~ Client
class ViewModel(private val authRepository: AuthRepository) {
  init {
    authRepository.login(username = "hello", password = "scelerisque")
  }
}

// ~ Adaptee (external module, third lib) unmodifiable
// Retrofit service
class LoginService {
  fun login(username: String, password: String): User {
    return User(id = 0, username= username)
  }
}

// ADAPTER
class LoginServiceAuthRepositoryImplementation(
  private val loginService: LoginService,
) : AuthRepository {
  override fun login(username: String, password: String): User =
    loginService.login(username = username, password = password)
}

fun main() {
  val loginService = LoginService()
  val authRepository: AuthRepository = LoginServiceAuthRepositoryImplementation(loginService)
  val vm = ViewModel(authRepository = authRepository)
}
