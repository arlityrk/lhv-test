package com.selenide.lhv.tests.lease;

import com.codeborne.selenide.Condition;
import com.selenide.lhv.pages.LeaseCalculatorPage;

import static com.codeborne.selenide.Condition.*;
import static org.junit.Assert.assertEquals;

public class LeaseCalculatorVerifier {

    LeaseCalculatorPage calcPage = new LeaseCalculatorPage();

    public void verifyPageTitle(){
        calcPage.getPageTitle().shouldHave(attribute("text", calcPage.getExpectedPageTitle()));
    }

    public void verifyPageUrl(){
        assertEquals(calcPage.getExpectedPageUrl(), calcPage.getPageUrl());
    }

    public void verifyCalculatorHeaderText(){
        calcPage.getCalculatorHeaderText().shouldHave(text(calcPage.getExpectedCalculatorHeaderText()));
    }
    public void verifyAccountTypeRadioValue(LeaseCalculatorPage.AccountTypeValues accountType) {
        calcPage.getAccountTypeRadio().shouldHave(value(accountType.toString()));
    }

    public void verifyLeaseTypeRadioValue(LeaseCalculatorPage.LeaseTypeValues leaseType) {
        calcPage.getLeaseTypeRadio().shouldHave(value(leaseType.toString()));
    }

    public void verifyPriceInputValue(String expectedValue) {
        calcPage.getPriceInput().shouldHave(value(expectedValue));
    }

    public void verifyVatIncludedCheckboxState(Boolean expectedState) {
        if (expectedState) {
            calcPage.getVatIncludedCheckbox().shouldBe(checked);
        } else {
            calcPage.getVatIncludedCheckbox().shouldNotBe(checked);
        }
    }

    public void verifyDownpaymentPercentageInputValue(String expectedValue) {
        calcPage.getDownpaymentPercentageInput().shouldHave(value(expectedValue));
    }

    public void verifyDownpaymentInputValue(String expectedValue) {
        calcPage.getDownpaymentInput().shouldHave(value(expectedValue));
    }

    public void verifyLeasePeriodYearsSelectValue(String optionTextValue) {
        calcPage.getLeasePeriodYearsSelect().shouldHave(text(optionTextValue));
    }

    public void verifyLeasePeriodMonthsSelectValue(String optionTextValue) {
        calcPage.getLeasePeriodMonthsSelect().getSelectedOption().shouldHave(text(optionTextValue));
    }

    public void verifyInterestRateInputValue(String expectedValue) {
        calcPage.getInterestRateInput().shouldHave(value(expectedValue));
    }

    public void verifyRemainderPercentageInputValue(String expectedValue) {
        calcPage.getRemainderPercentageInput().shouldHave(value(expectedValue));
    }

    public void verifyRemainderInputValue(String expectedValue) {
        calcPage.getRemainderInput().shouldHave(value(expectedValue));
    }

    public void verifyMonthlyPaymentCalculationResultValue(String expectedValue) {
        calcPage.getMonthlyPaymentResultText().shouldHave(text(expectedValue));
    }

    public void verifyLeaseOwnershipRadioValue(LeaseCalculatorPage.LeaseOwnershipValues value) {
        calcPage.getLeaseOwnershipRadio().shouldHave(value(value.toString()));
    }

    public void verifyMaritalStatusCheckboxState(Boolean expectedState) {
        if (expectedState) {
            calcPage.getMaritalStatusCheckbox().shouldBe(checked);
        } else {
            calcPage.getMaritalStatusCheckbox().shouldNotBe(checked);
        }
    }

    public void verifyDependantPersonsSelectValue(String expectedOptionTextValue) {
        calcPage.getDependantPersonsSelect().shouldHave(text(expectedOptionTextValue));
    }

    public void verifyMonthlyIncomeInputValue(String expectedValue) {
        calcPage.getMonthlyIncomeInput().shouldHave(value(expectedValue));
    }

    public void verifyMaxPaymentCalculationResultValue(String expectedValue) {
        calcPage.getMaxPaymentResultText().shouldHave(text(expectedValue));
    }

    public void verifyVatSchedulingSelectVisibility(Condition hiddenOrVisible) {
        calcPage.getVatSchedulingSelect().shouldBe(hiddenOrVisible);
    }

    public void verifyGuarantorMaritalStatusCheckboxVisibility(Condition hiddenOrVisible) {
        calcPage.getGuarantorMaritalStatusCheckboxLabel().shouldBe(hiddenOrVisible);
    }

    public void verifyGuarantorDependentPersonSelectVisibility(Condition hiddenOrVisible) {
        calcPage.getGuarantorDependentPersonSelect().shouldBe(hiddenOrVisible);
    }

    public void verifyGuarantorMonthlyIncomeInputVisibility(Condition hiddenOrVisible) {
        calcPage.getGuarantorMonthlyIncomeInput().shouldBe(hiddenOrVisible);
    }
}
