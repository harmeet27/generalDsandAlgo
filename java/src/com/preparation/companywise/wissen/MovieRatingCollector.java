package com.preparation.companywise.wissen;

import java.util.*;

public class MovieRatingCollector {
        public static class RatingCollectorImpl implements RatingCollector {

//            ConcurrentHashMap
            static HashMap<String,List<Double>> movieRecord = new HashMap();


            @Override
            public void putNewRating(String movie, double rating) {
                // YOUR CODE HERE

                if(movieRecord.containsKey(movie)){
                    movieRecord.get(movie).add(rating);
                }else{
                    LinkedList<Double> ratings = new LinkedList();
                    ratings.add(rating);
                    movieRecord.put(movie, ratings);
                }
            }

            @Override
            public double getAverageRating(String movie) {
                // YOUR CODE HERE

                if(movieRecord.containsKey(movie)){
//                    LinkedList<Double> ratings = movieRecord.get(movie);

                    return 0;

                }else{
                    return -1;
                }

            }

            @Override
            public int getRatingCount(String movie) {
                // YOUR CODE HERE
                if(movieRecord.containsKey(movie)){
                    return movieRecord.get(movie).size();
                }else{
                    return -1;
                }
            }
        }

        ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

        public interface RatingCollector {
            // This is an input. Make note of this rating.  Rating can be a double number between 0 and 100.
            void putNewRating(String movie, double rating);

            // Get the average rating
            double getAverageRating(String movie);

            // Get the total number of ratings received for the movie
            int getRatingCount(String movie);
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int numLines = Integer.parseInt(scanner.nextLine());
            int currentLine = 0;
            while (currentLine++ < numLines) {
                final RatingCollector stats = new RatingCollectorImpl();
                final Set<String> movies = new TreeSet<>();

                String line = scanner.nextLine();
                String[] inputs = line.split(",");
                for (int i = 0; i < inputs.length; ++i) {
                    String[] tokens = inputs[i].split(" ");
                    final String symbol = tokens[0];
                    movies.add(symbol);
                    final double price = Double.parseDouble(tokens[1]);

                    stats.putNewRating(symbol, price);

                }

                for (String movie : movies) {
                    System.out.println(
                            String.format("%s %.4f %d", movie, stats.getAverageRating(movie), stats.getRatingCount(movie)));
                }

            }
            scanner.close();

        }
    }
