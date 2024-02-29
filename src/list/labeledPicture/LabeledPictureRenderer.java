/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.labeledPicture;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Subhro Ghosh
 */
public class LabeledPictureRenderer extends JPanel implements ListCellRenderer<LabeledPicture>
{
    
    private JLabel imgLabel;
    private JLabel nameLabel;

    public LabeledPictureRenderer()
    {
        Dimension size = new Dimension(50, 50);
        
        imgLabel = new JLabel();
        imgLabel.setMaximumSize(size);
        imgLabel.setMinimumSize(size);
        imgLabel.setPreferredSize(size);
        imgLabel.setSize(size);
        
        nameLabel = new JLabel();
        nameLabel.setOpaque(true);

        this.setLayout(new BorderLayout());
        this.add(imgLabel, BorderLayout.WEST);
        this.add(nameLabel, BorderLayout.CENTER);
        
    }
    

    @Override
    public Component getListCellRendererComponent(JList<? extends LabeledPicture> list, LabeledPicture value, int index, boolean isSelected, boolean cellHasFocus)
    {
        
        LabeledPicture e = (LabeledPicture)value;
        
        
        try
        {
            byte imageFileBytes[] = e.getImageFileBytes();
            ByteArrayInputStream bris = new ByteArrayInputStream(imageFileBytes);
            BufferedImage bimg = ImageIO.read(bris);
            double scale = getResizedScale(imgLabel.getWidth(), imgLabel.getHeight(), bimg.getWidth(),bimg.getHeight()) ;
            Image img = bimg.getScaledInstance((int)(bimg.getWidth() * scale), (int)(bimg.getHeight()*scale), Image.SCALE_SMOOTH) ;
            imgLabel.setIcon(new ImageIcon(img));
        } catch (IOException ex)
        {
            System.out.println("Can't read the image!");
        }
        
        nameLabel.setText(e.getImgName());
        nameLabel.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
        nameLabel.setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
        
        return this;
        
    }
    
    private double getResizedScale(int vWd, int vHt, int iWd, int iHt)
    {                                 // viewPortWidth-Heigt and imageWidth-Height
        
        if(iWd <= vWd && iHt <= vHt)
            return 1 ;
        
        double vRatio = (double) vHt / vWd ;
        double iRatio = (double) iHt / iWd ;
        double scale ;
        
        if(vRatio > iRatio)
            // fit to width
            scale = (double) vWd / iWd ;
        else
            // fit to height
            scale = (double) vHt / iHt ;
            
        return scale ;
    }
    
}
