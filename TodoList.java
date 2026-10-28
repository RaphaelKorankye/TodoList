import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        int choice = 0;

        while (choice != 4) {
            System.out.println("\n=== To-Do List Manager ===");
            System.out.println("1. View tasks");
            System.out.println("2. Add a task");
            System.out.println("3. Remove a task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!input.hasNextInt()) {
                System.out.println("Please enter a number from 1 to 4.");
                input.nextLine();
                continue;
            }

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                if (tasks.isEmpty()) {
                    System.out.println("You have no tasks yet.");
                } else {
                    int i = 0;
                    while (i < tasks.size()) {
                        System.out.println(
                                (i + 1) + ". " + tasks.get(i)
                        );
                        i++;
                    }
                }

            } else if (choice == 2) {
                System.out.print("Enter a task: ");
                String task = input.nextLine().trim();

                if (!task.isEmpty()) {
                    tasks.add(task);
                    System.out.println("Task added successfully.");
                } else {
                    System.out.println("Task cannot be empty.");
                }

            } else if (choice == 3) {
                if (tasks.isEmpty()) {
                    System.out.println("There are no tasks to remove.");
                } else {
                    int i = 0;
                    while (i < tasks.size()) {
                        System.out.println(
                                (i + 1) + ". " + tasks.get(i)
                        );
                        i++;
                    }

                    System.out.print("Enter task number to remove: ");

                    if (input.hasNextInt()) {
                        int number = input.nextInt();
                        input.nextLine();

                        if (number >= 1 && number <= tasks.size()) {
                            String removed = tasks.remove(number - 1);
                            System.out.println("Removed: " + removed);
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    } else {
                        System.out.println("Please enter a valid number.");
                        input.nextLine();
                    }
                }

            } else if (choice == 4) {
                System.out.println("Goodbye!");

            } else {
                System.out.println("Invalid option.");
            }
        }

        input.close();
    }
}