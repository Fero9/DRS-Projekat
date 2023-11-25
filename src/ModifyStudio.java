import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifyStudio {
    public static void selectStudio() {
        String query = "SELECT * FROM studio";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id_studio = resultSet.getInt("id_studio");
                String studio_name = resultSet.getString("studio_name");

                System.out.println("Studio ID: " + id_studio);
                System.out.println("Studio Name: " + studio_name);
                System.out.println("------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertStudio(int id_studio, String studio_name) {
        String query = "INSERT INTO genre (id_studio, studio_name) VALUES (?, ?)";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1,id_studio);
            preparedStatement.setString(2, studio_name);


            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Studio" + " " + studio_name + " " + "inserted successfully!");
            } else {
                System.out.println("Failed to insert studio.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStudio(int id_studio, String newStudio) {
        String query = "UPDATE studio SET studio_name = ? WHERE id_studio = ?";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newStudio);
            preparedStatement.setInt(2, id_studio);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Studio" +" " + newStudio + " " + "updated successfully!");
            } else {
                System.out.println("Failed to update studio.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudio(int id_studio) {
        String query = "DELETE FROM studio WHERE id_studio = ?";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id_studio);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Studio deleted successfully!");
            } else {
                System.out.println("Failed to delete studio.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
