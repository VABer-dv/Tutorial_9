import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class DrawGraph extends JPanel {
//   private int MAX_SCORE;
   private static final int PREF_W = 800;
   private static final int PREF_H = 650;
   private static final int BORDER_GAP = 50;
   private static final Color GRAPH_COLOR = Color.blue;
   private static final Color GRAPH_POINT_COLOR = Color.CYAN;
   private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
   private static final int GRAPH_POINT_WIDTH = 6;
   private int Y_HATCH_CNT = 20;
   private ArrayList<Integer> time_add;
   private ArrayList<Integer> time_del;

   public DrawGraph(ArrayList<Integer> time_add, ArrayList<Integer> time_del ) {
      this.time_add = time_add;
      this.time_del = time_del;
      this.Y_HATCH_CNT = 20;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

//      if (time_del.get(0)<10)
//    	  Y_HATCH_CNT = 10;
//      else
      
      double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (time_add.size() - 1);
      double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (Y_HATCH_CNT - 1);

      List<Point> graphPoints = new ArrayList<Point>();
      List<Point> graphPoints2 = new ArrayList<Point>();
      int shift = time_add.size()/50;
      if (shift<1)
    	  shift = 1;
      
      
      int shift_text = time_add.size() / 20;
      
//      int avr=time_del.get(0);
//      for (int i=0; i<=100; i++){
//    	  avr = avr +  time_del.get(i);
//    	  System.out.println(time_del.get(i));
//      }
      
      Y_HATCH_CNT = Collections.max(time_del);
//      System.out.println(Y_HATCH_CNT+ " " + avr + " " + shift_text);
      int avr_add=0;
      int avr_del=time_del.get(0);
      for (int i = 0; i < time_add.size(); i++) {
    	  avr_add = avr_add + time_add.get(i);
    	  avr_del = avr_del + time_del.get(i);
         
          if (i%shift_text==0){
        	 int x1 = (int) (i * xScale + BORDER_GAP);
         	 int y1 = getHeight() - ((avr_add/shift * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP);
        	 graphPoints.add(new Point(x1, y1));
        	 x1 = (int) (i * xScale + BORDER_GAP);
        	 y1 = getHeight() - ((avr_del/shift * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP);
        	 graphPoints2.add(new Point(x1, y1));
        	 
        	 g2.drawString(Integer.toString(i), x1-5, getHeight() - ((-1* (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP)-30);
        	 avr_add=0;
        	 avr_del=0;
         }
      }
      graphPoints2.get(0).y = graphPoints2.get(1).y;
      g2.drawString(Integer.toString(time_add.size()), (int) (time_add.size() * xScale + BORDER_GAP)-5, getHeight() - ((-1* (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP)-30);


      // create x and y axes 
      g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
      g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);

      // create hatch marks for y axis. 
//      Y_HATCH_CNT = time.get(time.size()-1);
      for (int i = 0; i < Y_HATCH_CNT; i++) {
         int x0 = BORDER_GAP;
         int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
         int y0 = getHeight() - (((i + 1) * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP);
         int y1 = y0;
         g2.drawLine(x0, y0, x1, y1);
         g2.drawString(Integer.toString(i+1), x0 - 20, y0+5);
      }
      g2.drawString("ms", BORDER_GAP - 20, getHeight() - (((Y_HATCH_CNT ) * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP)-15);

      // and for x axis
      for (int i = 0; i < time_add.size() - 1; i=i+shift) {   	 
         int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2) / (time_add.size() - 1) + BORDER_GAP;
         int x1 = x0;
         int y0 = getHeight() - BORDER_GAP;
         int y1 = y0 - GRAPH_POINT_WIDTH;
         g2.drawLine(x0, y0, x1, y1);
      }

      Stroke oldStroke = g2.getStroke();
      g2.setColor(GRAPH_COLOR);
      g2.setStroke(GRAPH_STROKE);
      for (int i = 0; i < graphPoints.size() - 1; i++) {
         int x1 = graphPoints.get(i).x;
         int y1 = graphPoints.get(i).y;
         int x2 = graphPoints.get(i + 1).x;
         int y2 = graphPoints.get(i + 1).y;
         g2.drawLine(x1, y1, x2, y2);         
      }
      
      g2.setColor(Color.RED);
      for (int i = 0; i < graphPoints2.size() - 1; i++) {
         int x1 = graphPoints2.get(i).x;
         int y1 = graphPoints2.get(i).y;
         int x2 = graphPoints2.get(i + 1).x;
         int y2 = graphPoints2.get(i + 1).y;
         g2.drawLine(x1, y1, x2, y2);         
      }

      g2.setStroke(oldStroke);      
      g2.setColor(GRAPH_POINT_COLOR);
      for (int i = 0; i < graphPoints.size(); i++) {
         int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
         int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;;
         int ovalW = GRAPH_POINT_WIDTH;
         int ovalH = GRAPH_POINT_WIDTH;
         g2.fillOval(x, y, ovalW, ovalH);
      }
      
      g2.setColor(Color.yellow);
      for (int i = 0; i < graphPoints2.size(); i++) {
         int x = graphPoints2.get(i).x - GRAPH_POINT_WIDTH / 2;
         int y = graphPoints2.get(i).y - GRAPH_POINT_WIDTH / 2;;
         int ovalW = GRAPH_POINT_WIDTH;
         int ovalH = GRAPH_POINT_WIDTH;
         g2.fillOval(x, y, ovalW, ovalH);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   static void createAndShowGui(ArrayList<Integer> time_add, ArrayList<Integer> time_del) {
      List<Integer> scores = new ArrayList<Integer>();
      Random random = new Random();
      int maxDataPoints = 16;
      int maxScore = 20;
      for (int i = 0; i < maxDataPoints ; i++) {
         scores.add(random.nextInt(maxScore));
      }
      DrawGraph mainPanel = new DrawGraph(time_add, time_del);
      
      JFrame frame = new JFrame("DrawGraph");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }
}