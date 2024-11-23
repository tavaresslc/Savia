package tech.buildrun.savia.repository;

import java.util.UUID;

import tech.buildrun.savia.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {
}
