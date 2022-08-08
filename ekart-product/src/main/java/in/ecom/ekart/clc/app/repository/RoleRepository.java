package in.ecom.ekart.clc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ecom.ekart.clc.app.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Role findRoleByRoleName(String roleName);
		//select role from role where rolename="customer";

}
