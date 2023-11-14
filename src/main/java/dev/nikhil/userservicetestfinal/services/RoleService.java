package dev.nikhil.userservicetestfinal.services;

import dev.nikhil.userservicetestfinal.models.Role;
import dev.nikhil.userservicetestfinal.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(String name) {
        Role role = new Role();
        role.setRole(name);

        return roleRepository.save(role);
    }
}
