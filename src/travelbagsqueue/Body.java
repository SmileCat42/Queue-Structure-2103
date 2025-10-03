/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package travelbagsqueue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
/**
 *
 * @author Windows10
 */
public class Body extends javax.swing.JFrame {
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Body.class.getName());

    final int size=8;  
   int FRONT=6,current=6,REAR=2,N=5;
   Bag ITEM;
        
   public static class Bag{
       public String name;
       public int bagtype;
       public int id;
       public double weight;
       
       public void setAll(int a, int b, double c, String d){
           bagtype=a;
           id=b;
           weight=c;
           name=d;
       }
   }
   public static Bag[] QUEUE = new Bag[8];
      static {
        for (int i = 0; i < 8; i++) {
            QUEUE[i] = new Bag();
        }
      
   QUEUE[6].setAll(1,1034,26.8,"GR");
   QUEUE[7].setAll(2,2245,20.2,"RN");
   QUEUE[0].setAll(3,3489,24.6,"AS");
   QUEUE[1].setAll(1,1157,27.3,"SB");
   QUEUE[2].setAll(2,2410,18.9,"KM");
      }
     public  boolean QINSERT(Bag item){
     ITEM=item; 
    if(REAR==N || REAR+1==FRONT){
       System.out.println("QUEUE FULL");
       return false; //Can not insert
    }
    else
     if(FRONT==-1){   //NULL concept
       FRONT=0; REAR=0;
     }else if(REAR==7){
         REAR=0;
     }else{
       REAR++;
     }
    QUEUE[REAR]=ITEM;
    return true;
  }    
       public boolean QDELETE(){
    if(FRONT==-1){
      System.out.println("Empty queue");
      return false;
    }
    ITEM=QUEUE[FRONT];
    if(FRONT==REAR){
        FRONT=-1;
        REAR=-1;
    }else if(FRONT==size-1){
        FRONT=0;
    }else{
        FRONT++;
    }
    return true;
  }
 public void showDatainQueue(){
     System.out.print("Data in Queue:");
     for(int i=0;i<=REAR;i++){
        System.out.print(QUEUE[i]+","); 
        jTextArea1.setText(jTextArea1.getText()+"-"+QUEUE[i]);
     }   
     System.out.println();
     System.out.println("FRONT:"+FRONT);
     System.out.println("REAR:"+REAR);
 } 
 public void showTable() {
    current=FRONT;
    for(int i=0;i<N;i++){
            jTable1.setValueAt(QUEUE[current].name, 0, current);
            current++;
            if(current==8){
                current=0;
            }
        }
    
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        centerRenderer.setVerticalAlignment(SwingConstants.CENTER);
        for(int i = 0; i < jTable1.getColumnCount(); i++){
        jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }
}
 public void showArea(){
     jTextArea1.setText("NAME : "+QUEUE[FRONT].name+"\nBag type : "+QUEUE[FRONT].bagtype
     +"\nTicket Number : "+QUEUE[FRONT].id+"\nWeight : "+QUEUE[FRONT].weight);
     
     jTextArea1.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
     jTextArea1.setBackground(new Color(255, 228, 225)); // สีชมพูอ่อน
    jTextArea1.setForeground(Color.DARK_GRAY);  
    jTextArea1.setBorder(BorderFactory.createLineBorder(Color.PINK, 2, true));
    jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
 }
 public void setPic(){
     if(FRONT==-1){
         jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nodata.png")));
         return;
     }
}
 public void showBill(){
     if(FRONT==-1){
         return;
     }
    double std,w,total,pu;
    String over="Over : ";
    if(QUEUE[FRONT].bagtype==1){
        std=25.5;
        w=(QUEUE[FRONT].weight)-std;
        pu=800;
    }else if(QUEUE[FRONT].bagtype==2){
        std=23.8;
        w=(QUEUE[FRONT].weight)-std;
        pu=700;
}else if(QUEUE[FRONT].bagtype==2){
        std=24;
        w=(QUEUE[FRONT].weight)-std;
        pu=600;
}else{
        std=25;
        w=(QUEUE[FRONT].weight)-std;
        pu=750;
}
    jLabel9.setForeground(Color.BLACK);
    if(w<0){
    over="Not over : ";
    w=0;
}

total=100+(pu*w);

    jLabel8.setText("Standard : "+std+" kg");
jLabel9.setText(""+over+String.format("%.2f", w)+" kg");
if(w>0){
    jLabel9.setForeground(Color.RED);
}
jLabel10.setText("Total : "+String.format("%.2f", total)+" baht");
}
public void showPic(){
    if(FRONT==-1){
         jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nodata.png")));
         return;
     }
     if(QUEUE[FRONT].bagtype==1){
         jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/suitcase.jpg")));
     }else if(QUEUE[FRONT].bagtype==2){
         jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/packup.jpg")));
     }else if(QUEUE[FRONT].bagtype==3){
         jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backpack2.jpg")));
     }else{
         jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nodata.png")));
     }
 }
         public int checkValue(Object value) {
    int res=-1;
    if (value instanceof String) {
        String str = (String) value;
        
        try {
            // ถ้าแปลงเป็นเลขได้ แสดงว่าไม่ใช่ pure string
            res=Integer.parseInt(str);
            System.out.println("This is a number: " + str);
        } catch (NumberFormatException e) {
            // ถ้าแปลงไม่ได้ = เป็นข้อความ
            System.out.println("This is a String: " + str);
            return res; // ออกจากฟังก์ชัน
        }
    } else {
        // กรณีเป็น object อื่นๆ
        System.out.println("Not a string: " + value);
    }
    return res;
}
         
    
    public Body() {
        initComponents();
            showTable();
            showArea();
            jLabel2.setText("FRONT : "+FRONT);
            jLabel3.setText("REAR : "+REAR);
            showPic();
            showBill();
            jTable1.setRowHeight(40);   // กำหนดความสูงแถว
        jTable1.setFont(new Font("SansSerif", Font.BOLD, 18));
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
    jTable1.getColumnModel().getColumn(i).setPreferredWidth(60); // กว้างพอดี 2 ตัวอักษร
        }
        
        
        
        UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.PLAIN, 14));
        UIManager.put("OptionPane.buttonFont", new Font("Tahoma", Font.PLAIN, 14));
        
       ImageIcon icon = new ImageIcon(getClass().getResource("/image/blackground9.jpg"));

Image img = icon.getImage();
Image newImg = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);

// ใส่ลง JLabel
ImageIcon scaledIcon = new ImageIcon(newImg);
JLabel bgLabel = new JLabel(scaledIcon);

// ขยายเต็มเฟรม
bgLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
bgLabel.setOpaque(true);

jLayeredPane1.add(bgLabel, JLayeredPane.DEFAULT_LAYER);
this.setSize(jLayeredPane1.getPreferredSize()); 
    this.setResizable(false); // ไม่ให้ยืด
    this.setLocationRelativeTo(null); // จอกลาง

        jTable1.setGridColor(new Color(200, 200, 200));  // เส้นจาง ๆ
jTable1.setShowGrid(true);
jTable1.setBackground(new Color(245, 245, 250)); // สีพื้นหลังอ่อน
jTable1.setForeground(new Color(50, 50, 50));    // สีตัวอักษรเข้ม

JTableHeader header = jTable1.getTableHeader();
header.setFont(new Font("SansSerif", Font.BOLD, 16));

DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
headerRenderer.setBackground(new Color(206, 6, 249)); // น้ำเงินโคบอลต์
headerRenderer.setForeground(Color.WHITE);
headerRenderer.setHorizontalAlignment(JLabel.CENTER);

for (int i = 0; i < jTable1.getColumnModel().getColumnCount(); i++) {
    jTable1.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
}

jLabel1.setBorder(BorderFactory.createLineBorder(new Color(200,200,200), 2, true)); 
jLabel1.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0,0,4,4,new Color(180,180,180)), // เงาด้านล่าง+ขวา
        BorderFactory.createLineBorder(Color.WHITE, 2, true)              // กรอบขาวโค้งมน
));

jPanel1.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true));
jPanel2.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true));
jPanel4.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true));

jPanel1.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(180, 180, 180)),
        BorderFactory.createLineBorder(Color.WHITE, 2, true)
));
jPanel2.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(180, 180, 180)),
        BorderFactory.createLineBorder(Color.WHITE, 2, true)
));
jPanel4.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(180, 180, 180)),
        BorderFactory.createLineBorder(Color.WHITE, 2, true)
));


}
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel2 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                GradientPaint gp = new GradientPaint(
                    0, 0, new Color(255, 182, 193),   // ชมพูอ่อนด้านบน
                    0, getHeight(), new Color(255, 253, 254) // ม่วงลาเวนเดอร์ด้านล่าง
                );
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                GradientPaint gp = new GradientPaint(
                    0, 0, new Color(255, 182, 193),   // ชมพูอ่อนด้านบน
                    0, getHeight(), new Color(255, 253, 254) // ม่วงลาเวนเดอร์ด้านล่าง
                );
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                GradientPaint gp = new GradientPaint(
                    0, 0, new Color(255, 182, 193),   // ชมพูอ่อนด้านบน
                    0, getHeight(), new Color(255, 253, 254) // ม่วงลาเวนเดอร์ด้านล่าง
                );
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
            }
        };
        ;
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Curlz MT", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "check bill", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jButton1.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1840744 (1).png"))); // NOI18N
        jButton1.setText("Paid");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Chakra Petch SemiBold", 0, 14)); // NOI18N
        jLabel8.setText("Standard :");

        jLabel9.setFont(new java.awt.Font("Chakra Petch SemiBold", 0, 14)); // NOI18N
        jLabel9.setText("Over :");

        jLabel10.setFont(new java.awt.Font("Chakra Petch SemiBold", 1, 16)); // NOI18N
        jLabel10.setText("Total :");

        jLabel11.setFont(new java.awt.Font("Chakra Petch SemiBold", 0, 14)); // NOI18N
        jLabel11.setText("    Fee : 100 baht");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Insert", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("INSERT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Name");

        jLabel5.setText("Bag type");

        jLabel6.setText("Ticket Number");

        jLabel7.setText("Weight");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jTextField1)
                    .addComponent(jTextField4))
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "0", "1", "2", "3", "4", "5", "6", "7"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("FRONT = -");

        jLabel3.setText("REAR = -");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(0, 96, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLayeredPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(REAR+1==FRONT){
            System.out.println("QUEUE full");
            JOptionPane.showMessageDialog(null, "QUEUE full ");
            return;
        }
        String tf1=jTextField1.getText();
        int tf2=checkValue(jTextField2.getText());
        int tf3=checkValue(jTextField3.getText());
        int tf4=checkValue(jTextField4.getText());
        if(!tf1.matches("[A-Z]+" )){
            System.out.println("recomment change name to short form 2 upper charactor ");
            JOptionPane.showMessageDialog(null, "กรุณาใส่ชื่อย่อ ภาษาอังกฤษพิมพ์ใหญ่ 2 ตัวอักษรค่ะ");
            return;
        }
        if(tf2==-1){
            System.out.println("Pls take number for bag type");
             JOptionPane.showMessageDialog(null, "กรอกตัวเลขที่ช่องประเภทของกระเป๋าค่ะ ");
             return;
        }
        if(tf2<1 || tf2>3){
            System.out.println("Pls take number for bag type 1-3");
             JOptionPane.showMessageDialog(null, "กรอกประเภทของกระเป๋า 1-3 ค่ะ ");
             return;
        }
        if(tf3==-1){
            System.out.println("Pls take number for ticket number");
             JOptionPane.showMessageDialog(null, "กรอกตัวเลขที่ช่องหมายเลขตั๋วค่ะ ");
             return;
        }
        if(tf3<1000 || tf3>9999){
            System.out.println("Pls take number ticket 1000-9999");
             JOptionPane.showMessageDialog(null, "กรอกหมายเลขตั๋วตั้งแต่ 1000-9999 ค่ะ ");
             return;
        }
        for(int i=0;i<N;i++){
            if(tf3==QUEUE[i].id){
                System.out.println("This ticket number exist already");
                 JOptionPane.showMessageDialog(null, "หมายเลขตั๋วนี้อยู่ในคิวแล้วค่ะ");
                 return;
            }
        }
        if(tf4==-1){
            System.out.println("Pls take number for weight");
             JOptionPane.showMessageDialog(null, "กรอกตัวเลขที่ช่องน้ำหนักค่ะ ");
             return;
        }
        if(tf4<0 || tf4>60){
            System.out.println("Pls take weight between 0-60 (0=no luggage)");
             JOptionPane.showMessageDialog(null, "กรอกน้ำหนักตั้งแต่ 0-60 ค่ะ (0 คือไม่มีสัมภาระค่ะ) ");
             return;
        }
        if(FRONT==-1){
        if(REAR==FRONT){
            FRONT=REAR=0;
            Bag ins=new Bag();
            
        ins.name=tf1;
        ins.bagtype=tf2;
        ins.id=tf3;
        ins.weight=tf4;
        QUEUE[REAR]=ins;
        N++;
        showTable();
        System.out.println("Insert data complete");
        jLabel2.setText("FRONT : "+FRONT);
            jLabel3.setText("REAR : "+REAR);
        return;
        }
        }
        
        Bag ins=new Bag();
        ins.name=tf1;
        ins.bagtype=tf2;
        ins.id=tf3;
        ins.weight=tf4;
        QINSERT(ins);
        N++;
        showTable();
        System.out.println("Insert data complete");
        jLabel2.setText("FRONT : "+FRONT);
            jLabel3.setText("REAR : "+REAR);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(FRONT==-1){
           System.out.println("QUEUE empty");
           JOptionPane.showMessageDialog(null, "QUEUE empty ");
            return;
        }
        
        if(REAR==FRONT){
            QUEUE[FRONT]=null;
            QUEUE[FRONT]=new Bag();
            jTable1.setValueAt("", 0, FRONT);
            showArea();
        System.out.println("Delete data complete");
            FRONT=REAR=-1;
            jLabel2.setText("FRONT : "+FRONT);
            jLabel3.setText("REAR : "+REAR);
            showPic();
            showBill();
            return;
        }
        
        int pre=FRONT;
        if(QDELETE()){
        QUEUE[pre]=null;
        QUEUE[pre]=new Bag();
        jTable1.setValueAt("", 0, pre);
        N--;
        showArea();
        System.out.println("Delete data complete");
        jLabel2.setText("FRONT : "+FRONT);
            jLabel3.setText("REAR : "+REAR);
            showPic();
            showBill();
        }else{
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Body().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
