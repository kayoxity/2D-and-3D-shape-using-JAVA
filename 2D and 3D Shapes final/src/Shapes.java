import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
 
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Shapes extends JFrame
{
	
		JButton brushBut, lineBut, ellipseBut, rectBut, fillBut, rotBut, nothing;
		
		Graphics2D graphSettings;
                
                ArrayList<Shape> shapes = new ArrayList<Shape>();
                ArrayList<Color> shapeFill = new ArrayList<Color>();

		String clearr = "no";
		int currentAction = 1;
		
		Color fillColor=Color.BLACK;
	
        public static void main(String [] args)
        {
                new Shapes();
        }

        public Shapes()
        {
            JMenuBar mb =  new JMenuBar();
            JButton help = new JButton("Help");
            JButton info = new JButton("Team");

            mb.add(help);
            mb.add(info);
            
            this.setJMenuBar(mb);
            
            info.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame tf = new JFrame("Team Members");
                
                Box box = Box.createVerticalBox();
               
                JLabel members= new JLabel("TEAM MEMBERS");
                members.setFont(new Font("Serif", Font.BOLD, 18));
                members.setForeground(Color.blue);
                JLabel member1= new JLabel("IIT2016051          Austin Kispotta");
                JLabel member2= new JLabel("IIT2016052          Rakesh Lakra");
                JLabel member3= new JLabel("IIT2016041          Vikash Kumar");
                JLabel member4= new JLabel("LIT2016014          Arindam Pratap");
                JLabel member5= new JLabel("LIT2016012          Manisha Meena");
                member1.setAlignmentX(Component.CENTER_ALIGNMENT);
                member2.setAlignmentX(Component.CENTER_ALIGNMENT);
                member3.setAlignmentX(Component.CENTER_ALIGNMENT);
                member4.setAlignmentX(Component.CENTER_ALIGNMENT);
                member5.setAlignmentX(Component.CENTER_ALIGNMENT);
                members.setAlignmentX(Component.CENTER_ALIGNMENT);
                
                box.add(members);
                box.add(member1);
                box.add(member2);
                box.add(member3);
                box.add(member4);
                box.add(member5);
                
              
                tf.add(box);
                tf.setSize(300,300);
               tf.setVisible(true);
               //tf.setBackground(Color.blue);
            }
        });
            help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame tf = new JFrame("Help Box");
                
                Box box = Box.createVerticalBox();
                JLabel members= new JLabel("HELP BOX");
                members.setFont(new Font("Serif", Font.BOLD, 18));
                members.setForeground(Color.blue);
                JLabel member1= new JLabel("STEP 1:    Choose shape");
                JLabel member2= new JLabel("STEP 2:    Choose colour");
                JLabel member3= new JLabel("STEP 3:    Click in the canvas");
                JLabel member4= new JLabel("STEP 4:    Drag according to you will for desirable shapes.");
                JLabel member5= new JLabel("");
                member1.setAlignmentX(Component.CENTER_ALIGNMENT);
                member2.setAlignmentX(Component.CENTER_ALIGNMENT);
                member3.setAlignmentX(Component.CENTER_ALIGNMENT);
                member4.setAlignmentX(Component.CENTER_ALIGNMENT);
                member5.setAlignmentX(Component.CENTER_ALIGNMENT);
                members.setAlignmentX(Component.CENTER_ALIGNMENT);
                
                box.add(members);
                box.add(member1);
                box.add(member2);
                box.add(member3);
                box.add(member4);
                box.add(member5);
                
                
                tf.add(box);
                tf.setSize(300,300);
               // setBackground(new Color(70,80,70));
               tf.setVisible(true);
            }
        });
            
            this.setSize(800, 600);
            this.setTitle("Java Paint");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            
            Icon panelicon = new ImageIcon("./src/Panel backround.png");
            JPanel buttonPanel = new JPanel();
            Color panelbg = new Color(190,50,50);
            buttonPanel.setBackground(panelbg);
            
            Box theBox = Box.createVerticalBox();

            brushBut = makeMeColorButton("./src/Pencil selected.png", 1, false);
            lineBut = makeMeColorButton("./src/Line.png", 2, false);
            ellipseBut = makeMeColorButton("./src/Oval.png", 3, false);
            rectBut = makeMeColorButton("./src/Rectangle.png", 4, false);
            fillBut = makeMeColorButton("./src/Color.png", 5, true);
            nothing = makeMeColorButton("./src/Blank.png", 7, false);
            //clearBut = makeMeColorButton("./src/Clear.png", 8, false);
            
            brushBut.setOpaque(false);
            brushBut.setContentAreaFilled(false);
            brushBut.setBorderPainted(false);
            javax.swing.border.Border emptyBorder = BorderFactory.createEmptyBorder();
            brushBut.setBorder(emptyBorder);
            
            lineBut.setOpaque(false);
            lineBut.setContentAreaFilled(false);
            lineBut.setBorderPainted(false);
            lineBut.setBorder(emptyBorder);
            
            ellipseBut.setOpaque(false);
            ellipseBut.setContentAreaFilled(false);
            ellipseBut.setBorderPainted(false);
            ellipseBut.setBorder(emptyBorder);
            
            rectBut.setOpaque(false);
            rectBut.setContentAreaFilled(false);
            rectBut.setBorderPainted(false);
            rectBut.setBorder(emptyBorder);
            
            fillBut.setOpaque(false);
            fillBut.setContentAreaFilled(false);
            fillBut.setBorderPainted(false);
            fillBut.setBorder(emptyBorder);
            
            nothing.setOpaque(false);
            nothing.setContentAreaFilled(false);
            nothing.setBorderPainted(false);
            nothing.setBorder(emptyBorder);
            
           /* clearBut.setOpaque(false);
            clearBut.setContentAreaFilled(false);
            clearBut.setBorderPainted(false);
            clearBut.setBorder(emptyBorder);*/
            
            theBox.add(brushBut);
            theBox.add(lineBut);
            theBox.add(ellipseBut);
            theBox.add(rectBut);
            theBox.add(fillBut);
            theBox.add(nothing);
            //theBox.add(clearBut);
            
            buttonPanel.add(theBox);
            
            this.add(buttonPanel, BorderLayout.EAST);
            this.add(new DrawingBoard(), BorderLayout.CENTER);
            this.setVisible(true);
        }
        public JButton makeMeColorButton(String iconFile, final int actionNum, final boolean stroke){
        	JButton theBut = new JButton();
            Icon butIcon = new ImageIcon(iconFile);
            theBut.setIcon(butIcon);
            
            theBut.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
                                        
					if(stroke)
                                        {
						fillColor = JColorChooser.showDialog(null,  "Pick a Fill", Color.BLACK);
					}
                                        else if(actionNum < 7)
                                        {
                                            currentAction = actionNum;
                                        }
                                        
                                        if(currentAction == 1)
                                        {
                                            ImageIcon image = new ImageIcon("./src/Pencil selected.png");
                                            brushBut.setIcon(image);
                                            image = new ImageIcon("./src/Line.png");
                                            lineBut.setIcon(image);
                                            image = new ImageIcon("./src/Oval.png");
                                            ellipseBut.setIcon(image);
                                            image = new ImageIcon("./src/Rectangle.png");
                                            rectBut.setIcon(image);
                                        }
                                        else if(currentAction == 2)
                                        {
                                            ImageIcon image = new ImageIcon("./src/Pencil.png");
                                            brushBut.setIcon(image);
                                            image = new ImageIcon("./src/Line selected.png");
                                            lineBut.setIcon(image);
                                            image = new ImageIcon("./src/Oval.png");
                                            ellipseBut.setIcon(image);
                                            image = new ImageIcon("./src/Rectangle.png");
                                            rectBut.setIcon(image);
                                        }
                                        else if(currentAction == 3)
                                        {
                                            ImageIcon image = new ImageIcon("./src/Pencil.png");
                                            brushBut.setIcon(image);
                                            image = new ImageIcon("./src/Line.png");
                                            lineBut.setIcon(image);
                                            image = new ImageIcon("./src/Oval selected.png");
                                            ellipseBut.setIcon(image);
                                            image = new ImageIcon("./src/Rectangle.png");
                                            rectBut.setIcon(image);
                                        }
                                        else if(actionNum == 4)
                                        {
                                            ImageIcon image = new ImageIcon("./src/Pencil.png");
                                            brushBut.setIcon(image);
                                            image = new ImageIcon("./src/Line.png");
                                            lineBut.setIcon(image);
                                            image = new ImageIcon("./src/Oval.png");
                                            ellipseBut.setIcon(image);
                                            image = new ImageIcon("./src/Rectangle selected.png");
                                            rectBut.setIcon(image);
                                        }
                                     /*   else if(actionNum == 8)
                                        {
                                            clearr = "yes";
                                          //  drawArea.clear();
                                            clearr = "no";
                                        }
					*/
				}

                    private Shape drawRectangle(int x1, int x2, int y1, int y2) {
                        int x = Math.min(x1, x2);
                        int y = Math.min(y1, y2);

                        int width = Math.abs(x1 - x2);
                        int height = Math.abs(y1 - y2);

                        return new Rectangle2D.Float(
                                x, y, width, height);}
            });
            
            return theBut;  
        }

        private class DrawingBoard extends JComponent
        {
        	
                
                Point drawStart, drawEnd;

                public DrawingBoard()
                {
                	
                        this.addMouseListener(new MouseAdapter()
                          {
                        	
                            public void mousePressed(MouseEvent e)
                            {
                            	
                            	if(currentAction != 1){
                            	
                            	drawStart = new Point(e.getX(), e.getY());
                            	drawEnd = drawStart;
                                repaint();
                                
                            	}
                            	
                                
                            }

                            public void mouseReleased(MouseEvent e)
                                {
                            	
                            	if(currentAction != 1){
                            	
                            	Shape aShape = null;
                            	
                            	if (currentAction == 2){
                            		aShape = drawLine(drawStart.x, drawStart.y,
                            				e.getX(), e.getY());
                            	} else 
                            	
                            	if (currentAction == 3){
                            		aShape = drawEllipse(drawStart.x, drawStart.y,
                            				e.getX(), e.getY());
                            	} else 
                            	
                            	if (currentAction == 4) {
                                    aShape = drawRectangle(drawStart.x, drawStart.y,
                                    		e.getX(), e.getY());
                            	}
                                  shapes.add(aShape);
                                  shapeFill.add(fillColor);
                                  drawStart = null;
                                  drawEnd = null;
                                  repaint();
                                  
                            	}
                                  
                                }
                          } );

                        this.addMouseMotionListener(new MouseMotionAdapter()
                        {
                        	
                          public void mouseDragged(MouseEvent e)
                          {
                        	  if(currentAction == 1){
                      			
                      			int x = e.getX();
                      			int y = e.getY();
                      			
                      			Shape aShape = null;
                      			aShape = drawBrush(x,y,3,3);
                      			
                      			shapes.add(aShape);
                                  shapeFill.add(fillColor);
                      		}
                        	drawEnd = new Point(e.getX(), e.getY());
                            repaint();
                          }
                        } );
                }
                

                public void paint(Graphics g)
                {
                        graphSettings = (Graphics2D)g;
                        graphSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                        graphSettings.setStroke(new BasicStroke(4));

                        Iterator<Color> fillCounter = shapeFill.iterator();
                        /*
                        if(clearr.equals("yes"))
                        {
                            super.paintComponent(graphSettings);
                            Shape aShape = null;
                            aShape = drawRectangle(0,0,1000,1000);
                            shapes.add(aShape);
                            graphSettings.draw(aShape);
                            shapeFill.add(Color.WHITE);
                            repaint();
                        }
                        */
                        for (Shape s : shapes)
                        {
                                super.paintComponent(graphSettings);
                        	graphSettings.draw(s);
                        	graphSettings.setPaint(fillCounter.next());
                        	graphSettings.fill(s);
                        }
                        
                        if (drawStart != null && drawEnd != null)
                        {
                            graphSettings.setComposite(AlphaComposite.getInstance(
                                    AlphaComposite.SRC_OVER, 0.40f));
                        	graphSettings.setPaint(Color.LIGHT_GRAY);
                        	
                        	Shape aShape = null;
                        	
                        	if (currentAction == 2){
                        		aShape = drawLine(drawStart.x, drawStart.y,
                                		drawEnd.x, drawEnd.y);
                        	} else 
                        	
                        	if (currentAction == 3){
                        		aShape = drawEllipse(drawStart.x, drawStart.y,
                                		drawEnd.x, drawEnd.y);
                        	} else 
                        	
                        	if (currentAction == 4) {	
                                aShape = drawRectangle(drawStart.x, drawStart.y,
                                		drawEnd.x, drawEnd.y);
                        	}
                                
                                
                                graphSettings.draw(aShape);
                        }
                }

                private Rectangle2D.Float drawRectangle(
                        int x1, int y1, int x2, int y2)
                {
                        int x = Math.min(x1, x2);
                        int y = Math.min(y1, y2);

                        int width = Math.abs(x1 - x2);
                        int height = Math.abs(y1 - y2);

                        return new Rectangle2D.Float(
                                x, y, width, height);
                }
                
                private Ellipse2D.Float drawEllipse(
                        int x1, int y1, int x2, int y2)
                {
                        int x = Math.min(x1, x2);
                        int y = Math.min(y1, y2);
                        int width = Math.abs(x1 - x2);
                        int height = Math.abs(y1 - y2);

                        return new Ellipse2D.Float(
                                x, y, width, height);
                }
                
                private Line2D.Float drawLine(
                        int x1, int y1, int x2, int y2)
                {

                        return new Line2D.Float(
                                x1, y1, x2, y2);
                }
                
                private Ellipse2D.Float drawBrush(
                        int x1, int y1, int brushStrokeWidth, int brushStrokeHeight)
                {
                	
                	return new Ellipse2D.Float(
                            x1, y1, brushStrokeWidth, brushStrokeHeight);
                	
                }

        }
        
}