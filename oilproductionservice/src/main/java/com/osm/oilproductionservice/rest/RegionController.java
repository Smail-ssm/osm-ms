package com.osm.oilproductionservice.rest;


import com.osm.oilproductionservice.domain.Region;
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
    public ResponseEntity<Region> createRegion(@RequestBody Region region) {
        Region createdRegion = regionService.createRegion(region);
        return ResponseEntity.ok(createdRegion);  // Return the created region in the response
    }

    // Get all Regions
    @GetMapping
    public List<Region> getAllRegions() {
        return regionService.getAllRegions();  // Return list of regions
    }

    // Get a specific Region by ID
    @GetMapping("/{id}")
    public ResponseEntity<Region> getRegion(@PathVariable Long id) {
        Region region = regionService.getRegion(id);
        if (region != null) {
            return ResponseEntity.ok(region);  // Return the region if found
        } else {
            return ResponseEntity.notFound().build();  // Return 404 if region is not found
        }
    }

    // Update an existing Region by ID
    @PutMapping("/{id}")
    public ResponseEntity<Region> updateRegion(@PathVariable Long id, @RequestBody Region region) {
        Region updatedRegion = regionService.updateRegion(id, region);
        if (updatedRegion != null) {
            return ResponseEntity.ok(updatedRegion);  // Return the updated region
        } else {
            return ResponseEntity.notFound().build();  // Return 404 if region is not found
        }
    }

    // Delete a Region by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Long id) {
        boolean deleted = regionService.deleteRegion(id);
        if (deleted) {
            return ResponseEntity.noContent().build();  // Return 204 if deletion is successful
        } else {
            return ResponseEntity.notFound().build();  // Return 404 if region is not found
        }
    }
}
