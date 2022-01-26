package com.service.Glib.repositories;

import com.service.Glib.entities.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlatformRepository extends JpaRepository<Platform, Long> {
}
