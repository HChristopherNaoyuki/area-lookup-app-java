// Package declaration
package Solution;

import java.util.HashMap;
import java.util.Map;

public class CountryData
{
    // HashMap to store country -> towns -> codes
    private final Map<String, Map<String, String[]>> data;

    // Constructor to initialize country, town, and code data
    public CountryData()
    {
        data = new HashMap<>();
        
        // South Africa towns and codes
        Map<String, String[]> southAfricaTowns = new HashMap<>();
        southAfricaTowns.put("Cape Town", new String[]{"021", "8000"});
        southAfricaTowns.put("Johannesburg", new String[]{"011", "2000"});
        southAfricaTowns.put("Durban", new String[]{"031", "4000"});
        data.put("South Africa", southAfricaTowns);

        // United Kingdom towns and codes
        Map<String, String[]> ukTowns = new HashMap<>();
        ukTowns.put("London", new String[]{"020", "WC2N5DU"});
        ukTowns.put("Oxford", new String[]{"01865", "OX13PN"});
        ukTowns.put("Southampton", new String[]{"023", "SO147DW"});
        data.put("United Kingdom", ukTowns);
    }

    // Method to get country names as an array
    public String[] getCountries()
    {
        return data.keySet().toArray(new String[0]);
    }

    // Method to get towns for a specified country
    public String[] getTowns(String country)
    {
        Map<String, String[]> towns = data.get(country);
        if (towns != null)
        {
            return towns.keySet().toArray(new String[0]);
        }
        return new String[0];
    }

    // Method to get phone code for a specified town
    public String getPhoneCode(String country, String town)
    {
        return data.get(country).get(town)[0];
    }

    // Method to get postal code for a specified town
    public String getPostalCode(String country, String town)
    {
        return data.get(country).get(town)[1];
    }
}
