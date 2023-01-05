 import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.sql.ResultSet

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.sun.org.apache.bcel.internal.generic.RETURN

import net.bytebuddy.asm.Advice.Return


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
String ID
String pass
String query = 'select * from public.user'
//List<List> rowlist = CustomKeywords.'database.ConnectDB.executeQuery'(query)
ResultSet result = CustomKeywords.'database.ConnectDB.executeQuery'(query)
result.next()

//Save the result as a string
String valueFromDB1_1 = result.getString(1)
String valueFromDB1_2= result.getString(2)
//Move the cursor in the result table to the second row
result.next()
//still get the value from the first column
String valueFromDB2_1 = result.getString(1)
String valueFromDB2_2 = result.getString(2)
println(valueFromDB1_1)
println(valueFromDB1_2)
println(valueFromDB2_1)
println(valueFromDB2_2)


//use For
String qrCountNum = 'select COUNT(*) from public.user'
ResultSet countNumResult = CustomKeywords.'database.ConnectDB.executeQuery'(qrCountNum)
//for(def rowNum = 1; rowNum <= CountResult; rowNum++) {
//	
//}
countNumResult.next()
println(countNumResult.getInt(1))


//return [valueFromDB2,valueFromDB]

WebUI.verifyElementClickable(findTestObject('100201_D/btn_login'))

WebUI.click(findTestObject('100201_D/btn_login'))
