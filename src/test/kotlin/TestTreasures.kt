import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestTreasures {
    // test for 1 element of array
    @Test
    fun maxTreasures1() {
        assertEquals(7.0, getMaxTreasures(arrayOf(7)))
    }

    // test for 2 element of array
    @Test
    fun maxTreasures2() {
        assertEquals(2.0, getMaxTreasures(arrayOf(1, 2)))
        assertEquals(3.0, getMaxTreasures(arrayOf(2, 2)))
        assertEquals(3.5, getMaxTreasures(arrayOf(2, 3)))
        assertEquals(10.0, getMaxTreasures(arrayOf(2, 10)))
        assertEquals(11.0, getMaxTreasures(arrayOf(10, 2)))
    }

    // test for 3 element of array
    @Test fun maxTreasures3_1() = assertEquals(8.0, getMaxTreasures(arrayOf(2, 4, 6)))
    @Test fun maxTreasures3_2() = assertEquals(8.0, getMaxTreasures(arrayOf(2, 6, 4)))
    @Test fun maxTreasures3_3() = assertEquals(10.0, getMaxTreasures(arrayOf(6, 2, 4)))
    @Test fun maxTreasures3_4() = assertEquals(9.0, getMaxTreasures(arrayOf(6, 4, 2)))

    @Test fun maxTreasures3_5() = assertEquals(10.0, getMaxTreasures(arrayOf(4, 4, 6)))
    @Test fun maxTreasures3_6() = assertEquals(7.0, getMaxTreasures(arrayOf(4, 4, 2)))
    @Test fun maxTreasures3_7() = assertEquals(8.0, getMaxTreasures(arrayOf(4, 4, 4)))


    @Test fun maxTreasures5_1() = assertEquals(14.0, getMaxTreasures(arrayOf(4, 2, 5, 1, 5)))
    @Test fun maxTreasures6_1() = assertEquals(26.0, getMaxTreasures(arrayOf(3, 1, 10, 6, 3, 10)))

    @Test fun maxTreasures7_1() = assertEquals(63.0, getMaxTreasures(arrayOf(20, 22, 20, 22, 20)))

}