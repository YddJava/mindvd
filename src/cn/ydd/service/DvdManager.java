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
				System.out.println("DVD" + dvd.getName() + "����ɹ���");
			} else if (dvd.getState() == 0)
			{
				System.out.println("��Ҫ��ġ�" + dvd.getName() + "���Ѿ��������");
			}
		} else
		{
			System.out.println("��Ҫ���DVD������");
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
				System.out.println("DVD" + dvd.getName() + "�黹�ɹ���");
				System.out.println("Ӧ�����Ԫ����"+money);
			} else if (dvd.getState() == 1)
			{
				System.out.println("��Ҫ���ġ�" + dvd.getName() + "���Ѿ����ڣ�");
			}
		} else
		{
			System.out.println("���겻����������DVD��");
		}

	}
	
	public void dvdRank(){
		List<Dvd> list = dd.findAll();
		Collections.sort(list);
		System.out.println("**********�����**********");
		System.out.println("����\t\t"+"����");
		for(Dvd d : list){
			System.out.println(d.getName()+"\t\t"+d.getDvdCount());
		}
	}
}
