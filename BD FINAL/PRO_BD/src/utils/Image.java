/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class Image extends JPanel {
	int x;
	int y;
	public Image(int x,int y) {
		setBackground(Color.LIGHT_GRAY);
        this.x=x;
        this.y=y;
	}
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
        arg0.drawImage(Tools.loadImage("utils/fondo.jpg"),0,0,x,y,null);
	}

}

