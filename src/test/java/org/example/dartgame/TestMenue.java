package org.example.dartgame;


import org.junit.jupiter.api.*;

public class TestMenue {
    @BeforeAll
    static void beforeAll(){
        Player spieler = new Player("Frank", 20, "macht kramk");
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
    @DisplayName("Earn Money Test")
    public void earnMoneyTest(){
        Player spieler = new Player("Frank", 20, "macht krank");
        Assertions.assertEquals(70, spieler.earnCredit(20))
    }
}
