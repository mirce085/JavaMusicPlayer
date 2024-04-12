import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Decoder;
import javazoom.jl.decoder.Header;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SongService {

    public static void main(String[] args) {
        ArrayList<Song> songs = new ArrayList<Song>();

        SongService.GetAllSongs(songs);
    }

    public static void GetAllSongs(List<Song> songs)
    {
        File directory = new File("Songs");

        File[] files = directory.listFiles();

        if(files == null)
        {
            return;
        }

        for(File file : files)
        {
            Song song = new Song();
            song.Title = file.getName();
            song.Path = file.getPath();
            song.DurationInSeconds = GetSongDuration(song.Path);

            songs.add(song);
        }
    }

    public static int GetSongDuration(String path)
    {
        try {
            InputStream inputStream = new FileInputStream(path);
            Bitstream bitstream = new Bitstream(inputStream);
            Decoder decoder = new Decoder();

            float durationInSeconds = 0.0f;

            Header header;
            while ((header = bitstream.readFrame()) != null) {
                durationInSeconds += header.ms_per_frame() / 1000.0f;
                bitstream.closeFrame();
            }

            bitstream.close();
            inputStream.close();

            return (int)durationInSeconds;
        }
        catch (Exception e)
        {
            return -1;
        }
    }
}
