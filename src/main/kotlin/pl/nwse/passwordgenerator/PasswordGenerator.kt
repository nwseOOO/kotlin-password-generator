package pl.nwse.passwordgenerator

import org.apache.commons.lang3.RandomStringUtils
import java.security.SecureRandom

object PasswordGenerator {

    private val letters : String = "abcdefghijklmnopqrstuvwxyz"
    private val numbers : String = "1234567890"
    private val characters : String = "~`!@#\$%^&*()-_=+[{]}\\|;:'\",<.>/?";

    private val pattern : CharArray = (this.letters + this.letters.uppercase() + this.numbers + this.characters).toCharArray()

    fun generatePassword() : String {
        return RandomStringUtils.random(
            32,
            0,
            this.pattern.size.minus(1),
            false,
            false,
            this.pattern,
            SecureRandom()
        )
    }

}

fun main() {
    val passwordGenerator : PasswordGenerator = PasswordGenerator()

    for(i in 1..10) {
        println("%d. ".format(i) + passwordGenerator.generatePassword())
    }
}
