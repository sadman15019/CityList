package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    /**
     * this method is for testing add method of citylist class
     */
    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(0).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(0).size());
        assertTrue(cityList.getCities(0).contains(city));
    }

    /**
     * this method is for testing delete method of CityList class
     */
    @Test
    public void testDelete() {
        /*creating and initializing objects for citylist and city class*/
        CityList citylist = new CityList();
        City city1 = new City("Dhaka", "Mohammadpur");
        City city2 = new City("Dhaka", "Malibag");
        citylist.add(city1);
        citylist.add(city2);
        citylist.delete(city1);
        assertTrue(!citylist.getCities(0).contains(city1));
    }
    /**
     * this method is for testing add method when there are any exception occurs
     */
    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    /**
     * this method is for testing delete method when there are any exception occurs
     */
    @Test
    public void testDeleteException() {
        /*creating and initializing objects for citylist and city class*/
        CityList citylist = new CityList();
        City city1 = new City("Dhaka", "Mohammadpur");
        City city2 = new City("Dhaka", "Malibag");
        citylist.add(city1);
        citylist.add(city2);
        citylist.delete(city1);
        /*trying to delete an object which is not in the list*/
        assertThrows(IllegalArgumentException.class, () -> {
            citylist.delete(city1);
        });
    }

    /**
     * this method is for testing count method of citylist class
     */
    @Test
    public void testcount(){
        /*creating and initializing objects for citylist and city class*/
        CityList citylist = new CityList();
        City city1 = new City("Dhaka", "Mohammadpur");
        City city2 = new City("Dhaka", "Malibag");
        citylist.add(city1);
        citylist.add(city2);
        assertEquals(2,citylist.count());
        citylist.delete(city1);
        assertEquals(1,citylist.count());
    }
    /**
     * this method is for testing the getcities method of citylist class
     */
    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(0).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(0).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(0).get(1)));
    }
    /**
     * this method is for testing the modified version of getcities method of citylist class
     */
    @Test
    public void testGetCities_province()
    {
        CityList citylist=new CityList();
        City city1=new City("Dhaka","Mohammadpur");
        City city2=new City("Khulna","Fullbarigate");
        citylist.add(city1);
        citylist.add(city2);
        assertEquals(0,city2.compareTo(citylist.getCities(1).get(0)));//comapring city2 with zero indexed city from citylist
        assertEquals(0,city1.compareTo(citylist.getCities(1).get(1)));//comapring city1 with one indexed city from citylist
    }
}
