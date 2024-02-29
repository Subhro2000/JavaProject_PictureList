/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.labeledPicture;

/**
 *
 * @author Subhro Ghosh
 */
public class LabeledPicture
{
    private String imgName;
    private byte imageFileBytes[];

    public LabeledPicture(String imgName, byte[] imageFileBytes)
    {
        this.imgName = imgName;
        this.imageFileBytes = imageFileBytes;
    }

    public String getImgName()
    {
        return imgName;
    }

    public byte[] getImageFileBytes()
    {
        return imageFileBytes;
    }
    
    
    
}
