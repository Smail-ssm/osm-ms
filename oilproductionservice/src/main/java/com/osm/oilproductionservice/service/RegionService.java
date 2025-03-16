package com.osm.oilproductionservice.service;


import com.osm.oilproductionservice.domain.Region;
import com.osm.oilproductionservice.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    // Create a new Region
    public Region createRegion(Region region) {
        return regionRepository.save(region);
    }

    // Update an existing Region
    public Region updateRegion(Long id, Region region) {
        if (regionRepository.existsById(id)) {
            region.setId(id);  // Set the id to make sure we update the correct Region
            return regionRepository.save(region);
        }
        return null;  // Region not found
    }

    // Get a Region by ID
    public Region getRegion(Long id) {
        Optional<Region> region = regionRepository.findById(id);
        return region.orElse(null);  // Return region if found, otherwise return null
    }

    // Get all Regions
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    // Delete a Region by ID
    public boolean deleteRegion(Long id) {
        if (regionRepository.existsById(id)) {
            regionRepository.deleteById(id);
            return true;
        }
        return false;  // Region not found
    }
}
