package com.yash.VideoGameRentalStore.model.entity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class VideoGame {
    private String title;
    private String genre;
    private double price;
    private int current_stock;
    private final int gameID;
    private String imageUrl;

    public VideoGame(String title,int gameID, String genre, double price, int current_stock,  String imageUrl) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.current_stock = current_stock;
        this.gameID = gameID;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }


    public static VideoGame fromString (final String videoGameString) {
        String[] parts = videoGameString.split(",");
        String videogameTitle = parts[0];
        int videogameID = Integer.parseInt(parts[1]);
        String videogamegenre = parts[2];
        double videogameprice = Double.parseDouble(parts[3]);
        int videogamestock = Integer.parseInt(parts[4]);
        String videogameImageUrl = parts[5];
        return new VideoGame(videogameTitle, videogameID, videogamegenre, videogameprice, videogamestock, videogameImageUrl);

    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", current_stock=" + current_stock +
                ", gameID=" + gameID +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
