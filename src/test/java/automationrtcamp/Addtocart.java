package automationrtcamp;

import com.microsoft.playwright.*;


public class Addtocart {
	
	private void assertTrue(boolean visible) {
		// TODO Auto-generated method stub
		
	}
	public void testLogin() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            BrowserContext context = browser.newContext();

            // Create a new page
            Page page = context.newPage();

            // Move to Amazon.com
            page.navigate("https://www.amazon.com");
            
            // Search products
        
            page.type("#twotabsearchtextbox", "Laptop");
            page.click("input[value='Go']");

            // Click search results
            page.click(".s-search-results div[data-asin][data-index='0'] h2 a");

            // confirm product page load
            assertTrue(page.isVisible("#productTitle"));

            // Add to cart product
            page.click("#add-to-cart-button");

            // wait for product add to cart
            page.waitForSelector(".a-alert-success");

            // confirm that product added 
            assertTrue(page.isVisible(".a-alert-success"));
            
            //Checkout 
            page.click("#nav-cart");
            
            //Click on checkout button
            page.click("input[name='proceedToRetailCheckout']");

            
            //Wait
            page.waitForSelector("#enterAddressFullName");
            
            //Fill the details
            page.fill("#enterAddressfullname", "Jayshree Varma");
            page.fill("#enterddress", "58 Charly Lane");
            page.fill("#entercity", "Ahmedabad");
            page.fill("#enterregion", "Gujart");
            page.fill("#enterzipcode", "382481");
            page.fill("#entermobileNumber", "9898989898");
            
            page.click("input[name='shipToThisAddress']");
            
            //Select payment method
            page.click("input[name='Cashondelivery']");
            
            //Click on place order
            page.click("input[name='placeYourOrder']");
            
            //Wait
            page.waitForSelector(".order-confirmation");
            
            //close
            browser.close();
            
            
        }
     }
}