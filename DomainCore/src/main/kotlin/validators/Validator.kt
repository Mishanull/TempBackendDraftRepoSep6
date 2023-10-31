package Validators

interface Validator<T> {
    fun validate(entity: T): List<String>
}
