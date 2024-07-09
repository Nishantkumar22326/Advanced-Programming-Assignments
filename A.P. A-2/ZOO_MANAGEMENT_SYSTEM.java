// MAIN FUNCTION

/*
All small alphabets
 Admin Username---> nishant22326
 Admin Password---> hellonishant
 */

import java.util.*;


public class ZOO_MANAGEMENT_SYSTEM {
    public static void main(String[] args) {
        HashMap<String, Double> discountCategories = new HashMap<>();
        // hardcoding 2 discounts
        discountCategories.put("Minors", 10.0);
        discountCategories.put("Seniors", 20.0);
        HashMap<Integer, Double> special_deals_hashmap = new HashMap<>();
        special_deals_hashmap.put(2, 15.0);
        special_deals_hashmap.put(3, 30.0);
        Admin admean = new Admin("nishant22326", "hellonishant");
        Admin.Event eventManager = new Admin.Event();
        Admin.Manage_Animals managing_animals = new Admin.Manage_Animals();
        // Hardcoding 2 animals of each type
        managing_animals.Add_hardcode_animals_to_attraction("lion", "Mammal", "roar", "Lion is the king of the jungle.");
        managing_animals.Add_hardcode_animals_to_attraction("tiger", "Mammal", "roaring", "Tiger Zinda Hai.");
        managing_animals.Add_hardcode_animals_to_attraction("Crocodile", "Reptile", "crocs", "Threat for life.");
        managing_animals.Add_hardcode_animals_to_attraction("snake", "Reptile", "ss-ss", "King Cobra is most venomous reptile.");
        managing_animals.Add_hardcode_animals_to_attraction("frog", "Amphibian", "tarr-tarr","Frog stays both on land and in water.");
        managing_animals.Add_hardcode_animals_to_attraction("salamanders", "Amphibian", "hisses","Terrestrial salamanders produce low intensity sounds.");
       
        Visitor new_Visitor = null; // visitor class object
        boolean visitorLoggedIn = false; // Track visitor's login status
        boolean adminLoggedIn = false; // Track admin's login status
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("WELCOME TO ZOOtopia!!!");
            System.out.println("---------------------------------------------");

            if (adminLoggedIn) {

                System.out.println("<< WELCOME ADMIN >>");
                System.out.println();
                System.out.println("ADMIN MENU-->");
                System.out.println();
                System.out.println("1.MANAGE ATTRACTIONS");
                System.out.println("2.MANAGE ANIMALS");
                System.out.println("3.SCHEDULE EVENTS");
                System.out.println("4.SET DISCOUNTS");
                System.out.println("5.SET SPECIAL DEALS");
                System.out.println("6.VIEW VISITOR STATS");
                System.out.println("7.VIEW FEEDBACK");
                System.out.println("8.EXIT");
                int take_input;
                System.out.print("Enter your choice :");
                take_input = sc.nextInt();
                sc.nextLine();
                System.out.println("---------------------------------------------");
                if (take_input == 1) {
                    System.out.println("MANAGE ATTRACTIONS-->");
                    System.out.println();
                    System.out.println("1.ADD ATTRACTION");
                    System.out.println("2.VIEW ATTRACTION");
                    System.out.println("3.MODIFY ATTRACTION");
                    System.out.println("4.REMOVE ATTRACTION");
                    System.out.println("5.EXIT");
                    int take_input2;
                    System.out.print("Enter your choice : ");
                    take_input2 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("---------------------------------------------");
                   
                    if (take_input2 == 1) {
                        System.out.print("Enter Attraction ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Attraction Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Attraction Description: ");
                        String description = sc.nextLine();
                        System.out.print("Enter Ticket Price: ");
                        double ticketPrice = sc.nextDouble();
                        sc.nextLine();
                        int num_of_visitors_of_this_attraction = 0;
                        int open_and_close_check=1;
                        Admin.Managing_Attractions new_attraction = new Admin.Managing_Attractions(id, name,
                                description, ticketPrice, num_of_visitors_of_this_attraction,open_and_close_check);
                        eventManager.addAttraction(id, name, description, ticketPrice,num_of_visitors_of_this_attraction,open_and_close_check);
                        
                    } else if (take_input2 == 2) {
                        eventManager.viewAllAttractions();
                    } else if (take_input2 == 3) {
                        int enter_id;
                        String name;
                        String descrip;
                        double ticketprice;
                        System.out.print("Enter Attraction ID you want to modify:");
                        enter_id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Attraction Name :");
                        name = sc.nextLine();
                        // sc.nextLine();
                        System.out.print("Enter Attraction Description :");
                        descrip = sc.nextLine();
                        System.out.print("Enter Attraction Ticket price :");
                        ticketprice = sc.nextDouble();
                        sc.nextLine();
                        eventManager.modifyAttraction(enter_id, name, descrip, ticketprice);
                    } else if (take_input2 == 4) {
                        int Id;
                        System.out.print("Enter Description ID :");
                        Id = sc.nextInt();
                        sc.nextLine();
                        eventManager.removeAttraction(Id);
                    } else if (take_input2 == 5) {
                        // exit
                        continue;
                    } else {
                        System.out.println("YOU HAVE ENTERED WRONG CHOICE!!!!");
                    }
                } else if (take_input == 2) {
                    System.out.println("MANAGE ANIMALS--->");
                    System.out.println();
                    System.out.println("1.ADD ANIMAL");
                    System.out.println("2.UPDATE ANIMAL DETAILS");
                    System.out.println("3.REMOVE ANIMAL");
                    System.out.println("4.EXIT");
                    System.out.print("Enter your choice : ");
                    int input_for_animals = sc.nextInt();
                    sc.nextLine();
                    // System.out.println("---------------------------------------------");
                    if (input_for_animals == 1) {
                        System.out.print("Enter Animal Name :");
                        String animal_name = sc.nextLine();
                        System.out.print("Enter Animal Type :");
                        String animal_type = sc.nextLine();
                        System.out.print("Enter Animal Sound :");
                        String sound_of_animal = sc.nextLine();
                        System.out.print("Enter Animal Description :");
                        String descrip_of_animal = sc.nextLine();
                        managing_animals.Add_AnimalToAttraction(animal_name, animal_type, sound_of_animal,
                                descrip_of_animal);
                    } else if (input_for_animals == 2) {
                        System.out.print("Enter Animal Name You Want To Update :");
                        String animal_name = sc.nextLine();
                        System.out.print("Enter New Name :");
                        String new_name = sc.nextLine();
                        System.out.print("Enter New Type :");
                        String new_type = sc.nextLine();
                        System.out.print("Enter New Sound : ");
                        String new_sound = sc.nextLine();
                        System.out.print("Enter New Description :");
                        String new_descrip = sc.nextLine();
                        managing_animals.updateAnimalDetails(animal_name, new_name, new_type, new_sound, new_descrip);

                    } else if (input_for_animals == 3) {
                        System.out.print("Enter Animal Name You Want To Remove :");
                        String animal_name_to_remove = sc.nextLine();
                        managing_animals.removeAnimal(animal_name_to_remove);

                    } else if (input_for_animals == 4) {
                        continue;
                        
                    } 
                    else {
                        System.out.println("YOU HAVE ENTERED WRONG OPTION!!!!");
                    }

                } else if (take_input == 3) {
                    
                    Admin.Schedule_Events scheduling = new Admin.Schedule_Events();
                    System.out.print("Enter Attraction ID to set schedule: ");
                    int attractionId = sc.nextInt();
                    sc.nextLine();
                    boolean attractionFound = false;
                    Admin.Managing_Attractions selectedAttraction = null;
                    for (Admin.Managing_Attractions attractionzz : eventManager.attract.values()) {
                        if (attractionzz.getId() == attractionId) {
                            attractionFound = true;
                            selectedAttraction = attractionzz;
                            break;
                        }
                    }
                    if (attractionFound) {
                        System.out.print("Enter 0 for close and 1 for open the "+ selectedAttraction.getName()+" :");
                        int openorclosestatus=sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter updated ticket price:");
                        double update_ticket_price=sc.nextDouble();
                        sc.nextLine();
                        selectedAttraction.updateTicketPrice(update_ticket_price);
                        if (openorclosestatus == 0 || openorclosestatus == 1) {
                            selectedAttraction.setOpen_or_close_check(openorclosestatus);
                            // if (openorclosestatus == 1) {
                            //     System.out.println(selectedAttraction.getName() + " is now OPEN.");
                            // } else {
                            //     System.out.println(selectedAttraction.getName() + " is now CLOSED.");
                            // }
                        }
                        else{
                            System.out.println("You have entered wrong input!!!!");
                        }    
                    } 
                    else {
                        System.out.println("ATTRACTION WITH ID" + attractionId + "NOT FOUND!!!!");
                    }

                } else if (take_input == 4) {
                    // set discount
                    System.out.println("SET DISCOUNTS--->");
                    System.out.println();
                    System.out.println("1. ADD DISCOUNT");
                    System.out.println("2. MODIFY DISCOUNT");
                    System.out.println("3. REMOVE DISCOUNT");
                    System.out.println("4. EXIT");
                    System.out.print("Enter your choice :");
                    int enter_discount_choice = sc.nextInt();
                    sc.nextLine();
                    System.out.println("---------------------------------------------");
                    if (enter_discount_choice == 1) {
                        System.out.print("Enter Discount Category: ");
                        String category = sc.nextLine();
                        System.out.print("Enter Discount Percentage (e.g., 20 for 20%): ");
                        double percentage = sc.nextDouble();
                        sc.nextLine();
                    
                        if ("Students".equalsIgnoreCase(category)) {
                            discountCategories.put(category, percentage);
                            System.out.println("Discount added successfully.");
                        } else if (category.equalsIgnoreCase("Seniors")) {
                            discountCategories.put(category, percentage);
                            System.out.println("Discount added successfully.");
                        } else if (category.equalsIgnoreCase("Minors")) {
                            discountCategories.put(category, percentage);
                            System.out.println("Discount added successfully.");
                        } else {
                            System.out.println("Invalid discount category.");
                        }
                    } else if (enter_discount_choice == 2) {
                        System.out.print("Enter Discount Category to Modify: ");
                        String category = sc.nextLine();

                        // Check if the category exists in the discount map
                        if (discountCategories.containsKey(category)) {
                            System.out.print("Enter New Discount Percentage (e.g., 20 for 20%): ");
                            double newPercentage = sc.nextDouble();
                            sc.nextLine();
                            // Update the discount for the category
                            discountCategories.put(category, newPercentage);
                            System.out.println("Discount for " + category + " modified successfully.");
                        } else {
                            System.out.println("Discount category not found. Please add the discount first.");
                        }
                    } else if (enter_discount_choice == 3) {
                        System.out.print("Enter Discount Category to Remove: ");
                        String category = sc.nextLine();
                        // Check if the category exists in the discount map
                        if (discountCategories.containsKey(category)) {
                            // Remove the discount for the category
                            discountCategories.remove(category);
                            System.out.println("Discount for " + category + " removed successfully.");
                        } else {
                            System.out.println("Discount category not found. Nothing to remove.");
                        }
                    } else if (enter_discount_choice == 4) {
                        continue;
                        
                    } else {
                        System.out.println("ENTERED WRONG CHOICE");
                    }

                } else if (take_input == 5) {
                    System.out.println("SETTING SPECIAL DEALS-->");
                    System.out.println();
                    System.out.println("Current Special Deals:");
                    for (Map.Entry<Integer, Double> entry : special_deals_hashmap.entrySet()) {
                        System.out.println("Buy " + entry.getKey() + " attractions, get a " + (entry.getValue())+ "% discount.");
                    }
                    // System.out.println("---------------------------------------------");
                    System.out.println();
                    System.out.println("1. Add a Special Deal");
                    System.out.println("2. Remove a Special Deal");
                    System.out.print("Enter your choice: ");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    System.out.println("---------------------------------------------");
                    if (choice == 1) {
                        // Add a new special deal
                        System.out.print("Enter the number of tickets for the special deal: ");
                        int numoftickets = sc.nextInt();
                        sc.nextLine();
                        if (numoftickets <= 0) {
                            System.out.println("Invalid number of tickets.");
                        } else {
                            System.out.print("Enter the discount percentage (e.g., 15 for 15%): ");
                            double discountPercentage = sc.nextDouble();
                            sc.nextLine();
                            special_deals_hashmap.put(numoftickets, discountPercentage);
                            System.out.println("Special deal added successfully.");
                        }
                    } else if (choice == 2) {
                        System.out.print("Enter the num_of_ticket to remove the special deal: ");
                        int attractionsCount = sc.nextInt();
                        sc.nextLine();
                        if (special_deals_hashmap.containsKey(attractionsCount)) {
                            special_deals_hashmap.remove(attractionsCount);
                            System.out.println("Special deal removed successfully.");
                        } else {
                            System.out.println("No special deal found for the specified number of attractions.");
                        }
                    } else {
                        System.out.println("Invalid choice.");
                    }

                } else if (take_input == 6) {

                    // view visitor stats
                    System.out.println("VISITORS STATS-->");
                    System.out.println();
                    System.out.print("-Total Visitors :");
                    // total visitors
                    int final_visitors = admean.getNum_of_Vistors();
                    System.out.println(final_visitors);
                    System.out.println();
                    System.out.print("-Total Revenue :");
                    // total revenue
                    Double final_revenue = admean.getTotalRevenue();
                    System.out.println(final_revenue + " Rs.");
                    System.out.println();
                    System.out.print("-Most Popular Attraction :");
                    // most popular attraction
                    int maxVisitors = -1;
                    Admin.Managing_Attractions most_poupular_attraction = null;
                    if(final_visitors>0){
                        // System.out.println("HIII");
                    for (Admin.Managing_Attractions attraction : eventManager.attract.values()) {
                        // int visitorCount = attraction.getTicketedVisitors();
                        // if (visitorCount > maxVisitors) {
                        //     maxVisitors = visitorCount;
                        //     most_poupular_attraction = attraction;
                        // }
                        int VISITORCOUNT=attraction.getCount_of_visitors();
                        if(VISITORCOUNT>maxVisitors){
                            maxVisitors=VISITORCOUNT;
                            most_poupular_attraction=attraction;
                        }
                    }
                    }
                    if (most_poupular_attraction != null) {
                        System.out.println(most_poupular_attraction.getName());
                        // System.out.println("-Total Visitors: " + maxVisitors);
                    } else {
                        System.out.println("No attractions have been visited yet.");
                    }

                } else if (take_input == 7) {
                    System.out.println("FEEDBACK:");
                    System.out.println();
                    if (new_Visitor == null) {
                        System.out.println("No feedback available...Sorry:)");
                        System.out.println("First register and provide some feedback.");

                    } 
                    else {
                        System.out.println("FEEDBACK-->");
                        new_Visitor.viewFeedback();
                        System.out.println("---------------------------------------------");
                    }

                } else if (take_input == 8) {
                    adminLoggedIn = false;
                    System.out.println("LOGGED OUT ADMIN!!!");

                } else {
                    System.out.println();
                    System.out.println("WRONG OPTION FOR ADMIN MENU");
                }
            } else if (visitorLoggedIn) {
                System.out.println("VISITOR'S MENU-->");
                System.out.println();
                System.out.println("1.EXPLORE THE ZOO");
                System.out.println("2.BUY MEMBERSHIP");
                System.out.println("3.BUY TICKETS");
                System.out.println("4.VIEW DISCOUNTS");
                System.out.println("5.VIEW SPECIAL DEALS");
                System.out.println("6.VISIT ANIMALS");
                System.out.println("7.VISIT ATTRACTIONS");
                System.out.println("8.LEAVE FEEDBACK");
                System.out.println("9.LOGOUT");
                System.out.print("Enter your choice :");
                int choose_choice = sc.nextInt();
                sc.nextLine();
                System.out.println("---------------------------------------------");

                if (choose_choice == 1) {
                    while (true) {
                        System.out.println("EXPLORE THE ZOO-->");
                        System.out.println();
                        System.out.println("1.VIEW ATTRACTIONS");
                        System.out.println("2.VIEW ANIMALS");
                        System.out.println("3.EXIT");
                        System.out.print("Enter your choice :");
                        int explore_choice = sc.nextInt();
                        sc.nextLine();
                        System.out.println("---------------------------------------------");

                        if (explore_choice == 1) {
                            System.out.println("LIST OF ATTRACTIONS :");
            
                            for (Admin.Managing_Attractions attractionsss : eventManager.attract.values()) {
                                if(attractionsss.getOpen_or_close_check()==1){
                                    System.out.println(attractionsss.getId() + ". " + attractionsss.getName());
                                }
                            }

                            System.out.print("Enter your choice for which attraction you want to read description :");
                            int attraction_choice = sc.nextInt();
                            sc.nextLine();
                            Admin.Managing_Attractions selectedAttraction = eventManager.attract.get(attraction_choice);
                            if (selectedAttraction != null) {
                                System.out.print("Description of " + selectedAttraction.getName() + " : ");
                                System.out.println(selectedAttraction.getDescription());

                            } else {
                                System.out.println("Attraction with ID " + attraction_choice + " not found.!!!!!");
                            }

                        } else if (explore_choice == 2) {
                            // VIEW ANIMALS
                            System.out.println("List of Animals:");

                            for (Animal animal : managing_animals.getAnimalsList()) {
                                System.out.println(animal.getName());
                            }

                        } else if (explore_choice == 3) {
                            break;

                        } else {
                            System.out.println("WRONG OPTION SELECTED!!!!");
                        }
                    }
                } else if (choose_choice == 2) {
                    System.out.println("BUY MEMBERSHIP-->");
                    System.out.println();
                    System.out.println("1. BASIC MEMBERSHIP (Rs. 20)");
                    System.out.println("2. PREMIUM MEMBERSHIP (Rs. 50)");
                    System.out.print("Enter your choice :");
                    int membership_choice = sc.nextInt();
                    sc.nextLine();
                    System.out.println("---------------------------------------------");
                    if (membership_choice == 1) {
                        System.out.print("Enter Coupan Code (VALID):");
                        String coupan_code = sc.nextLine();
                        String storing_category = "";
                        if (Objects.equals(coupan_code.toLowerCase(), "none")) {
                            // age wagerah to check nhi karni yaha pr
                            if (new_Visitor.getVisitorBalance() >= 20) {
                                double updatedbalance = new_Visitor.getVisitorBalance() - 20;
                                new_Visitor.setVisitorBalance(updatedbalance);
                                new_Visitor.setBasicMemeber(true);
                                new_Visitor.setPremiumMember(false);
                                System.out.println("You have purchased the Basic Membership.");
                                System.out.println("Your Available Balance :" + new_Visitor.getVisitorBalance());
                                double reveue = admean.getTotalRevenue();
                                reveue += 20;
                                admean.setTotal_revenue(reveue);
                            } else {
                                System.out.println("Insufficient balance to purchase ticket...");
                            }
                        } else {
                            // coupan daala hai. None nhi daala to age wagerah bhi check kr
                            if (Objects.equals(coupan_code,"MINORS10") || Objects.equals(coupan_code,"SENIORS20")
                                    || Objects.equals(coupan_code,"STUDENTS30")) {
                                boolean qualifies_for_discount = false;
                                if (new_Visitor.getAge() < 18 && Objects.equals(coupan_code,"MINORS10")) {
                                    qualifies_for_discount = true;
                                    storing_category = "Minors";
                                } else if (new_Visitor.getAge() > 60 && Objects.equals(coupan_code,"SENIORS20")) {
                                    qualifies_for_discount = true;
                                    storing_category = "Seniors";
                                } else if (new_Visitor.getAge() > 10 && new_Visitor.getAge() < 22
                                        && Objects.equals(coupan_code,"STUDENTS30")) {
                                    qualifies_for_discount = true;
                                    storing_category = "Students";
                                }
                                if (qualifies_for_discount) {
                                    double discountPercentage = discountCategories.get(storing_category);
                                    // if (new_Visitor.getVisitorBalance() >= 20.0) {
                                    double discountedPrice = 20.0 * (1 - discountPercentage / 100);
                                    if (new_Visitor.getVisitorBalance() >= discountedPrice) {
                                        // updating the visitor's balance
                                        double updatedBalance = new_Visitor.getVisitorBalance() - discountedPrice;
                                        new_Visitor.setVisitorBalance(updatedBalance);
                                        new_Visitor.setPremiumMember(false); 
                                        new_Visitor.setBasicMemeber(true);
                                        System.out.println("You have purchased the Basic Membership.");
                                        System.out.println("Your Available Balance :" + new_Visitor.getVisitorBalance());
                                        double revenue = admean.getTotalRevenue();
                                        revenue += discountedPrice;
                                        admean.setTotal_revenue(revenue);
                                    } else {
                                        System.out.println("Insufficient balance to purchase the Basic Membership.");
                                    }

                                } else {
                                    System.out.println("You are not qualified for discount....:)");
                                }
                            } else {
                                System.out.println("INVALID COUPAN CODE.....");
                            }
                        }
                    } else if (membership_choice == 2) {
                        System.out.print("ENTER COUPAN CODE:");
                        String coupan_code = sc.nextLine();

                        String storing_category = "";
                        if (Objects.equals(coupan_code.toLowerCase(),"none")) {
                            if (new_Visitor.getVisitorBalance() >= 50) {
                                double updatedbalance = new_Visitor.getVisitorBalance() - 50;
                                new_Visitor.setVisitorBalance(updatedbalance);
                                new_Visitor.setBasicMemeber(false);
                                new_Visitor.setPremiumMember(true);
                                System.out.println("You have purchased the Premium Membership.");
                                System.out.println("Your Available Balance :" + new_Visitor.getVisitorBalance());
                                double reveue = admean.getTotalRevenue();
                                reveue += 50;
                                admean.setTotal_revenue(reveue);
                            } else {
                                System.out.println("Insufficient balance to purchase ticket...");
                            }
                        } else {
                            if (Objects.equals(coupan_code,"MINORS10") || Objects.equals(coupan_code,"SENIORS20")
                                    || Objects.equals(coupan_code,"STUDENTS30")) {
                                boolean qualifies_for_discount = false;
                                if (new_Visitor.getAge() < 18 && Objects.equals(coupan_code,"MINORS10")) {
                                    qualifies_for_discount = true;
                                    storing_category = "Minors";
                                } else if (new_Visitor.getAge() > 60 && Objects.equals(coupan_code,"SENIORS20")) {
                                    qualifies_for_discount = true;
                                    storing_category = "Seniors";
                                } else if (new_Visitor.getAge() > 10 && new_Visitor.getAge() < 22
                                        && Objects.equals(coupan_code,"STUDENTS30")) {
                                    qualifies_for_discount = true;
                                    storing_category = "Students";
                                }
                                if (qualifies_for_discount) {
                                    double discountPercentage = discountCategories.get(storing_category);
                                    // if (new_Visitor.getVisitorBalance() >= 50.0) {
                                    double discountedPrice = 50.0 * (1 - discountPercentage / 100);
                                    if (new_Visitor.getVisitorBalance() >= discountedPrice) {
                                        // updating visitor's balance
                                        double updatedBalance = new_Visitor.getVisitorBalance() - discountedPrice;
                                        new_Visitor.setVisitorBalance(updatedBalance);
                                        new_Visitor.setPremiumMember(true); 
                                        new_Visitor.setBasicMemeber(false);
                                        System.out.println("You have purchased the Premium Membership.");
                                        System.out.println("Your Available balance :" + new_Visitor.getVisitorBalance());
                                        double revenue = admean.getTotalRevenue();
                                        revenue += discountedPrice;
                                        admean.setTotal_revenue(revenue);
                                    } else {
                                        System.out.println("Insufficient balance to purchase the Premium Membership.");
                                    }
                                } else {
                                    System.out.println(
                                            "You do not qualify for a discount based on the entered coupon code and age.");
                                }
                            } else {
                                System.out.println("INVALID COUPAN CODE.....");
                            }
                        }
                    }
                } else if (choose_choice == 3) {
                    
                    // checking whether visitor has any membership or not
                    if (new_Visitor.isBasicMemeber() == false && new_Visitor.isPremiumMember() == false) {
                        System.out.println("YOU CAN'T BUY TICKETS. BUY MEMBERSHIP FIRST");
                    } else {
                        System.out.println("BUY TICKETS :");
                        System.out.print("Enter No. Of Tickets :");
                        int no_of_tickets = sc.nextInt();
                        sc.nextLine();
                        if (new_Visitor.isPremiumMember()) {
                            System.out.println("YOU ARE PREMIUM MEMBER. TICKETS ARE FREE FOR YOU:)");
                            continue;
                        } else {
                            for (Admin.Managing_Attractions attractionsss : eventManager.attract.values()) {
                                if(attractionsss.getOpen_or_close_check()==1){
                                System.out.print("ATTRACTION ID: " + attractionsss.getId() + "||" + "ATTRACTION NAME: "
                                        + attractionsss.getName() + "||");
                                System.out.println(" Ticket Price : " + attractionsss.getTicketPrice());
                                }
                            }
                        }
                        System.out.println("BUY TICKETS:");
                        // select  attraction to buy tickets
                        System.out.print("Select an attraction ID to buy ticket :");
                        int select_attraction_for_ticket = sc.nextInt();
                        sc.nextLine();
                        System.out.print("ENTER COUPAN CODE :");
                        String Coupan_Code = sc.nextLine();
                        String storing_category = "";
                        double discountPercentage = 0.0;
                        double ticketPrice;
                        double totalTicketPrice;
                        if (Objects.equals(Coupan_Code,"None")) {
                            if (special_deals_hashmap.containsKey(no_of_tickets)) {
                                double discount_percent = special_deals_hashmap.get(no_of_tickets);
                                ticketPrice = eventManager.attract.get(select_attraction_for_ticket).getTicketPrice()
                                        * no_of_tickets;
                                totalTicketPrice = ticketPrice * (1 - discount_percent / 100);
                                if (eventManager.attract.containsKey(select_attraction_for_ticket)) {
                                    if (new_Visitor != null) {
                                        double visitorBalance = new_Visitor.getVisitorBalance();

                                        if (visitorBalance >= totalTicketPrice) {
                                            visitorBalance -= totalTicketPrice;
                                            new_Visitor.setVisitorBalance(visitorBalance);
                                            System.out.println("The ticket for "
                                                    + eventManager.attract.get(select_attraction_for_ticket).getName()
                                                    + " was purchased successfully.");
                                            System.out.println("Your balance is now " + visitorBalance + " Rs.");
                                            Double revenue_update = admean.getTotalRevenue();
                                            revenue_update = totalTicketPrice + revenue_update;
                                            admean.setTotal_revenue(revenue_update);
                                            new_Visitor.addTicketPurchaseDetails(select_attraction_for_ticket,
                                                    no_of_tickets);
                                        } else {
                                            System.out.println("Insufficient balance to purchase the ticket.");
                                        }
                                    } else {
                                        System.out.println(
                                                "Visitor not logged in. Please log in or register as a visitor.");
                                    }
                                } else {
                                    System.out.println("Attraction does not exit.");
                                }
                            } else {
                                // Agar no. tickets kam hai special deals se to
                                ticketPrice = eventManager.attract.get(select_attraction_for_ticket).getTicketPrice()
                                        * no_of_tickets;
                                totalTicketPrice = no_of_tickets * ticketPrice;
                                if (eventManager.attract.containsKey(select_attraction_for_ticket)) {
                                    if (new_Visitor != null) {
                                        double visitorBalance = new_Visitor.getVisitorBalance();
                                        if (visitorBalance >= totalTicketPrice) {
                                            // updating the visitors balance
                                            visitorBalance -= totalTicketPrice;
                                            new_Visitor.setVisitorBalance(visitorBalance);
                                            System.out.println();
                                            System.out.println("The ticket for "
                                                    + eventManager.attract.get(select_attraction_for_ticket).getName()
                                                    + " was purchased successfully.");
                                            System.out.println("Your balance is now " + visitorBalance + " Rs.");
                                            Double revenue_update = admean.getTotalRevenue();
                                            revenue_update = totalTicketPrice + revenue_update;
                                            admean.setTotal_revenue(revenue_update);
                                            new_Visitor.addTicketPurchaseDetails(select_attraction_for_ticket,
                                                    no_of_tickets);
                                        } else {
                                            System.out.println("Insufficient balance to purchase the ticket.");
                                        }
                                    } else {
                                        System.out.println(
                                                "Visitor not logged in. Please log in or register as a visitor.");
                                    }
                                } else {
                                    System.out.println("Attraction does not exit.");
                                }
                            }
                        } else {
                            // agar coupan code none nhi daala to
                            if (Objects.equals(Coupan_Code,"MINORS10") || Objects.equals(Coupan_Code,"SENIORS20")
                                    || Coupan_Code.equals("STUDENTS30")) {
                                boolean qualifies_for_discount = false;
                                if (new_Visitor.getAge() < 18 && Objects.equals(Coupan_Code,"MINORS10")) {
                                    qualifies_for_discount = true;
                                    storing_category = "Minors";
                                } else if (new_Visitor.getAge() > 60 && Objects.equals(Coupan_Code,"SENIORS20")) {
                                    qualifies_for_discount = true;
                                    storing_category = "Seniors";
                                } else if (new_Visitor.getAge() > 10 && new_Visitor.getAge() < 22
                                        && Objects.equals(Coupan_Code,"STUDENTS30")) {
                                    qualifies_for_discount = true;
                                    storing_category = "Students";
                                }
                                if (qualifies_for_discount) {
                                    // yaha pr 2 case ayenge ek agr special deals lag rhi hai and ek agr nhi lg rhi
                                    if (special_deals_hashmap.containsKey(no_of_tickets)) {
                                        // agar special deal lg rhi hai
                                        double discount_percent = special_deals_hashmap.get(no_of_tickets);
                                        double coupan_code_discount_percent = discountCategories.get(storing_category);
                                        ticketPrice = eventManager.attract.get(select_attraction_for_ticket)
                                                .getTicketPrice() * no_of_tickets;
                                        totalTicketPrice = ticketPrice * (1 - coupan_code_discount_percent / 100);
                                        totalTicketPrice = totalTicketPrice * (1 - discount_percent / 100);
                                        if (eventManager.attract.containsKey(select_attraction_for_ticket)) {
                                            if (new_Visitor != null) {
                                                double visitorBalance = new_Visitor.getVisitorBalance();
                                                if (visitorBalance >= totalTicketPrice) {
                                                    // updating the visitor's balance
                                                    visitorBalance -= totalTicketPrice;
                                                    new_Visitor.setVisitorBalance(visitorBalance);
                                                    System.out.println("The ticket for "+ eventManager.attract.get(select_attraction_for_ticket).getName()+ " was purchased successfully.");
                                                    System.out.println("Your balance is now " + visitorBalance + " Rs.");
                                                    Double revenue_update = admean.getTotalRevenue();
                                                    revenue_update = totalTicketPrice + revenue_update;
                                                    admean.setTotal_revenue(revenue_update);
                                                    new_Visitor.addTicketPurchaseDetails(select_attraction_for_ticket,
                                                            no_of_tickets);
                                                } else {
                                                    System.out.println("Insufficient balance to purchase the ticket.");
                                                }
                                            } else {
                                                System.out.println(
                                                        "Visitor not logged in. Please log in or register as a visitor.");
                                            }
                                        } else {
                                            System.out.println("Attraction does not exit.");
                                        }

                                    } else {
                                        double coupan_code_discount_percent = discountCategories.get(storing_category);
                                        ticketPrice = eventManager.attract.get(select_attraction_for_ticket).getTicketPrice() * no_of_tickets;
                                        totalTicketPrice = ticketPrice * (1 - coupan_code_discount_percent / 100);
                                        if (eventManager.attract.containsKey(select_attraction_for_ticket)) {
                                            if (new_Visitor != null) {
                                                double visitorBalance = new_Visitor.getVisitorBalance();
                                                if (visitorBalance >= totalTicketPrice) {
                                                    visitorBalance -= totalTicketPrice;
                                                    new_Visitor.setVisitorBalance(visitorBalance);
                                                    System.out.println("The ticket for "+ eventManager.attract.get(select_attraction_for_ticket).getName()+ " was purchased successfully.");
                                                    System.out.println("Your balance is now " + visitorBalance + " Rs.");
                                                    Double revenue_update = admean.getTotalRevenue();
                                                    revenue_update = totalTicketPrice + revenue_update;
                                                    admean.setTotal_revenue(revenue_update);
                                                    new_Visitor.addTicketPurchaseDetails(select_attraction_for_ticket,
                                                            no_of_tickets);
                                                } else {
                                                    System.out.println("Insufficient balance to purchase the ticket.");
                                                }
                                            } else {
                                                System.out.println(
                                                        "Visitor not logged in. Please log in or register as a visitor.");
                                            }
                                        } else {
                                            System.out.println("Attraction does not exit.");
                                        }
                                    }

                                } else {
                                    System.out.println("YOU DO NOT QUALIFY TO AVAIL DISCOUNT....");
                                }
                            } else {
                                System.out.println("INVALID COUPAN CODE.........");
                            }

                        }
                    }
                } else if (choose_choice == 4) {
                   
                    if (discountCategories.isEmpty()) {
                        System.out.println("SORRY!! NO DISCOUNTS AVAILABLE:) ");
                    } else {
                        System.out.println("AVAILABLE DISCOUNTS-->");
                        System.out.println();
                        for (Map.Entry<String, Double> entry : discountCategories.entrySet()) {
                            String category = entry.getKey();
                            double percentage = entry.getValue();
                            System.out.println(category + ": " + percentage + "%");
                            if ("Students".equalsIgnoreCase(category)) {
                                System.out.println("(Coupon Code: STUDENTS30)");
                                System.out.println("Age - 10-22 years");
                                System.out.println();
                            } else if ("Seniors".equalsIgnoreCase(category)) {
                                System.out.println("(Coupon Code: SENIORS20)");
                                System.out.println("Age > 60 years");
                            } else if ("Minors".equalsIgnoreCase(category)) {
                                System.out.println("(Coupon Code: MINORS10)");
                                System.out.println("Age < 18 years");
                            } else {
                                System.out.println();
                            }
                        }
                    }

                } else if (choose_choice == 5) {
                    System.out.println("SPECIAL DEALS-->");
                    System.out.println();
                    for (Map.Entry<Integer, Double> entry : special_deals_hashmap.entrySet()) {
                        int numtickets = entry.getKey();
                        double discountpercenTAGE = entry.getValue();
                        System.out.println("Buy " + numtickets + " Tickets and get " + discountpercenTAGE);
                    }

                } else if (choose_choice == 6) {
                    System.out.println("Visiting Animals-->");
                    System.out.println();
                    System.out.println("1. FEED ANIMAL");
                    System.out.println("2. READ ABOUT ANIMAL");
                    System.out.print("Enter your choice :");
                    int choice_for_animal = sc.nextInt();
                    sc.nextLine();
                    System.out.println("---------------------------------------------");
                    if (choice_for_animal == 1) {
                        System.out.println("Select an animal to feed:");

                        for (Animal animal : managing_animals.getAnimalsList()) {
                            System.out.println(animal.getName());
                        }

                        System.out.print("Enter the name of the animal you want to feed: ");
                        String animalToFeed = sc.nextLine();

                        // here i am checking wthere the animal exist or not.... then feeding it....
                        boolean fed = false;
                        for (Animal animal : managing_animals.getAnimalsList()) {
                            if (animal.getName().equalsIgnoreCase(animalToFeed)) {
                                System.out.println("Feeding " + animal.getName() + "--");
                                if (animal instanceof Mammal) {
                                    System.out.println("Sound :" +((Mammal) animal).getSound());
                                } else if (animal instanceof Reptile) {
                                    System.out.println("Sound :"+((Reptile) animal).getSound());
                                } else if (animal instanceof Amphibian) {
                                    System.out.println("Sound :" + ((Amphibian) animal).getSound());
                                } else {
                                    System.out.println("INVALID MAMMAL TYPE!!!!");
                                }
                                fed = true;
                                break;
                            }
                        }

                        if (!fed) {
                            System.out.println("Animal not found or unable to feed.");
                        }

                    } else if (choice_for_animal == 2) {
                        System.out.println("Select an animal to read about:");
                        for (Animal animal : managing_animals.getAnimalsList()) {
                            System.out.println(animal.getName());
                        }
                        System.out.print("Enter the name of the animal you want to read about: ");
                        String animalToRead = sc.nextLine();

                        boolean found = false;
                        for (Animal animal : managing_animals.getAnimalsList()) {
                            if (animal.getName().equalsIgnoreCase(animalToRead)) {
                                System.out.println("Here's some information about the " + animal.getName() + ":");
                                System.out.println(animal.getDescription());
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Animal not found or no description available.");
                        } 
                        
                        // else {
                        //     System.out.println("You have selected the wrong choice!");
                        // }
                    } 
                    else {
                        System.out.println("You have selected wrong choice!!!!");
                    }
                } else if (choose_choice == 7) {
                    System.out.println("VISIT ATTRACTIONS-->");
                    System.out.println();
                    while (true) {
                        System.out.println("Select an Attraction to Visit:");
                        // int option = 1;
                        for (Admin.Managing_Attractions attractionzzz : eventManager.attract.values()) {
                            if(attractionzzz.getOpen_or_close_check()==1){
                                System.out.println(attractionzzz.getId() + ". " + attractionzzz.getName());
                            }
                            // System.out.println(attractionzzz.getId() + ". " + attractionzzz.getName());
                            // option++;
                        }
                        System.out.println("For Exit Please Enter -1");
                        System.out.println();
                        System.out.print("Enter Attraction Id you want to visit: ");
                        int choice = sc.nextInt();
                        sc.nextLine();

                        if (choice == -1) {
                            System.out.println("Exiting the Attractions menu.");
                            break; 
                        } else if (eventManager.attract.containsKey(choice)) {
                            Admin.Managing_Attractions selectedAttraction = eventManager.attract.get(choice);
                            if (new_Visitor != null) {
                                if (new_Visitor.isPremiumMember()) {
                                    System.out.println();
                                    System.out.println("Thank you for visiting " + selectedAttraction.getName());
                                    System.out.println("Hope you enjoyed the attarction!!!");
                                    System.out.println();
                                    selectedAttraction.increment_visitors_of_attraction();
                                    int updating_count_visitor=selectedAttraction.getCount_of_visitors();
                                    updating_count_visitor=updating_count_visitor+1;
                                    selectedAttraction.setCount_of_visitors(updating_count_visitor);


                                } else if (new_Visitor.isBasicMemeber()) {
                                    if (new_Visitor.getTicketPurchaseDetails().containsKey(selectedAttraction.getId())) {
                                        int remainingTickets = new_Visitor.getTicketPurchaseDetails().get(selectedAttraction.getId());
                                        if (remainingTickets > 0) {
                                            System.out.println(
                                                    "You are using 1 ticket to visit " + selectedAttraction.getName());
                                            remainingTickets--;
                                            new_Visitor.addTicketPurchaseDetails(selectedAttraction.getId(),
                                                    remainingTickets);
                                            selectedAttraction.incrementTicketedVisitors();
                                            System.out.println();
                                            System.out.println("Thank you visiting " + selectedAttraction.getName());
                                            System.out.println("Hope you enjoyed the attraction!!!!");
                                            System.out.println();
                                            selectedAttraction.increment_visitors_of_attraction();
                                            int updating_count_visitor=selectedAttraction.getCount_of_visitors();
                                            updating_count_visitor=updating_count_visitor+1;
                                            selectedAttraction.setCount_of_visitors(updating_count_visitor);
                                            
                                            // Managing_Attractions.setCount_of_visitors(Managing_Attractions.getCount_of_visitors());;
                                            // eventManager.attract.get(selectedAttraction.getId())
                                        } else {
                                            System.out.println("You don't have any more tickets to visit "+ selectedAttraction.getName() + ". Please buy tickets first.");
                                        }
                                    } else {
                                        System.out.println("You don't have any tickets for "+ selectedAttraction.getName() + ". Please buy tickets first.");
                                    }
                                }
                                else{
                                    System.out.println("You don't have any membership. Buy membership first...");
                                }
                            } else {
                                System.out.println("Visitor not logged in. Please log in or register as a visitor.");
                            }
                        } else {
                            System.out.println("Invalid choice. Please select a valid attraction or Exit.");
                            // YAHA PR DEKHLE EXIT YA CONTINUE AYEGA KYA
                        }
                    }
                } else if (choose_choice == 8) {
                    // sc.nextLine();
                    System.out.print("ENTER YOUR FEEDBACK. (MAX. 200 CHARACTERS): ");
                    String feedbackgiving = sc.nextLine();
                    new_Visitor.leaveFeedback(feedbackgiving);
                } else if (choose_choice == 9) {
                    visitorLoggedIn = false;
                    System.out.println("LOGGED OUT!!!!");
                    // break;

                } else {
                    System.out.println("WRONG OPTION FOR VISITOR MENU");
                }
            } else {
                System.out.println("1. " + (adminLoggedIn ? "Admin Menu" : "Enter as Admin"));
                System.out.println("2. " + (visitorLoggedIn ? "Visitor Menu" : "Enter as Visitor"));
                System.out.println("3. View  Special Deals");
                System.out.println("4. Exit the program" );
                int OPTION;
                System.out.print("Enter your choice :");
                OPTION = sc.nextInt();
                sc.nextLine();
                if (OPTION == 1) {
                    System.out.print("Enter Admin Username :");
                    String USERNAME = sc.next();
                    sc.nextLine();
                    System.out.print("Enter Admin Password :");
                    String PASSWORD = sc.nextLine();
                    Admin new_admin = new Admin("nishant22326", "hellonishant");
                    boolean check = new_admin.ifAdmin(USERNAME, PASSWORD);
                    if (check) {
                        adminLoggedIn = true;
                        continue;
                    } else {
                        System.out.println("WRONG CREDENTIALS!!!!");
                        System.out.println("TRY AGAIN....");
                        continue;
                    }
                } else if (OPTION == 2) {
                    if (!visitorLoggedIn) {
                        while(true){
                        System.out.println("1. REGISTER");
                        System.out.println("2. LOGIN");
                        System.out.print("Enter your choice :");
                        int enter_choice = sc.nextInt();
                        sc.nextLine();
                        String name;
                        int age;
                        String phone_number;
                        Double visitor_balance;
                        String mail_id;
                        String password;

                        if (enter_choice == 1) {
                            System.out.print("Enter Visitor Name :");
                            name = sc.nextLine();
                            // sc.nextLine();
                            System.out.print("Enter Visitor Age :");
                            age = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Visitor Phone no. :");
                            phone_number = sc.nextLine();
                            // sc.nextLine();
                            System.out.print("Enter Visitor Balance :");
                            visitor_balance = sc.nextDouble();
                            sc.nextLine();
                            System.out.print("Enter Visitor Email Id: ");
                            mail_id = sc.nextLine();
                            // sc.nextLine();
                            System.out.print("Enter Visitor Password: ");
                            password = sc.nextLine();
                            new_Visitor = new Visitor(name, age, phone_number, visitor_balance, mail_id, password);
                            new_Visitor.register_visitor(name, age, phone_number, visitor_balance, mail_id, password);
                            visitorLoggedIn = true;
                            int update_total_visitors=admean.getNum_of_Vistors();
                            update_total_visitors++;
                            admean.setNum_of_Visitors(update_total_visitors);
                            continue;
                            // break;
                        }

                        else if (enter_choice == 2) {
                            String email;
                            String pass;
                            System.out.print("Enter Visitor Email Id :");
                            email = sc.nextLine();
                            // sc.nextLine();
                            System.out.print("Enter Visitor Password :");
                            pass = sc.nextLine();
                            boolean visitorAuthenticated = new_Visitor.ifVisitor(email, pass);
                            // Visitor VISITOR= new Visitor(email,pass);
                            boolean checking = new_Visitor.ifVisitor(email, pass);
                            if (visitorAuthenticated) {
                                visitorLoggedIn = true; 
                                System.out.println("LOGIN SUCCESSFULL!!!");
                                // continue;
                                break;
                            } else {
                                System.out.println("INVALID CREDENTIALS!!!!");
                                System.out.println("FIRST REGISTER YOURSELF");
                            }
                        } else {
                            System.out.println("YOU HAVE CHOOSEN WRONG OPTION FOR VISITOR!!!");
                        }
                    }
                }    

                } else if (OPTION == 3) {
                    System.out.println("SPECIAL DEALS-->");
                    System.out.println();
                    for (Map.Entry<Integer, Double> entry : special_deals_hashmap.entrySet()) {
                        int numtickets = entry.getKey();
                        double discountpercenTAGE = entry.getValue();
                        System.out.println("Buy " + numtickets + " Tickets and get " + discountpercenTAGE);
                    }
                } 
                else if(OPTION==4){
                    System.out.println("Exiting the ZOO_MANAGEMENT_SYSTEM.");
                    break;
                    
                }
                else {
                    System.out.println("YOU HAVE CHOOSEN WRONG OPTION.....!!!!");
                }
            }
        }

    }

}
