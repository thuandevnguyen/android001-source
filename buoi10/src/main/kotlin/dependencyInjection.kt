// Entities
class Person(val name: String, val age: Int)

interface PersonRepository {
  fun getPersonByName(name: String): Person
}

// Higher module
class GetPersonUseCase(
  private val repo: PersonRepository
) {
  fun execute(name: String): Person = repo.getPersonByName(name)
}

// lower-module
class FakePersonRepository : PersonRepository {
  override fun getPersonByName(name: String): Person {
    return Person(name = name, age = 20)
  }
}

fun main() {
  val getPersonUseCase = GetPersonUseCase(repo = FakePersonRepository())
  getPersonUseCase.execute(name = "hello")
}