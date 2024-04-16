/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author nazim
 */
public class MyFirstForm extends javax.swing.JFrame {

    private MusicPlayer _player = new MusicPlayer(this);
    /**
     * Creates new form MyFirstForm
     */
    public MyFirstForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        footPanel = new javax.swing.JPanel();
        musicTimeSlider = new javax.swing.JSlider();
        back = new javax.swing.JButton();
        pause_play = new javax.swing.JButton();
        rewind = new javax.swing.JButton();
        next = new javax.swing.JButton();
        startTime = new javax.swing.JLabel();
        endTime = new javax.swing.JLabel();
        volumeSlider = new javax.swing.JSlider();
        volumeDown = new javax.swing.JButton();
        volumeUp = new javax.swing.JButton();
        timeMinus = new javax.swing.JButton();
        timePlus = new javax.swing.JButton();
        musicFeatures = new javax.swing.JPanel();
        musicName = new javax.swing.JLabel();
        _artist = new javax.swing.JLabel();
        _time = new javax.swing.JLabel();
        artistName = new javax.swing.JLabel();
        timeDuration = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        _songList = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //setPreferredSize(new Dimension(874, 576));

        footPanel.setBackground(new java.awt.Color(0, 51, 51));

        back.setBackground(new java.awt.Color(0, 51, 51));
        back.setForeground(new java.awt.Color(255, 255, 0));
        back.setText("jButton1");
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        pause_play.setBackground(new java.awt.Color(0, 51, 51));
        pause_play.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        pause_play.setForeground(new java.awt.Color(255, 255, 0));
        pause_play.setText("⏯");
        pause_play.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pause_play.setMaximumSize(new java.awt.Dimension(40, 40));
        pause_play.setMinimumSize(new java.awt.Dimension(40, 40));
        pause_play.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pause_playActionPerformed(_selectedSong);
            }
        });

        rewind.setBackground(new java.awt.Color(0, 51, 51));
        rewind.setForeground(new java.awt.Color(255, 255, 0));
        rewind.setText("\uD83D\uDD04");
        rewind.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        rewind.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rewind.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repeatSong();
            }
        });

        next.setBackground(new java.awt.Color(0, 51, 51));
        next.setForeground(new java.awt.Color(255, 255, 0));
        next.setText("⏹");
        next.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopSong();
            }
        });

        musicTimeSlider.setBackground(new java.awt.Color(0, 51, 51));
        musicTimeSlider.setValue(0);
        musicTimeSlider.setEnabled(false);

        startTime.setForeground(new java.awt.Color(255, 255, 0));
        startTime.setText("00:00");

        endTime.setForeground(new java.awt.Color(255, 255, 0));
        endTime.setText("End Time");

        volumeSlider.setForeground(new java.awt.Color(255, 255, 0));
        volumeSlider.setBackground(new java.awt.Color(0, 51, 51));

        musicTimeSlider.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(_player.GetState() == PlayerState.Playing) {
                    _player.Pause();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(_player.GetState() == PlayerState.Stopped)
                {
                    return;
                }

                JSlider source = (JSlider) e.getSource();

                int frame = source.getValue();

                _player.SetPausedPosition(frame);

                _player.SetCurrentTimeInMilli((int) (frame / (2.08 * _player.GetSong().GetFrameRatePerMilliseconds())));

                _player.Play();
            }
        });

        volumeDown.setBackground(new java.awt.Color(0, 51, 51));
        volumeDown.setForeground(new java.awt.Color(255, 255, 0));
        volumeDown.setText("-");
        volumeDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volumeDownActionPerformed(evt);
            }
        });

        volumeUp.setBackground(new java.awt.Color(0, 51, 51));
        volumeUp.setForeground(new java.awt.Color(255, 255, 0));
        volumeUp.setFont(new java.awt.Font("Liberation Sans", 0, 10));
        volumeUp.setText("+");

        timeMinus.setBackground(new java.awt.Color(0, 51, 51));
        timeMinus.setForeground(new java.awt.Color(255, 255, 0));
        timeMinus.setText("⏪");
        timeMinus.setFont(new java.awt.Font("Liberation Sans", 0, 20));
        timeMinus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        timeMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeMinusActionPerformed();
            }
        });

        timePlus.setBackground(new java.awt.Color(0, 51, 51));
        timePlus.setForeground(new java.awt.Color(255, 255, 0));
        timePlus.setText("⏩");
        timePlus.setFont(new java.awt.Font("Liberation Sans", 0, 20));
        timePlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timePlusActionPerformed();
            }
        });

        javax.swing.GroupLayout footPanelLayout = new javax.swing.GroupLayout(footPanel);
        footPanel.setLayout(footPanelLayout);
        footPanelLayout.setHorizontalGroup(
            footPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(timeMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pause_play, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rewind, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timePlus, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(volumeDown, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGap(7, 7, 7)
                .addComponent(volumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(5, 5,5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(footPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(endTime)
                    .addComponent(volumeUp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(footPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(footPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startTime)
                    .addComponent(musicTimeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        footPanelLayout.setVerticalGroup(
            footPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(musicTimeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(footPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(endTime)
                    .addComponent(startTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(footPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(footPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rewind, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timePlus, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(footPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(volumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(volumeDown)
                            .addComponent(volumeUp)
                            .addComponent(timeMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pause_play, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );

        musicFeatures.setBackground(new java.awt.Color(0, 70, 70));

        musicName.setFont(new java.awt.Font("Noto Serif ExtraCondensed SemiBold", 1, 16)); // NOI18N
        musicName.setForeground(new java.awt.Color(255, 255, 0));
        musicName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        musicName.setText("Music Name");

        _artist.setForeground(new java.awt.Color(255, 255, 0));
        _artist.setText("Artist:");

        _time.setForeground(new java.awt.Color(255, 255, 0));
        _time.setText("Time:");

        artistName.setForeground(new java.awt.Color(255, 255, 0));
        artistName.setText("ArtistName");

        timeDuration.setForeground(new java.awt.Color(255, 255, 0));
        timeDuration.setText("TimeDuration");

        javax.swing.GroupLayout musicFeaturesLayout = new javax.swing.GroupLayout(musicFeatures);
        musicFeatures.setLayout(musicFeaturesLayout);
        musicFeaturesLayout.setHorizontalGroup(
            musicFeaturesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musicFeaturesLayout.createSequentialGroup()
                .addGroup(musicFeaturesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(musicFeaturesLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(musicName, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(musicFeaturesLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(musicFeaturesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(_time)
                            .addComponent(_artist))
                        .addGap(18, 18, 18)
                        .addGroup(musicFeaturesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeDuration)
                            .addComponent(artistName))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        musicFeaturesLayout.setVerticalGroup(
            musicFeaturesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musicFeaturesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(musicName, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(musicFeaturesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_artist)
                    .addComponent(artistName))
                .addGap(26, 26, 26)
                .addGroup(musicFeaturesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_time)
                    .addComponent(timeDuration))
                .addContainerGap(260, Short.MAX_VALUE))
        );


        DefaultListModel<Song> listModel = new DefaultListModel<>();

        SongService.GetAllSongs(listModel);

        songs = new javax.swing.JList<>(listModel);

        songs.setBackground(new java.awt.Color(0, 80, 80));
        songs.setForeground(new java.awt.Color(255, 255, 0));

        songs.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(_player.GetState() != PlayerState.Paused)
                {
                    setTitleArtistLabels(songs.getSelectedValue());
                    endTime.setText(songs.getSelectedValue().GetFormattedDuration());
                    _selectedSong = songs.getSelectedValue();
                    _player.Stop();
                }
            }
        });

        scrollPane.setViewportView(songs);

        songs.setCellRenderer(new CustomCellRenderer());

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        _songList.setBackground(new java.awt.Color(0, 51, 51));
        _songList.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        _songList.setForeground(new java.awt.Color(255, 255, 0));
        _songList.setText("Song List");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_songList, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(_songList))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPane)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(musicFeatures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(musicFeatures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(footPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volumeDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volumeDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_volumeDownActionPerformed

    /**
     * Handles the action when the play/pause button is clicked.
     *
     * @param song the song to be played or paused
     */
    private void pause_playActionPerformed(Song song)
    {
        if(_player.GetState() != PlayerState.Playing)
        {
            if(_selectedSong == null)
            {
                return;
            }
            sliderValueUpdated(song);
            if(_player.GetSong() == null)
            {
                _player.SetSong(song);
            }
            _player.Play();
            musicTimeSlider.setEnabled(true);
        }
        else if (_player.GetState() == PlayerState.Playing) {
            _player.Pause();
        }
    }

    /**
     * Handles the action when the time plus button is clicked.
     * Increases playback time by default duration if the player is playing.
     */
    private void timePlusActionPerformed() {
        if(_player.GetState() == PlayerState.Playing)
        {
            _player.RewindFor(true);
        }
    }

    /**
     * Handles the action when the time minus button is clicked.
     * Decreases playback time by default duration if the player is playing.
     */
    private void timeMinusActionPerformed() {
        if(_player.GetState() == PlayerState.Playing)
        {
            _player.RewindFor(false);
        }
    }


    private void sliderValueUpdated(Song song) {
        musicTimeSlider.setMaximum(song.GetMp3File().getFrameCount());
    }

    public void setStartTime(String time)
    {
        startTime.setText(time);
    }

    public void setSliderValue(int frame)
    {
        musicTimeSlider.setValue(frame);
    }



    private void setTitleArtistLabels(Song song) {
        artistName.setText(song.GetArtist());
        musicName.setText(song.GetTitle());
        timeDuration.setText(song.GetFormattedDuration());
    }

    private void stopSong()
    {
        if(_player.GetState() == PlayerState.Playing)
        {
            _player.Stop();
            musicTimeSlider.setEnabled(false);
        }
    }

    private void repeatSong()
    {
        if(_player.GetState() == PlayerState.Playing)
        {
            _player.Rewind();
        }
    }

    public int getSliderMaxValue()
    {
        return musicTimeSlider.getMaximum();
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyFirstForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyFirstForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyFirstForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyFirstForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyFirstForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel _artist;
    private javax.swing.JLabel _songList;
    private javax.swing.JLabel _time;
    public javax.swing.JLabel artistName;
    private javax.swing.JButton back;
    private javax.swing.JLabel endTime;
    private javax.swing.JPanel footPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel musicFeatures;
    private javax.swing.JLabel musicName;
    private javax.swing.JSlider musicTimeSlider;
    private javax.swing.JButton next;
    private javax.swing.JButton pause_play;
    private javax.swing.JButton rewind;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JList<Song> songs;
    private javax.swing.JLabel startTime;
    public javax.swing.JLabel timeDuration;
    private javax.swing.JButton timeMinus;
    private javax.swing.JButton timePlus;
    private javax.swing.JButton volumeDown;
    private javax.swing.JSlider volumeSlider;
    private javax.swing.JButton volumeUp;
    private Song _selectedSong;
    // End of variables declaration//GEN-END:variables
}
