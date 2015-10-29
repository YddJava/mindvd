package cn.ydd.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.ydd.entity.Dvd;

public class DvdDao
{
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	
	public void myClose(){
		try
		{
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("πÿ±’◊ ‘¥ ß∞‹");
		}
	}
	
	public DvdDao()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("º”‘ÿ«˝∂Ø ß∞‹");
		}

	}

	public void addDvd(Dvd dvd)
	{
		try
		{
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");
			String sql = "insert into dvd(name)values (?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dvd.getName());
			ps.execute();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ÃÌº” ß∞‹");
		} finally
		{
			myClose();
		}
	}
	public void deleteByName(String name){
		try
		{
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");
			String sql = "delete from dvd where name =?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.execute();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("…æ≥˝ ß∞‹");
		} finally
		{
			myClose();
		}
	}
	public void deleteById(int id)
	{
		try
		{
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");
			String sql = "delete from dvd where id =?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("…æ≥˝ ß∞‹");
		} finally
		{
			myClose();
		}

	}

	public void updateDvd(Dvd dvd)
	{
		try
		{
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");
			String sql = "update dvd set name =?,state=?,borrowdate=?,returndate=?,dvdcount=? where id =?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dvd.getName());
			ps.setInt(2, dvd.getState());
			java.sql.Date sqlborrow = dvd.getBorrowDate() == null ? null : new java.sql.Date(dvd.getBorrowDate().getTime());;
			ps.setDate(3, sqlborrow);
			java.sql.Date sqlreturn = dvd.getReturnDate() == null ? null : new java.sql.Date(dvd.getReturnDate().getTime());
			ps.setDate(4, sqlreturn);
			ps.setInt(5, dvd.getDvdCount());
			ps.setInt(6, dvd.getId());
			ps.execute();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("–ﬁ∏ƒ ß∞‹");
		} finally
		{
			myClose();
		}
	}

	public List<Dvd> findByName(String name){
		
		List<Dvd> list = new ArrayList<Dvd>();
		try
		{
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");
			String sql = "select * from dvd where name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next())
			{
				Dvd dvd = new Dvd();
				dvd.setName(rs.getString("name"));
				dvd.setId(rs.getInt("id"));
				dvd.setState(rs.getInt("state"));
				dvd.setBorrowDate(rs.getDate("borrowDate"));
				dvd.setReturnDate(rs.getDate("returnDate"));
				dvd.setDvdCount(rs.getInt("dvdCount"));
				list.add(dvd);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("≤È’“ ß∞‹");
		} finally
		{
			myClose();
		}
		return list;
	}
	
	
	public Dvd findById(int id)
	{
		
		Dvd dvd = new Dvd();
		try
		{
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");
			String sql = "select * from dvd where id =?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next())
			{
				dvd.setName(rs.getString("name"));
				dvd.setId(rs.getInt("id"));
				dvd.setState(rs.getInt("state"));
				dvd.setBorrowDate(rs.getDate("borrowDate"));
				dvd.setReturnDate(rs.getDate("returnDate"));
				dvd.setDvdCount(rs.getInt("dvdCount"));
			}

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("≤È’“ ß∞‹");
		} finally
		{
			myClose();
		}
		return dvd;
	}

	public List<Dvd> findAll()
	{
		List<Dvd> list = new ArrayList<Dvd>();
		try
		{
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");
			String sql = "select * from dvd";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next())
			{
				Dvd dvd = new Dvd();
				dvd.setName(rs.getString("name"));
				dvd.setId(rs.getInt("id"));
				dvd.setState(rs.getInt("state"));
				dvd.setBorrowDate(rs.getDate("borrowDate"));
				dvd.setReturnDate(rs.getDate("returnDate"));
				dvd.setDvdCount(rs.getInt("dvdCount"));
				list.add(dvd);
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("≤È’“ ß∞‹");
		} finally
		{
			myClose();
		}
		return list;
	}
	
	
	
}
