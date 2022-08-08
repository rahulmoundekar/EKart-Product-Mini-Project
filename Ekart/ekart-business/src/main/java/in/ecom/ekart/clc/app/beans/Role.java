package in.ecom.ekart.clc.app.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

	private int id;

	private String roleName;

	private List<UserRole> userRoleList;
}
