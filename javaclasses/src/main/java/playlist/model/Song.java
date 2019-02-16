package playlist.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Song extends Melody {
    private String author;
    private String singer;
    Logger log = LogManager.getLogger(Song.class);

    public Song(int duration, String title, int byteSize, String author, String singer, MusicStyle musicStyle){
        super (duration, title, byteSize, musicStyle);
        this.author = author;
        this.singer = singer;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void playMelody() {
        log.info("Song is playing by "+singer+". The words were written by "+author);
    }
}
