/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package list.labeledPicture;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Subhro Ghosh
 */
public class LabeledPictureList extends javax.swing.JFrame
{

    /**
     * Creates new form LabeledPictureList
     */
    
    private DefaultListModel<LabeledPicture> model;
    private File imgFile;
    private byte[] imgFileByteArray;
    
    private File listFile;
    private final int FIXED_LABEL_LENGTH = 100;  //100byte
    private final int FIXED_PICTURE_LENGTH = 256*1024; //256 kb
    private static String recentPicPath = "C:\\Users\\Subhro Ghosh\\Downloads";
    
    
    public LabeledPictureList()
    {
        initComponents();
        
        imgList.setCellRenderer(new LabeledPictureRenderer());
        imgList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        model = new DefaultListModel<>();
        imgList.setModel(model);
        
        listFile = new File("List.dat");
        
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        imgList = new javax.swing.JList<>();
        imgAddress = new javax.swing.JTextField();
        btnChoose = new javax.swing.JButton();
        imgLabel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        jScrollPane1.setViewportView(imgList);

        btnChoose.setText("...");
        btnChoose.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnChooseActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoveActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("PICTURE LIST");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(imgAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRemove)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel2)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imgAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChoose)
                    .addComponent(btnAdd))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove)
                    .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(66, 66, 66))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnChooseActionPerformed
    {//GEN-HEADEREND:event_btnChooseActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(recentPicPath));
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileFilter filter1  = new FileNameExtensionFilter("JPEG Files", "JPG", "JPEG", "jpe", "jiff");
        chooser.addChoosableFileFilter(filter1);
        
        FileFilter filter2 = new FileNameExtensionFilter("BITMAP Files", ".bmp");
        chooser.addChoosableFileFilter(filter2);
        
//        chooser.addChoosableFileFilter(new FileFilter()
//        {
//            @Override
//            public boolean accept(File f)
//            {
//                return f.length() < FIXED_PICTURE_LENGTH;
//            }
//
//            @Override
//            public String getDescription()
//            {
//                return "subhro";
////                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//
//        });
        
        int result = chooser.showOpenDialog(this);
        
        if(result == JFileChooser.APPROVE_OPTION)
        {
            imgFile =chooser.getSelectedFile(); 
            recentPicPath = chooser.getCurrentDirectory().getAbsolutePath();
        }
        
        imgAddress.setText(imgFile.getName());
        
    }//GEN-LAST:event_btnChooseActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        // TODO add your handling code here:
        DataOutputStream dos = null;
        
        try
        {
            dos = new DataOutputStream(new FileOutputStream(listFile));
            
            for (int i = 0; i < model.getSize(); i++)
            {
                saveRecord(dos, imgList.getModel().getElementAt(i));
            }
            dos.close();
        } catch (Exception ex)
        {
            System.out.println("can't save the file");
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddActionPerformed
    {//GEN-HEADEREND:event_btnAddActionPerformed
        // TODO add your handling code here:
         String name = imgLabel.getText();
        
        //converting an imagefile to a bytearray
        try
        {
            FileInputStream fis = new FileInputStream(imgFile);
            imgFileByteArray = new byte[(int)imgFile.length()];
            fis.read(imgFileByteArray);
            fis.close();
        } catch (Exception ex)
        {
        }
        model.addElement(new LabeledPicture(name, imgFileByteArray));
        JOptionPane.showMessageDialog(this, "Picture Added");
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        // TODO add your handling code here:
        loadRecords();
    }//GEN-LAST:event_formWindowOpened

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRemoveActionPerformed
    {//GEN-HEADEREND:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        model.removeElement(imgList.getSelectedValue());
        
    }//GEN-LAST:event_btnRemoveActionPerformed

    
    private void loadRecords()
    {
        
        if(!listFile.exists())
            return;
        
        System.out.println("Loading.....");
        DataInputStream dis = null;
        long len = listFile.length();
        int recordSize = 1+100+4+(256*1024);
        int rlen = (int)len/recordSize;
        
        try
        {
            dis= new DataInputStream(new FileInputStream(listFile));
            
            for (int i = 0; i < rlen; i++)
            {
                LabeledPicture lb = loadRecord(dis);
                model.addElement(lb);
            }
            dis.close();
        } catch (Exception ex)
        {
            System.out.println("Can't load the list");
        }
    }
    
                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(LabeledPictureList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(LabeledPictureList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(LabeledPictureList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(LabeledPictureList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new LabeledPictureList().setVisible(true);
            }
        });
    }
    
    
    private void saveRecord(DataOutputStream out, LabeledPicture record) throws IOException
     {
        
        //save label 
        byte byts[] = record.getImgName().getBytes();
        byte strlen = (byte)byts.length;
        out.write(strlen); // 1byte for label length
        out.write(byts); //100 byte for label
        
        //label padding
        byte strbytes[] = new byte[FIXED_LABEL_LENGTH];
        out.write(strbytes,0,FIXED_LABEL_LENGTH-byts.length);

        //now write image content to file
        byte fileBytes[] = record.getImageFileBytes();
        int piclen = fileBytes.length;
        out.writeInt(piclen); // 4 byte for image length
        out.write(fileBytes); // 256kb for image
        
        //Extra padding
        while(piclen++ < FIXED_PICTURE_LENGTH)
            out.write(0);
        
    }
    
    private LabeledPicture loadRecord(DataInputStream dis) throws IOException
    {
        //read the image label 
        byte strlen = dis.readByte();
        byte strbyts[] = new byte[strlen];
        dis.read(strbyts);
        String s = new String(strbyts);
        dis.skipBytes(FIXED_LABEL_LENGTH-strbyts.length);
        
        //read the picture
        int imglen = dis.readInt();
        byte imgbr[] = new byte[imglen];
        dis.read(imgbr);
        dis.skipBytes(FIXED_PICTURE_LENGTH-imgbr.length);
        
        LabeledPicture lbpic = new LabeledPicture(s, imgbr);
        return lbpic;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnRemove;
    private javax.swing.JTextField imgAddress;
    private javax.swing.JTextField imgLabel;
    private javax.swing.JList<list.labeledPicture.LabeledPicture> imgList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
