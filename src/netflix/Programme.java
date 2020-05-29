/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix;

/**
 *
 * @author Poyraz
 */
public class Programme {
    private int id;
    private String name;
    private String type;
    private String genre;
    private int numberOfEpisodes;
    private int lengthOfProgramme;

    public Programme(int id, String name, String type, String genre, int numberOfEpisodes, int lengthOfProgramme) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.genre = genre;
        this.numberOfEpisodes = numberOfEpisodes;
        this.lengthOfProgramme = lengthOfProgramme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public int getLengthOfProgramme() {
        return lengthOfProgramme;
    }

    public void setLengthOfProgramme(int lengthOfProgramme) {
        this.lengthOfProgramme = lengthOfProgramme;
    }
    
   
}
