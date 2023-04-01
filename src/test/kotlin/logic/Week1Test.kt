package logic

import logic.Problem.Companion.EAST
import logic.Problem.Companion.NORTH
import logic.Problem.Companion.SOUTH
import logic.Problem.Companion.WEST
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Week1Test : WorldTestBase() {
    @Test
    fun karelsFirstProgram() {
        testAfterEachGoalOf(Problem.karelsFirstProgram) {
            assertKarelAt(4, 8, EAST)
            assertSoleBeeperAt(3, 8)
        }
    }

    @Test
    fun obtainArtifact() {
        testAfterEachGoalOf(Problem.obtainArtifact) {
            assertKarelAt(3, 5)
            assertSoleBeeperAtKarel()
        }
    }

    @Test
    fun defuseOneBomb() {
        testAfterEachGoalOf(Problem.defuseOneBomb) {
            assertKarelAt(0, 9, EAST)
            assertNoBeepers()
        }
    }

    @Test
    fun defuseTwoBombs() {
        testAfterEachGoalOf(Problem.defuseTwoBombs) {
            assertKarelAt(0, 9, NORTH)
            assertNoBeepers()
        }
    }

    @Test
    fun practiceHomeRun() {
        testAfterEachGoalOf(Problem.practiceHomeRun) {
            assertKarelAt(0, 9, EAST)
            assertNoBeepers()
        }
    }

    @Test
    fun climbTheStairs() {
        testAfterEachGoalOf(Problem.climbTheStairs) {
            assertKarelAt(7, 3, EAST)
            assertNoBeepers()
        }
    }

    @Test
    fun fillTheHoles() {
        testAfterEachGoalOf(Problem.fillTheHoles) {
            assertKarelAt(9, 8, EAST)
            assertNumberOfBeepers(4)
            assertAllBeepersTouch(FloorPlan.WALL_ALL - FloorPlan.WALL_NORTH)
        }
    }

    @Test
    fun saveTheFlower() {
        testAfterEachGoalOf(Problem.saveTheFlower) {
            assertKarelAt(9, 9, EAST)
            assertSoleBeeperAt(5, 1)
        }
    }

    @Test
    fun mowTheLawn() {
        testAfterEachGoalOf(Problem.mowTheLawn) {
            assertKarelAt(1, 2, WEST)
            assertNoBeepers()
        }
    }

    @Test
    fun harvestTheField() {
        testAfterEachGoalOf(Problem.harvestTheField) {
            assertEquals(4, world.y)
            assertEquals(SOUTH, world.direction)
            assertNoBeepers()
        }
    }

    @Test
    fun repairTheStreet() {
        testAfterEachGoalOf(Problem.repairTheStreet) {
            assertKarelAt(9, 8, EAST)
            for (x in 0..9) {
                val isSolid = (world.floorPlan.wallsAt(x, 9).and(FloorPlan.WALL_NORTH)) != 0
                val isRepaired = world.beeperAt(x, 9)
                assertTrue(isSolid.xor(isRepaired))
            }
        }
    }

    @Test
    fun cleanTheRoom() {
        testAfterEachGoalOf(Problem.cleanTheRoom) {
            assertKarelAt(0, 0, WEST)
            assertNoBeepers()
        }
    }

    @Test
    fun tileTheFloor() {
        testAfterEachGoalOf(Problem.tileTheFloor) {
            assertKarelAt(4, 5, SOUTH)
            assertNumberOfBeepers(100)
        }
    }

    @Test
    fun stealOlympicFire() {
        testAfterEachGoalOf(Problem.stealOlympicFire) {
            assertKarelAt(9, 9, EAST)
            assertNoBeepers()
        }
    }

    @Test
    fun removeTheTiles() {
        testAfterEachGoalOf(Problem.removeTheTiles) {
            assertEquals(100, initialWorld.countBeepers())
            assertKarelAt(4, 5, SOUTH)
            assertNoBeepers()
        }
    }

    @Test
    fun walkTheLabyrinth() {
        testAfterEachGoalOf(Problem.walkTheLabyrinth) {
            assertSoleBeeperAtKarel()
        }
    }
}
