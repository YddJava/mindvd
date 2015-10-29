package cn.ydd.menu;

import java.util.List;
import java.util.Scanner;

import cn.ydd.Dao.DvdDao;
import cn.ydd.entity.Dvd;
import cn.ydd.service.DvdManager;

public class Menu
{
	private int num;
	DvdDao dd = new DvdDao();
	Dvd dvd = new Dvd();
	DvdManager dm = new DvdManager();
	Scanner sc = new Scanner(System.in);

	public void startMenu() throws Exception
	{
		System.out.println("��ӭʹ������DVD������");
		System.out.println("---------------------------------");

		System.out.println("0.�����");
		System.out.println("1.����DVD");
		System.out.println("2.�鿴DVD");
		System.out.println("3.ɾ��DVD");
		System.out.println("4.���DVD");
		System.out.println("5.�黹DVD");
		System.out.println("6.��        ��");

		System.out.println("---------------------------------");
		System.out.print("��ѡ��");
		num = sc.nextInt();
		switch (num)
		{
		case 0:
			dm.dvdRank();
			returnMain();
			break;
		case 1:
			addMenu();
			break;
		case 2:
			seleceMenu();
			break;
		case 3:
			deleteMenu();
			break;
		case 4:
			borrowMenu();
			break;
		case 5:
			returnMenu();
			break;
		case 6:
			System.out.println("ллʹ�ã�");
			break;

		default:
			throw new Exception();
		}
	}

	public void returnMain()
	{
		System.out.println("======================");
		System.out.print("����0���أ�");

		num = sc.nextInt();

		
		try
		{
			if (num == 0){
				startMenu();
			} else {
				System.out.println("�����������");
				returnMain();
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			System.out.println("�����������");
		}
		

	}

	public void addMenu()
	{
		System.out.println("----->����DVD");
		System.out.println();
		System.out.print("������DVD���ƣ�");
		String name = sc.next();
		dvd.setName(name);
		dd.addDvd(dvd);
		System.out.println("������" + name + "���ɹ���");
		returnMain();
	}

	public void seleceMenu()
	{
		System.out.println("----->�鿴DVD");
		System.out.print("���\t\t" + "״̬\t\t" + "����\t\t\t" + "�������\t\t"
				+ "�������\n");
		List<Dvd> list = dd.findAll();
		for (Dvd d : list)
		{
			System.out.println(d);
		}
		returnMain();
	}

	public void deleteMenu()
	{
		System.out.println("----->ɾ��DVD");
		System.out.println();
		System.out.print("������DVD���ƣ�");
		String name = sc.next();
		List<Dvd> list = dd.findByName(name);
		if(!list.isEmpty()){	
			dd.deleteByName(name);
			System.out.println("ɾ���ɹ���");
		} else {
			System.out.println("��Ҫɾ����DVD�����ڣ�");
		}
		returnMain();
	}

	public void borrowMenu()
	{
		System.out.println("----->���DVD");
		System.out.println();
		System.out.print("������DVD��ţ�");
		num = sc.nextInt();
		dm.borrowDvd(num);
		returnMain();
	}

	public void returnMenu()
	{
		System.out.println("----->�黹DVD");
		System.out.println();
		System.out.print("������DVD��ţ�");
		num = sc.nextInt();
		dm.returnDvd(num);
		returnMain();
	}
	
	
}
