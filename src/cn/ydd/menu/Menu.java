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
		System.out.println("欢迎使用迷你DVD管理器");
		System.out.println("---------------------------------");

		System.out.println("0.琅琊榜");
		System.out.println("1.新增DVD");
		System.out.println("2.查看DVD");
		System.out.println("3.删除DVD");
		System.out.println("4.借出DVD");
		System.out.println("5.归还DVD");
		System.out.println("6.退        出");

		System.out.println("---------------------------------");
		System.out.print("请选择：");
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
			System.out.println("谢谢使用！");
			break;

		default:
			throw new Exception();
		}
	}

	public void returnMain()
	{
		System.out.println("======================");
		System.out.print("输入0返回：");

		num = sc.nextInt();

		
		try
		{
			if (num == 0){
				startMenu();
			} else {
				System.out.println("你的输入有误！");
				returnMain();
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			System.out.println("你的输入有误！");
		}
		

	}

	public void addMenu()
	{
		System.out.println("----->新增DVD");
		System.out.println();
		System.out.print("请输入DVD名称：");
		String name = sc.next();
		dvd.setName(name);
		dd.addDvd(dvd);
		System.out.println("新增《" + name + "》成功！");
		returnMain();
	}

	public void seleceMenu()
	{
		System.out.println("----->查看DVD");
		System.out.print("序号\t\t" + "状态\t\t" + "名称\t\t\t" + "借出日期\t\t"
				+ "借出次数\n");
		List<Dvd> list = dd.findAll();
		for (Dvd d : list)
		{
			System.out.println(d);
		}
		returnMain();
	}

	public void deleteMenu()
	{
		System.out.println("----->删除DVD");
		System.out.println();
		System.out.print("请输入DVD名称：");
		String name = sc.next();
		List<Dvd> list = dd.findByName(name);
		if(!list.isEmpty()){	
			dd.deleteByName(name);
			System.out.println("删除成功！");
		} else {
			System.out.println("你要删除的DVD不存在！");
		}
		returnMain();
	}

	public void borrowMenu()
	{
		System.out.println("----->借出DVD");
		System.out.println();
		System.out.print("请输入DVD编号：");
		num = sc.nextInt();
		dm.borrowDvd(num);
		returnMain();
	}

	public void returnMenu()
	{
		System.out.println("----->归还DVD");
		System.out.println();
		System.out.print("请输入DVD编号：");
		num = sc.nextInt();
		dm.returnDvd(num);
		returnMain();
	}
	
	
}
