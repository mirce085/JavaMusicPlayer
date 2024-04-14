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
            Song song = new Song(file.getPath());
            songs.add(song);
        }
    }

}
