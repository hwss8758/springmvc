package hello.springmvc.basic.requestmapping

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MappingClassController {

    @GetMapping("/mapping/users")
    fun user(): String {
        return "get users"
    }

    @PostMapping("/mapping/users")
    fun addUser(): String {
        return "post user"
    }

    @GetMapping("/mapping/users/{userId}")
    fun findUser(@PathVariable userId: String): String {
        return "get userId = $userId"
    }

    @PatchMapping("/mapping/users/{userId}")
    fun updateUser(@PathVariable userId: String): String {
        return "get userId = $userId"
    }

    @DeleteMapping("/mapping/users/{userId}")
    fun deleteUser(@PathVariable userId: String): String {
        return "get userId = $userId"
    }
}