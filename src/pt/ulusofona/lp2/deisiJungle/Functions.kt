package pt.ulusofona.lp2.deisiJungle

import kotlin.math.max

enum class CommandType{
    GET, POST
}

    fun getPlayerInfo(gameManager: GameManager, playerName: String?): String {
        val players = gameManager.tabuleiro.jogadores;
        var playerInfo = ""
        players.filter { it.name.equals(playerName) }.forEach {
            playerInfo += (it.id).toString() + " | " + it.name + " | " +
                    it.species.name + " | " + it.energy + " | " + (it.position + 1)
        }
        if (!playerInfo.equals("")) {
            return playerInfo
        }
        return "Inexistent player"
    }


    fun playersBySpecies(gameManager: GameManager, speciesID: String?): String {
        val players = gameManager.tabuleiro.jogadores
        var result = ""
        val arrayList = ArrayList<String>()

        players.filter { it.species.identifier.toString() == speciesID }.forEach { arrayList.add(it.name)}

        arrayList.sortDescending()

        arrayList.forEach{result+=it+","}

        if (result.isNotEmpty()) {
            result = result.substring(0,result.length - 1)
        }
        return result
    }


    fun mostTraveled(gameManager: GameManager): String {

        val players = gameManager.tabuleiro.jogadores
        var result = ""
        var dist = 0

        val sortedPlayersList = players.sortedWith(compareBy{it.distancia}).reversed()

        sortedPlayersList.forEach {
            dist += it.distancia;
            result += it.name + ":" + it.species.identifier + ":" + it.distancia + "\n"
        }

        return result + "Total:" + dist
    }


    fun topEnergeticOmnivores(gameManager: GameManager, max_results: String): String? {
        val players = gameManager.tabuleiro.jogadores
        var result = ""

        var list = players.filter { it.species.tipoAnimal == AnimalType.OMNIVORO }.sortedWith(compareBy { it.energy }).reversed()

        list = list.subList(0, max_results.toInt())

        list.forEach { result += it.name + ":" + it.energy + "\n" }

        if (result.isNotEmpty()){
            result = result.substring(0, result.length-1)
        }
        return result
    }


    fun consumedFoods(gameManager: GameManager): String? {
        return ""
    }


    fun move(gameManager: GameManager, numPosições: String): String? {
        val move : MovementResult = gameManager.moveCurrentPlayer(numPosições.toInt(), true)
        var message = ""

        if(move.message == null){
            message = "OK"
        }else if(move.code == MovementResultCode.CAUGHT_FOOD){
            message = "Apanhou comida"
        }else if(move.code == MovementResultCode.INVALID_MOVEMENT){
            message = "Movimento invalido"
        }else if(move.code == MovementResultCode.NO_ENERGY){
            message = "Sem energia"
        }

        return message
    }


    fun getFunctions(commandType: CommandType): (GameManager, List<String>) -> String? {

        if (commandType == CommandType.GET) {
            return ::get
        } else if (commandType == CommandType.POST) {
            return ::post
        }
        return { a, b -> null } //função que retorna null
    }


    fun get(gameManager: GameManager, list: List<String>): String? {
        when{
            list[0].equals("PLAYER_INFO") -> {return getPlayerInfo(gameManager, list.get(1))}
            list[0].equals("PLAYERS_BY_SPECIE") -> {return playersBySpecies(gameManager, list.get(1))}
            list[0].equals("MOST_TRAVELED") -> {return mostTraveled(gameManager)}
            list[0].equals("TOP_ENERGETIC_OMNIVORES") -> {return topEnergeticOmnivores(gameManager, list.get(1))}
            list[0].equals("CONSUMED_FOODS") -> {return consumedFoods(gameManager)}
        }
        return null
    }


    fun post(gameManager: GameManager, list: List<String>): String? {
        return move(gameManager, list[0])
    }

    fun router(): (CommandType) -> (GameManager, List<String>) -> String? {
        return ::getFunctions
    }

    fun main() {
        val manager = GameManager()
        manager.createInitialJungle(12, arrayOf(arrayOf("1", "Aedro", "E"), arrayOf("2", "Zoao", "E")))
        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        val result = commandGetFn.invoke(manager, listOf("PLAYERS_BY_SPECIE", "E"))
        println(result)
    }
