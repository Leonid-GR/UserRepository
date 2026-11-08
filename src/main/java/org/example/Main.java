package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        UserRepository repository = new UserRepository();

        repository.addUser(new User(1, "Leonid", "leonid@gmail.com"));
        repository.addUser(new User(2, "Ivan", "ivan@gmail.com"));
        repository.addUser(new User(3, "Oleg", "oleg@gmail.com"));

        System.out.println("Пошук за ID:");

        repository.findUserById(1).ifPresentOrElse(
                User::showInfo,
                () -> System.out.println("Користувача не знайдено")
        );

        System.out.println("\nПошук за Email:");

        repository.findUserByEmail("ivan@gmail.com").ifPresentOrElse(
                User::showInfo,
                () -> System.out.println("Користувача не знайдено")
        );

        System.out.println("\nВсі користувачі:");

        repository.findAllUsers().ifPresentOrElse(
                users -> System.out.println("Кількість користувачів: " + users.size()),
                () -> System.out.println("Список користувачів порожній")
        );
    }
}
