package com.task;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class TakesScreenshot {

		public static void createScreenShot(final String path) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateN = dateformat.format(currentDate.getTime());
		System.out.println("Date:" + dateformat);
		String filename = "screenshot" + dateN + ".png";
		File destinationFile = new File(path + "/Screenshot" + filename);
		FileUtils.copyFile(screenshot, destinationFile);
	}
}
