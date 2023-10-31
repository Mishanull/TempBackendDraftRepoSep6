package Validators

import Models.User

class UserValidator : Validator<User> {
    override fun validate(entity: User): List<String> {
        val errors = mutableListOf<String>()
        if (entity.username.isBlank()) {
            errors.add("Username must not be blank.")
        }
        if (!entity.email.contains('@')) {
            errors.add("Invalid email format.")
        }
        

        return errors
    }
}