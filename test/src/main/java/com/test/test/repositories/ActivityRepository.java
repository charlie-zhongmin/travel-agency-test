package com.test.test.repositories;

import com.test.test.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ActivityRepository extends JpaRepository<Activity, Long> {

    Optional<Activity> findByDate(String date);
}
