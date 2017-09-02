//SetBound(x,y,height,width)
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
public class database extends JFrame
{
  public static void main(String args[])
  {
    JFrame f=new JFrame("Database Application By Rohit Chauhan");
    final JFrame displayf=new JFrame("Display Records");
    final JFrame insertf=new JFrame("Insert Records");
    final JFrame deletef=new JFrame("Delete Records");
    final JFrame updatef=new JFrame("Update Records");
    final JFrame help = new JFrame("Help");
    final JFrame about = new JFrame("Help");
    help.setLayout(null);
    about.setLayout(null);
    about.setSize(350,350);
    help.setSize(350,350);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(null);
    insertf.setLayout(null);
    deletef.setLayout(null);
    updatef.setLayout(null);

    //Help Frame Content
    JLabel helpContent = new JLabel("<html><h1>Help Of Databse App</h1><ol><li>First Of All Start Mysql Server And create table called 'emp1' under 'test' Databse or import test.sql file through phpmyadmin.</li><li>Download Mysql Connector.jar after that copy .jar file in java/jdk/jre/lib/ext And Set Classpath For that file..</li><li>That's it run the program And Manage Your databse</li></ol></html>");
    helpContent.setBounds(10,10,300,250);
    // Main Form Content
    JLabel lblnm=new JLabel("Database App By Rohit Chauhan");
    Font font=new Font("Cambria", Font.PLAIN, 18);
    lblnm.setFont(font);
    lblnm.setBounds(30,20,500,25);
    JButton btnhelp = new JButton("Help");
    btnhelp.setBounds(200,210,70,30);
    JButton btnabout = new JButton("About Us");
    btnabout.setBounds(180,60,100,30);
    JButton display = new JButton("Display Records");
    display.setBounds(10, 60, 140, 30);
    JButton insert = new JButton("Insert Records");
    insert.setBounds(10, 210, 140, 30);
    JButton delete = new JButton("Delete Rocords");
    delete.setBounds(10, 110, 140, 30);
    JButton update = new JButton("Update Records");
    update.setBounds(10, 160, 140, 30);
    ImageIcon image = new ImageIcon("db.png");
    JLabel imagelabel = new JLabel(image);
    imagelabel.setBounds(160, 80, 120,130);

    //Display Form
    JPanel panel = new JPanel();
    JScrollPane jsp = new JScrollPane();
   //Insert Form Content
   JLabel inlblid=new JLabel("Enter ID  :");
   inlblid.setBounds(10,20,300,25);
   final JTextField intxtid=new JTextField();
   intxtid.setBounds(90,20,150,25);
   JLabel inlblnm=new JLabel("Enter Name  :");
   inlblnm.setBounds(10,60,300,25);
   final JTextField intxtnm=new JTextField();
   intxtnm.setBounds(90,60,150,25);
   JLabel inlbldes=new JLabel("Enter Discription :");
   inlbldes.setBounds(10,100,300,25);
   final JTextArea area=new JTextArea();
   area.setBounds(10,140, 200,100);
   JButton insave = new JButton("Save");
   insave.setBounds(220,140,70,25);
   JButton incancle = new JButton("Back");
   incancle.setBounds(220,180,70,25);
   incancle.addActionListener(new ActionListener()
     {
          public void actionPerformed(ActionEvent event)
          {
              intxtid.setText("");
              intxtnm.setText("");
              area.setText("");
              insertf.setVisible(false);
          }
     });
     insave.addActionListener(new ActionListener()
       {
            public void actionPerformed(ActionEvent event)
            {
                String intxtnm1,intxtdes1;
                String intxtid1;
                intxtid1=intxtid.getText();
                int result = Integer.parseInt(intxtid1);
                intxtnm1=intxtnm.getText();
                intxtdes1=area.getText();
                Rohit r1=new Rohit();
                r1.insert(result,intxtnm1,intxtdes1);
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(null,"Record Saved.....");
                intxtid.setText("");
                intxtnm.setText("");
                area.setText("");
                int msg = JOptionPane.showConfirmDialog(frame, "Want To Add another Record?");
                if(JOptionPane.NO_OPTION==msg)
                {
                  insertf.setVisible(false);
                }
            }
       });

       //Delete Form
       final JLabel lbldel=new JLabel("Enter Name To Delete Record  :");
       lbldel.setBounds(20,30,210,30);
       final JTextArea del=new JTextArea();
       final JButton delok=new JButton("Delete");
       final JButton delcancle=new JButton("Back");
       del.setBounds(190,35,80,20);
       delok.setBounds(20,75,100,30);
       delcancle.setBounds(150,75,100,30);
       delcancle.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent event)
         {
            del.setText("");
            deletef.setVisible(false);
         }
       });
       delok.addActionListener(new ActionListener()
       {
         public void actionPerformed(ActionEvent event)
         {

            Rohit r2=new Rohit();
            String deltxtid1;
            deltxtid1=del.getText();
            JFrame frame1 = new JFrame();
            int msg = JOptionPane.showConfirmDialog(frame1, "Are You Sure ?");
            if(JOptionPane.YES_OPTION==msg)
            {
                r2.delete(deltxtid1);
            }
         }
       });

       //Update Form
       JLabel id= new JLabel("Enter Name You want to Update ");
       id.setBounds(20,30,210,30);
       final JTextField name = new JTextField();
       name.setBounds(190,35,80,20);
       final JButton getdata = new JButton("Get Data");
       getdata.setBounds(75,68,100,30);
       
       getdata.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent event)
          {
            Rohit r = new Rohit();
            String nametxt = name.getText();
            r.getdata(nametxt);
            updatef.setVisible(false);

          }
       });

    //When User Click it Will Run This
    display.addActionListener(new ActionListener()
      {
           public void actionPerformed(ActionEvent event)
           {
               Rohit r=new Rohit();
               r.display();

           }

      });
      btnhelp.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event)
        {
          help.setVisible(true);
        }
      });
    insert.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent event)
             {
                 insertf.setVisible(true);

             }
        });
    delete.addActionListener(new ActionListener()
          {
            public void actionPerformed(ActionEvent event)
            {
                            deletef.setVisible(true);
            }
        });

    update.addActionListener(new ActionListener()
          {
               public void actionPerformed(ActionEvent event)
               {
                   updatef.setVisible(true);
               }
        });
    f.add(display); // Adding Compopnants To JFrame
    f.add(insert);
    f.add(imagelabel);
    f.add(delete);
    f.add(update);
    f.add(lblnm);
    f.setSize(320,300);  //Setting Form Size
    f.setVisible(true); //Is Form Visibel
    //Help Form
    f.add(btnhelp);
    f.add(btnabout);
    help.setLayout(null);
    help.add(helpContent);
    displayf.setVisible(false);
    displayf.setSize(300,300);
    panel.setLayout(new BorderLayout());
    panel.add(jsp,BorderLayout.CENTER);
    displayf.setContentPane(panel);
    //Adding Compnat to Insert Font
    insertf.add(intxtid);
    insertf.add(inlblid);
    insertf.add(inlblnm);
    insertf.add(intxtnm);
    insertf.add(inlbldes);
    insertf.add(area);
    insertf.add(insave);
    insertf.add(incancle);
    insertf.setVisible(false);
    insertf.setSize(320,300);
    
    //Delete Form Content Adding
    deletef.add(del);
    deletef.add(delcancle);
    deletef.add(lbldel);
    deletef.add(delok);
    deletef.setVisible(false);
    deletef.setSize(300,300);
    //Update Form
    
    updatef.add(name);
    updatef.add(getdata);
    updatef.setVisible(false);
    updatef.add(id);
    updatef.setSize(300,300);
  }
}
class Rohit
{
     void display(){
       Connection con = null;
       Statement st = null;
       ResultSet rs = null;
       String s;
    //connect your app to mysql database
       try{
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
           st = con.createStatement();
           s = "select * from emp1";
           rs = st.executeQuery(s);
           ResultSetMetaData rsmt = rs.getMetaData();
           int c = rsmt.getColumnCount();
           Vector column = new Vector(c);
           for(int i = 1; i <= c; i++)
           {
               column.add(rsmt.getColumnName(i));
           }
           Vector data = new Vector();
           Vector row = new Vector();
           while(rs.next())
           {
               row = new Vector(c);
               for(int i = 1; i <= c; i++){
                   row.add(rs.getString(i));
               }
               data.add(row);
           }
           JFrame displayf = new JFrame();
           displayf.setSize(500,120);
           displayf.setLocationRelativeTo(null);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            displayf.setContentPane(panel);
            displayf.setVisible(true);
                   
                   
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }finally{
           try{
           st.close();
           rs.close();
           con.close();
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, "ERROR CLOSE");
           }
       }
          
      } //Display Over
  void insert(int id,String nm,String des)
  {
    int id1;
    String nm1;
    String des1;
    nm1=nm;
    id1=id;
    des1=des;
    Connection con;
    Statement stmt;
    ResultSet rs;
		try
		{
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/test";
				con=DriverManager.getConnection(url,"root","");
				stmt=con.createStatement();
        int x=stmt.executeUpdate("insert into emp1 values ("+id1+",'"+nm1+"','"+des1+"')");
        System.out.println(id1);
        System.out.println(nm1);
        System.out.println(des1);
        System.out.println("Record Add");
				stmt.close();
				con.close();
		}
		catch(Exception e)
		{
			System.out.println("Sorry"+e);
		}

  }
  void delete(String a)
  {
    //String b=a;
    Connection con;
    Statement stmt;
    ResultSet rs;
		try
		{
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/test";
				con=DriverManager.getConnection(url,"root","");
				stmt=con.createStatement();
        int d=stmt.executeUpdate("delete from emp1 where name='"+a+"'");
        System.out.println("Deleted");
    }
    catch(Exception e)
    {
      JOptionPane.showMessageDialog(null, "Record Deleted...");
    }
  }
  void getdata(String name)
  {
    Connection conn;
    Statement stmt;
    ResultSet rs;
    final JFrame updatedata = new JFrame("Data That you want to  Update");
    updatedata.setLayout(null);
    JLabel lblupid = new JLabel("ID");
    lblupid.setBounds(20,-8,50,70);
    final JTextField txtupid = new JTextField();
    txtupid.setBounds(100,20,50,20);
    JLabel lblupname = new JLabel("Name");
    lblupname.setBounds(20,20,50,70);
    final JTextField txtupname = new JTextField();
    txtupname.setBounds(100,50,70,20);
    JLabel lblupdes = new JLabel("Descripction");
    lblupdes.setBounds(20,55,80,70);
    final JTextField txtupdes = new JTextField();
    txtupdes.setBounds(100,80,120,20);
    JButton btnupsave = new JButton("Update Record");
    btnupsave.setBounds(75,115,130,30);
    btnupsave.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent event)
         {   
          int id=Integer.parseInt(txtupid.getText());
          String name = txtupname.getText();
          String des = txtupdes.getText();
          update(id,name,des);
          updatedata.setVisible(false);
         }
    });
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
      stmt = conn.createStatement();
      rs = stmt.executeQuery("select * from emp1 where name='"+name+"'");
      while(rs.next())
      {
        txtupid.setText(rs.getString(1));
        txtupname.setText(rs.getString(2));
        txtupdes.setText(rs.getString(3));
      }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    updatedata.add(btnupsave);
    updatedata.add(lblupdes);
    updatedata.add(txtupdes);
    updatedata.add(lblupname);
    updatedata.add(txtupname);
    updatedata.add(txtupid);
    updatedata.add(lblupid);
    updatedata.setSize(300,300);
    updatedata.setVisible(true);
  }
  void update(int id,String name,String des)
  {
    Connection con;
    Statement stmt;
    ResultSet rs;
		try
		{
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/test";
				con=DriverManager.getConnection(url,"root","");
				stmt=con.createStatement();
        int d=stmt.executeUpdate("update emp1 set id="+id+",name='"+name+"',des='"+des+"' where id="+id);
        JOptionPane.showMessageDialog(null,"Data Updated");
    }
    catch(Exception e)
    {
      JOptionPane.showMessageDialog(null, e);
    }
  }
}
