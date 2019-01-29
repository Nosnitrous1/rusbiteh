package com.packt.webdriver.chapter1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NavigateToAUrl {
    public static void main(String[] args) {
        // 1.	������� �������� google.com (��� ����� ������ ��������� �� ��� �����) � ������ � ������ ������ habrahabr;
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("habrahabr.ru");
        WebElement searchButton = driver.findElement(By.name("btnK"));
        System.out.println("Goto harbr");
        searchButton.click();

        // 2.	����� ����������� ����������� ������, ������� ���� habrahabr.ru ������ �� ������ (��� ������ ����� ���� �� �������� �� ������ ��������� ������, � ������ �������� ���, ������� � �������� ������ habrahabr.ru);
        // List <WebElement> Element = driver.findElements(By.className("LC20lb"));
        List<WebElement> Element = driver.findElements(By.className("iUh30"));
        System.out.println("Megethos" + Element.size());
        System.out.println("Pame stous epomenous \n");

        String[] linkhrefs = new String[Element.size()];
        int j = 0;
        for (WebElement e : Element) {
            String Curlink = e.getText();
            System.out.println("j = " + j + " text= " + e.getText() + " Curlink.contains(\"habrahabr.ru\") " + Curlink.contains("habrahabr.ru"));
            if (Curlink.contains("habrahabr.ru")) {
                e.click();
                break;
            }
            j++;
        }

        // 3.	������� � ������ "���������" ������ �� ������ � ����;
        List<WebElement> Elhabra = driver.findElements(By.className("nav-links__item-link"));
        System.out.println("How many Elem " + Element.size());

        j = 0;
        for (WebElement e : Elhabra) {
            String Curlink = e.getText();
            System.out.println("j = " + j + " text= " + e.getText() + " Curlink.contains(\"���������\") " + Curlink.contains("���������"));
            if (Curlink.contains("���������")) {
                e.click();
                break;
            }
            j++;
        }

        // 4.	������� 2-� �������� ������� "���������" ������ �� ����� "2" � ���������;
        List<WebElement> ElhabraSend = driver.findElements(By.cssSelector(".toggle-menu__item"));
        System.out.println("Members " + Element.size());

        j = 0;
        for (WebElement e : ElhabraSend) {
            String Curlink = e.getText();
            System.out.println("j = " + j + " text= " + e.getText() + " Curlink.contains(\"2\") " + Curlink.contains("2"));
            if (Curlink.contains("2")) {
                e.click();
                break;
            }
            j++;
        }

        // �������
        WebElement searchLink = driver.findElement(By.className("post__title_link"));
        String SearchTxt = searchLink.getText();
        System.out.println("First article= "+SearchTxt);
        searchLink.click();         // �� �� �������� 1-� ������

        // 5.	��������� ����� ������� ����� �� ��������
        String titleTxt = driver.getTitle();
        System.out.println("title= "+titleTxt);

        // 6.	������� google.com � ���������� ����� �� �������� �� ���� 5.
        driver.get("https://www.google.com");
        WebElement searchBox1 = driver.findElement(By.name("q"));
        searchBox1.sendKeys(SearchTxt);
        WebElement searchButton1 = driver.findElement(By.name("btnK"));
        System.out.println("Goto "+ SearchTxt);
        searchButton1.click();

        // 7.	���������, ��� ���������� ������ ������������� �������� ��������.
        String SearchTxt1 = driver.findElement(By.cssSelector(".gLFyf")).getAttribute("value");
        System.out.println("SearchTxt1= "+SearchTxt1+" SearchTxt= "+SearchTxt);
        if (SearchTxt1 == SearchTxt) {
            String ModTxt = "������ ���������� '"+ SearchTxt + "'";
            System.out.println(ModTxt);
            WebElement searchPhrase = driver.findElement(By.cssSelector(".gLFyf"));
            searchPhrase.sendKeys(ModTxt);
        }
    }
 }
