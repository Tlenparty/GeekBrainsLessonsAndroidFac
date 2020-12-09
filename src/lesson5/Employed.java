package lesson5;

import com.sun.jndi.ldap.ext.StartTlsResponseImpl;

public class Employed {

        // Задание 1

        private String name;
        private String surname;
        private String middleName;

        protected int age;
        public String position;
        private int salary;

        protected String email;
        private String telephone;

        // Задание 2

        public Employed (String name, String middleName, String surname, int age,
                         String position, String email, String telephone, int salary){

                this.name = name;
                this.surname = surname;
                this.middleName = middleName;
                if  ( age >=0 && age < 100) {
                        this.age = age;
                }else {
                        System.err.println("Неверный возраст");
                }
                this.position = position;
                this.salary = salary;
                this.email = email;
                this.telephone = telephone;
        }

        // Задание 3

        void printInfo(){
                System.out.printf("Меня зовут %s %s %s мне %d лет, я занимаю должность %s, мой e-mail %s, мой телефон %s " +
                        " и моя ЗП %d\n" ,name, middleName, surname, age, position, email, telephone, salary);
        }

        @Override
        public String toString() {
                return String.format("Меня зовут %s %s %s мне %d лет, я занимаю должность %s, мой e-mail %s, мой телефон %s " +
                        " и моя ЗП %d\n" ,name, middleName, surname, age, position, email, telephone, salary);
        }
}
