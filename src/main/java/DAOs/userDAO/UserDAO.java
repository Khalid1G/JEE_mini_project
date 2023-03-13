package DAOs.userDAO;

import Beans.User;

interface UserDAO{
    public User getUserById(long id);
    public void register(User user);
    public User getUserByEmail(String email);
    public void login(User user);
    public void updateUser(User user);
    public void deleteUser(Long user_id);


}