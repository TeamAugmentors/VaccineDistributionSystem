/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Color;

/**
 *
 * @author Lassassin
 */
public class ColorEx extends Color{
    
    public static final Color MY_BLUE = Color.decode("#029CD8");
    public static final Color MY_DARK_GREY = Color.decode("#27292A");
    public static final  Color MY_TEXT_GREY = Color.decode("#BBBBBB");
    public static final  Color MY_ERROR_RED =  Color.decode("#E00000");
    
    public ColorEx(int rgb) {
        super(rgb);
    }
    
    
}
