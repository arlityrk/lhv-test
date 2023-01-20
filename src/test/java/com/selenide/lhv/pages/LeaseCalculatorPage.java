package com.selenide.lhv.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;

public class LeaseCalculatorPage {
    private final String PageTitle = "Liising · LHV";
    private final String PageUrl = "https://www.lhv.ee/et/liising";
    private final String CalculatorHeaderText = "Arvuta kuumakse";

    public enum AccountTypeValues {
        PRIVATE_PERSON("P"),
        COMPANY("C");

        public final String valueParameter;

        AccountTypeValues(String valueParameter) {
            this.valueParameter = valueParameter;
        }

        @Override
        public String toString() {
            return valueParameter;
        }
    }

    public enum LeaseTypeValues {
        FINANCIAL_LEASE("HP"),
        OPERATIONAL_LEASE("FL");

        public final String valueParameter;

        LeaseTypeValues(String valueParameter) {
            this.valueParameter = valueParameter;
        }

        @Override
        public String toString() {
            return valueParameter;
        }
    }

    public enum LeaseOwnershipValues {
        ALONE("single"),
        WITH_CO_APPLICANT("guarantor");

        public final String valueParameter;

        LeaseOwnershipValues(String valueParameter) {
            this.valueParameter = valueParameter;
        }

        @Override
        public String toString() {
            return valueParameter;
        }
    }

    public enum CalculatorTabValues {
        MONTHLY_PAYMENT("Näidiskuumakse"),
        MAX_PAYMENT("Maksimaalne kuumakse");

        public final String valueParameter;

        CalculatorTabValues(String valueParameter) {
            this.valueParameter = valueParameter;
        }

        @Override
        public String toString() {
            return valueParameter;
        }
    }

    public LeaseCalculatorPage open() {
        Cookie ck = new Cookie("COOKIES_CONSENT", "%7B%22necessary%22%3Atrue%2C%22statistical%22%3Atrue%2C%22functional%22%3Atrue%2C%22advertising%22%3Atrue%7D");
        Selenide.open(PageUrl);
        WebDriverRunner.getWebDriver().manage().addCookie(ck);
        if (getCookiesModal().isDisplayed()) {
            acceptCookies();
        }
        return this;
    }

    private SelenideElement getCookiesModal(){
        return $(By.id("pirukas"));
    }

    private void acceptCookies() {
        $(By.id("acceptPirukas")).click();
    }

    public String getExpectedPageTitle() {
        return PageTitle;
    }

    public String getExpectedPageUrl() {
        return PageUrl;
    }

    public String getExpectedCalculatorHeaderText() {
        return CalculatorHeaderText;
    }

    public String getPageUrl() {
        return WebDriverRunner.url();
    }

    public SelenideElement getPageTitle() {
        return $(By.cssSelector("title"));
    }

    public SelenideElement getCalculatorHeaderText() {
        return $(By.cssSelector("#kalkulaator h2"));
    }

    public SelenideElement getAccountTypeRadio() {
        return $(By.name("account_type"));
    }

    public void setAccountTypeRadioValue(AccountTypeValues accountType) {
        $(By.cssSelector("[name='account_type'][value='" + accountType.toString() + "'] + label")).click();
    }

    public SelenideElement getLeaseTypeRadio() {
        return $(By.name("lease_type"));
    }

    public void setLeaseTypeRadioValue(LeaseTypeValues leaseType) {
        $(By.cssSelector("[name='lease_type'][value='" + leaseType.toString() + "'] + label")).click();
    }

    public SelenideElement getPriceInput() {
        return $(By.cssSelector("#price"));
    }

    public void setPriceInputValue(String value) {
        $(By.cssSelector("#price")).setValue(value);
    }

    public SelenideElement getVatIncludedCheckbox() {
        return $(By.cssSelector("#vat_included"));
    }

    public void clickVatIncludedCheckbox() {
        $(By.cssSelector("#vat_included + label")).click();
    }

    public SelenideElement getVatSchedulingSelect() {
        return $(By.id("vat_scheduling"));
    }

    public SelenideElement getDownpaymentPercentageInput() {
        return $(By.cssSelector("#initial_percentage"));
    }

    public SelenideElement getDownpaymentInput() {
        return $(By.cssSelector("#initial"));
    }

    public void setDownpaymentPercentageInputValue(String value) {
        $(By.cssSelector("#initial_percentage")).setValue(value);
    }

    public SelenideElement getLeasePeriodYearsSelect() {
        return $(By.name("years"));
    }

    public void setLeasePeriodYearsSelectValue(String optionTextValue) {
        $(By.name("years")).selectOption(optionTextValue);
    }

    public SelenideElement getLeasePeriodMonthsSelect() {
        return $(By.name("months"));
    }

    public SelenideElement getInterestRateInput() {
        return $(By.cssSelector("#interest_rate"));
    }

    public void setInterestRateInputValue(String value) {
        $(By.cssSelector("#interest_rate")).setValue(value);
    }

    public SelenideElement getRemainderPercentageInput() {
        return $(By.cssSelector("#reminder_percentage"));
    }

    public SelenideElement getRemainderInput() {
        return $(By.cssSelector("#reminder"));
    }

    public void setReminderInputValue(String value) {
        $(By.cssSelector("#reminder")).setValue(value);
    }

    public SelenideElement getMonthlyPaymentResultText() {
        return $(By.cssSelector("div #monthly-payment .payment"));
    }

    public SelenideElement getMaxPaymentResultText() {
        return $(By.cssSelector("div #max-payment .payment"));
    }

    public void clickCalculatorTab(CalculatorTabValues tabName) {
        $(By.linkText(tabName.toString())).click();
    }

    public SelenideElement getLeaseOwnershipRadio() {
        return $(By.name("ownership"));
    }

    public void setLeaseOwnershipRadioValue(LeaseOwnershipValues value) {
        $(By.cssSelector("[name='ownership'][value='" + value.toString() + "'] + label")).click();
    }

    public SelenideElement getMaritalStatusCheckbox() {
        return $(By.id("marital-status-married"));
    }

    public SelenideElement getDependantPersonsSelect() {
        return $(By.id("dependent-persons"));
    }

    public SelenideElement getMonthlyIncomeInput() {
        return $(By.id("monthly-income"));
    }

    public SelenideElement getGuarantorMaritalStatusCheckboxLabel() {
        return $(By.cssSelector("#marital-status-married + label"));
    }

    public SelenideElement getGuarantorDependentPersonSelect() {
        return $(By.id("guarantor-dependent-persons"));
    }

    public SelenideElement getGuarantorMonthlyIncomeInput() {
        return $(By.id("guarantor-monthly-income"));
    }

    public void setGuarantorDependentPersonSelectValue(String optionTextValue) {
        $(By.id("guarantor-dependent-persons")).selectOption(optionTextValue);
    }

    public void setGuarantorMonthlyIncomeInputValue(String value) {
        $(By.cssSelector("#guarantor-monthly-income")).setValue(value);
    }


}
