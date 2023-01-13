import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


WebUI.openBrowser('')

WebUI.navigateToUrl('https://testkensho01.yoshikei-dvlp.co.jp/webodrlmt/apl/10/100201_D.aspx')

for (def rowNum = 1; rowNum <= findTestData('TestDataFile').getRowNumbers(); rowNum++) {
	println(rowNum)
	//WebUI.setText(findTestObject('100201_D/input__pwdPassword'), password)
	WebUI.setText(findTestObject('100201_D/input_ID_txtWeb_Login_Id'), findTestData('TestDataFile').getValue(1, rowNum))
    println(findTestData('TestDataDriven').getValue(1, rowNum))
	//WebUI.setText(findTestObject('100201_D/input__pwdPassword'), password)
	WebUI.setText(findTestObject('100201_D/input__pwdPassword'), findTestData('TestDataFile').getValue(2, rowNum))
	println(findTestData('TestDataDriven').getValue(2, rowNum))
	
	//	verify with database data
	for (def rowNumdb = 1; rowNumdb <= findTestData('Test DataAsDB').getRowNumbers(); rowNumdb++) {
//				if(WebUI.verifyNotMatch(WebUI.getAttribute(findTestObject('100201_D/input_ID_txtWeb_Login_Id'), 'value'),findTestData('Test DataAsDB').getValue(1, rowNumdb).trim() ,false, FailureHandling.STOP_ON_FAILURE)	)
//				{								
//					continue
//				} else
//					WebUI.click(findTestObject('100201_D/btn_login'))
		println(findTestData('Test DataAsDB').getValue(1, rowNumdb))
		println(findTestData('Test DataAsDB').getValue(2, rowNumdb))
		
		if(WebUI.getAttribute(findTestObject('100201_D/input_ID_txtWeb_Login_Id'), 'value') != findTestData('Test DataAsDB').getValue(1, rowNumdb).trim() && WebUI.getAttribute(findTestObject('100201_D/input__pwdPassword'), 'value') != findTestData('Test DataAsDB').getValue(2, rowNumdb).trim()) {
			continue
		} else 	println('success')
			    WebUI.click(findTestObject('100201_D/btn_login'))
				break
	}
	
}
//WebUI.closeBrowser()

