package dk.edutor.eduport.mc

import dk.edutor.eduport.*


class MCChecker : Port {
    override fun check(challenge: Challenge, solution: Solution): Assessment {
        if (!(challenge is MCChallenge)) throw IllegalArgumentException("Challenge should be Multiple Choice")
        if (!(solution is MCSolution)) throw IllegalArgumentException("Solution should be Multiple Choice")
        try {
            for (answer: String in solution.answers) {
                check(challenge.answers[answer]!!)
            }
        }catch(e:IllegalStateException){
            return Assessment(solution, 0)
        }
        return Assessment(solution, 12)
    }

    override fun sayHello(text: String) = ""

}