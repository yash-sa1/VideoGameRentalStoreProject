package com.yash.VideoGameRentalStore.data;

import com.yash.VideoGameRentalStore.model.entity.Customer;
import com.yash.VideoGameRentalStore.model.entity.Rental;
import com.yash.VideoGameRentalStore.model.entity.VideoGame;

import java.io.IOException;
import java.util.List;

public interface DataAccessLayerInterface {

    List<Customer> getAllCustomers();

    List<VideoGame> getAllVideoGames();

    List<Rental> getAllRentals(List<VideoGame> videoGames, List<Customer> customers);

    void saveRental(Rental rental);

    void changeStockAfterRenting (VideoGame game) throws IOException;

    void changeStockAfterReturning (VideoGame game) throws IOException;

    boolean checkRentalID(Rental rental , String entryToCheck) throws IOException;

    List<String> readAndPrintRentalsFile(String customerID) throws IOException;

    void registerCustomer(Customer customer) throws IOException;

    int create_next_id(String filename) throws IOException;


}
