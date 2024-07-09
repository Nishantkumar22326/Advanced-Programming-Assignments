
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.Instant;
import java.time.LocalTime;
import java.time.Duration;
import java.time.temporal.ChronoUnit;


class Books {
    int id;
    String title;
    String author;
    int total_copies;
    int available_copies;
    public LocalTime local_time;

    public Books(int id, String title, String author, int total_copies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.total_copies = total_copies;
        this.available_copies = total_copies;
    }
}

class Librarian {

    static ArrayList<Books> book = new ArrayList<>(); // CREATING AN ARRAY LIST TO STORE ALL THE BOOKS
    static ArrayList<LibraryMember> members = new ArrayList<>(); // CREATING AN ARRAY LIST TO STORE ALL THE MEMBERS

    // FUNCTION TO ADD A BOOK
    public void addBook(int id, String title, String author, int total_copies) {
        Books booK = new Books(id, title, author, total_copies);
        book.add(booK); // ADDING IN THE book ARRAYLIST
        System.out.println("BOOK ADDED SUCCESSFULLY !!!");
    }

    // FUNCTION TO REMOVE A BOOK
    public void removeBook(int id) {
        Books Book_to_remove = null;
        for (Books books : book) {
            if (books.id == id) {
                Book_to_remove = books;
                break;
            }
        }
        if (Book_to_remove != null) {
            book.remove(Book_to_remove); // REMOVING FROM book ARRAYLIST
            System.out.println("BOOK REMOVED SUCCESSFULLY !!!");
        } else {
            System.out.println("BOOK NOT FOUND !!!");
        }
    }

    // FUNCTION TO REGISTER A MEMBER
    public void register_member(String name, int age, String phone_num) {
        // HERE WHENEVER A MEMBER IS CREATED AN EMPTY ARRAYLIST IS PASSED TO IT WHICH
        // WILL STORE THE RECORD OF THE BOOKS ISSUED TO HIM
        ArrayList<Books> Books=new ArrayList<>();
        LibraryMember MemBer = new LibraryMember(name, phone_num,Books);
        members.add(MemBer); // ADDING MEMBER TO THE members ARRYALIST
        // map.put(name,null);
        System.out.println("MEMBER ADDED SUCCESSFULLY !!!");
    }

    // FUNTION TO REMOVE MEMBER FROM THE members ARRAYLIST
    public void remove_member(String name, String phone_num) {
        LibraryMember memberToremove = null;
        // System.out.println(phone_num);
        for (LibraryMember member : members) {
            if (member.phone_num.equals(phone_num)) {
                // System.out.println("hello");
                memberToremove = member;
                break;
            }
        }
        if (memberToremove != null) {
            members.remove(memberToremove); // REMOVING FROM THE members ARRAYLIST
            System.out.println("MEMBER REMOVED SUCCESSFULLY!!!");
        } else {
            System.out.println("MEMBER NOT FOUND!!!");
        }
    }

    // FUNCTION TO LIST ALL THE BOOKS
    public void list_books() {
        for (Books listing_books : book) { // THIS LOOP WILL PRINT ALL THE BOOKS AVAILABLE IN THE book ARRAYLIST
            // System.out.println("AVAILABLE BOOKS !!!");
            System.out.print("BOOK ID: ");
            System.out.println(listing_books.id);
            System.out.print("BOOK TITLE: ");
            System.out.println(listing_books.title);
            System.out.print("BOOK AUTHOR: ");
            System.out.println(listing_books.author);
            System.out.print("AVAILABLE COPIES OF THE BOOK: ");
            System.out.println(listing_books.available_copies);
        }
    }

    // FUNCTION TO PRINT THE LIST OF REGISTERED MEMBERS
    public void list_registered_members() {
        for (LibraryMember listingLibraryMember : members) {
            System.out.print("Name: ");
            System.out.println(listingLibraryMember.name);
            // THIS LOOP WILL PRINT THE LIST OF REGISTERED MEMBERS IN THE members ARRAYLIST
            System.out.print("Age: ");
            System.out.println(listingLibraryMember.age);
            System.out.print("Phone Number: ");
            System.out.println(listingLibraryMember.phone_num);
        }
    }

    public void show_member_with_fine(){
        for( LibraryMember mem: members) {
            System.out.println("MEMBER NAME: ");
            System.out.println(mem.name);
            System.out.println("MEMBER PENALTY: ");
            System.out.println(mem.penalty_amount);
        }
    }
}

class LibraryMember {
    static int mems = 0;
    String name;
    int age;
    String phone_num;
    int mem_id;
    int penalty_amount = 0;


    public ArrayList<Books> temporaryBooks = new ArrayList<>();
    //ArrayList<BorrowedBooks> borrowedBooks=new ArrayList<>();

    static public Map<Integer, ArrayList[]> issued_books = new HashMap<>();
    public LibraryMember(String name, String phone_num,ArrayList<Books> temoBooks) {
        this.name = name;
        this.phone_num = phone_num;
        this.mem_id = mems;
        this.temporaryBooks=temoBooks;
        mems++; // ASSIGNING MEM_ID TO MEMBERS FROM 0 TO n

    }

    /// THIS FUNCTION IS FOR LOGGING AS A MEMBER
    public void enter_member(String name, String phone_num) {
        LibraryMember member_to_login = null;
        for (LibraryMember MemBER : Librarian.members) {
            if (this.name.equals(name) && this.phone_num.equals(phone_num)) {
                System.out.println("LOGIN SUCCESSFULLY !!!");
                break;
            } else {
                System.out.println("MEMBER NOT FOUND !!!");
            }
        }
    }


    public long calculate_penalty(ArrayList<Books> temporaryBooks) {
        long total_penalty=0;
        for(Books book: temporaryBooks){
            long diff = ChronoUnit.SECONDS.between(book.local_time,LocalTime.now());
            if(diff > 10){
                total_penalty+=(diff-10)*3;
            }
        }
        return total_penalty;

    }

    public void issue_book(String title, int id,LibraryMember x) {
        // DO CHECKS THEN ISSUE
        if(x.penalty_amount>0){
            System.out.println("Pay Penalty first. Penalty amount is "+ x.penalty_amount);
            return;
        }
        Books book_to_issue = null;

        if (temporaryBooks.size() < 2) {
            for (Books b : Librarian.book) {
                if (b.id == id && b.title.equals(title) && b.available_copies > 0) {
                    book_to_issue = b;
//                    long penalty = x.calculate_penalty(x.temporaryBooks);
//                    if(penalty>0){
//                        System.out.println("pay penalty first");
//                        System.out.println("penalty_amount is " + x.penalty_amount);
//                        return;

//                    book_to_issue = b;
                    if (book_to_issue != null) {
                        temporaryBooks.add(book_to_issue);
                        book_to_issue.available_copies--;
                        System.out.println("BOOK ISSUED SUCCESSFULLY !!!");
                        b.local_time = java.time.LocalTime.now();
                        break;
                    }
                }
            }
                if(book_to_issue==null){
                    System.out.println("BOOK NOT FOUND !!!");
                }
//                System.out.println("BOOK NOT FOUND !!!!");

        }
        else {
            System.out.println("CAN'T ISSUE BOOK MORE THAN TWO BOOKS!!!"); // IF THE UPPER IF CONDITION IS NOT SATISFIED
        }
    }

    public long return_book(int id) {
        // Books temp_var=null;
        Books book_to_remove=null;
        long p=0;
        for (Books temp_variable : temporaryBooks) {
            if (temp_variable.id== id) {
                p=calculate_penalty(temporaryBooks);
                if(p>0){
                    System.out.println("Book returned success with fine: "+ p);
                }
                book_to_remove= temp_variable;
                break;
            }
        }
        if(book_to_remove!=null){
            temporaryBooks.remove(book_to_remove);
            book_to_remove.available_copies++;
            return p;
        }
        else{
            System.out.println("BOOK NOT FOUND IN YOUR ISSUED BOOKS !!!");
            return p;
        }

    }
}


public class Library_Management {
    public static void main(String[] args) {

        Librarian lib = new Librarian();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---------------------------------");
            System.out.println("1. ENTER AS A LIBRARIAN");
            System.out.println("---------------------------------");
            System.out.println("2. ENTER AS A MEMBER");
            System.out.println("---------------------------------");
            System.out.println("3. EXIT");
            System.out.println("---------------------------------");
            System.out.print("CHOOSE THE OPTION:- ");
            int a = sc.nextInt();

            if (a == 1) {
                boolean inner_loop = true;
                while (inner_loop) {
                    System.out.println("---------------------------------");
                    System.out.println("1. REGISTER AS MEMBER");
                    System.out.println("2. REMOVE A MEMBER");
                    System.out.println("3. ADD A BOOK");
                    System.out.println("4. REMOVE A BOOK");
                    System.out.println("5. VIEW ALL MEMBERS ALONG WITH THEIR FINE TO BE PAID");
                    System.out.println("6. VIEW ALL BOOKS");
                    System.out.println("7. VIEW ALL REGISTERED MEMBERS");
                    System.out.println("8. BACK");
                    System.out.println("---------------------------------");

                    System.out.print("CHOOSE THE OPTION:- ");
                    int h = sc.nextInt();
                    if (h == 1) {
                        sc.nextLine();
                        System.out.print("MEMBER NAME: ");
                        String i = sc.nextLine();
                        System.out.print("MEMBER AGE: ");
                        int j = sc.nextInt();
                        sc.nextLine();
                        System.out.print("MEMBER PHONE NUMBER: ");
                        String k = sc.nextLine();
                        System.out.println("---------------------------------");
                        lib.register_member(i, j, k);
                    } else if (h == 2) {
                        sc.nextLine();
                        System.out.print("MEMBER NAME: ");
                        String l = sc.nextLine();
                        System.out.print("MEMBER PHONE NUMBER: ");
                        String m = sc.nextLine();
                        System.out.println("---------------------------------");
                        lib.remove_member(l, m);

                    } else if (h == 3) {
                        sc.nextLine();
                        System.out.print("BOOK ID: ");
                        int n = sc.nextInt();
                        sc.nextLine();
                        System.out.print("BOOK TITLE: ");
                        String o = sc.nextLine();
                        // sc.nextLine();
                        System.out.print("BOOK'S AUTHOR: ");
                        String p = sc.nextLine();
                        System.out.print("NO. OF COPIES: ");
                        int q = sc.nextInt();
                        System.out.println("---------------------------------");
                        lib.addBook(n, o, p, q);

                    } else if (h == 4) {
                        sc.nextLine();
                        System.out.print("BOOK ID: ");
                        int r = sc.nextInt();
                        System.out.println("---------------------------------");
                        lib.removeBook(r);
                    } else if (h == 5) {
                        System.out.println("---------------------------------");
                        System.out.println("ALL MEMBERS ALONG WITH THEIR FINE: ");
                        lib.show_member_with_fine();
                        // show all members along with their fine
                    } else if (h == 6) {
                        System.out.println("---------------------------------");
                        System.out.println("LIST OF ALL BOOKS: ");
                        lib.list_books();
                    } else if (h == 7) {
                        System.out.println("---------------------------------");
                        System.out.println("LIST OF REGISTERED MEMBERS: ");
                        lib.list_registered_members();

                    } else if (h == 8) {
//                        System.out.println("---------------------------------");
                        inner_loop = false;
                        continue;
                    } else {
                        System.out.println("---------------------------------");
                        System.out.println("YOU HAVE CHOOSEN WRONG OPTION. TRY AGAIN !!!");
                    }
                }
            } else if (a == 2) {
                boolean member_found = false;
                // HERE FIRST YOU HAVE TO ASK FOR NAME AND PHONE NO.
                sc.nextLine();
                System.out.print("ENTER YOUR NAME:-");
                String b = sc.nextLine();
                System.out.print("ENTER YOUR PHONE NUMBER:-");
                String c = sc.nextLine();
                for (LibraryMember x : Librarian.members) {
                    if (x.name.equals(b) && x.phone_num.equals(c)) {
                        System.out.println("---------------------------------");
                        System.out.println("LOGIN SUCCESSFULL !!!!");
                        System.out.println("WELCOME " + b + " With" + " PHONE NUMBER:- " + c);
                        member_found = true;
                        //LibraryMember member= new LibraryMember(b,c,x.temporaryBooks);
                        LibraryMember lib2 = new LibraryMember(b, c, x.temporaryBooks);
                        while (true) {
                            System.out.println("---------------------------------");
                            System.out.println("1. LIST AVAILABLE BOOKS");
                            System.out.println("2. LIST MY BOOKS");
                            System.out.println("3. ISSUE BOOK");
                            System.out.println("4. RETURN BOOK");
                            System.out.println("5. PAY FINE");
                            System.out.println("6. BACK");
                            System.out.println("---------------------------------");
                            System.out.print("CHOOSE THE OPTION:- ");
                            int d = sc.nextInt();

                            if (d == 1) {
                                System.out.println("---------------------------------");
                                System.out.println("LIST OF AVAILABLE BOOKS: ");
                                lib.list_books();
                            }
                            // Map<Integer, ArrayList[]> temporaray= new HashMap<>();

                            else if (d == 2) {
//                                System.out.println("---------------------------------");
                                for (Books tempvar : x.temporaryBooks) {
                                    System.out.println("BOOKS BORROWED BY YOU :");
                                    System.out.print("BOOK ID: ");
                                    System.out.println(tempvar.id);
                                    System.out.print("BOOK TITLE: ");
                                    System.out.println(tempvar.title);
                                    System.out.print("BOOK AUTHOR: ");
                                    System.out.println(tempvar.author);
                                }

                            } else if (d == 3) {
                                sc.nextLine();
                                System.out.println("---------------------------------");
                                System.out.print("ENTER THE TITLE:- ");
                                String e = sc.nextLine();
                                System.out.print("ENTER BOOK ID:- ");
                                int f = sc.nextInt();
                                System.out.println("---------------------------------");
                                lib2.issue_book(e, f, x);


                            } else if (d == 4) {
                                // sc.nextLine();
                                System.out.println("---------------------------------");
                                System.out.print("ENTER BOOK ID:-");
                                int g = sc.nextInt();
                                System.out.println("---------------------------------");
                                long money=lib2.return_book(g);
                                // HERE YOU HAVE TO PRINT THE FINE CHARGED ON DELAY ALSO SEE THE
                                lib2.penalty_amount=(int)money;
                                System.out.println("SUCCESSFULLY RETURNED BOOK WITH ID:- " + g);
                            } else if (d == 5) {
                                //lib2.calculate_penalty(lib2.temporaryBooks);
                                if(lib2.penalty_amount>0){
                                    System.out.println("Successfully paid");
                                }
                                else{
                                    System.out.println("No dues");
                                }

                                // here you have to pay the fine
                            } else if (d == 6) {
                                System.out.println("---------------------------------");
                                System.out.println("GOING BACK !!!!");
                                break;
                            } else {
                                System.out.println("---------------------------------");
                                System.out.println("YOU HAVE CHOOSEN THE WRONG OPTION. TRY AGAIN !!!!");
                            }
                        }
                    }
                }
                if (!member_found) {
                    System.out.println("---------------------------------");
                    System.out.println("MEMBER WITH NAME " + b + " And Phone num:- " + c + " Do not exist");
                    System.out.println("TRY AGAIN !!!!");
//                    break;
                }
            }

            else {
                System.out.println("---------------------------------");
                System.out.println("EXITING !!!");
                break;
            }
        }
    }
}