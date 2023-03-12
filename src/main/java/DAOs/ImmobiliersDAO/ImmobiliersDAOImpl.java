import Beans.Immobiliers;
import DataBase.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImmobiliersDAOImpl implements ImmobiliersDAO {

    private Connection connection;

    public ImmobiliersDAOImpl() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public List<Immobiliers> getAllImmobilirs() {
        List<Immobiliers> immobiliers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM immobiliers");

            while (resultSet.next()) {
                Immobiliers immobilier = new Immobiliers(
                        resultSet.getLong("id"),
                        resultSet.getString("adresse"),
                        resultSet.getString("pay"),
                        resultSet.getString("ville"),
                        resultSet.getString("surface"),
                        resultSet.getInt("nbr_etage"),
                        resultSet.getString("type"),
                        resultSet.getString("description"),
                        resultSet.getDouble("prix"),
                        resultSet.getBoolean("disponibilite"),
                        resultSet.getLong("proprietaire_id"),
                        resultSet.getString("created_at"),
                        resultSet.getString("updated_at"),
                        resultSet.getString("deleted_at")
                );
                immobiliers.add(immobilier);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return immobiliers;
    }

    @Override
    public Immobiliers getImmobilierById(Long id) {
        Immobiliers immobilier = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM immobiliers WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                immobilier = new Immobiliers(
                        resultSet.getLong("id"),
                        resultSet.getString("adresse"),
                        resultSet.getString("pay"),
                        resultSet.getString("ville"),
                        resultSet.getString("surface"),
                        resultSet.getInt("nbr_etage"),
                        resultSet.getString("type"),
                        resultSet.getString("description"),
                        resultSet.getDouble("prix"),
                        resultSet.getBoolean("disponibilite"),
                        resultSet.getLong("proprietaire_id"),
                        resultSet.getString("created_at"),
                        resultSet.getString("updated_at"),
                        resultSet.getString("deleted_at")
                );
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return immobilier;
    }

    public void addImmobilier(Immobilier immobilier, User user) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO immobiliers(adresse, pay, ville, surface, nbr_etage, type, description, prix, disponibilite, proprietaire_id, created_at,bathroomNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)"
            );
            preparedStatement.setString(1, immobilier.getAdresse());
            preparedStatement.setString(2, immobilier.getPay());
            preparedStatement.setString(3, immobilier.getVille());
            preparedStatement.setString(4, immobilier.getSurface());
            preparedStatement.setInt(5, immobilier.getNbrEtage());
            preparedStatement.setString(6, immobilier.getType());
            preparedStatement.setString(7, immobilier.getDescription());
            preparedStatement.setDouble(8, immobilier.getPrix());
            preparedStatement.setBoolean(9, immobilier.getDisponibilite());
            preparedStatement.setLong(10, user.getId());
            preparedStatement.setString(11, LocalDateTime.now().toString());
            preparedStatement.setString(12, immobilier.getBathroomNumber.toString());

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Property added successfully!");
            } else {
                System.out.println("Failed to add property!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnexion(connection);
        }
    }

    @Override
    public void deleteImmobilier(Immobiliers immobilier) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM immobiliers WHERE id=?"
            );
            preparedStatement.setLong(1, immobilier.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Immobiliers> getImmobilierByUser(Long proprietaireId) {
        List<Immobiliers> immobilierList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM immobiliers WHERE proprietaire_id = ? AND deleted_at IS NULL"
            );
            preparedStatement.setLong(1, proprietaireId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Immobiliers immobilier = new Immobiliers(
                        resultSet.getLong("id"),
                        resultSet.getString("adresse"),
                        resultSet.getString("pay"),
                        resultSet.getString("ville"),
                        resultSet.getString("surface"),
                        resultSet.getInt("nbr_etage"),
                        resultSet.getString("type"),
                        resultSet.getString("description"),
                        resultSet.getDouble("prix"),
                        resultSet.getBoolean("disponibilite"),
                        resultSet.getLong("proprietaire_id"),
                        resultSet.getString("created_at"),
                        resultSet.getString("updated_at"),
                        resultSet.getString("deleted_at")
                        resultSe.getInt("getBathroomNumber")
                );
                immobilierList.add(immobilier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return immobilierList;
    }


    @Override
    public void updateImmobilier(Immobiliers immobilier) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE immobiliers SET adresse=?, pay=?, ville=?, surface=?, nbr_etage=?, type=?, description=?, prix=?, disponibilite=?, proprietaire_id=?, updated_at=?,bathroomNumber=? WHERE id=?"
            );
            preparedStatement.setString(1, immobilier.getAdresse());
            preparedStatement.setString(2, immobilier.getPay());
            preparedStatement.setString(3, immobilier.getVille());
            preparedStatement.setString(4, immobilier.getSurface());
            preparedStatement.setInt(5, immobilier.getNbr_etage());
            preparedStatement.setString(6, immobilier.getType());
            preparedStatement.setString(7, immobilier.getDescription());
            preparedStatement.setDouble(8, immobilier.getPrix());
            preparedStatement.setBoolean(9, immobilier.getDisponibilite());
            preparedStatement.setLong(10, immobilier.getProprietaire_id());
            preparedStatement.setString(11, getCurrentTimeStamp());
            preparedStatement.setLong(12, immobilier.getId());
            preparedStatement.setInt(13,immobilier.getBathroomNumber())
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
