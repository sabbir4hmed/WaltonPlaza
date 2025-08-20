const {expect} = require('@playwright/test');

class SecurePage
{
    constructor(page)
    {
        this.page = page;
        this.successmassage = page.locator("text = Logged In Successfully");
    }


    async verifyloginsuccess()
    {
        await
            expect(this.successmassage).toBeVisible();
    }
}

module.exports =
{
    SecurePage
}