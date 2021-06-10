package model;


        import com.example.MyProject.Beer;

        import java.util.ArrayList;
        import java.util.List;

public class BeerExpert {

    public List<Beer> getBeers(String color) {
        List<Beer> beers = new ArrayList<>();
        if(color.equals("amber")){
        beers.add(new Beer("Jack Amber", 100.0));
        beers.add(new Beer("Red Moose", 100.0));}
        else {
            beers.add(new Beer("Jalil Pale Ale", 200.0));
            beers.add(new Beer("Gout Stout", 200.0));
        }
        return beers;
    }
}