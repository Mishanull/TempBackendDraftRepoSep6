package validators.exceptions

class UserValidationException(errors: List<String>) : Exception(errors.joinToString("\n"))
