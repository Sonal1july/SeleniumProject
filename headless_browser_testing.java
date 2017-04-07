import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class headless_browser_testing {

	public static void main(String[] args) throws InterruptedException {
		
		 File file = new File("phantomjs.exe");				
	        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
	        WebDriver driver = new PhantomJSDriver();	
	        driver.manage().window().maximize();
	        
	        driver.get("http://staging.qubiqle.com/#/login?access_token=f2c162408dd31ff1adf9074770d63b85758686f2&restaurant_id=446");
			Thread.sleep(15000);
			String namo  = driver.getTitle();
			System.out.println(""+namo);
			
			
			WebElement Invoice = (new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='tile-wrapper col-lg-3 col-sm-4 margin_bottom--24 Invoices']//*[@class='panel_container tile']")));
			Invoice.click();
			
			Thread.sleep(10000);
		
			WebElement PendingApprovalInvoice = driver.findElement(By.xpath(".//*[contains(text(),'Pending Approval')]//ancestor::md-tab-item[1]"));
			PendingApprovalInvoice.click();
			
			Thread.sleep(3000);
			
			//Selecting the First Invoice
			WebElement InvoiceTable = driver.findElement(By.xpath(".//*[@class='_md md-no-transition md-active md-no-scroll']"));
			List<WebElement> InvoiceList = InvoiceTable.findElements(By.xpath(".//*[@ng-click='invoiceDetails(invoice.id)']"));
			InvoiceList.get(1).click();
			
			Thread.sleep(8000);
			
			
			WebElement Image = driver.findElement(By.xpath(".//*[@id='split-panel']/invoice-sidebar/div/div/div/div/ul/li/img"));
			int h = Image.getSize().height;
			int w = Image.getSize().width;
			
			System.out.println("height "+h);
			System.out.println("width "+w);
			
			WebElement RotateBtn = driver.findElement(By.xpath(".//*[@id='split-panel']/invoice-sidebar/div/div/nav/div[2]/span[2]"));
			RotateBtn.click();
			
			int h1 = Image.getSize().height;
			int w1 = Image.getSize().width;
			System.out.println("height "+h1);
			System.out.println("width "+w1);
			
			if(h==w1 && w==h1){
				System.out.println("Image Rotation Validated");
			}else{
				System.out.println("Image Rotation failed");
			}

	}

}
