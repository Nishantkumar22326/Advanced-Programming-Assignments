//ADMIN CLASS FILE

/*
All small alphabets
 Admin Username---> nishant22326
 Admin Password---> hellonishant
 */
import java.util.*;


class Admin {
    private String username;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getTotal_revenue() {
        return Total_revenue;
    }


    private String password;
    private double Total_revenue;
    private int num_of_visitors;
    // private HashMap<Integer, Managing_Attractions> attractions = new HashMap<>();
    // private HashMap<Integer, HashSet<Animal>> attraction_animals = new HashMap<>();

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.Total_revenue=0;
        this.num_of_visitors=0;

    }

    public int getNum_of_Vistors(){
        return num_of_visitors;
    }

    public void setNum_of_Visitors(int num_visitor){
        num_of_visitors=num_visitor;
    }

    public void setTotal_revenue(double total_revenue) {
        Total_revenue = total_revenue;
    }

    public double getTotalRevenue() {
        return Total_revenue;
    }

    public boolean ifAdmin(String username, String password) {
        // return this.username.equals(username) && this.password.equals(password);
        // return Objects.equals(username, )
        return Objects.equals(this.username, username) && Objects.equals(this.password, password);
    }
    static class Managing_Attractions{
        private int attraction_id;
        private String attraction_name;
        private String attraction_description;
        private double ticket_price;
        private int ticketedVisitors;
        private int count_of_visitors_of_an_attraction;
        private int open_or_close_check;

        public int getOpen_or_close_check() {
            return open_or_close_check;
        }

        public void setOpen_or_close_check(int open_or_close_check) {
            this.open_or_close_check = open_or_close_check;
        }

        public Managing_Attractions(int attraction_id, String attraction_name, String attraction_description,
                double ticket_price,int count_of_visitors_of_an_attraction,int open_or_close_check) {
            this.attraction_id = attraction_id;
            this.attraction_name = attraction_name;
            this.attraction_description = attraction_description;
            this.ticket_price = ticket_price;
            this.ticketedVisitors = 0;
            this.count_of_visitors_of_an_attraction=0;
            this.open_or_close_check=1;
        }

        public int getCount_of_visitors() {
            return count_of_visitors_of_an_attraction;
        }

        public void setCount_of_visitors(int count_of_visitors) {
            this.count_of_visitors_of_an_attraction = count_of_visitors;
        }
        
        public void increment_visitors_of_attraction() {
            this.count_of_visitors_of_an_attraction++;
        }

        public int getId() {
            return attraction_id;
        }

        public String getName() {
            return attraction_name;
        }

        public String getDescription() {
            return attraction_description;
        }

        public double getTicketPrice() {
            return ticket_price;
        }

        public int getTicketedVisitors() {
            return ticketedVisitors;
        }

        public void updateTicketPrice(double newPrice) {
            ticket_price = newPrice;
            System.out.println("UPDATED SUCCESSFULLY");
        }

        public void incrementTicketedVisitors() {
            ticketedVisitors++;
        }
    }

    static class Event {
        public HashMap<Integer, Managing_Attractions> attract = new HashMap<>();

        public void addAttraction(int id, String name, String description, double ticketPrice,int num_of_visitors_of_this_attraction,int open_or_close_check) {
            Managing_Attractions attraction = new Managing_Attractions(id, name, description, ticketPrice,num_of_visitors_of_this_attraction,open_or_close_check);
            attract.put(id, attraction);
            System.out.println("ATTRACTION ADDED SUCCESSFULLY!!!!");
            // for (Managing_Attractions attractionss : attract.values()) {
            //     System.out.println("HIIII");
            //     System.out.println("Attraction ID: " + attraction.getId());
            //     System.out.println("Name: " + attraction.getName());
            //     System.out.println("Description: " + attraction.getDescription());
            //     System.out.println("Ticket Price: " + attraction.getTicketPrice());
            //     System.out.println("--------------");
            // }
        }

        public void viewAllAttractions() {
            System.out.println("hi");
            for (Managing_Attractions attraction : attract.values()) {
                // System.out.println("HIIII");
                System.out.println("Attraction ID: " + attraction.getId());
                System.out.println("Name: " + attraction.getName());
                System.out.println("Description: " + attraction.getDescription());
                System.out.println("Ticket Price: " + attraction.getTicketPrice());
                System.out.println("--------------");
            }
        }

        public Managing_Attractions getAttraction(int id) {
        return attract.get(id);
        }

        public void modifyAttraction(int id, String name, String description, double ticketPrice) {
            if (attract.containsKey(id)) {
                Managing_Attractions attraction = attract.get(id);
                attraction.attraction_name = name;
                attraction.attraction_description = description;
                attraction.ticket_price = ticketPrice;
                System.out.println("ATTRACTION MODIFIED SUCCESSFULLY!!!!");
            } else {
                System.out.println("Attraction with ID " + id + " not found.");
            }
        }

        public void removeAttraction(int id) {
            attract.remove(id);
            System.out.println("ATTRACTION WITH ID " + id + " REMOVED SUCCESSFULLY!!!!");
        }

    }

    static class Schedule_Events {

        public static void updateTicketPrice(Managing_Attractions attraction, double newPrice) {
            attraction.updateTicketPrice(newPrice);
        }

        public static void incrementTicketedVisitors(Managing_Attractions attraction) {
            attraction.incrementTicketedVisitors();
        }
        

    }

    static class  Manage_Animals{
        
        private ArrayList<Animal> animalsList = new ArrayList<>();
        public ArrayList<Animal> getAnimalsList() {
            return animalsList;
        }
        
        public Animal createAnimal(String name, String animalType, String sound, String description) {
            // System.out.println("IN CREATE ANIMAL");
           
            switch (animalType) {
                case "Mammal":
                    // System.out.println("HI INSIDE SWITCH");
                    return new Mammal(name,sound,description);
                    
                case "Amphibian":
                    return new Amphibian(name, sound, description);
                    
                case "Reptile":
                    return new Reptile(name, sound, description);
                default:
                    return null; 
            }
        }

        public void Add_AnimalToAttraction(String animalname, String animalType,String sounds, String descrips){
            Animal animal = createAnimal(animalname, animalType, sounds, descrips);
            if (animal != null) {
                animalsList.add(animal);
                // System.out.println(animalname + " named " + animalname+ " added to the zoo.");
                System.out.println("Animal with name "+ animalname +" successfully added." );

            } else {
                System.out.println("Failed to add the animal. Invalid animal type: " + animalType);
            }
        }

        public void Add_hardcode_animals_to_attraction(String animalname, String animalType,String sounds, String descrips){
             Animal animalzzz = createAnimal(animalname, animalType, sounds, descrips);
                if (animalzzz != null) {
                animalsList.add(animalzzz);
                // System.out.println(animalname + " named " + animalname+ " added to the zoo.");
                // System.out.println("Animal with name "+ animalname +" successfully added." );

                } 
            //     else {
            //     System.out.println("Failed to add the animal. Invalid animal type: " + animalType);
            // }

        }

        public void updateAnimalDetails(String animalName, String newAnimalName, String newAnimalType, String newAnimalSound, String newAnimalDescription) {
            boolean animalFound = false;
            for (Animal animal : animalsList) {
                if (animal.getName().equalsIgnoreCase(animalName)) {
                    animal.setName(newAnimalName); 
                    if (animal instanceof Mammal) {
                        // System.out.println("HII JIIBDGDUWWJJFJ");
                        ((Mammal) animal).setType(newAnimalType);
                        ((Mammal) animal).setSound(newAnimalSound);
                        ((Mammal) animal).setDescription(newAnimalDescription);
                    } else if (animal instanceof Amphibian) {
                        ((Amphibian) animal).setType(newAnimalType);
                        ((Amphibian) animal).setSound(newAnimalSound);
                        ((Amphibian) animal).setDescription(newAnimalDescription);
                    } else if (animal instanceof Reptile) {
                        ((Reptile) animal).setType(newAnimalType);
                        ((Reptile) animal).setSound(newAnimalSound);
                        ((Reptile) animal).setDescription(newAnimalDescription);
                    }
                    animalFound = true;
                    System.out.println("Animal details updated successfully.");
                    break;
                }
            }
            if (!animalFound) {
                System.out.println("Animal with name " + animalName + " not found in the zoo.");
            }
        }
        
        public void removeAnimal(String animallname) {
            
            Animal animalToRemove = null;
            int animalCount = 0;
            int num_of_animals_of_a_category=0;
            
            String category = "";
            for (Animal animal : animalsList) {
                if (animal.getName().equalsIgnoreCase(animallname)) {
                    // animalCount++;
                    category = animal.getType();
                    for(Animal animalsss : animalsList){
                        if(animalsss.getType().equals(category)){
                            num_of_animals_of_a_category+=1;
                        }
                    }
                }
            }
        
            if (num_of_animals_of_a_category <= 2) {
                System.out.println("You cannot remove " + animallname + " because there must be at least 2 animals of category " + category);
            }
            else{
                for (Animal animal : animalsList) {
                if (animal.getName().equalsIgnoreCase(animallname)) {
                    animalToRemove = animal;
                    break;
                }
            }
            if (animalToRemove != null) {
                animalsList.remove(animalToRemove);
                System.out.println("Animal removed successfully from the zoo.");
            } else {
                System.out.println("Animal with name " + animallname + " not found in the zoo.");
            }
        }
        
    }
       

        
    
    }
    
}

