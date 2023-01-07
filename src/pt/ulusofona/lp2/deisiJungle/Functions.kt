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

        if(list.size < max_results.toInt()){
            list = list.subList(0, list.size)
        }else{
            list = list.subList(0, max_results.toInt())
        }

        list.forEach { result += it.name + ":" + it.energy + "\n" }

        if (result.isNotEmpty()){
            result = result.substring(0, result.length-1)
        }
        return result
    }


    fun consumedFoods(gameManager: GameManager): String? {
        val players = gameManager.tabuleiro.jogadores
        var arrayList = ArrayList<String>()
        var result = ""

        players.forEach {arrayList.addAll(it.eatenFoods)}

        arrayList.toSet().toList().sortedBy{it}.forEach{result += it}

        if(result.isNotEmpty()){
            result = result.substring(0, result.length-1)
        }

        return result
    }


    fun move(gameManager: GameManager, numPosições: String): String? {
        try{
            if(numPosições.equals("")){
                return "OK"
            }

            if(gameManager.tabuleiro.currentPlayer.position + numPosições.toInt() < 0){
                return "Movimento invalido"
            }

            val move : MovementResult = gameManager.moveCurrentPlayer(numPosições.toInt(), true)
            var message = ""

            if(move.code == MovementResultCode.VALID_MOVEMENT){
                message = "OK"
            }else if(move.code == MovementResultCode.CAUGHT_FOOD){
                message = "Apanhou comida"
            }else if(move.code == MovementResultCode.INVALID_MOVEMENT){
                message = "Movimento invalido"
            }else if(move.code == MovementResultCode.NO_ENERGY){
                message = "Sem energia"
            }

            return message
        }catch(e : NumberFormatException){
            return "Movimento invalido"
        }
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
        if(list.get(0).equals("MOVE")) {
            return move(gameManager, list.get(1))
        }
        return null
    }

    fun router(): (CommandType) -> (GameManager, List<String>) -> String? {
        return ::getFunctions
    }

fun main() {

    val manager = GameManager()
    manager.createInitialJungle(12, arrayOf(arrayOf("1", "Tiago", "E"), arrayOf("2", "Joao", "L")))
    val routerFn = router()
    val commandGetFn = routerFn.invoke(CommandType.POST)
    println(commandGetFn.invoke(manager, listOf("MOVE", "6")))

}
