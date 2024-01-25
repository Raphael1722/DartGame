package org.example.dartgame;


import org.junit.jupiter.api.*;

/**
 * Dies ist die Test Klasse zum testen mit JUnit
 *
 * @author MüllerR
 * @version 1.0
 */
public class TestMenue {
    @BeforeAll
    static void beforeAll(){
        Player spieler = new Player("Frank", 20, "macht krank");
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("Vor jedem Test");
    }
    @AfterEach
    void afterEach(){
        System.out.println("Nach jedem Test");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("Alle Tests fertig");
    }
    @Test
    @DisplayName("Calculate Win Test 1")
    public void calculateWinTest1(){
        Player spieler = new Player("Frank", 20, "macht krank");
        Assertions.assertEquals(60, spieler.calculateWin(20,9,501));
    }
    @Test
    @DisplayName("Calculate Win Test 2")
    public void calculateWinTest2(){
        Player spieler = new Player("Frank", 20, "macht krank");
        Assertions.assertEquals(60, spieler.calculateWin(20,6,301));
    }
    @Test
    @DisplayName("Calculate Win Test 3")
    public void calculateWinTest3(){
        Player spieler = new Player("Frank", 20, "macht krank");
        Assertions.assertEquals(30, spieler.calculateWin(20,7,301));
    }
    @Test
    @DisplayName("Calculate Win Test 4")
    public void calculateWinTest4(){
        Player spieler = new Player("Frank", 20, "macht krank");
        Assertions.assertEquals(30, spieler.calculateWin(20,10,501));
    }
}
