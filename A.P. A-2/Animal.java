//ANIMAL CLASS FILE

interface Zoo_Element{
    void displayInfo();
}


abstract class Animal implements Zoo_Element {
    String name;
    String type;
    String sound;
    String description;

    public Animal(String name, String type,String sound,String description) {
        this.name = name;
        this.type = type;
        this.sound=sound;
        this.description=description;

    }
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getSound() {
        return sound;
    }


    public void setSound(String sound) {
        this.sound = sound;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Sound:" + sound);
        System.out.println("Description:" +description);
        System.out.println();
    }
}



class Mammal extends Animal {
    public Mammal(String name,String sound,String description) {
        super(name, "Mammal",sound, description);
    }
}

class Amphibian extends Animal {
    public Amphibian(String name,String sound,String description) {
        super(name, "Amphibian",sound, description);
    }
}

class Reptile extends Animal {
    public Reptile(String name, String sound,String description) {
        super(name, "Reptile",sound, description);
    }
}





