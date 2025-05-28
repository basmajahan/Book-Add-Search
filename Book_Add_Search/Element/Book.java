package Element;

import java.lang.*;
import java.util.*;
import java.io.*;

import Frame.*;

public class Book
{
	private String title;
	private String author;


	File f;
	FileWriter w;
	Scanner s;

	public Book()
	{
		this.title="";

		 this.author = "";

	}

	public Book (String title, String author)
	{
		this.title=title;
		this.author=author;

	}

	 public void settitle(String title)
	 {
	 	this.title=title;

	 }
	 public void setauthor(String author)
	 {
	 	this.author=author;
	 }
	 public String gettitle()
	{
		return title;
	}
	
	public String getauthor()
	{
		return author;
	}




	public void addBook()
	{
		try{

		f=new File("./Data.txt");
		f.createNewFile();

		w=new FileWriter(f,true);
		w.write(gettitle()+"\t");
		w.write(getauthor()+"\n");
		w.flush();   
		w.close();

		}

		catch(IOException ioe)
		
		{
			ioe.printStackTrace();
		}
	}

		public boolean getBook(String title ,String author)
	{
		boolean flag=false;

		f=new File("./Data.txt");
		
		try
		{
			s=new Scanner(f);
			
			while(s.hasNextLine())
			{
				String line=s.nextLine();
				String[] value=line.split("\t");
				if(value[0].equals(title)&&value[1].equals(author))
				{
					flag=true;
				}
			}
			
			
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		return flag;
	}
	
}
	
	

