import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Header;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;
import jdk.jfr.Description;
import com.mpatric.mp3agic.Mp3File;


public class MusicPlayer extends PlaybackListener
{
    private AdvancedPlayer _player;
    private Song _song; //Aggregation
    private PlayerState _state = PlayerState.Stopped;
    private Thread _playThread;
    private int _pausedPosition;
    private Mp3File _mp3File;


    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        ArrayList<Song> songs = new ArrayList<Song>();

        SongService.GetAllSongs(songs);

        player.SetSong(songs.get(0));

        try {
            player.Play();
            Thread.sleep(5000);
            player.Rewind();
            Thread.sleep(2000);
            player.Play();
            Thread.sleep(5000);
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
        else if (_state == PlayerState.Playing)
        {
            return;
        }

        try
        {
            FileInputStream fileInputStream = new FileInputStream(_song.GetPath());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            _player = new AdvancedPlayer(bufferedInputStream);
            _player.setPlayBackListener(this);

            StartPlayThread();
            Thread.sleep(1000);
            _state = PlayerState.Playing;
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    private void StartPlayThread()
    {
        new Thread(() -> {
            try
            {
                if (_state == PlayerState.Paused)
                {
                    _player.play(_pausedPosition, Integer.MAX_VALUE);
                }
                else
                {
                    _player.play();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }).start();
    }


    public void Pause() {
        if (_state == PlayerState.Playing) {
            _state = PlayerState.Paused;
            _player.stop();
            _player.close();
            _player = null;
        }
    }

    public void Stop() {
        if (_state == PlayerState.Stopped)
        {
            return;
        }
        _player.stop();
        _player.close();
        _player = null;
        _song = null;
        _state = PlayerState.Stopped;
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
        long newPosition;
        if(direction)
        {
            newPosition = Math.min(_song.GetDurationInSeconds() * 1000, (long)(_pausedPosition / _song.GetFrameRatePerMilliseconds()) + duration);
        }
        else
        {
            newPosition = Math.max(0, (long)(_pausedPosition / _song.GetFrameRatePerMilliseconds()) - duration);
        }
        _pausedPosition = (int)((double) newPosition * _song.GetFrameRatePerMilliseconds());
        Play();
    }

    /**true if front, false if back*/
    public void RewindFor(boolean direction) // by default, it will be 5 seconds
    {
        if (_player == null)
        {
            return;
        }
        Pause();
        long newPosition;
        if(direction)
        {
            newPosition = Math.min(_song.GetDurationInSeconds() * 1000, (long)(_pausedPosition / _song.GetFrameRatePerMilliseconds()) + 5000);
        }
        else
        {
            newPosition = Math.max(0, (long)(_pausedPosition / _song.GetFrameRatePerMilliseconds()) - 5000);
        }
        _pausedPosition = (int)((double) newPosition * _song.GetFrameRatePerMilliseconds());
        Play();
    }


    @Override
    public void playbackFinished(PlaybackEvent evt) {
        if(_song != null)
        {
            _pausedPosition += (int) ((double) evt.getFrame() * _song.GetFrameRatePerMilliseconds());
        }
    }
}
