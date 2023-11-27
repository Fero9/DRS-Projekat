import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class VideoGameApp {
    public static void main(String[] args) {
        selectGames();

        //Queries related to the Genre table modification
        ModifyGenre.selectGenre();
        ModifyGenre.insertGenre(6,"Test");
        ModifyGenre.updateGenre(6, "test two");
        ModifyGenre.deleteGenre(6);

        //Queries related to the Studio table modification
        ModifyStudio.selectStudio();
        ModifyStudio.insertStudio(6, "Test Studio");
        ModifyStudio.updateStudio(6, "New Test Studio");
        ModifyStudio.deleteStudio(6);

    }

    public static void selectGames() {
        String query = "SELECT * FROM video_game";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id_video_game = resultSet.getInt("id_video_game");
                String video_game_name = resultSet.getString("video_game_name");
                int video_game_genre_id = resultSet.getInt("video_game_genre_id");
                int video_game_studio_id = resultSet.getInt("video_game_studio_id");
                int video_game_platform_id = resultSet.getInt("video_game_platform_id");
                Date video_game_release_date = new Date(resultSet.getDate("video_game_release_date").getTime());
                int video_game_rating = resultSet.getInt("video_game_rating");

                System.out.println("Video Game ID: " + id_video_game);
                System.out.println("Name: " + video_game_name);
                System.out.println("Genre: " + video_game_genre_id);
                System.out.println("Studio: " + video_game_studio_id);
                System.out.println("Platform: " + video_game_platform_id);
                System.out.println("Release Date: " + video_game_release_date);
                System.out.println("Rating: " + video_game_rating);
                System.out.println("------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
