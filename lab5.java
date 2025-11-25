import java.util.*;

class Film {
    String name;
    int year;
    String country;
    String genre;
    double cost;

    public Film(String name, int year, String country, String genre, double cost) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.genre = genre;
        this.cost = cost;
    }

    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Год: " + year);
        System.out.println("Страна: " + country);
        System.out.println("Жанр: " + genre);
        System.out.println("Стоимость: " + cost);
        System.out.println("------------------------");
    }
}

public class lab5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Film[] films = new Film[5];

        // Создаем фильмы
        films[0] = new Film("Интерстеллар", 2014, "США", "фантастика", 2500);
        films[1] = new Film("Криминальное чтиво", 1994, "США", "криминал", 1800);
        films[2] = new Film("Паразиты", 2019, "Корея", "драма", 2200);
        films[3] = new Film("Крестный отец", 1972, "США", "криминал", 2000);
        films[4] = new Film("Амели", 2001, "Франция", "романтика", 1500);

        while (true) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Фильмы с стоимостью выше средней");
            System.out.println("2. Самый ранний фильм");
            System.out.println("3. Сортировка по названию");
            System.out.println("4. Поиск и редактирование");
            System.out.println("5. Показать все фильмы");
            System.out.println("0. Выход");
            System.out.print("Выберите: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showExpensiveFilms(films);
                    break;
                case 2:
                    showOldestFilm(films);
                    break;
                case 3:
                    sortFilms(films);
                    break;
                case 4:
                    searchAndEdit(films, scanner);
                    break;
                case 5:
                    showAllFilms(films);
                    break;
                case 0:
                    System.out.println("Пока!");
                    return;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }

    // 1. Фильмы с стоимостью выше средней
    static void showExpensiveFilms(Film[] films) {
        double total = 0;
        for (Film film : films) {
            total += film.cost;
        }
        double average = total / films.length;

        System.out.println("\nСредняя стоимость: " + average);
        System.out.println("Фильмы дороже средней:");

        for (Film film : films) {
            if (film.cost > average) {
                film.printInfo();
            }
        }
    }

    // 2. Самый ранний фильм
    static void showOldestFilm(Film[] films) {
        Film oldest = films[0];
        for (int i = 1; i < films.length; i++) {
            if (films[i].year < oldest.year) {
                oldest = films[i];
            }
        }
        System.out.println("\nСамый ранний фильм:");
        oldest.printInfo();
    }

    // 3. Упорядочить массив по названиям фильмов в алфавитном порядке
    static void sortFilms(Film[] films) {
        for (int i = 0; i < films.length - 1; i++) {
            for (int j = i + 1; j < films.length; j++) {
                if (films[i].name.compareTo(films[j].name) > 0) {
                    // Меняем местами
                    Film temp = films[i];
                    films[i] = films[j];
                    films[j] = temp;
                }
            }
        }
        System.out.println("\nФильмы отсортированы по названию:");
        showAllFilms(films);
    }

    // 4. Организовать поиск по названию, исправление одного из полей и вывод полной информации о фильме после редактирования
    static void searchAndEdit(Film[] films, Scanner scanner) {
        scanner.nextLine(); // очистка буфера
        System.out.print("Введите название фильма: ");
        String searchName = scanner.nextLine();

        Film foundFilm = null;
        for (Film film : films) {
            if (film.name.equalsIgnoreCase(searchName)) {
                foundFilm = film;
                break;
            }
        }

        if (foundFilm == null) {
            System.out.println("Фильм не найден!");
            return;
        }

        System.out.println("\nНайден фильм:");
        foundFilm.printInfo();

        System.out.println("Что изменить?");
        System.out.println("1 - Название");
        System.out.println("2 - Год");
        System.out.println("3 - Страна");
        System.out.println("4 - Жанр");
        System.out.println("5 - Стоимость");
        System.out.print("Выберите: ");

        int field = scanner.nextInt();
        scanner.nextLine(); // очистка буфера

        switch (field) {
            case 1:
                System.out.print("Новое название: ");
                foundFilm.name = scanner.nextLine();
                break;
            case 2:
                System.out.print("Новый год: ");
                foundFilm.year = scanner.nextInt();
                break;
            case 3:
                System.out.print("Новая страна: ");
                foundFilm.country = scanner.nextLine();
                break;
            case 4:
                System.out.print("Новый жанр: ");
                foundFilm.genre = scanner.nextLine();
                break;
            case 5:
                System.out.print("Новая стоимость: ");
                foundFilm.cost = scanner.nextDouble();
                break;
            default:
                System.out.println("Неверный выбор!");
                return;
        }

        System.out.println("\nФильм после изменений:");
        foundFilm.printInfo();
    }

    // 5. Показать все фильмы
    static void showAllFilms(Film[] films) {
        for (Film film : films) {
            film.printInfo();
        }
    }
