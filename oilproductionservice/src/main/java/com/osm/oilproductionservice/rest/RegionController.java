package com.osm.oilproductionservice.rest;

import com.osm.oilproductionservice.domain.customTypes.Region;
import com.osm.oilproductionservice.dto.ApiResponse;
import com.osm.oilproductionservice.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/production/regions")
public class RegionController {

    @Autowired
    private RegionService regionService;

    // Create a new Region
    @PostMapping
    public ResponseEntity<ApiResponse<Region>> createRegion(@RequestBody Region region) {
        try {
            Region createdRegion = regionService.createRegion(region);
            ApiResponse<Region> response = new ApiResponse<>(true, "Region created successfully", createdRegion);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<Region> response = new ApiResponse<>(false, "Error creating region: " + e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }

    // Get all Regions
    @GetMapping
    public ResponseEntity<ApiResponse<List<Region>>> getAllRegions() {
        List<Region> regions = regionService.getAllRegions();
        ApiResponse<List<Region>> response = new ApiResponse<>(true, "Regions fetched successfully", regions);
        return ResponseEntity.ok(response);
    }

    // Get a specific Region by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Region>> getRegion(@PathVariable Long id) {
        Region region = regionService.getRegion(id);
        if (region != null) {
            ApiResponse<Region> response = new ApiResponse<>(true, "Region found", region);
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<Region> response = new ApiResponse<>(false, "Region not found", null);
            return ResponseEntity.status(404).body(response);
        }
    }

    // Update an existing Region by ID
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Region>> updateRegion(@PathVariable Long id, @RequestBody Region region) {
        Region updatedRegion = regionService.updateRegion(id, region);
        if (updatedRegion != null) {
            ApiResponse<Region> response = new ApiResponse<>(true, "Region updated successfully", updatedRegion);
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<Region> response = new ApiResponse<>(false, "Region not found", null);
            return ResponseEntity.status(404).body(response);
        }
    }

    // Delete a Region by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteRegion(@PathVariable Long id) {
        boolean deleted = regionService.deleteRegion(id);
        if (deleted) {
            ApiResponse<Void> response = new ApiResponse<>(true, "Region deleted successfully", null);
            return ResponseEntity.noContent().build();
        } else {
            ApiResponse<Void> response = new ApiResponse<>(false, "Region not found", null);
            return ResponseEntity.status(404).body(response);
        }
    }
}
