package playlist.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public abstract class Melody {
    private int duration;
    private String title;
    private int byteSize;
    private MusicStyle musicStyle;
    private static final int BYTE_INTO_BIT = 8;
    private Logger log = LogManager.getLogger(Melody.class);

    public Melody(int duration, String title, int byteSize, MusicStyle musicStyle) {
        this.duration = duration;
        this.byteSize = byteSize;
        this.musicStyle = musicStyle;
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getByteSize() {
        return byteSize;
    }

    public void setByteSize(int byteSize) {
        this.byteSize = byteSize;
    }

    public MusicStyle getMusicStyle() {
        return musicStyle;
    }

    public void setMusicStyle(MusicStyle musicStyle) {
        this.musicStyle = musicStyle;
    }

    public abstract void playMelody();

    public double getBitRate(){
        double bitRate = 0;
        try {
            bitRate = (duration * BYTE_INTO_BIT) / byteSize;
        } catch (ArithmeticException exception){
            log.info("Can't evaluate bitrate with bytesize is 0. "+exception.getMessage());
        }
        return bitRate;
    }

    @Override
    public String toString(){
        return "Melody [title = " + this.title + ", duration= " + duration + ", musicStyle " + musicStyle + "]\n";
    }

}
