package com.selenide.lhv.tests.lease;

import com.selenide.lhv.pages.LeaseCalculatorPage;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;

public class LeaseCalculatorTests {

    LeaseCalculatorPage calcPage = new LeaseCalculatorPage();
    LeaseCalculatorVerifier v = new LeaseCalculatorVerifier();

    @Test
    public void testUrlAndTitles() {
        calcPage.open();
        v.verifyPageTitle();
        v.verifyPageUrl();
        v.verifyCalculatorHeaderText();
    }

    @Test
    public void testMonthlyPaymentCalculatorDefaultValues() {
        calcPage.open();
        calcPage.clickCalculatorTab(LeaseCalculatorPage.CalculatorTabValues.MONTHLY_PAYMENT);
        v.verifyAccountTypeRadioValue(LeaseCalculatorPage.AccountTypeValues.PRIVATE_PERSON);
        v.verifyLeaseTypeRadioValue(LeaseCalculatorPage.LeaseTypeValues.FINANCIAL_LEASE);
        v.verifyPriceInputValue("15 000");
        v.verifyVatIncludedCheckboxState(true);
        v.verifyDownpaymentPercentageInputValue("10");
        v.verifyDownpaymentInputValue("1500");
        v.verifyLeasePeriodYearsSelectValue("6");
        v.verifyLeasePeriodMonthsSelectValue("0");
        v.verifyInterestRateInputValue("6");
        v.verifyRemainderPercentageInputValue("10");
        v.verifyRemainderInputValue("1500");
        v.verifyMonthlyPaymentCalculationResultValue("206.37");
    }

    @Test
    public void testMaxPaymentCalculatorDefaultValues() {
        calcPage.open();
        calcPage.clickCalculatorTab(LeaseCalculatorPage.CalculatorTabValues.MAX_PAYMENT);
        v.verifyLeaseOwnershipRadioValue(LeaseCalculatorPage.LeaseOwnershipValues.ALONE);
        v.verifyMaritalStatusCheckboxState(true);
        v.verifyDependantPersonsSelectValue("1");
        v.verifyMonthlyIncomeInputValue("900");
        v.verifyMaxPaymentCalculationResultValue("280.32");
    }

    @Test
    public void testCompanyOperationalLeaseCalculator() {
        calcPage.open();
        calcPage.clickCalculatorTab(LeaseCalculatorPage.CalculatorTabValues.MONTHLY_PAYMENT);
        v.verifyVatSchedulingSelectVisibility(hidden);
        calcPage.setAccountTypeRadioValue(LeaseCalculatorPage.AccountTypeValues.COMPANY);
        v.verifyVatSchedulingSelectVisibility(visible);
        calcPage.setLeaseTypeRadioValue(LeaseCalculatorPage.LeaseTypeValues.OPERATIONAL_LEASE);
        v.verifyVatSchedulingSelectVisibility(hidden);
        calcPage.setPriceInputValue("25000");
        calcPage.clickVatIncludedCheckbox();
        calcPage.setDownpaymentPercentageInputValue("30");
        v.verifyDownpaymentInputValue("7500");
        calcPage.setLeasePeriodYearsSelectValue("3");
        calcPage.setInterestRateInputValue("7.9");
        calcPage.setReminderInputValue("3777");
        v.verifyRemainderPercentageInputValue("15.11");
        v.verifyMonthlyPaymentCalculationResultValue("530.19");
    }

    @Test
    public void testMaxPaymentCalculatorWithGuarantor() {
        calcPage.open();
        calcPage.clickCalculatorTab(LeaseCalculatorPage.CalculatorTabValues.MAX_PAYMENT);
        v.verifyGuarantorMaritalStatusCheckboxVisibility(hidden);
        v.verifyGuarantorDependentPersonSelectVisibility(hidden);
        v.verifyGuarantorMonthlyIncomeInputVisibility(hidden);
        calcPage.setLeaseOwnershipRadioValue(LeaseCalculatorPage.LeaseOwnershipValues.WITH_CO_APPLICANT);
        v.verifyGuarantorMaritalStatusCheckboxVisibility(visible);
        v.verifyGuarantorDependentPersonSelectVisibility(visible);
        v.verifyGuarantorMonthlyIncomeInputVisibility(visible);
        calcPage.setGuarantorDependentPersonSelectValue("4");
        calcPage.setGuarantorMonthlyIncomeInputValue("2400");
        v.verifyMaxPaymentCalculationResultValue("1387.98");
    }
}
