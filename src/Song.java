import com.mpatric.mp3agic.Mp3File;

import java.io.File;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

/**
 * The Song class represents a music file with associated metadata.
 */
public class Song {
    private String _title;
    private String _path;
    private String _artist;
    private long _durationInSeconds;
    private Mp3File _mp3;
    private double _frameRatePerMilliseconds;

    /**
     * Constructor for the Song class.
     *
     * @param filePath The file path of the song.
     */
    public Song(String filePath)
    {
        try {
            _mp3 = new Mp3File(filePath);

            _frameRatePerMilliseconds = (double) _mp3.getFrameCount() / _mp3.getLengthInMilliseconds();

            _durationInSeconds = _mp3.getLengthInSeconds();

            _path = filePath;

            AudioFile audioFile = AudioFileIO.read(new File(filePath));

            Tag tag =  audioFile.getTag();
            if(tag != null){
                _title = tag.getFirst(FieldKey.TITLE);
                _artist = tag.getFirst(FieldKey.ARTIST);
            }
            else{
                _title = "N/A";
                _artist = "N/A";
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Gets the title of the song.
     *
     * @return The title of the song.
     */
    public String GetTitle() {
        return _title;
    }

    /**
     * Gets the artist of the song.
     *
     * @return The artist of the song.
     */
    public String GetArtist() {
        return _artist;
    }

    /**
     * Gets the formatted duration of the song.
     *
     * @return The formatted duration of the song.
     */

    public String GetFormattedDuration() {
        long minutes = _mp3.getLengthInSeconds() / 60;
        long seconds = _mp3.getLengthInSeconds() % 60;
        String formattedTime = String.format("%02d:%02d", minutes, seconds);

        return formattedTime;
    }

    /**
     * Gets the duration of the song in seconds.
     *
     * @return The duration of the song in seconds.
     */
    public long GetDurationInSeconds() {
        return _durationInSeconds;
    }

    /**
     * Gets the file path of the song.
     *
     * @return The file path of the song.
     */
    public String GetPath() {
        return _path;
    }

    /**
     * Gets the Mp3File object representing the song.
     *
     * @return The Mp3File object representing the song.
     */
    public Mp3File GetMp3File(){
        return _mp3;
    }

    /**
     * Gets the frame rate per milliseconds of the song.
     *
     * @return The frame rate per milliseconds of the song.
     */
    public double GetFrameRatePerMilliseconds()
    {
        return _frameRatePerMilliseconds;
    }
}
