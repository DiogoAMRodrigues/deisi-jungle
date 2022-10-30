package pt.ulusofona.lp2.deisiJungle;

public class Especie {
    char identifier;
    String name;
    String image;

    public Especie(char identifier) {
        switch(this.identifier){
            case 'E':
                this.name = "Elefante";
                this.image = "elephant.png";
                break;
            case 'L':
                this.name = "Leão";
                this.image = "lion.png";
                break;
            case 'T':
                this.name = "Tartaruga";
                this.image = "turtle.png";
                break;
            case 'P':
                this.name = "Passáro";
                this.image = "bird.png";
                break;
            case 'Z':
                this.name = "Tarzan";
                this.image = "tarzan.png";
                break;
        }

    }
}
