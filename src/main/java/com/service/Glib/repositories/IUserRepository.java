package com.service.Glib.repositories;

import com.service.Glib.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
