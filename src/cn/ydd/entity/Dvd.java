package cn.ydd.entity;

import java.util.Date;

public class Dvd implements Comparable<Dvd>
{
	private String name;
	private int id;
	private int state;
	private Date borrowDate;
	private Date returnDate;
	private int dvdCount;
	
	public int getDvdCount()
	{
		return dvdCount;
	}
	public void setDvdCount(int dvdCount)
	{
		this.dvdCount = dvdCount;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getState()
	{
		return state;
	}
	public void setState(int state)
	{
		this.state = state;
	}
	public Date getBorrowDate()
	{
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate)
	{
		this.borrowDate = borrowDate;
	}
	public Date getReturnDate()
	{
		return returnDate;
	}
	public void setReturnDate(Date returnDate)
	{
		this.returnDate = returnDate;
	}
	@Override
	public String toString()
	{
		if(state==1){
			return id+"\t\t¿É½è\t\t" + name +"\t\t\t" + borrowDate +"\t\t"+dvdCount;
		} else {
			return id+"\t\t½è³ö\t\t" + name +"\t\t\t" + borrowDate+"\t\t"+dvdCount;
		}
	}
	@Override
	public int compareTo(Dvd d)
	{
		// TODO Auto-generated method stub
		return d.getDvdCount()-this.dvdCount;
	}
	
	
	
}
