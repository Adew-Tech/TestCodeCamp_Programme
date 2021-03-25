package Konga;

import PageObjects.Cart;
import PageObjects.CheckOutPage;
import PageObjects.DashboardPage;
import Setup.SetupTests;

import java.util.Random;

public class Test extends SetupTests{
    @org.testng.annotations.Test
    public void testLoginPage()
    {
        int addToCartButtonID = 1, minPin =0, maxPin = 9, pinEnteries = 0, totalPinEntered = 4;
        String userId = "Enter Username", password = "Enter Password",
                cardNumber = "5334 5678 2233 4456", date = "02/25", cvv = "419";

        //Instantiate random class
        Random random = new Random();

        try {//Sign in to Konga

            //Replaced the class type name 'LoginPage' with 'var'
            var loginPage = DashboardPage.clickLoginSignUpButton();

            //Replace the username and password string with valid user details
            loginPage.enterUsername(userId);
            loginPage.enterUserPassword(password);

            //Click on Login Button
            loginPage.clickLoginBtn();

            //Select any of the categories and subcategory
            var subCategoryPage = DashboardPage.clickCategoryAndSub();

            //Click on the add to cart button
            Cart.clickOnAddToCart(addToCartButtonID);

            //Click on the My Cart Menu
            var addToCartPage = Cart.clickMyCartButton();


            //Click on checkout
            var checkOutPage = addToCartPage.clickCheckOut();

            //Click "Pay Now" to enable “Continue to Payment” button - the user must have preselected pick up method
            CheckOutPage.clickOnPayNow();

            //Click on the “Continue to Payment” button
            CheckOutPage.clickContinueToPayment();

            //Select the “CARD” payment method
            CheckOutPage.clickOnPaymentType();

            //Input a wrong card number, date, CVV
            CheckOutPage.enterCardDetails(cardNumber, date , cvv);

            //Click on the Field for entering card pin
            CheckOutPage.clickOnPinField();

            //Enter pin randomly
            while(pinEnteries != totalPinEntered) {

                //Store randomly entered pin
                int enterPin = random.nextInt((maxPin - minPin + 1) + minPin);

                //Enter the pin
                checkOutPage.clickOnPin(enterPin);

                //Increment pin entry
                pinEnteries++;
            }
            //Print out the error message for the card number field.
            System.out.println(checkOutPage.invalid_message());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
