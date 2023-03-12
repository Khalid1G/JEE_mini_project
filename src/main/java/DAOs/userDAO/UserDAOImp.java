package DAOs.userDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.User;
import DataBase.ConnectionFactory;

public class UserDAOImpl implements UserDAO {

    private Connection connection;

    public UserDAOImpl() {
        connection = ConnectionFactory.getInstance();
    }

    @Override
    public void register(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO users(nom, prenom, role, tel, adress, email, password, avatar, created_at, updated_at, deleted_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setString(4, user.getTel());
            preparedStatement.setString(5, user.getAdress());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getPassword());
            preparedStatement.setString(8, user.getAvatar());
            preparedStatement.setString(9, user.getCreated_at());
            preparedStatement.setString(10, user.getUpdated_at());
            preparedStatement.setString(11, user.getDeleted_at());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void login(User user) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            rs = stmt.executeQuery();
            if (rs.next()) {
                // User is found, set user properties from result set
                user.setId(rs.getLong("id"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setRole(rs.getString("role"));
                user.setTel(rs.getString("tel"));
                user.setAdress(rs.getString("adress"));
                user.setAvatar(rs.getString("avatar"));
                user.setCreated_at(rs.getString("created_at"));
                user.setUpdated_at(rs.getString("updated_at"));
                user.setDeleted_at(rs.getString("deleted_at"));
            } else {
                // User not found, throw an exception
                throw new RuntimeException("Invalid email or password");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection, stmt, rs);
        }
    }

    @Override
    public void deleteUser(long userId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id=?");
            preparedStatement.setLong(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE users SET nom=?, prenom=?, role=?, tel=?, adress=?, email=?, password=?, avatar=?, created_at=?, updated_at=?, deleted_at=? WHERE id=?");

            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setString(4, user.getTel());
            preparedStatement.setString(5, user.getAdress());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getPassword());
            preparedStatement.setString(8, user.getAvatar());
            preparedStatement.setString(9, user.getCreated_at());
            preparedStatement.setString(10, user.getUpdated_at());
            preparedStatement.setString(11, user.getDeleted_at());
            preparedStatement.setLong(12, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public User getUserByEmail(String email) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email=?");
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user = new User(rs.getLong("id"), rs.getString("nom"), rs.getString("prenom"),
                        rs.getString("role"), rs.getString("tel"), rs.getString("adress"), rs.getString("email"),
                        rs.getString("password"), rs.getString("avatar"), rs.getString("created_at"),
                        rs.getString("updated_at"), rs.getString("deleted_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserById(long id) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id=?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user = new User(rs.getLong("id"), rs.getString("nom"), rs.getString("prenom"),
                        rs.getString("role"), rs.getString("tel"), rs.getString("adress"), rs.getString("email"),
                        rs.getString("password"), rs.getString("avatar"), rs.getString("created_at"),
                        rs.getString("updated_at"), rs.getString("deleted_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

}