import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import javax.jws.WebService

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.org.apache.bcel.internal.generic.Select

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebElement as Keys

WebUI.callTestCase(findTestCase('100201_D/TC_新規登録CheckLink'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.selectAllOption(findTestObject('100101_D/select_県'))

'lay so cac gia tri dc chon va luu vao mot bien'
def SelectedItem

//WebUI.deselectOptionByIndex(findTestObject('100101_D/select_県'), 2)

SelectedItems = WebUI.getNumberOfTotalOption(findTestObject('100101_D/select_県'))

'verify the number of Oprtion with Exxpected result'
WebUI.verifyEqual(SelectedItems, 48)

'select Option by Index'
WebUI.selectOptionByIndex(findTestObject('100101_D/select_県'), 2)
WebUI.verifyOptionSelectedByIndex(findTestObject('100101_D/select_県'), 2, 60)

'select option by label'
WebUI.selectOptionByValue(findTestObject('100101_D/select_県'), '兵庫県', true)
'verifying the option is selected by label option'
WebUI.verifyOptionSelectedByLabel(findTestObject('100101_D/select_県'), '兵庫県', true, 60)

'select Option by value'
WebUI.selectOptionByValue(findTestObject('100101_D/select_県'), '大阪府', true)
'Verify　Option is selected by value Option'
WebUI.verifyOptionSelectedByValue(findTestObject('100101_D/select_県'), '大阪府', true, 60)

WebUI.deselectOptionByIndex(findTestObject('100101_D/select_県'), '2,3')

'verify drop down data list are present'
List<String> options_list = new ArrayList<String>()
WebUI.verifyOptionsPresent(findTestObject('100101_D/select_県'), ['兵庫県','大阪府','東京都','稚内市'])





