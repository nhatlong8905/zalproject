package zalora;

import constant.Constants;

public class HomePage extends GeneralPage {
	public HomePage open() {
		Constants.WEBDRIVER.navigate().to(Constants.Zalora_URL);
		return this;
	}
}
