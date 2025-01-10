package com.yash.VideoGameRentalStore.model.entity;

public class Customer {
    private String name;
    private int customerid;

    public Customer(String name, int customerid) {
        this.name = name;
        this.customerid = customerid;
    }

    public String getName() {
        return name;
    }

    public int getCustomerid() {
        return customerid;
    }

    public static Customer fromString( String customerString) {
        String [] parts  = customerString.split(",");
        if (parts.length < 2) {
            throw new IllegalArgumentException("invalid customer string file" + customerString);
        }

        return null;
        //test
    }


}
