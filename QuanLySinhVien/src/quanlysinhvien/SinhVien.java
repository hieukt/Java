/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysinhvien;

import java.util.Scanner;

/**
 *
 * @author Lenovo-PC
 */
public class SinhVien {

    private String nameSV;
    private int yearSV;
    private String adressSV;
    private float pointSV;

    public void inputSV() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập tên sinh viên: ");
        nameSV = sc.nextLine();
        System.out.println("Mời bạn nhập năm sinh của sinh viên: ");
        yearSV = sc.nextInt();
        sc.nextLine();
        System.out.println("Mời bạn nhập địa chỉ cho sinh viên: ");
        adressSV = sc.nextLine();
        System.out.println("Mời bạn nhập điểm cho sinh viên: ");
        pointSV = sc.nextFloat();
    }

    public void outPutSV() {
        System.out.println("Sinh viên tên: " + nameSV + " Sinh năm: " + yearSV + " Quê ở: " + adressSV + " Được " + pointSV + " điểm ");
    }

    public String getNameSV() {
        return nameSV;
    }

    public void setNameSV(String nameSV) {
        this.nameSV = nameSV;
    }

    public int getYearSV() {
        return yearSV;
    }

    public void setYearSV(int yearSV) {
        this.yearSV = yearSV;
    }

    public String getAdressSV() {
        return adressSV;
    }

    public void setAdressSV(String adressSV) {
        this.adressSV = adressSV;
    }

    public float getPointSV() {
        return pointSV;
    }

    public void setPointSV(float pointSV) {
        this.pointSV = pointSV;
    }

}
