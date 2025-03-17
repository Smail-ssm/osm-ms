package com.osm.oilproductionservice.rest;

import com.osm.oilproductionservice.domain.QualityControlRule;
import com.osm.oilproductionservice.dto.ApiResponse;
import com.osm.oilproductionservice.service.QualityControlRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/production/qualitycontrolrules")
public class QualityControlRuleController {

    @Autowired
    private QualityControlRuleService qualityControlRuleService;

    /**
     * Create a new quality control rule.
     */
    @PostMapping
    public ResponseEntity<ApiResponse<QualityControlRule>> createRule(@RequestBody QualityControlRule rule) {
        try {
            QualityControlRule createdRule = qualityControlRuleService.createRule(rule);
            ApiResponse<QualityControlRule> response = new ApiResponse<>(true, "Quality control rule created successfully", createdRule);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            ApiResponse<QualityControlRule> response = new ApiResponse<>(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * Retrieve all quality control rules.
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<QualityControlRule>>> getAllRules() {
        List<QualityControlRule> rules = qualityControlRuleService.getAllRules();
        ApiResponse<List<QualityControlRule>> response = new ApiResponse<>(true, "Quality control rules fetched successfully", rules);
        return ResponseEntity.ok(response);
    }

    /**
     * Retrieve a quality control rule by its ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<QualityControlRule>> getRuleById(@PathVariable Long id) {
        return qualityControlRuleService.getRuleById(id).map(rule -> ResponseEntity.ok(new ApiResponse<>(true, "Rule found", rule))).orElse(ResponseEntity.status(404).body(new ApiResponse<>(false, "Rule not found", null)));
    }

    /**
     * Update an existing quality control rule.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<QualityControlRule>> updateRule(@PathVariable Long id, @RequestBody QualityControlRule ruleDetails) {
        try {
            QualityControlRule updatedRule = qualityControlRuleService.updateRule(id, ruleDetails);
            if (updatedRule != null) {
                ApiResponse<QualityControlRule> response = new ApiResponse<>(true, "Quality control rule updated successfully", updatedRule);
                return ResponseEntity.ok(response);
            } else {
                ApiResponse<QualityControlRule> response = new ApiResponse<>(false, "Rule not found", null);
                return ResponseEntity.status(404).body(response);
            }
        } catch (RuntimeException e) {
            ApiResponse<QualityControlRule> response = new ApiResponse<>(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * Delete a quality control rule by its ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteRule(@PathVariable Long id) {
        boolean deleted = qualityControlRuleService.deleteRule(id);
        if (deleted) {
            ApiResponse<Void> response = new ApiResponse<>(true, "Quality control rule deleted successfully", null);
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<Void> response = new ApiResponse<>(false, "Rule not found", null);
            return ResponseEntity.status(404).body(response);
        }
    }
}
