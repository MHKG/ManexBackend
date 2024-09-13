package com.manex.backend.DAO;

import com.manex.backend.entities.TbUsers;
import com.manex.backend.response.XscResponse;

public interface AuthDAO {
	XscResponse login(String email, String password);

	TbUsers updatePassword(String password, String token);
}
