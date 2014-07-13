/*
 * Copyright 2014 Azige.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.azige.lrcplayer.ui;

import io.github.azige.lrcplayer.Lyric;
import io.github.azige.lrcplayer.LyricEvent;
import io.github.azige.lrcplayer.LyricReader;
import io.github.azige.lrcplayer.LyricTimeLine;
import io.github.azige.lrcplayer.LyricTimeStamp;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Thread.UncaughtExceptionHandler;
import java.nio.charset.Charset;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import io.github.azige.lrcplayer.res.Strings;

/**
 *
 * @author Azige
 */
public class LyricPlayer extends javax.swing.JFrame{

    MediaPlayer player;
    Timer timer;
    File lrcFile;
    Lyric lrc;
    Charset charset = Charset.forName(Strings.getText("charset"));
    private LyricTimeLine timeLine;
    private LyricEvent currentEvent;
    private boolean sliderTrace = true;
    private final JFileChooser fileChooser;

    /**
     * Creates new form LyricPlayer
     */
    public LyricPlayer(){
        initComponents();
        // To init JavaFX
        new JFXPanel();
        fileChooser = new JFileChooser();
        setLocationRelativeTo(null);

        viewbuttonGroup.add(lyricRadioButtonMenuItem);
        viewbuttonGroup.add(editorRadioButtonMenuItem);
        editorPanel.setVisible(false);
        try{
            setIconImage(ImageIO.read(getClass().getResourceAsStream("/io/github/azige/lrcplayer/res/icon.jpg")));
        }catch (IOException ex){
            ex.printStackTrace();
        }
        editorPanel.lyricPlayer = this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewbuttonGroup = new javax.swing.ButtonGroup();
        stopButton = new javax.swing.JButton();
        timeLabel = new javax.swing.JLabel();
        timeLineSlider = new javax.swing.JSlider();
        totalTimeLabel = new javax.swing.JLabel();
        playToggleButton = new javax.swing.JToggleButton();
        viewPanel = new javax.swing.JPanel();
        lyricScrollPane = new javax.swing.JScrollPane();
        lyricTextArea = new javax.swing.JTextArea();
        editorPanel = new io.github.azige.lrcplayer.ui.LyricEditorPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        lyricRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        editorRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(Strings.getText("main_title")); // NOI18N
        setResizable(false);

        stopButton.setText(Strings.getText("stop")); // NOI18N
        stopButton.setEnabled(false);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        timeLabel.setText("00:00.00");

        timeLineSlider.setEnabled(false);
        timeLineSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                timeLineSliderMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                timeLineSliderMouseReleased(evt);
            }
        });

        totalTimeLabel.setText("00:00.00");

        playToggleButton.setText(Strings.getText("play")); // NOI18N
        playToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playToggleButtonActionPerformed(evt);
            }
        });

        viewPanel.setLayout(new javax.swing.OverlayLayout(viewPanel));

        lyricTextArea.setEditable(false);
        lyricTextArea.setLineWrap(true);
        lyricTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lyricScrollPane.setViewportView(lyricTextArea);

        viewPanel.add(lyricScrollPane);
        viewPanel.add(editorPanel);

        fileMenu.setText(Strings.getText("file")); // NOI18N

        openMenuItem.setText(Strings.getText("open")); // NOI18N
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        jMenuBar1.add(fileMenu);

        viewMenu.setText(Strings.getText("view")); // NOI18N

        lyricRadioButtonMenuItem.setSelected(true);
        lyricRadioButtonMenuItem.setText(Strings.getText("real-time_lyric")); // NOI18N
        lyricRadioButtonMenuItem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lyricRadioButtonMenuItemItemStateChanged(evt);
            }
        });
        viewMenu.add(lyricRadioButtonMenuItem);

        editorRadioButtonMenuItem.setText(Strings.getText("lyric_editor")); // NOI18N
        editorRadioButtonMenuItem.setEnabled(false);
        editorRadioButtonMenuItem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                editorRadioButtonMenuItemItemStateChanged(evt);
            }
        });
        viewMenu.add(editorRadioButtonMenuItem);

        jMenuBar1.add(viewMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(timeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(playToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(timeLineSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalTimeLabel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeLabel)
                    .addComponent(timeLineSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalTimeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stopButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(playToggleButton)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        stop();
    }//GEN-LAST:event_stopButtonActionPerformed

    private void timeLineSliderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeLineSliderMousePressed
        if (player != null){
            sliderTrace = false;
        }
    }//GEN-LAST:event_timeLineSliderMousePressed

    private void timeLineSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeLineSliderMouseReleased
        if (player != null){
            seek();
            refreshView(timeLineSlider.getValue());
            sliderTrace = true;
        }
    }//GEN-LAST:event_timeLineSliderMouseReleased

    private void playToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playToggleButtonActionPerformed
        if (playToggleButton.isSelected()){
            if (player == null){
                if (!openMediaFile()){
                    playToggleButton.setSelected(false);
                    return;
                }
            }
            play();
        }else{
            pause();
        }
    }//GEN-LAST:event_playToggleButtonActionPerformed

    private void lyricRadioButtonMenuItemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lyricRadioButtonMenuItemItemStateChanged
        if (lyricRadioButtonMenuItem.isSelected()){
            lyricScrollPane.setVisible(true);
        }else{
            lyricScrollPane.setVisible(false);
        }
    }//GEN-LAST:event_lyricRadioButtonMenuItemItemStateChanged

    private void editorRadioButtonMenuItemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_editorRadioButtonMenuItemItemStateChanged
        if (editorRadioButtonMenuItem.isSelected()){
            editorPanel.setVisible(true);
            editorPanel.converLyricToListModel();
        }else{
            editorPanel.setVisible(false);
            editorPanel.convertListModelToLyric();
            timeLine = new LyricTimeLine(lrc);
        }
    }//GEN-LAST:event_editorRadioButtonMenuItemItemStateChanged

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        openMediaFile();
    }//GEN-LAST:event_openMenuItemActionPerformed

    private boolean openMediaFile(){
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            File mediaFile = fileChooser.getSelectedFile();
            try{
                player = new MediaPlayer(new Media(mediaFile.toURI().toString()));
            }catch (MediaException ex){
                JOptionPane.showMessageDialog(this, ex.getLocalizedMessage());
                return false;
            }
            player.setOnReady(() -> {
                int totalTime = (int)player.getMedia().getDuration().toMillis();
                totalTimeLabel.setText(LyricTimeStamp.fromMillis(totalTime).toString());
                timeLineSlider.setMaximum(totalTime);
                timeLineSlider.setEnabled(true);
            });
            player.setOnEndOfMedia(this::stop);
            lrcFile = new File(mediaFile.getParentFile(), mediaFile.getName().replaceAll("\\.[^\\.]*$", "") + ".lrc");
            if (lrcFile.exists()){
                try{
                    lrc = new LyricReader(new InputStreamReader(new FileInputStream(lrcFile), charset)).readLyric();
                }catch (Exception ex){
                    lrc = null;
                    throw new RuntimeException(ex);
                }
            }else{
                lrc = null;
            }
            if (lrc != null){
                timeLine = new LyricTimeLine(lrc);
            }else{
                lyricTextArea.setText(Strings.getText("lyric_not_available"));
            }
            timer = new Timer(10, this::timerLisener);
            editorRadioButtonMenuItem.setEnabled(true);
            return true;
        }else{
            return false;
        }
    }

    private void play(){
        player.play();
        timer.start();
        stopButton.setEnabled(true);
    }

    private void timerLisener(ActionEvent e){
        refreshView((int)player.getCurrentTime().toMillis());
    }

    private void refreshView(int time){
        if (sliderTrace == true){
            timeLineSlider.setValue(time);
        }
        timeLabel.setText(LyricTimeStamp.fromMillis(time).toString());
        if (timeLine != null){
            timeLine.setTime(time);
            if (currentEvent != timeLine.getCurrentEvent()){
                currentEvent = timeLine.getCurrentEvent();
                lyricTextArea.setText(currentEvent.getLyric());
            }
        }
    }

    private void pause(){
        player.pause();
        timer.stop();
    }

    private void stop(){
        timer.stop();
        player.stop();
        player.seek(Duration.ZERO);
        lyricTextArea.setText("");
        timeLineSlider.setValue(0);
        timeLabel.setText("00:00.00");
        playToggleButton.setSelected(false);
        stopButton.setEnabled(false);
    }

    private void disposeMedia(){
        player.dispose();
        player = null;
        timeLine = null;
        lrc = null;
        lrcFile = null;
        timer = null;
        totalTimeLabel.setText("00:00.00");
        timeLineSlider.setMaximum(2);
        timeLineSlider.setValue(1);
        timeLineSlider.setEnabled(false);
        playToggleButton.setSelected(false);
    }

    public void seek(int time){
        if (player != null){
            timeLineSlider.setValue(time);
            seek();
        }
    }

    private void seek(){
        player.seek(Duration.millis(timeLineSlider.getValue()));
        // for synchronization
        if (timer.isRunning()){
            timer.stop();
            player.currentTimeProperty().addListener(new ChangeListener<Duration>(){

                @Override
                public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue){
                    observable.removeListener(this);
                    timer.start();
                }
            });
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try{
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if ("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch (ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(LyricPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }catch (InstantiationException ex){
            java.util.logging.Logger.getLogger(LyricPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }catch (IllegalAccessException ex){
            java.util.logging.Logger.getLogger(LyricPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }catch (javax.swing.UnsupportedLookAndFeelException ex){
            java.util.logging.Logger.getLogger(LyricPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        final Logger logger = Logger.getLogger("io.github.azige.lrcplayer");

        Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e) -> {
            logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
        });

        try{
            FileHandler fileHandler = new FileHandler("lyric-player.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            Logger rootLogger = Logger.getLogger("");
            rootLogger.addHandler(fileHandler);
        }catch (IOException ex){
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new LyricPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private io.github.azige.lrcplayer.ui.LyricEditorPanel editorPanel;
    private javax.swing.JRadioButtonMenuItem editorRadioButtonMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButtonMenuItem lyricRadioButtonMenuItem;
    private javax.swing.JScrollPane lyricScrollPane;
    private javax.swing.JTextArea lyricTextArea;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JToggleButton playToggleButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JSlider timeLineSlider;
    private javax.swing.JLabel totalTimeLabel;
    private javax.swing.JMenu viewMenu;
    private javax.swing.JPanel viewPanel;
    private javax.swing.ButtonGroup viewbuttonGroup;
    // End of variables declaration//GEN-END:variables
}
