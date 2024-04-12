import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Header;
import javazoom.jl.player.Player;
import jdk.jfr.Description;


public class MusicPlayer
{
    private Player _player;
    private Song _song; //Aggregation


    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        ArrayList<Song> songs = new ArrayList<Song>();

        Song song = new Song("Songs" + File.separator + "sinister-156638.mp3");

        player.SetSong(song);

        try {
            player.Play();
            Thread.sleep(5000);
            player.Rewind();
        }
        catch (Exception e)
        {

        }
    }

    public Song GetSong()
    {
        return _song;
    }

    public void SetSong(Song song)
    {
        // Here can be some checking
        _song = song;
    }

    public void Play()
    {
        if(_song == null)
        {
            JOptionPane.showMessageDialog(null, "Select music!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try
        {
            FileInputStream inputStream = new FileInputStream(_song.Path);
            _player = new Player(inputStream);
            new Thread(() -> {
                try {
                    _player.play();
                } catch (Exception e) {
                    return;
                }
            }).start();
        }
        catch (Exception e)
        {
            return;
        }
    }

    private void Play(int skip)
    {
        if(_song == null)
        {
            JOptionPane.showMessageDialog(null, "Select music!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try
        {
            FileInputStream inputStream = new FileInputStream(_song.Path);
            long a = inputStream.skip(skip);
            _player = new Player(inputStream);
            new Thread(() -> {
                try {
                    _player.play();
                } catch (Exception e) {
                    return;
                }
            }).start();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public void Pause() {
        if (_player != null) {
            _player.close();
        }
    }

    public void Stop() {
        if (_player == null)
        {
            return;
        }
        _player.close();
        _player = null;
        _song = null;

    }

    public void Rewind()
    {
        if (_player == null)
        {
            return;
        }
        Song temp = _song;
        Stop();
        _song = temp;
        Play();
    }

    /**true if front, false if back.\nDuration in milliseconds*/
    public void RewindFor(boolean direction, int duration)
    {
        if (_player == null)
        {
            return;
        }
        Pause();
        int currentPosition = _player.getPosition();
        int newPosition;
        if(direction)
        {
            newPosition = Math.min(_song.DurationInSeconds * 1000, currentPosition + duration);
        }
        else
        {
            newPosition = Math.max(0, currentPosition - duration);
        }
        Play(newPosition);
    }

    /**true if front, false if back*/
    public void RewindFor(boolean direction) // by default, it will be 5 seconds
    {
        if (_player == null)
        {
            return;
        }
        Pause();
        int currentPosition = _player.getPosition();
        int newPosition;
        if(direction)
        {
            newPosition = Math.min(_song.DurationInSeconds * 1000, currentPosition + 5000);
        }
        else
        {
            newPosition = Math.max(0, currentPosition - 5000);
        }
        Play(newPosition);
    }
}
