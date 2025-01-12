package com.yash.VideoGameRentalStore.data;

import com.yash.VideoGameRentalStore.model.entity.Customer;
import com.yash.VideoGameRentalStore.model.entity.Rental;
import com.yash.VideoGameRentalStore.model.entity.VideoGame;
import com.yash.VideoGameRentalStore.service.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public interface DataAccessLayerInterface {

    List<Customer> getAllCustomers(); // this is a method signature to get all customers

    List<VideoGame> getAllVideoGames();

    List<Rental> getAllRentals(List<VideoGame> videoGames, List<Customer> customers);

    void saveRental(Rental rental);

    void changeStockAfterRenting (VideoGame game) throws IOException;

    void changeStockAfterReturning (VideoGame game) throws IOException;

    boolean checkRentalID(Rental rental , String entryToCheck) throws IOException;

    List<String> readAndPrintRentalsFile(String customerID) throws IOException;

    void registerCustomer(Customer customer) throws IOException;

    int create_next_id(String filename) throws IOException;

    // Generic method to read data from a file and convert each line to a target entity
    private <T> List<T> getAllFromFile(String filename, Function<String, T> fromStringFunction) {
        // Create a new list to hold the target entities
        final List<T> targetEntities = new ArrayList<>();

        // Load the file lines using the FileUtils.loadData method
        List<String> fileLines = FileUtils.loadData(filename);

        // Iterate over each line in the file
        fileLines.forEach(fileLine -> {
            // Convert the file line to a target entity using the provided function
            T TargetEntity = fromStringFunction.apply(fileLine);
            // Add the target entity to the list
            targetEntities.add(TargetEntity);
        });

        // Return the list of target entities
        return targetEntities;
    }
}
