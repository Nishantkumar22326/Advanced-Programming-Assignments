//VISITOR CLASS FILE

import java.util.*;


class Visitor {
    private String name;
    private int Age;
    private String phone_num;
    private Double balance;
    private String mail;
    private String passWORD;
    private boolean isPremiumMember;
    private List<String> feedbackList; 
    private boolean isBasicMemeber;

    private HashMap<Integer, Integer> ticketPurchaseDetails = new HashMap<>();


   
    public boolean isBasicMemeber() {
        return isBasicMemeber;
    }
    public void setBasicMemeber(boolean isBasicMemeber) {
        this.isBasicMemeber = isBasicMemeber;
    }
    public void setPremiumMember(boolean isPremiumMember) {
        this.isPremiumMember = isPremiumMember;
    }
    public boolean isPremiumMember() {
        return isPremiumMember;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return Age;
    }
    public void setAge(int age) {
        Age = age;
    }
    public String getPhone_num() {
        return phone_num;
    }
    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }
    
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPassWORD() {
        return passWORD;
    }
    public void setPassWORD(String passWORD) {
        this.passWORD = passWORD;
    }
    
    private static HashMap<String, Visitor> map = new HashMap<>();

    public Visitor(String name, int Age, String phone_num, Double balance, String mail, String passWORD) {
        this.name = name;
        this.Age = Age;
        this.phone_num = phone_num;
        this.balance = balance;
        this.mail = mail;
        this.passWORD = passWORD;
        feedbackList=new ArrayList<>();

    }
    public Double getVisitorBalance() {
        return balance;
    }
    public void setVisitorBalance(Double newBalance) {
        balance = newBalance;
    }
    
    // public Visitor(String mail, String passwords){
    // this.mail=mail;
    // this.passWORD= passWORD;
    // }

    public void register_visitor(String name, int age, String phonenumber, Double bal, String MAIL, String password) {
        Visitor visitor = new Visitor(name, age, phone_num, balance, mail, passWORD);
        map.put(MAIL, visitor);
        System.out.println("REGISTRATION SUCCESSFULL!!!!");
    }

    public static boolean ifVisitor(String mail, String password) {
        if (map.containsKey(mail)) {
            Visitor registeredVisitor = map.get(mail);
            // return registeredVisitor.passWORD.equals(password);
            return Objects.equals(registeredVisitor.passWORD, password);
        }
        return false;
    }

    public void leaveFeedback(String feedback) {
        if (feedback.length() > 200) {
            System.out.println("Feedback is too long (max 200 characters).");
        } else {
            feedbackList.add(feedback); 
            System.out.println("Thank you for your feedback");
        }
    }

    public void viewFeedback() {
        System.out.println("Visitor Feedback:");
        for (String feedback : feedbackList) {
            System.out.println(feedback);
        }
    }

    public void addTicketPurchaseDetails(int attractionId, int numTickets) {
        ticketPurchaseDetails.put(attractionId, numTickets);
    }

    public HashMap<Integer, Integer> getTicketPurchaseDetails() {
        return ticketPurchaseDetails;
    }

    
}
