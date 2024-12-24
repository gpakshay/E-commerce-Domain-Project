package com.testCases;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.testng.Assert;

import com.base.Test_Class;
import com.pages.CartPage;
import com.pages.PaymentInfoPage;
import com.util.TestUtil;

public class PaymentInfoPageTest extends Test_Class {
	PaymentInfoPage paymentInfoPage;
	CartPage cartPage;
	Alert alert;

	@Test(priority = 0)
	public void verifyPurchaseWithoutInfo() {
		cartPage = new CartPage();
		System.out.println("Going to Payment Page");
		paymentInfoPage = cartPage.goToPaymentPage();

		System.out.println("Click on Purchase Button-->verifyPurchaseWithoutInfo");
		paymentInfoPage.clickPurchaseBtn();

		String txt = TestUtil.handleAlert(driver, alert);
		System.out.println("Get Pop ups alert text");

		System.out.println("Verifying Purchase Page without entering any order details");
		Assert.assertEquals(txt, "Please fill out Name and Creditcard.");
	}

	@Test(priority = 1)
	public void verifyPurchaseWithInfo() {
		System.out.println("Send Order details in Payment Page");
		paymentInfoPage.sendDetails();
		takeScreenshot(driver, "purchase");
		System.out.println("Click on Purchase Button-->verifyPurchaseWithInfo");
		paymentInfoPage.clickPurchaseBtn();

		Assert.assertEquals(paymentInfoPage.getSuccessMsg(), "Thank you for your purchase!");

	}
}
