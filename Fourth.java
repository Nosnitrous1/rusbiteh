package com.packt.webdriver.chapter1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NavigateToAUrl {
    public static void main(String[] args) {
        // 1.	Открыть страницу google.com (или любой другой поисковик на ваш выбор) и ввести в строке поиска habrahabr;
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("habrahabr.ru");
        WebElement searchButton = driver.findElement(By.name("btnK"));
        System.out.println("Goto harbr");
        searchButton.click();

        // 2.	После отображения результатов поиска, открыть сайт habrahabr.ru кликом на ссылку (доп плюсом будет если вы выберете не первый результат поиска, а именно выберете тот, который с доменным именем habrahabr.ru);
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

        // 3.	Перейти в раздел "Песочница" кликом на ссылку в меню;
        List<WebElement> Elhabra = driver.findElements(By.className("nav-links__item-link"));
        System.out.println("How many Elem " + Element.size());

        j = 0;
        for (WebElement e : Elhabra) {
            String Curlink = e.getText();
            System.out.println("j = " + j + " text= " + e.getText() + " Curlink.contains(\"Песочница\") " + Curlink.contains("Песочница"));
            if (Curlink.contains("Песочница")) {
                e.click();
                break;
            }
            j++;
        }

        // 4.	Открыть 2-ю страницу раздела "Песочница" кликом на цифру "2" в пагинации;
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

        // переход
        WebElement searchLink = driver.findElement(By.className("post__title_link"));
        String SearchTxt = searchLink.getText();
        System.out.println("First article= "+SearchTxt);
        searchLink.click();         // ша на страницу 1-й статьи

        // 5.	Запомнить тайтл первого поста на странице
        String titleTxt = driver.getTitle();
        System.out.println("title= "+titleTxt);

        // 6.	Открыть google.com и произвести поиск по значению из шага 5.
        driver.get("https://www.google.com");
        WebElement searchBox1 = driver.findElement(By.name("q"));
        searchBox1.sendKeys(SearchTxt);
        WebElement searchButton1 = driver.findElement(By.name("btnK"));
        System.out.println("Goto "+ SearchTxt);
        searchButton1.click();

        // 7.	Проверить, что результаты поиска соответствуют искомому значению.
        String SearchTxt1 = driver.findElement(By.cssSelector(".gLFyf")).getAttribute("value");
        System.out.println("SearchTxt1= "+SearchTxt1+" SearchTxt= "+SearchTxt);
        if (SearchTxt1 == SearchTxt) {
            String ModTxt = "ПОЛНОЕ СОВПАДЕНИЕ '"+ SearchTxt + "'";
            System.out.println(ModTxt);
            WebElement searchPhrase = driver.findElement(By.cssSelector(".gLFyf"));
            searchPhrase.sendKeys(ModTxt);
        }
    }
 }
