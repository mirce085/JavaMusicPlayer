import com.mpatric.mp3agic.Mp3File;

import java.io.File;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class Song {
    private String _title;
    private String _path;
    private String _artist;
    private long _durationInSeconds;
    private Mp3File _mp3;
    private double _frameRatePerMilliseconds;

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

    public String GetTitle() {
        return _title;
    }

    public String GetArtist() {
        return _artist;
    }

    public String GetFormattedDuration() {
        long minutes = _mp3.getLengthInSeconds() / 60;
        long seconds = _mp3.getLengthInSeconds() % 60;
        String formattedTime = String.format("%02d:%02d", minutes, seconds);

        return formattedTime;
    }

    public long GetDurationInSeconds() {
        return _durationInSeconds;
    }

    public String GetPath() {
        return _path;
    }

    public Mp3File GetMp3File(){
        return _mp3;
    }
    public double GetFrameRatePerMilliseconds()
    {
        return _frameRatePerMilliseconds;
    }
}
