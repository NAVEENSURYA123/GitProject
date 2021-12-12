package org.simple;

import org.openqa.selenium.support.PageFactory;

public class Simple extends Simpe{
	public Simple() {
		PageFactory.initElements(driver, this);
	}

}
