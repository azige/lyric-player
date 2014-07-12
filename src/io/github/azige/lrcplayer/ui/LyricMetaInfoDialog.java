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

import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import io.github.azige.lrcplayer.Lyric;
import io.github.azige.lrcplayer.Lyric.LyricMetaType;

/**
 *
 * @author Azige
 */
public class LyricMetaInfoDialog extends javax.swing.JDialog{

    private final Lyric lyric;
    private final Map<JCheckBox, JTextField> map = new HashMap<>();

    /**
     * Creates new form LyricMetaInfoDialog
     */
    public LyricMetaInfoDialog(java.awt.Frame parent, boolean modal, Lyric lyric){
        super(parent, modal);
        this.lyric = lyric;
        initComponents();
        map.put(albumCheckBox, albumTextField);
        map.put(artistCheckBox, artistTextField);
        map.put(byCheckBox, byTextField);
        map.put(offsetCheckBox, offsetTextField);
        map.put(titleCheckBox, titleTextField);
        map.put(editorCheckBox, editorTextField);
        map.put(versionCheckBox, versionTextField);
        readMetaInfo(LyricMetaType.ALBUM, albumCheckBox);
        readMetaInfo(LyricMetaType.ARTIST, artistCheckBox);
        readMetaInfo(LyricMetaType.BY, byCheckBox);
        readMetaInfo(LyricMetaType.OFFSET, offsetCheckBox);
        readMetaInfo(LyricMetaType.TITLE, titleCheckBox);
        readMetaInfo(LyricMetaType.EDITOR, editorCheckBox);
        readMetaInfo(LyricMetaType.VERSION, versionCheckBox);
        setLocationRelativeTo(parent);
    }

    private void readMetaInfo(LyricMetaType type, JCheckBox checkBox){
        String info = lyric.getMeta(type);
        if (info == null){
            checkBox.setSelected(false);
            map.get(checkBox).setEnabled(false);
        }else{
            checkBox.setSelected(true);
            map.get(checkBox).setText(info);
        }
    }

    private void writeMetaInfo(LyricMetaType type, JCheckBox checkBox){
        if (checkBox.isSelected()){
            lyric.setMeta(type, map.get(checkBox).getText());
        }else{
            lyric.setMeta(type, null);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        albumCheckBox = new javax.swing.JCheckBox();
        artistCheckBox = new javax.swing.JCheckBox();
        byCheckBox = new javax.swing.JCheckBox();
        offsetCheckBox = new javax.swing.JCheckBox();
        titleCheckBox = new javax.swing.JCheckBox();
        editorCheckBox = new javax.swing.JCheckBox();
        versionCheckBox = new javax.swing.JCheckBox();
        albumTextField = new javax.swing.JTextField();
        artistTextField = new javax.swing.JTextField();
        byTextField = new javax.swing.JTextField();
        offsetTextField = new javax.swing.JTextField();
        titleTextField = new javax.swing.JTextField();
        editorTextField = new javax.swing.JTextField();
        versionTextField = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Meta Info");
        setResizable(false);

        albumCheckBox.setText("Album");
        albumCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });

        artistCheckBox.setText("Artist");
        artistCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });

        byCheckBox.setText("By");
        byCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });

        offsetCheckBox.setText("Offset");
        offsetCheckBox.setToolTipText("");
        offsetCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });

        titleCheckBox.setText("Title");
        titleCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });

        editorCheckBox.setText("Editor");
        editorCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });

        versionCheckBox.setText("Version");
        versionCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });

        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(versionCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(versionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(artistCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(artistTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(byCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(byTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(editorCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(editorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(titleCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(offsetCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(offsetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(albumCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(albumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(confirmButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {albumCheckBox, artistCheckBox, byCheckBox, editorCheckBox, offsetCheckBox, titleCheckBox, versionCheckBox});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {albumTextField, artistTextField, byTextField, editorTextField, offsetTextField, titleTextField, versionTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(albumCheckBox)
                    .addComponent(albumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artistCheckBox)
                    .addComponent(artistTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(byCheckBox)
                    .addComponent(byTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(offsetCheckBox)
                    .addComponent(offsetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleCheckBox)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editorCheckBox)
                    .addComponent(editorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(versionCheckBox)
                    .addComponent(versionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(confirmButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxActionPerformed
        JCheckBox checkBox = (JCheckBox)evt.getSource();
        map.get(checkBox).setEnabled(checkBox.isSelected());
    }//GEN-LAST:event_checkBoxActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        writeMetaInfo(LyricMetaType.ALBUM, albumCheckBox);
        writeMetaInfo(LyricMetaType.ARTIST, artistCheckBox);
        writeMetaInfo(LyricMetaType.BY, byCheckBox);
        writeMetaInfo(LyricMetaType.OFFSET, offsetCheckBox);
        writeMetaInfo(LyricMetaType.TITLE, titleCheckBox);
        writeMetaInfo(LyricMetaType.EDITOR, editorCheckBox);
        writeMetaInfo(LyricMetaType.VERSION, versionCheckBox);
        this.dispose();
    }//GEN-LAST:event_confirmButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox albumCheckBox;
    private javax.swing.JTextField albumTextField;
    private javax.swing.JCheckBox artistCheckBox;
    private javax.swing.JTextField artistTextField;
    private javax.swing.JCheckBox byCheckBox;
    private javax.swing.JTextField byTextField;
    private javax.swing.JButton confirmButton;
    private javax.swing.JCheckBox editorCheckBox;
    private javax.swing.JTextField editorTextField;
    private javax.swing.JCheckBox offsetCheckBox;
    private javax.swing.JTextField offsetTextField;
    private javax.swing.JCheckBox titleCheckBox;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JCheckBox versionCheckBox;
    private javax.swing.JTextField versionTextField;
    // End of variables declaration//GEN-END:variables
}
