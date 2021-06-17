package ai.sn.repositories;

import ai.sn.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role getRoleByName(String name);
}
