package logic

import logic.Problem.Companion.EAST
import logic.Problem.Companion.NORTH
import org.junit.Assert.assertEquals
import org.junit.Test

class Week2Test : WorldTestBase() {
    @Test
    fun hangTheLampions() {
        testAfterEachGoalOf(Problem.hangTheLampions) {
            assertKarelAt(9, 9, EAST)
            assertNumberOfBeepers(10)
            assertAllBeepersTouch(FloorPlan.WALL_NORTH)
        }
    }

    @Test
    fun followTheSeeds() {
        testAfterEachGoalOf(Problem.followTheSeeds) {
            assertKarelAt(9, 9, NORTH)
            assertNoBeepers()
        }
    }

    @Test
    fun cleanTheTunnels() {
        testAfterEachGoalOf(Problem.cleanTheTunnels) {
            assertKarelAt(9, 9, EAST)
            assertNoBeepers()
        }
    }

    @Test
    fun increment() {
        testAfterEachGoalOf(Problem.increment) {
            val before = initialWorld.binaryNumber()
            val after = world.binaryNumber()
            assertEquals((before + 1).and(255), after)
        }
    }

    @Test
    fun decrement() {
        testAfterEachGoalOf(Problem.decrement) {
            val before = initialWorld.binaryNumber()
            val after = world.binaryNumber()
            assertEquals((before - 1).and(255), after)
        }
    }

    @Test
    fun addSlow() {
        testAfterEachGoalOf(Problem.addSlow) {
            val one = initialWorld.binaryNumber(0)
            val two = initialWorld.binaryNumber(1)
            val sum = world.binaryNumber(1)
            assertEquals((one + two).and(255), sum)
        }
    }

    @Test
    fun saveTheFlowers() {
        testAfterEachGoalOf(Problem.saveTheFlowers) {
            assertKarelAt(9, 9, EAST)
            assertNumberOfBeepers(4)
            assertAllBeepersTouch(FloorPlan.WALL_SOUTH)
            assertNoBeepersTouch(FloorPlan.WALL_EAST)
        }
    }

    @Test
    fun findTeddyBear() {
        testAfterEachGoalOf(Problem.findTeddyBear) {
            assertSoleBeeperAtKarel()
        }
    }

    @Test
    fun jumpTheHurdles() {
        testAfterEachGoalOf(Problem.jumpTheHurdles) {
            val x = Integer.numberOfTrailingZeros((initialWorld.beepersHi.ushr(9 * 10 - 64)).toInt())
            assertKarelAt(x, 9, EAST)
            assertSoleBeeperAtKarel()
        }
    }

    @Test
    fun solveTheMaze() {
        testAfterEachGoalOf(Problem.solveTheMaze) {
            assertSoleBeeperAtKarel()
        }
    }

    @Test
    fun quantize() {
        testAfterEachGoalOf(Problem.quantizeBits) {
            assertKarelAt(9, 9, EAST)
            for (x in 0..9) {
                val expected = initialWorld.beeperAt(x, 4)
                for (y in 0..9) {
                    assertEquals(expected, world.beeperAt(x, y))
                }
            }
        }
    }

    @Test
    fun addFast() {
        testAfterEachGoalOf(Problem.addFast) {
            val one = initialWorld.binaryNumber(0)
            val two = initialWorld.binaryNumber(1)
            val sum = world.binaryNumber(3)
            assertEquals((one + two).and(255), sum)
        }
    }
}
