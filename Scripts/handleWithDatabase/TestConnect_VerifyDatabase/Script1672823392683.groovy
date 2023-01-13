import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.sql.ResultSet

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



//connect to DB
String url='localhost'
String dbname='testDB'
String port='5432'
String username='postgres'
String password='admin'
CustomKeywords.'database.ConnectDB.connectDB'(url, dbname, port, username, password)

//open Browser & setText user & password
WebUI.openBrowser('')

WebUI.navigateToUrl('https://testkensho01.yoshikei-dvlp.co.jp/webodrlmt/apl/10/100201_D.aspx')

WebUI.setText(findTestObject('100201_D/input_ID_txtWeb_Login_Id'), 'YSM12321')

WebUI.setEncryptedText(findTestObject('100201_D/input__pwdPassword'), 'tbk9U9LYcWOIVmxuQUH1Aw==')

//verify username& password
//Databaseの情報を取得します
String query = 'select * from public.user'
ResultSet result = CustomKeywords.'database.ConnectDB.executeQuery'(query)
//Move the cursor in the result table to the second row
result.next()

//Save the result as a string
//String valueFromDB1_1 = result.getString(1)
//String valueFromDB1_2= result.getString(2)
//Move the cursor in the result table to the second row
//result.next()
//still get the value from the first column
//String valueFromDB2_1 = result.getString(1)
//String valueFromDB2_2 = result.getString(2)
//println(valueFromDB1_1)
//println(valueFromDB1_2)
//println(valueFromDB2_1)
//println(valueFromDB2_2)

//use For
String qrCountNum = 'select COUNT(*) from public.user'
ResultSet countNumResult = CustomKeywords.'database.ConnectDB.executeQuery'(qrCountNum)
countNumResult.next()
println('num:'+countNumResult.getInt(1))
for(def rowNum = 1; rowNum <= countNumResult.getInt(1); rowNum++) {	
	def user, pass
	user  =WebUI.getAttribute(findTestObject('100201_D/input_ID_txtWeb_Login_Id'), 'value')
	pass = WebUI.getAttribute(findTestObject('100201_D/input__pwdPassword'), 'value')
	if(user.equals(result.getString(1).trim()) && pass.equals(result.getString(2).trim())){
		println('success! データベースに入力した値があります。')
		//				WebUI.click(findTestObject('100201_D/btn_login'))
						break

	} else { result.next()
			continue
	}
		  
}

WebUI.verifyElementClickable(findTestObject('100201_D/btn_login'))

WebUI.click(findTestObject('100201_D/btn_login'))

CustomKeywords.'database.ConnectDB.closeDatabaseConnection'()
WebUI.delay(5)
WebUI.closeBrowser()