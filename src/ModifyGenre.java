import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifyGenre {
    public static void selectGenre() {
        String query = "SELECT * FROM genre";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int id_genre = resultSet.getInt("id_genre");
                    String genre_name = resultSet.getString("genre_name");

                    System.out.println("Genre ID: " + id_genre);
                    System.out.println("Genre Name: " + genre_name);
                    System.out.println("------------------------");
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertGenre(int id_genre, String genreName) {
        String query = "INSERT INTO genre (id_genre, genre_name) VALUES (?, ?)";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1,id_genre);
            preparedStatement.setString(2, genreName);


            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Genre" + " " + genreName + " " + "inserted successfully!");
            } else {
                System.out.println("Failed to insert genre.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateGenre(int id_genre, String newGenreName) {
        String query = "UPDATE genre SET genre_name = ? WHERE id_genre = ?";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newGenreName);
            preparedStatement.setInt(2, id_genre);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Genre" +" " + newGenreName + " " + "updated successfully!");
            } else {
                System.out.println("Failed to update genre.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteGenre(int id_genre) {
        String query = "DELETE FROM genre WHERE id_genre = ?";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id_genre);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Genre deleted successfully!");
            } else {
                System.out.println("Failed to delete genre.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
