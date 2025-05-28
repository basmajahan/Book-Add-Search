package Frame;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Element.*;

public class Frameintro extends JFrame implements ActionListener
{
	ImageIcon img;
	JLabel imgLabel;
	JPanel panel;
	JLabel title,author;
	JButton searchbtn, addbtn,exitbtn;
	JTextField titlefield,authorfield;
	Color mycolor,mycolor2,mycolor3;
	Font myfont, myfont2;

	public Frameintro() {

		super("Book Tracker");
		this.setSize(800,950);
		
		mycolor=new Color(255, 255, 255);

		mycolor2=new Color(244, 194, 194);
		
		myfont=new Font("Times New Roman",Font.PLAIN,20);
		

		
		panel=new JPanel();
		panel.setLayout(null);
		
		panel.setBackground(mycolor);
		
		
		title=new JLabel("Book Title");

		title.setBounds(250, 250, 100, 35);
		title.setBackground(mycolor2);
		title.setFont(myfont);
		panel.add(title);

		
		titlefield=new JTextField();
		titlefield.setBounds(360, 250, 200, 30);
		panel.add(titlefield);
		
		author =new JLabel("Author");
		author.setBounds(250, 300, 100, 30);
		author.setFont(myfont);
		panel.add(author);

		authorfield=new JTextField();
		authorfield.setBounds(360, 300, 200, 30);
		panel.add(authorfield);
		

		addbtn=new JButton("Add");
		addbtn.setBounds(570, 300, 90, 30);
		addbtn.setBackground(mycolor2);
		
		addbtn.addActionListener(this);
		panel.add(addbtn);
		

        searchbtn = new JButton("Search");
        searchbtn.setBounds(570, 250, 90, 30);
        searchbtn.setBackground(mycolor2);
        searchbtn.addActionListener(this);
        panel.add(searchbtn);

       
		
		
		exitbtn=new JButton("Exit");
		exitbtn.setBounds(370, 600, 100, 40);
		exitbtn.setBackground(mycolor2);

		exitbtn.addActionListener(this);
		panel.add(exitbtn);

		img = new ImageIcon(getClass().getResource("/img/bookimg.jpg"));
        imgLabel = new JLabel(img);
        imgLabel.setBounds(40, 40, 180, 180); 
        panel.add(imgLabel);
		this.add(panel);
		
		
        }

        public void actionPerformed(ActionEvent ae)
	{
		String title=titlefield.getText();
		String author=authorfield.getText();
		String command = ae.getActionCommand();
		
		if(ae.getSource()==searchbtn)
		{
			Book b=new Book();
			
			if(b.getBook(title,author)==true)
			{
				JOptionPane.showMessageDialog(null,"Book Found");
			
			this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Book Not found");
			}
		}
		else if(ae.getSource()==addbtn)
		{
			Book b=new Book(title,author);
				b.addBook();
				titlefield.setText("");
				authorfield.setText("");
				JOptionPane.showMessageDialog(null,"Added");			
		}
		else if (exitbtn.getText().equals(command))
		{
			int choice = JOptionPane.showConfirmDialog(null, "Do you want to exit", "Exit", JOptionPane.YES_NO_OPTION);

			if (choice == JOptionPane.YES_OPTION)
			{
		        System.exit(0); 
		    }
		 
            else if (choice == JOptionPane.NO_OPTION)
            	{ 

            	}

            else

            {

            }
		}
	}
	}
