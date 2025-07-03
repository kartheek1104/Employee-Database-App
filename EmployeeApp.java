import java.util.*;

public class EmployeeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {
            System.out.println("\n--- Employee Management ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter position: ");
                    String position = scanner.nextLine();

                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();

                    dao.addEmployee(new Employee(id, name, position, salary));
                    break;

                case 2:
                    List<Employee> employees = dao.getAllEmployees();
                    if (employees.isEmpty()) {
                        System.out.println("[INFO] No employees found.");
                    } else {
                        for (Employee emp : employees) {
                            System.out.println(emp);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID of employee to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new position: ");
                    String newPosition = scanner.nextLine();

                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();

                    dao.updateEmployee(new Employee(updateId, newName, newPosition, newSalary));
                    break;

                case 4:
                    System.out.print("Enter ID of employee to delete: ");
                    int deleteId = scanner.nextInt();
                    dao.deleteEmployee(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("[WARN] Invalid choice.");
            }
        }
    }
}