package in.ecom.ekart.clc.app.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private int id;
	private String username;
	private String password;

	private List<UserRole> userRoleList;

}
