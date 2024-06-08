package example.repository;

import example.model.Language;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LangRepository extends JpaRepository<Language, Long> {}
