
package ObjectPageJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login {

	@SerializedName("emailAndSdtorPasswordIncorrectMsg")
	@Expose
	private String emailAndSdtorPasswordIncorrectMsg;
	@SerializedName("PhoneNumberIncorrectMsg")
	@Expose
	private String phoneNumberIncorrectMsg;
	@SerializedName("emailIncorrectMsg")
	@Expose
	private String emailIncorrectMsg;
	@SerializedName("emailSdtOrPasswordWrongMsg")
	@Expose
	private String emailSdtOrPasswordWrongMsg;
	@SerializedName("passwordNotEnoughtCharacterMsg")
	@Expose
	private String passwordNotEnoughtCharacterMsg;
	@SerializedName("passwordNotEnoughtCharacter")
	@Expose
	private String passwordNotEnoughtCharacter;
	@SerializedName("passwordWrong")
	@Expose
	private String passwordWrong;
	@SerializedName("passwordCorrect")
	@Expose
	private String passwordCorrect;
	@SerializedName("emailCorrect")
	@Expose
	private String emailCorrect;
	@SerializedName("phoneIncorrect")
	@Expose
	private String phoneIncorrect;
	@SerializedName("emailIncorrect")
	@Expose
	private String emailIncorrect;
	@SerializedName("displayUserName")
	@Expose
	private String displayUserName;

	public String getEmailAndSdtorPasswordIncorrectMsg() {
		return emailAndSdtorPasswordIncorrectMsg;
	}

	public String getPhoneNumberIncorrectMsg() {
		return phoneNumberIncorrectMsg;
	}

	public String getEmailIncorrectMsg() {
		return emailIncorrectMsg;
	}

	public String getEmailSdtOrPasswordWrongMsg() {
		return emailSdtOrPasswordWrongMsg;
	}

	public String getPasswordNotEnoughtCharacterMsg() {
		return passwordNotEnoughtCharacterMsg;
	}

	public String getPasswordNotEnoughtCharacter() {
		return passwordNotEnoughtCharacter;
	}

	public String getPasswordWrong() {
		return passwordWrong;
	}

	public String getPasswordCorrect() {
		return passwordCorrect;
	}

	public String getEmailCorrect() {
		return emailCorrect;
	}

	public String getPhoneIncorrect() {
		return phoneIncorrect;
	}

	public String getEmailIncorrect() {
		return emailIncorrect;
	}

	public String getDisplayUserName() {
		return displayUserName;
	}
}
