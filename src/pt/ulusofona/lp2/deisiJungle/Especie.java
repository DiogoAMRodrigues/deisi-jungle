package pt.ulusofona.lp2.deisiJungle;

public class Especie {
    char identifier;
    String name;
    String image;

    public Especie(char identifier) {
        switch (identifier) {
            case 'E' -> {
                this.name = "Elefante";
                this.image = "elephant.png";
            }
            case 'L' -> {
                this.name = "Leão";
                this.image = "lion.png";
            }
            case 'T' -> {
                this.name = "Tartaruga";
                this.image = "turtle.png";
            }
            case 'P' -> {
                this.name = "Pássaro";
                this.image = "bird.png";
            }
            case 'Z' -> {
                this.name = "Tarzan";
                this.image = "tarzan.png";
            }
        }
        this.identifier = identifier;
    }

    public char getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
