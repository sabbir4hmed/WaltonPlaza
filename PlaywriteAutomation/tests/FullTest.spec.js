const {test} = require('@playwright/test');

const {HomePage} = require('../Pages/HomePage');
const {PracticePage} = require('../Pages/PracticePage');
const {LoginPage} = require('../Pages/LoginPage');
const {SecurePage} = require('../Pages/SecurePage');

test('Full Practice Test Flow' , async ({page}) => {

    const homepage = new HomePage(page);
    const practicePage = new PracticePage(page);
    const loginPage = new LoginPage(page);
    const securePage = new SecurePage(page);

    await homepage.goto();
    await homepage.clickpracticelink();
    await practicePage.clicktestloginlink();
    await loginPage.login("student", "Password123");
    await securePage.verifyloginsuccess();





})
