import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.keyword.builtin.VerifyMatchKeyword as VerifyMatchKeyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://testkensho01.yoshikei-dvlp.co.jp/webodrlmt/apl/10/100201_D.aspx')

WebUI.verifyElementClickable(findTestObject('100201_D/a_新規登録'))

WebUI.click(findTestObject('100201_D/a_新規登録'))

'check url'
def url = 'https://testkensho01.yoshikei-dvlp.co.jp/webodrlmt/apl/10/100101_D.aspx'

def currentUrl

currentUrl = WebUI.getUrl()

if (WebUI.verifyMatch(currentUrl, url, true)) {
    'Neeus bieu thuc ben trai laf trong thi tra ve false'
    WebUI.verifyElementClickable(findTestObject('100101_D/select_県'))

    WebUI.click(findTestObject('100101_D/select_県'))
} else {
    WebUI.closeBrowser()
}

