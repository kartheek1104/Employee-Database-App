import java.sql.*;
import java.util.*;

public class EmployeeDAO {

    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO employees (id, name, position, salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, emp.getId());
            stmt.setString(2, emp.getName());
            stmt.setString(3, emp.getPosition());
            stmt.setDouble(4, emp.getSalary());
            stmt.executeUpdate();
            System.out.println("[OK] Employee added successfully.");
        } catch (Exception e) {
            System.out.println("[ERROR] Add failed: " + e.getMessage());
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("position"),
                    rs.getDouble("salary")));
            }
        } catch (Exception e) {
            System.out.println("[ERROR] Fetch failed: " + e.getMessage());
        }
        return list;
    }

    public void updateEmployee(Employee emp) {
        String sql = "UPDATE employees SET name = ?, position = ?, salary = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getPosition());
            stmt.setDouble(3, emp.getSalary());
            stmt.setInt(4, emp.getId());
            stmt.executeUpdate();
            System.out.println("[OK] Employee updated successfully.");
        } catch (Exception e) {
            System.out.println("[ERROR] Update failed: " + e.getMessage());
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("[OK] Employee deleted successfully.");
        } catch (Exception e) {
            System.out.println("[ERROR] Delete failed: " + e.getMessage());
        }
    }
}
