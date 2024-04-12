import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Decoder;
import javazoom.jl.decoder.Header;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class Song {
    public String Title;
    public String Path;
    public String Artist;
    public int DurationInSeconds;

    public Song(String path)
    {
        Path = path;
        try {
            InputStream inputStream = new FileInputStream(Path);
            Bitstream bitstream = new Bitstream(inputStream);
            Decoder decoder = new Decoder();

            float durationInSeconds = 0.0f;

            Header header;
            while ((header = bitstream.readFrame()) != null) {
                durationInSeconds += header.ms_per_frame() / 1000.0f;
                bitstream.closeFrame();
            }
            DurationInSeconds = (int)durationInSeconds;
            bitstream.close();
            inputStream.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Some error has occurred!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
