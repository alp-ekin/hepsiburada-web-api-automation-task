package com.hepsiburada.stepImplementations;

import com.hepsiburada.pages.HepsiBuradaPage;
import com.hepsiburada.utils.Driver;
import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class StepImpl {
    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
    public String productPrice = "";

    HepsiBuradaPage hepsiBuradaPage = new HepsiBuradaPage();

    @Step({"Browser açılır"})
    public void setUpScenarios() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Step({"<url> url'ine git"})
    public void goToUrl(String url) {
        Driver.getDriver().navigate().to(url);
        Driver.getDriver().manage().window().maximize();
        Logger.info(url + " url'ine gidildi");
    }

    @Step({"<key> saniye bekle"})
    public void waitFor(String key) {
        try {
            Thread.sleep((long) (Integer.parseInt(key) * 1000L));
            Logger.info(key + " saniye beklendi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Sayfanın başlığı Hepsiburada mı?")
    public void confirmTitleHepsiburada() {
        wait.until(ExpectedConditions.visibilityOf(hepsiBuradaPage.titleHepsiburada)).isDisplayed();
        Logger.info("Sayfanın başlığının Hepsiburada olduğu doğrulandı.");
    }

    @Step("Sayfanın url'i <url> içeriyor mu?")
    public void girisUrl(String url) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(url));
    }

    @Step({"<xpath> xpath'li elemente tıkla"})
    public void clickXpathElement(String xpath) {
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        Logger.info(xpath + " Xpath'li elemente tıklandı");
    }

    @Step({"Search kutusuna tıkla"})
    public void clickSearchBox() {
        wait.until(ExpectedConditions.visibilityOf(hepsiBuradaPage.searchBox)).click();
        Logger.info("Search kutusuna tıklandı");
    }

    @Step({"Search kutusuna <search> yaz"})
    public void sendkeySearchBox(String search) {
        wait.until(ExpectedConditions.elementToBeClickable(hepsiBuradaPage.searchBox2)).sendKeys(search);
        hepsiBuradaPage.searchBox2.sendKeys(new CharSequence[]{Keys.ENTER});
        Logger.info(search + " kelimesi araması yapıldı");
    }

    @Step({"Çerez ayarlarını kabul et"})
    public void acceptCookies() {
        wait.until(ExpectedConditions.visibilityOf(hepsiBuradaPage.acceptButton)).click();
        Logger.info("Çerez ayarları kabul edildi.");
    }

    @Step({"Çerez ayarlarını reddet"})
    public void denyCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(hepsiBuradaPage.denyCookies)).click();
        Logger.info("Çerez ayarları reddedildi.");
    }

    @Step("Listelenen ürünlerden random bir tanesi seçilir.")
    public void holdAndSelectRandomly() {
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//li[@type='comfort']"));
        Random random = new Random();
        System.out.println(list.size());
        int randomNo = random.nextInt(list.size());
        System.out.println(randomNo);
        list.get(randomNo).click();
    }

    public void scrollDown() {
        try {
            int i;
            for (i = 0; i <= 30; ++i) {
                ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0," + i + ")", new Object[]{""});
            }

            while (i > 0) {
                ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0," + i + ")", new Object[]{""});
                --i;
            }
        } catch (WebDriverException var2) {
        } catch (Exception var3) {
        }
    }

    @Step("Sayfa aşağıya kaydırılır.")
    public void scrollDownPage() {
        this.scrollDown();
        Logger.info("Aşağı kaydırma işlemi yapıldı");
    }

    @Step("Değerlendirmeler sekmesine geçiş yapılır.")
    public void switchToCommentsTab() {
        wait.until(ExpectedConditions.visibilityOf(hepsiBuradaPage.commentsTab)).click();
        Logger.info("Değerlendirmeler tab'ına tıklandı");
    }

    @Step("Yeni açılan pencereye geçiş yapılır")
    public void switchToNewWindow() {
        String currentWindowHandle = Driver.getDriver().getWindowHandle();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                Driver.getDriver().switchTo().window(handle);
            }
        }
        Logger.info("Yeni açılan pencereye geçiş yapıldı");
    }

    @Step("<xpath> xpath'li elementin texti <text> mi?")
    public void assertXPATHTextWithGivenText(String xpath, String text) {
        String elementText = "";
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(element));
        elementText = element.getText();
        Logger.info("Elementin texti= " + elementText + "\nBeklenen text= " + text);
        Assert.assertEquals("Elementin texti ile beklenen text aynı değil", text, elementText);
    }

    @Step("Değerlendirme yoksa bitir, varsa sırala, thumbsUp yap ve <text> yazısının geldiğini kontrol et.")
    public void checkCommentsOrderThumsUpCheckThankYou(String text) {
        if (!checkElementIsLocated(hepsiBuradaPage.henuzDegerlendirmeYok)) {
            this.scrollDown();
            clickXpathElement(hepsiBuradaPage.sıralaDropDown);
            clickXpathElement(hepsiBuradaPage.enYeniDegerlendirme);
            this.scrollDown();
            clickXpathElement(hepsiBuradaPage.thumbsUpIcon);
            assertXPATHTextWithGivenText(hepsiBuradaPage.tesekkurEderiz, text);
        } else {
            Assert.assertTrue("Henüz değerlendirme yok", true);
        }
        waitFor("5");
    }

    public boolean checkElementIsLocated(String xpath) {
        try {
            Driver.getDriver().findElement(By.xpath(xpath));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Diğer satıcılar yoksa devam et, varsa fiyat karşılaştır, düşük olanı seç.")
    public void checkOtherSellersAndMatchPrices() {
        waitFor("3");
        Integer lowestPrice = getNumberValueOfTextOfElement(getTextOfXpathElement(hepsiBuradaPage.currentProductsPricePath));
        int elementNumber = -1;
        if (checkElementIsLocated(hepsiBuradaPage.digerSaticilar)) {
            List<WebElement> prices = Driver.getDriver().findElements(By.xpath(hepsiBuradaPage.otherSellersProductPath));
            for (int i = 0; i < prices.size(); i++) {
                System.out.println("prices.get(i).getText() = " + prices.get(i).getText());
                if (lowestPrice > getNumberValueOfTextOfElement(prices.get(i).getText())) {
                    lowestPrice = getNumberValueOfTextOfElement(prices.get(i).getText());
                    elementNumber = i;
                }
            }
            if (elementNumber != -1) {
                Driver.getDriver().findElements(By.xpath(hepsiBuradaPage.uruneGit)).get(elementNumber).click();
            }
        } else {
            Assert.assertTrue("Diğer satıcı yok", true);
        }
    }

    public String getTextOfXpathElement(String xpath) {
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(element));
        Logger.info("Xpath'li elementin texti: " + element.getText());
        return element.getText();
    }

    public Integer getNumberValueOfTextOfElement(String text) {
        Integer price = Integer.valueOf(text.substring(0, text.indexOf(',')).replace(".", "").replace(" TL", ""));
        System.out.println("price = " + price);
        return price;
    }

    @Step("Ürünü sepete ekle.")
    public void addProductToCart() {
        wait.until(ExpectedConditions.visibilityOf(hepsiBuradaPage.sepeteEkle)).click();
        Logger.info("Ürün sepete eklendi");
    }

    @Step("Ürün fiyatı kaydedilir.")
    public void saveProductPrice() {
        productPrice = getTextOfXpathElement(hepsiBuradaPage.productsPricePath);
        Logger.info("Ürün fiyatı kaydedildi: " + productPrice);
    }

    @Step("Kaydedilen ürün fiyatı ile sepetteki fiyat karşılaştırılır.")
    public void assertPrices() {
        clickXpathElement(hepsiBuradaPage.sepeteGit);
        waitFor("3");
        Assert.assertEquals("Ürün fiyatları aynı değil", getNumberValueOfTextOfElement(getTextOfXpathElement(hepsiBuradaPage.priceOfProductInCartPath)), getNumberValueOfTextOfElement(productPrice));
    }
}