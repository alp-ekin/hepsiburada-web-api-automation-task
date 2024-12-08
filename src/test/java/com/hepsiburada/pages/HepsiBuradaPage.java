package com.hepsiburada.pages;

import com.hepsiburada.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HepsiBuradaPage {

    public HepsiBuradaPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@title='Hepsiburada']")
    public WebElement titleHepsiburada;

    @FindBy(css = "div.initialComponent-hk7c_9tvgJ8ELzRuGJwC")
    public WebElement searchBox;

    @FindBy(css = "input.searchBarContent-UfviL0lUukyp5yKZTi4k")
    public WebElement searchBox2;

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptButton;

    @FindBy(css = "#onetrust-policy-text>a")
    public WebElement denyCookies;

    @FindBy(xpath = "//button[text()='Değerlendirmeler']")
    public WebElement commentsTab;
    @FindBy(xpath = "//button[text()='Sepete ekle' or text()='Ön sipariş ver']")
    public WebElement sepeteEkle;

    public String henuzDegerlendirmeYok = "//span[text()='Henüz değerlendirme yok']";
    public String sıralaDropDown = "//div[@class='arrowUpOrange']";
    public String enYeniDegerlendirme = "//div[text()='En yeni değerlendirme']";
    public String thumbsUpIcon = "(//div[starts-with(@class,'thumbsUp')])[1]";
    public String tesekkurEderiz = "(//div[starts-with(@class,'thumbsUp')])[1]/../../../../../div[2]/span";
    public String currentProductsPricePath = "//div[@data-test-id='price']/div/div[@data-test-id='price-current-price']/span[1]";
    public String otherSellersProductPath = "//button[text()='Ürüne git']/../div/div";
    public String digerSaticilar = "//span[text()='Diğer satıcılar']";
    public String uruneGit = "//button[text()='Ürüne git']";
    public String productsPricePath = "//div[@data-test-id='price']/div/div[@data-test-id='price-current-price']/span[1]";
    public String sepeteGit = "//button[text()='Sepete git']";
    public String priceOfProductInCartPath = "//input[@id='selectedCheckBox']/../../../../div[2]/div[2]/div[2]/div/div";

}
