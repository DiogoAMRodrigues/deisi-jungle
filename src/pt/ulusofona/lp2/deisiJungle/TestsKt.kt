package pt.ulusofona.lp2.deisiJungle

import org.junit.Assert
import org.junit.Test

class TestsKt {
    @Test
    fun test01(){
        val manager = GameManager()
        manager.createInitialJungle(12, arrayOf(arrayOf("1", "Tiago", "E"), arrayOf("2", "Joao", "L")))
        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        Assert.assertEquals("1 | Tiago | Elefante | 180 | 1", commandGetFn.invoke(manager, listOf("PLAYER_INFO", "Tiago")))
        Assert.assertEquals("Inexistent player", commandGetFn.invoke(manager, listOf("PLAYER_INFO", "asd")))
    }

    @Test
    fun test02(){
        val manager = GameManager()
        manager.createInitialJungle(12, arrayOf(arrayOf("1", "Tiago", "E"), arrayOf("2", "Joao", "L")))
        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        Assert.assertEquals("Tiago", commandGetFn.invoke(manager, listOf("PLAYERS_BY_SPECIE", "E")))
    }

    @Test
    fun test03(){
        val manager = GameManager()
        manager.createInitialJungle(12, arrayOf(arrayOf("1", "Tiago", "E"), arrayOf("2", "Joao", "L")))
        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        Assert.assertEquals("Joao:L:0\n" +
                "Tiago:E:0\n" +
                "Total:0", commandGetFn.invoke(manager, listOf("MOST_TRAVELED", "")))
    }

    @Test
    fun test04(){
        val manager = GameManager()
        manager.createInitialJungle(12, arrayOf(arrayOf("1", "Tiago", "P"), arrayOf("2", "Joao", "L")))
        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        Assert.assertEquals("Tiago:70", commandGetFn.invoke(manager, listOf("TOP_ENERGETIC_OMNIVORES", "2")))
    }

    @Test
    fun test05(){
        val manager = GameManager()
        manager.createInitialJungle(12, arrayOf(arrayOf("1", "Tiago", "P"), arrayOf("2", "Joao", "L")))
        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        Assert.assertEquals("", commandGetFn.invoke(manager, listOf("CONSUMED_FOODS", "")))
    }

    @Test
    fun test06(){
        val manager = GameManager()
        manager.createInitialJungle(12, arrayOf(arrayOf("1", "Tiago", "P"), arrayOf("2", "Joao", "L")))
        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.POST)
        Assert.assertEquals("OK", commandGetFn.invoke(manager, listOf("MOVE", "6")))
    }

    @Test
    fun test07(){
        val manager = GameManager()
        manager.createInitialJungle(12, arrayOf(arrayOf("1", "Tiago", "P"), arrayOf("2", "Joao", "L")))
        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.POST)
        Assert.assertEquals("OK", commandGetFn.invoke(manager, listOf("MOVE", "")))
    }

    @Test
    fun test08(){
        val manager = GameManager()
        manager.createInitialJungle(12, arrayOf(arrayOf("1", "Tiago", "P"), arrayOf("2", "Joao", "L")), arrayOf(arrayOf("a","3")))
        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.POST)
        Assert.assertEquals("Apanhou comida", commandGetFn.invoke(manager, listOf("MOVE", "2")))
    }

    @Test
    fun test09(){
        val manager = GameManager()
        manager.createInitialJungle(12, arrayOf(arrayOf("1", "Tiago", "P"), arrayOf("2", "Joao", "L")), arrayOf(arrayOf("a","3")))
        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.POST)
        Assert.assertEquals("Movimento invalido", commandGetFn.invoke(manager, listOf("MOVE", "-2")))
    }

}
