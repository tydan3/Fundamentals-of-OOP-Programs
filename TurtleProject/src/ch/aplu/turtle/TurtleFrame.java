// Copyright 2002 Regula Hoefer-Isenegger
//
// This file is part of The Java Turtle Package
//
// The Java Turtle Package is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2 of the License, or
// (at your option) any later version.
//
// The Java Turtle Package is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with The Java Turtle Package; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

package ch.aplu.turtle;

import ch.aplu.turtle.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;


/** This class is used for a Turtle Application. It contains a <code>Playground</code> 
    where the <code>Turtle</code>s live.

    @author <a href="mailto:regula@hoefer.ch">Regula Hoefer-Isenegger</a>
    @version 0.1
 */
public class TurtleFrame 
    extends JFrame 
    implements TurtleContainer
{
    private Playground playground;
//      private Image background;


    /** If you want a new Window with a new Playground and specified <code>title</code>, 
	this is the constructor you need.
    */
    public TurtleFrame(String title) {
	super();
	init(title, new Playground(this));
    }
    /** If you want a new Window with a new <code>Playground</code> (with <code>width</code> and 
	<code>height</code>) and specified <code>title</code>, 
	this is the constructor you need.

	<code>width</code> and <code>height</code> belong to the <code>Playground</code>!!
    */
    public TurtleFrame(String title, int width, int height){
	super();
	Dimension size = new Dimension(width, height);
	init(title, new Playground(this, size));
    }
    /** New Window with specified <code>Playground</code>.
     */
    public TurtleFrame(String title, Playground playground){
	super();
	init(title, playground);
    }
    /** New Window with no title and new <code>Playground</code>.
     */
    public TurtleFrame() {
	super();
	String title = "";
	init(title, new Playground(this));
    }
    /** New Window with no title and new <code>Playground</code> with <code>width</code> and 
	<code>height</code>.

	<code>width</code> and <code>height</code> belong to the <code>Playground</code>!!
    */
    public TurtleFrame(int width, int height){
	super();
	Dimension size = new Dimension(width, height);
	String title = "";
	init(title, new Playground(this, size));
    }
    /** New Window with no title and specified <code>Playground</code>
    */
    public TurtleFrame(Playground playground){
	super();
	String title = "";
	init(title, playground);
    }


    /** */
    protected void init(String title, 
			Playground playground){
	this.playground = playground;
	super.setTitle(title);
	this.getContentPane().add(playground);
	setResizable(false);
//  	setLocationRelativeTo(null);
	setLocation();	
//  	this.background = new BufferedImage(playground.getWidth(), 
//  				       playground.getHeight(), 
//  				       BufferedImage.TYPE_4BYTE_ABGR );
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.pack();
	this.show();
    }
    /** If you don't want the Windows to appear on the center of the screen,
     override this method.
    */
    protected void setLocation(){
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension appSize = this.getPreferredSize();
	int locX = (screenSize.width - appSize.width)/2;
	int locY = (screenSize.height - appSize.height)/2;
	this.setLocation(locX, locY);
    }
    /** returns the playground of this TurtleFrame.
     */
    public Playground getPlayground(){
	return this.playground;
    }
}













