import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Decoder;
import javazoom.jl.decoder.Header;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * The SongService class provides functionality to retrieve songs from a directory.
 */
public class SongService {

    /**
     * The main method of the SongService class.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        ArrayList<Song> songs = new ArrayList<Song>();

        // Populate the songs list
        SongService.GetAllSongs(songs);
    }

    /**
     * Retrieves all songs from the specified directory and populates the given list.
     *
     * @param songs The list to populate with songs.
     */
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
            // Create a Song object for each file and add it to the list
            Song song = new Song(file.getPath());
            songs.add(song);
        }
    }

}
