package org.example;

public class DBUser {
        private int id;
        private String login;
        private String password;
        private String description;
        private int age;
        private boolean isActive;

        public DBUser(int id, String login, String password, String description, int age, boolean isActive) {
            this.id = id;
            this.login = login;
            this.password = password;
            this.description = description;
            this.age = age;
            this.isActive = isActive;
        }

        public DBUser(String login, String password, String description, int age, boolean isActive) {
            this(0, login, password, description, age, isActive);
        }

        public int getId() {
            return id;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public String getDescription() {
            return description;
        }

        public int getAge() {
            return age;
        }

        public boolean isActive() {
            return isActive;
        }

        @Override
        public String toString() {
            return "User{id=" + id + ", login='" + login + "', age=" + age + ", active=" + isActive + "}";
        }
}
