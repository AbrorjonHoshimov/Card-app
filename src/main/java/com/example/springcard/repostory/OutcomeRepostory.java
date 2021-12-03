package com.example.springcard.repostory;


import com.example.springcard.entity.Outcome;
import com.example.springcard.projection.ProjectionInOut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutcomeRepostory extends JpaRepository<Outcome,Integer> {

    List<ProjectionInOut> findAllByToCard_Number(String toCard_number);
}
