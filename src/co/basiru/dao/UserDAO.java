package co.basiru.dao;

import java.util.List;

import co.basiru.models.User;

public interface UserDAO {
	public String saveUsr(User usr);
	public String updateUsr(User usr);
	public String deleteUsr(int id);
	List<User> getUser();

}
