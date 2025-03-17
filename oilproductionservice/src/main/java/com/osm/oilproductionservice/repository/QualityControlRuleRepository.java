package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.domain.QualityControlRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QualityControlRuleRepository extends JpaRepository<QualityControlRule, Long> {
    Optional<QualityControlRule> findByRuleKey(String ruleKey);

    Optional<QualityControlRule> findByRuleName(String ruleName);
}