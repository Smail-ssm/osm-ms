package com.osm.oilproductionservice.constants;

public enum OilType {
    EXTRA_VIRGIN,    // Highest quality: cold-pressed, acidity <= 0.8%
    VIRGIN,          // Acidity <= 2%
    REFINED,         // Refined to remove flaws, often blended
    PURE,            // Blend of refined and virgin
    POMACE,          // Produced from olive residue (pomace) + refined oil
    LAMPANTE         // High acidity or flaws; not for direct consumption
}