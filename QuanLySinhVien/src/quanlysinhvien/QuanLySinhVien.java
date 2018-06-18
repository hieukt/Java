/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysinhvien;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lenovo-PC
 */
public class QuanLySinhVien {

    ArrayList<SinhVien> arrSV = new ArrayList<>();

    public void dockingDsSV(ArrayList<SinhVien> arrSV) {
        for (int i = 0; i < arrSV.size(); i++) {
            for (int j = 0; j < arrSV.size(); j++) {
                if (arrSV.get(i).getPointSV() < arrSV.get(j).getPointSV()) {
                    SinhVien sv = new SinhVien();
                    sv = arrSV.get(i);
                    arrSV.set(i, arrSV.get(j));
                    arrSV.set(j, sv);
                }
            }
        }
    }

    public void showListSV(ArrayList<SinhVien> arr) {
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).outPutSV();
        }
    }

    public void inputListSV(int n) {
        for (int i = 0; i < n; i++) {
            SinhVien sv = new SinhVien();
            sv.inputSV();
            arrSV.add(sv);
        }
    }

    public void searchSV(ArrayList<SinhVien> arr, String name) {
        int j = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getNameSV().lastIndexOf(name) >= 0) {
                arr.get(i).outPutSV();
                j = i;
            }
        }
        if (j == 0) {
            System.out.println("Không có thông tin của sinh viên cần tìm");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        QuanLySinhVien q = new QuanLySinhVien();
        Scanner sc = new Scanner(System.in);
        int choice, i = 0;
        while (i == 0) {
            System.out.println("******MENU******");
            System.out.println("Mời bạn lựa chọn");
            System.out.println("1.Nhập danh sách sinh viên");
            System.out.println("2.Hiển thị thông tin sinh viên");
            System.out.println("3.Sắp xếp danh sách sinh viên");
            System.out.println("4.Tìm kiếm sinh viên");
            System.out.println("5.Thoát");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Hãy nhập số sinh viên trong danh sách");
                    int n = sc.nextInt();
                    q.inputListSV(n);
                    break;
                case 2:
                    q.showListSV(q.arrSV);
                    break;
                case 3:
                    q.dockingDsSV(q.arrSV);
                    q.showListSV(q.arrSV);
                    break;
                case 4:
                    System.out.println("Nhập tên sinh viên cần tìm");
                    String a = sc.nextLine();
                    q.searchSV(q.arrSV, a);
                    break;
                case 5:
                    i = 1;
                    System.out.println("pp");
                    break;
            }
        }
    }

}
