package playlist.runner;

import org.apache.log4j.PropertyConfigurator;
import playlist.exception.DiskMemoryException;
import playlist.model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args) {
        Melody melody1 = new Song(175, "Shape of my heart", 0, "Sting", "Sting", MusicStyle.POP);
        Melody melody2 = new Song(250, "Californication", 256, "Red hot chili peppers", "Red hot chili peppers", MusicStyle.ROCK);
        Melody melody3 = new Song(144, "Angie", 256, "The Rolling Stones", "The Rolling Stones", MusicStyle.JAZZ);
        Melody melody4 = new Sonata(675, "Moonlight Sonata", 120, "Beethoven");
        List<Melody> melodies = new ArrayList<Melody>();
        melodies.add(melody1);
        melodies.add(melody2);
        melodies.add(melody3);
        MusicAlbum musicAlbum = new MusicAlbum();

        melody1.getBitRate();

        try {
            musicAlbum.burnMelodyList(melodies);
            musicAlbum.burnNewMelody(melody4);
        } catch (DiskMemoryException e) {
            e.printStackTrace();
        }

        musicAlbum.getMelodyList();

        musicAlbum.burnAlbumToFile();

    }


}
