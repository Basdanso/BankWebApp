package co.basiru;

import java.util.List;

public interface UserDAO {
	public String saveUsr(User usr);
	public String updateUsr(User usr);
	public String deleteUsr(int id);
	List<User> getUser();

}
