Name- Nishant Kumar
Roll no. - 2022326
Sec. -A

1. I have imported the necessary libraries.

2. I have created 3 classes - a) Librarian b) LibraryMember c)Books and at the end Main class is present.

3. In the Books class I am taking and assigning the necessary input for the books.

4. In the Librarian class I have added the following methods required by the Question.
   a)Contains methods for librarians to manage books and members.
   b)Methods include adding books, removing books, registering members, removing members, listing all books, and listing registered members.

5. In the LibraryMember class I have added the following methods required by the Question.
    a)Represents a library member with attributes like name, age, phone_num, mem_id, and penalty_amount.
    b)Keeps track of the books a member has issued in the temporaryBooks ArrayList.
    c)Contains methods for members to enter the system, calculate penalties, issue books, and return books.

6. The Library_Management Class:
   a) It is the main class where the program execution begins.
   b) It allows users to enter the system either as a librarian or a member or exit the code.
   c) Librarians can perform various tasks like adding/removing books, registering/removing members, and viewing lists.
   d) Members can log in, list available books, list their issued books, issue/return books, pay fines, etc.

    The Main Method:
    The main method initializes the Librarian class and starts an interactive menu-driven interface for librarians and members.
    Users can choose options to navigate through the system, perform actions, and interact with the library management system.
    Key Features:
        a)Librarians can manage the library's book inventory and member records.
        b)Members can log in and perform actions like borrowing and returning books also they see the list of thier borrowed books or the books
        available in the library.
        c)Fine calculation based on the return date for overdue books is partially implemented in the calculate_penalty method.