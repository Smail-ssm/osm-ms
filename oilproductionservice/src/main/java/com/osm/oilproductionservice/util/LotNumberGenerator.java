package com.osm.oilproductionservice.util;

import com.osm.oilproductionservice.model.BaseType;
import com.osm.oilproductionservice.model.Delivery;


public class LotNumberGenerator {

    /**
     * Generates a lot number based on the delivery's auto-generated id, olive type code, and delivery year.
     * <p>
     * Format: [ID as two digits][Olive Type Code][Year as two digits]
     * Example: if delivery id is 9, olive type code is "OC", and delivery year is 2024, the lot number becomes "09OC24".
     *
     * @param delivery The delivery entity containing the id, olive type, and delivery date.
     * @return A generated lot number string.
     */
    public static String generateLotNumber(Delivery delivery) {
        // Ensure the delivery has an ID.
        if (delivery.getId() == null) {
            throw new IllegalArgumentException("Delivery ID must be set before generating a lot number.");
        }

        // Format the ID part (e.g., 9 becomes "09")

        // Get the olive type code. Customize this to fetch the actual code from your BaseType.
        String oliveTypeCode = getOliveTypeCode(delivery.getOliveVariety());

        // Extract the last two digits of the delivery year.
        int fullYear = delivery.getDeliveryDate().getYear();
        String yearPart = String.format("%02d", fullYear % 100);

        // Combine the parts into the final lot number.
        return delivery.getDeliveryNumber() + oliveTypeCode + yearPart;
    }

    /**
     * Returns a short code for the given olive type.
     * Customize this method to extract the appropriate code from your BaseType or olive type entity.
     *
     * @param oliveType The BaseType representing the olive type.
     * @return A short string code for the olive type (e.g., "OC").
     */
    private static String getOliveTypeCode(BaseType oliveType) {
        // In a real implementation, you might call oliveType.getCode() or another property.
        // For demonstration, we assume oliveType.toString() returns the required code.
        return oliveType.getName();
    }
}
