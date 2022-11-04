package com.alvaro.javaAssessment.repository;

import com.alvaro.javaAssessment.model.Claim;;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {
}
