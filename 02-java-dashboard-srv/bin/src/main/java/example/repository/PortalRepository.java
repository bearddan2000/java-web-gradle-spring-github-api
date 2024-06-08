package example.repository;

import example.model.Portal;

import org.springframework.data.repository.CrudRepository;

public interface PortalRepository extends CrudRepository<Portal, Long> {}
