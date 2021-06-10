

package com.example.MyProject;

public class Beer {

    private String band;
    private double size;

    public Beer(String band, double size) {
        this.band = band;
        this.size = size;
    }



    public  String toString() {
        return "Beer{" +
                "band='" + band + '\'' +
                ", size=" + size +
                '}';
    }
}