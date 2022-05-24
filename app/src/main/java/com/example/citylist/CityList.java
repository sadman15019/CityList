package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    /*modified the method to get sorted list based on city along with provinces*/
    public List<City> getCities(int x) {
        List<City> cityList = cities;
        if(x==0) {
            Collections.sort(cityList);
        }
        else
        {
            Collections.sort(cityList,new Comparator<City>(){
                public int compare(City c1,City c2)
                {
                    return c1.getProvinceName().compareTo(c2.getProvinceName());//compare with respect to province
                }
            });

        }
        return cityList;
    }
    /*A method to delete city from city list*/
    public void delete(City city)
    {
        if(cities.contains(city)){
            cities.remove(city);
        }//list name is cities
        else
        {
           throw new IllegalArgumentException();
        }
    }
    public int count()
    {
        return cities.size();
    }
}
