package org.example;


public class Main {
    public static void main(String[] args) {

        DBSetup.createTables();

        UserRepository.addUser(new DBUser("user1", "password1", "someone", 25, true));
        UserRepository.addUser(new DBUser("user2", "password2", "unknown", 30, false));

        System.out.println("List of users:");
        UserRepository.getUsers().forEach(System.out::println);
    }
}

