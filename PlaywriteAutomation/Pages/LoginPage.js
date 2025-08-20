class LoginPage {
    constructor(page) {
        this.page = page;
        this.username = page.locator("//input[@id='username']");
        this.password = page.locator("//input[@id='password']");
        this.submitbutton = page.locator("//button[@id='submit']");

    }


    async login(username, password)
    {
        await
            this.username.fill(username);
        await
            this.password.fill(password);
        await
            this.submitbutton.click();
        await
            this.page.waitForLoadState('networkidle');

    }
}

module.exports =
{
    LoginPage
}