import kong.unirest.*;
import kong.unirest.json.*;

import java.text.DecimalFormat;
import java.util.Scanner;



public class APIs {
    //waits for the user to press enter so they can read the information given
    public static void enterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    //gets the films id from TheMovieDB so it can be searched
    static String search(String film){
        HttpResponse<JsonNode> response = Unirest.get("https://api.themoviedb.org/3/search/movie?api_key=")//API key redacted for security
                .queryString("query",film)
                .asJson();
        JSONObject json = response.getBody().getObject();
        JSONArray arr = json.getJSONArray("results");
        String id = arr.getJSONObject(0).getString("id");
        return id;
    }
    public static void main(String args[]) throws InterruptedException {
        Scanner kb = new Scanner(System.in);
        System.out.println("Welcome to the Movie Database!");
        System.out.print("What film would you like to search for: ");
        String input = kb.nextLine();
        String id = search(input);
        //uses TheMovieDB's API to look up a film by its id
        HttpResponse<JsonNode> response = Unirest.get("https://api.themoviedb.org/3/movie/"+id+"?api_key=")//API key redacted for security
                .asJson();
        //parses the response given by the API
        JSONObject json = response.getBody().getObject();
        //searches the JSON file for the key "genres" and stores it in an array
        JSONArray arr = json.getJSONArray("genres");
        //searches the array 'arr' for the key "name" to get all the genres of the film
        String genres = arr.getJSONObject(0).getString("name");
        for (int i = 1; i < arr.length(); i++) {
            genres = genres+", "+arr.getJSONObject(i).getString("name");
        }
        //searches the JSON file for the key "production_companies" and stores it in an array
        arr = json.getJSONArray("production_companies");
        String companies = arr.getJSONObject(0).getString("name");
        //searches the array 'arr' for the key "name" to get all the production companies
        for (int i = 1; i < arr.length(); i++) {
            companies = companies+", "+arr.getJSONObject(i).getString("name");
        }

        //searches the JSON file for a key and stores any data associated with that key in a string variable
        String overview = json.getString("overview");
        String releaseDate = json.getString("release_date");
        String status = json.getString("status");
        String number = json.getString("revenue");
        //converts the String version of revenue to a double
        double amount = Double.parseDouble(number);
        //formatter to be used later to write the revenue in a standard format
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        //makes runtime into an interger and then uses this to work out the amount of hours and minutes the film is
        int runtime = Integer.parseInt(json.getString("runtime"));
        int hours = runtime/60;
        int minutes = runtime%60;


        //uses TheMovieDB's API to look up a film's cast by its id
        response = Unirest.get("https://api.themoviedb.org/3/movie/"+id+"/credits"+"?api_key=")//API key redacted for security
                .asJson();
        //parses the response given by the API
        json = response.getBody().getObject();
        //searches the JSON file for the key "cast" and stores it in an array
        arr = json.getJSONArray("cast");
        //searches the array 'arr' for the key "name" to get the cast of the film
        String cast = arr.getJSONObject(0).getString("name");
        for (int i = 1; i < arr.length(); i++) {
            cast = cast+", "+arr.getJSONObject(i).getString("name");
        }

        //while loop so the user can get the information they want for the film they searched
        //if statements to check the number they entered and match it to what they wanted to find out
        boolean done = false;
        while(done == false){
            System.out.println("1. Genres");
            System.out.println("2. Production Companies");
            System.out.println("3. Overview of the film");
            System.out.println("4. Release date");
            System.out.println("5. Revenue");
            System.out.println("6. Cast");
            System.out.println("7. Runtime");
            System.out.println("8. All information");
            System.out.println("9. Change film");
            System.out.println("10. Exit");
            System.out.print("What would you like to know? Please enter an option from above: ");
            String answer = kb.nextLine();
            if(answer.equals("1")){
                System.out.println();
                System.out.println("Genres: "+genres);
                enterKey();
            }
            else if(answer.equals("2")){
                System.out.println();
                System.out.println("Production Companies: "+companies);
                enterKey();
            }
            else if(answer.equals("3")){
                System.out.println();
                System.out.println("Overview: "+overview);
                enterKey();
            }
            else if(answer.equals("4")){
                System.out.println();
                System.out.println("release date: "+releaseDate);
                System.out.println("status: "+status);
                enterKey();
            }
            else if(answer.equals("5")){
                System.out.println();
                System.out.println("revenue: $"+formatter.format(amount));
                enterKey();
            }
            else if(answer.equals("6")){
                System.out.println();
                System.out.println("Cast: "+cast);
                enterKey();
            }
            else if(answer.equals("7")){
                System.out.println();
                System.out.println("runtime: "+hours+" hours "+minutes+" minutes");
                enterKey();
            }
            else if(answer.equals("8")){
                System.out.println();
                System.out.println("Genres: "+genres);
                System.out.println("Production Companies: "+companies);
                System.out.println("Overview: "+overview);
                System.out.println("release date: "+releaseDate);
                System.out.println("status: "+status);
                System.out.println("revenue: $"+formatter.format(amount));
                System.out.println("Cast: "+cast);
                System.out.println("runtime: "+hours+" hours "+minutes+" minutes");
                enterKey();
            }
            //allows the user to change the film they want to search for
            //uses the same code as above to get the information
            else if(answer.equals("9")){
                System.out.println();
                System.out.print("What film would you like to search for: ");
                input = kb.nextLine();
                id = search(input);
                response = Unirest.get("https://api.themoviedb.org/3/movie/"+id+"?api_key=")//API key redacted for security
                        .asJson();
                json = response.getBody().getObject();
                arr = json.getJSONArray("genres");
                genres = arr.getJSONObject(0).getString("name");
                for (int i = 1; i < arr.length(); i++) {
                    genres = genres+", "+arr.getJSONObject(i).getString("name");
                }
                arr = json.getJSONArray("production_companies");
                companies = arr.getJSONObject(0).getString("name");
                for (int i = 1; i < arr.length(); i++) {
                    companies = companies+", "+arr.getJSONObject(i).getString("name");
                }
                overview = json.getString("overview");
                releaseDate = json.getString("release_date");
                status = json.getString("status");
                number = json.getString("revenue");
                amount = Double.parseDouble(number);
                runtime = Integer.parseInt(json.getString("runtime"));
                hours = runtime/60;
                minutes = runtime%60;
                response = Unirest.get("https://api.themoviedb.org/3/movie/"+id+"/credits"+"?api_key=")//API key redacted for security
                        .asJson();
                json = response.getBody().getObject();
                arr = json.getJSONArray("cast");
                cast = arr.getJSONObject(0).getString("name");
                for (int i = 1; i < arr.length(); i++) {
                    cast = cast+", "+arr.getJSONObject(i).getString("name");
                }
            }
            else if(answer.equals("10")){
                System.out.println("Goodbye!");
                done = true;
            }
            //if the user doesn't enter a number from above it asks them to retry
            else{
                System.out.println("Invalid input! Please retry.");
                enterKey();
            }
        }
    }
}