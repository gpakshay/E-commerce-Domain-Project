package com.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Test_Class;
import com.pages.CartPage;

public class CartPageTest extends Test_Class {
	CartPage cartPage;

	@BeforeMethod
	public void set() {
		cartPage = new CartPage();
	}

	@Test(priority = 0)
	public void goToCart() throws Exception {
		System.out.println("Go to Cart Page");
		cartPage.goToCart();
		Thread.sleep(5000);
	}


	@Test(priority = 2)
	public void valiadteTotalProductPrice() {
		takeScreenshot(driver, "CartTotal");
		System.out
				.println("Verifying whether Total table price shown on page is equal to the sum of price of all items");
		Assert.assertEquals(cartPage.getTableTotalPrice(), cartPage.getTotal());

	}
}
