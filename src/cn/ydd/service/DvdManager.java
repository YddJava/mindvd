package cn.ydd.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import cn.ydd.Dao.DvdDao;
import cn.ydd.entity.Dvd;

public class DvdManager
{
	DvdDao dd = new DvdDao();

	public void borrowDvd(int id)
	{
		Dvd dvd = dd.findById(id);
		if (dvd.getName() != null)
		{
			if (dvd.getState() == 1)
			{
				dvd.setState(0);
				dvd.setBorrowDate(new Date());
				dvd.setReturnDate(null);
				dvd.setDvdCount(dvd.getDvdCount()+1);
				dd.updateDvd(dvd);
				System.out.println("DVD" + dvd.getName() + "借出成功！");
			} else if (dvd.getState() == 0)
			{
				System.out.println("你要借的《" + dvd.getName() + "》已经被借出！");
			}
		} else
		{
			System.out.println("你要借的DVD不存在");
		}

	}

	public void returnDvd(int id)
	{
		Dvd dvd = dd.findById(id);
		if (dvd.getName() != null)
		{
			if (dvd.getState() == 0)
			{
				dvd.setState(1);
				dvd.setReturnDate(new Date());
				long day = dvd.getReturnDate().getTime() - dvd.getBorrowDate().getTime();
				long money = day/(1000*60*60*24);
				dvd.setBorrowDate(null);
				dd.updateDvd(dvd);
				System.out.println("DVD" + dvd.getName() + "归还成功！");
				System.out.println("应付租金（元）："+money);
			} else if (dvd.getState() == 1)
			{
				System.out.println("你要还的《" + dvd.getName() + "》已经存在！");
			}
		} else
		{
			System.out.println("本店不存在这样的DVD！");
		}

	}
	
	public void dvdRank(){
		List<Dvd> list = dd.findAll();
		Collections.sort(list);
		System.out.println("**********琅琊榜**********");
		System.out.println("名称\t\t"+"次数");
		for(Dvd d : list){
			System.out.println(d.getName()+"\t\t"+d.getDvdCount());
		}
	}
}
