import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
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

WebUI.setText(findTestObject('100201_D/input_ID_txtWeb_Login_Id'), '')

WebUI.setEncryptedText(findTestObject('100201_D/input__pwdPassword'), 'tbk9U9LYcWOIVmxuQUH1Aw==')

WebUI.verifyElementClickable(findTestObject('100201_D/btn_login'))

WebUI.click(findTestObject('100201_D/btn_login'))

WebUI.verifyElementText(findTestObject('100201_D/p_IDMsg'), 'ログインIDまたはメールアドレスを正しく入力してください。')

WebUI.verifyElementText(findTestObject('100201_D/p_PassMsg'), '')

WebUI.setText(findTestObject('100201_D/input_ID_txtWeb_Login_Id'), 'YSM12321')

WebUI.setEncryptedText(findTestObject('100201_D/input__pwdPassword'), '')

WebUI.verifyElementClickable(findTestObject('100201_D/btn_login'))

WebUI.click(findTestObject('100201_D/btn_login'))

WebUI.verifyElementText(findTestObject('100201_D/p_IDMsg'), '')

WebUI.verifyElementText(findTestObject('100201_D/p_PassMsg'), 'パスワードを入力してください。')

WebUI.setText(findTestObject('100201_D/input_ID_txtWeb_Login_Id'), 'test')

WebUI.setEncryptedText(findTestObject('100201_D/input__pwdPassword'), 'P9ET2sDE0SE=')

WebUI.verifyElementClickable(findTestObject('100201_D/btn_login'))

WebUI.click(findTestObject('100201_D/btn_login'))

WebUI.verifyElementText(findTestObject('100201_D/p_IDMsg'), 'ログインに失敗しました。入力内容をもう一度ご確認下さい。(2-2)')

WebUI.verifyElementText(findTestObject('100201_D/p_PassMsg'), '')

