package com.example.webProjekat.repository;

import com.example.webProjekat.model.Termin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TerminRepository extends JpaRepository<Termin, Long> {

    List<Termin> findByOrderByCenaAsc();

    List<Termin> findByOrderByCenaDesc();

    List<Termin> findByOrderByVremeTerminaAsc();

    List<Termin> findByOrderByVremeTerminaDesc();


}
