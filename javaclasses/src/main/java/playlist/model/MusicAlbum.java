package playlist.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import playlist.exception.DiskMemoryException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MusicAlbum {
    private List<Melody> melodyList;
    private static final double CD_SIZE_MB = 700.0;
    private Logger log = LogManager.getLogger(MusicAlbum.class);

    public MusicAlbum (){
    }

    public List<Melody> getMelodyList(){
        return melodyList;
    }

    public double getAlbumSizeMB() {
        double albumSizeMB = 0.0;
        for (Melody melody: melodyList){
            albumSizeMB+=melody.getByteSize();
        }
        return albumSizeMB;
    }

    public void burnMelodyList(List<Melody> melodyList) throws DiskMemoryException {
        this.melodyList = melodyList;
        if(getAlbumSizeMB() > CD_SIZE_MB){
            throw new DiskMemoryException("The disk size is exceeded!");
        }
    }

    public void burnNewMelody(Melody melody) throws DiskMemoryException {
        if (getAlbumSizeMB() + melody.getByteSize() > CD_SIZE_MB){
            throw new DiskMemoryException("The disk size is exceeded! Couldn't add new melody");
        }
        melodyList.add(melody);
    }

    public int getTimeDuration(){
        int timeSize = 0;
        for (Melody melody : melodyList){
            timeSize += melody.getDuration();
        }
        return timeSize;
    }

    public List<Melody> getMelodyListByStyle(MusicStyle style){
        List<Melody> melodies = new ArrayList<Melody>();
        for (Melody melody : melodyList){
            if (melody.getMusicStyle().equals(style)){
                melodies.add(melody);
            }
        }
        return melodies;
    }

    public List<Melody> getMelodyListByDuration(int minDuration, int maxDuration){
        List<Melody> melodies = new ArrayList<Melody>();
        for (Melody melody: melodyList){
            if (melody.getDuration()> minDuration && melody.getDuration()<maxDuration){
                melodies.add(melody);
            }
        }
        return melodies;
    }

    public void burnAlbumToFile() {
        File albumFile = new File("C:\\data\\JAVA.-ERROR-EXCEPTIONS\\musicAlbum.txt");
        try {
            albumFile.createNewFile();
        } catch (IOException e) {
            log.warn("Can't create new file! " + e.getMessage());
        }

        FileWriter writer;
        try {
            writer = new FileWriter(albumFile);
            for (Melody melody : melodyList) {
                writer.write(melody.toString());
                writer.flush();
            }
        } catch (IOException e) {
            log.warn("Can't write melodies to album " + e.getMessage());
        }

    }

}
