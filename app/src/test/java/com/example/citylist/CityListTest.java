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

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(0).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(0).size());
        assertTrue(cityList.getCities(0).contains(city));
    }

    @Test
    /*this method is for testing delete method*/
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

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    /*this method is for testing deleteexception*/
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
    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(0).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(0).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(0).get(1)));
    }
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
