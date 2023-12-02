

package automationrtcamp;

import com.microsoft.playwright.*;


public class Login {

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
            
            //click on Sign In
            page.click("#nav-link-accountList");
            
            //Enter login details
            page.fill("#ap_email", "jayshri487@gmail.com");
            page.click("#continue");
            page.fill("#ap_password", "Qatesting@123");
            page.click("#signInSubmit");
            
                        //Wait for login
            page.waitForSelector("#nav-link-accountList.nav-line-1");
            
                        //Search for product
            page.type("#twotabsearchtextbox", "PlayStation 5");
            page.click("input[value='Go']");
            
            
            //click on the first product from search results
            page.click(".s-search-results div[data-asin][data-index='0'] h2 a");
            
            //Add product to wishlist
            
            page.click("#add-to-wishlist-button-submit");
            
            //Wait for wishlist update
                     page.waitForSelector(".a-alert-success");
                     
                     //Move to wishlist page
                     page.click("#nav-link-accountList");
                     page.click("#nav-al-wishlist");
                     
                     //confirm product added to wishlist
                     assertTrue(page.isVisible(".g-items-section"));
                     
                     
}
    }
}

	