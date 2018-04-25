package dk.edutor.eduport.mc

import dk.edutor.eduport.Assessment
import dk.edutor.eduport.MCChallenge
import dk.edutor.eduport.MCSolution
import dk.edutor.eduport.PersonIdentifier
import org.junit.Test

import org.junit.Assert.*

class MCCheckerTest {

    @Test
    fun checkTest() {
        println("Checking the Multiple Choice Checker. Check function")
        val challenge = MCChallenge("Which animals are amphibian", hashMapOf("Frogs" to true, "Lions" to false, "Salamanders" to true, "birds" to false), "bio quiz")
        val solution = MCSolution(listOf("Frogs","Salamanders"), PersonIdentifier(1),1)
        val ass =  MCChecker().check(challenge, solution)
        assertTrue(ass.grade == 12 )
    }

    @Test
    fun checkWrongAnswerTest() {
        println("Checking the Multiple Choice Checker for wrong answer")
        val challenge = MCChallenge("Which animals are amphibian", hashMapOf("Frogs" to true, "Lions" to false, "Salamanders" to true, "birds" to false), "bio quiz")
        val solution = MCSolution(listOf("Frogs","Lions"), PersonIdentifier(1),1)
        val ass =  MCChecker().check(challenge, solution)
        assertTrue(ass.grade == 0 )
    }
}