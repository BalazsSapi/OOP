package lab2_extra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static void RateMovies(List<Movie> movies) {
        try (FileWriter writer = new FileWriter("ratings.out")) {
            for (Movie movie : movies) {
                System.out.println("Rate the movie: " + movie.getTitle() + " (0-10): ");
                double rating = -1;
                while (rating < 0 || rating > 10) {
                    try {
                        rating = scanner.nextFloat();
                        if (rating < 0 || rating > 10) {
                            System.out.println("Invalid rating! Please enter a number between 0 and 10.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter a valid number between 0 and 10.");
                    }
                }
                writer.write(movie.getTitle() + "," + movie.getDirector() + "," + movie.getReleaseYear() + "," + rating + "," + movie.getGenre() + "\n");

            }
            System.out.println("Ratings saved successfully to ratings.out!");
        }
        catch(IOException e){
            System.out.println("An error occurred while saving the ratings.");
        }
    }
    private static void AddNewMovie(List<Movie> movies) {
        System.out.println("Please enter the name of the movie you would like to add: ");
        String title;
        title = scanner.nextLine();
        System.out.println("Please enter the name of the director of the movie: ");
        String director;
        director = scanner.nextLine();
        System.out.println("Please enter the year of the movie: ");
        int releaseYear;
        releaseYear = scanner.nextInt();
        System.out.println("Please enter the rating of the movie: ");
        double rating;
        rating = scanner.nextDouble();
        scanner.nextLine();
        Genre genre = null;
        while (genre == null) {
            System.out.println("Please enter the genre (Horror,Comedy,Drama,Thriller,Romance,Action,Fantasy,ComedyDrama,Musical,ScienceFiction,Crime): ");
            String genreInput = scanner.nextLine();
            try {
                genre = Genre.valueOf(genreInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid genre! Please try again.");
            }
        }
        movies.add(new Movie(title, director, releaseYear, rating, genre));
        System.out.println("Movie added successfully!");
        ListMovies(movies);
    }
    private static void ListMovies(List<Movie> movies) {
        for(int i = 0; i < movies.size(); i++) {
            System.out.println(movies.get(i));
        }
    }
    private static void SearchTitle(List<Movie> movies) {
        String title;
        System.out.print("Title searched: ");
        title = scanner.nextLine();
        for(int i=0;i<movies.size();i++) {
            if(movies.get(i).getTitle().equals(title)) {
                System.out.println(movies.get(i));
                return;
            }
        }
        System.out.println("Title not found!");
    }
    private static List<Movie> ReadFile (){
        List<Movie> movies = new ArrayList<>();
        try {
            File myObj = new File("be.in");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitData=data.split(",");
                String title=splitData[0];
                String director=splitData[1];
                int releaseYear=Integer.parseInt(splitData[2]);
                double rating=Double.parseDouble(splitData[3]);
                Genre genre= Genre.valueOf(splitData[4]);
                movies.add(new Movie(title, director, releaseYear, rating, genre));
            }
            myReader.close();
            return movies;
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            return  null;
        }
    }
    public static void main(String[] args) {
        List<Movie> movies=ReadFile();
        ListMovies(movies);
        SearchTitle(movies);
        AddNewMovie(movies);
        RateMovies(movies);
        scanner.close();
    }
}