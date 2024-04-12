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
    private PlayerState _state = PlayerState.Stopped;

    private int _pausedPosition;


    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        ArrayList<Song> songs = new ArrayList<Song>();

        SongService.GetAllSongs(songs);

        player.SetSong(songs.get(0));

        try {
            player.Play();
            Thread.sleep(5000);
            player.Pause();
            Thread.sleep(5000);
            player.Play();
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
        if(_state == PlayerState.Paused)
        {
            Play(_pausedPosition);
            return;
        }
        else if (_state == PlayerState.Playing)
        {
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
            _state = PlayerState.Playing;
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
        if (_state == PlayerState.Playing)
        {
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
            _state = PlayerState.Playing;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public void Pause() {
        if (_state == PlayerState.Playing) {
            _pausedPosition = _player.getPosition();
            _player.close();
            _state = PlayerState.Paused;
        }
    }

    public void Stop() {
        if (_state == PlayerState.Stopped)
        {
            return;
        }
        _player.close();
        _player = null;
        _song = null;
        _state = PlayerState.Stopped;
        _pausedPosition = 0;
    }

    public void Rewind()
    {
        if (_state == PlayerState.Stopped)
        {
            return;
        }
        Song temp = _song;
        Stop();
        _song = temp;
        Play();
    }

    /**true if front, false if back.
     * Duration in milliseconds*/
    public void RewindFor(boolean direction, int duration)
    {
        if (_state == PlayerState.Stopped)
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
